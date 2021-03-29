package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;

public class OrderPageController
{
    @FXML
    TableView cartTable;
    @FXML
    Label orderTotalLabel;
    @FXML
    Label deliveryLabel;
    @FXML
    TextField deliveryTextField;
    @FXML
    public void initialize() {
        BigDecimal total = new BigDecimal(0);
        cartTable.getItems().removeAll();
        cartTable.getColumns().removeAll();
        TableColumn<CartItem, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<CartItem, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<CartItem, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<CartItem, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<CartItem, String> column5 = new TableColumn<>("Count");
        column5.setCellValueFactory(new PropertyValueFactory<>("count"));
        cartTable.getColumns().add(column1);
        cartTable.getColumns().add(column2);
        cartTable.getColumns().add(column3);
        cartTable.getColumns().add(column4);
        cartTable.getColumns().add(column5);
        for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
        {
            CartItem item = new CartItem(entry.getKey().getProductID(), entry.getKey().getPrice(), entry
            .getKey().getCompany(), entry.getKey().getModel(), entry.getValue());
            cartTable.getItems().add(item);
            total = total.add(entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())));
        }
        if(Customer.isIsPremium())
        {
            deliveryLabel.setText("Delivery fee: $0");
        }
        else
        {
            total = total.add(new BigDecimal(2));
            deliveryLabel.setText("Delivery fee: $2");
        }
        StringBuilder sb = new StringBuilder("Total: $");
        sb.append(total);
        orderTotalLabel.setText(sb.toString());
    }

    @FXML
    private void handleOrderButton(ActionEvent event)
    {
        String address = deliveryTextField.getText();
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Orders VALUES(?,?); SELECT SCOPE_IDENTITY()");
                preparedStatement.setInt(1, Customer.getAccountId());
                preparedStatement.setString(2, address);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                    int orderId = resultSet.getInt(1);
                    for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
                    {
                        PreparedStatement preparedStatementBoard = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.OrderProduct VALUES(?,?,?); SELECT SCOPE_IDENTITY()");
                        preparedStatementBoard.setInt(1, orderId);
                        preparedStatementBoard.setInt(2, entry.getKey().getProductID());
                        preparedStatementBoard.setInt(3, entry.getValue());
                        preparedStatementBoard.execute();
                        ResultSet resultSetBoard = preparedStatementBoard.getGeneratedKeys();
                        if(resultSetBoard.next())
                        {
                            System.out.println("Order product insert ok");
                        }
                        else
                        {
                            System.out.println("failed to add order product");
                        }
                    }
                    Cart.getCartItems().clear();
                    Parent root;
                    Stage appStage;
                    appStage=(Stage)cartTable.getScene().getWindow();
                    root= FXMLLoader.load(getClass().getResource("OrderHistoryPage.fxml"));
                    Scene scene=new Scene(root);
                    appStage.setScene(scene);
                    appStage.show();
                }
            }
        }
        catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
