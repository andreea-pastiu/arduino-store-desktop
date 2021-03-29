package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;

public class OrderHistoryPageController
{
    @FXML
    TableView historyTable;
    @FXML
    public void initialize()
    {
        historyTable.getItems().clear();
        historyTable.getColumns().clear();
        TableColumn<ArduinoBoard, String> column1 = new TableColumn<>("Order Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        TableColumn<ArduinoBoard, String> column2 = new TableColumn<>("Total($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("total"));
        historyTable.getColumns().add(column1);
        historyTable.getColumns().add(column2);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT o.OrdersId, SUM(op.Quantity * p.Price) AS Total FROM ArduinoStore.dbo.Orders o JOIN ArduinoStore.dbo.OrderProduct op ON o.OrdersId = op.OrdersId JOIN ArduinoStore.dbo.Product p ON op.ProductId = p.ProductId WHERE o.AccountId = " + Customer.getAccountId() +" GROUP BY o.OrdersId";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int orderId = resultSet.getInt("OrdersId");
                    BigDecimal total = resultSet.getBigDecimal("Total");
                    if(!Customer.isIsPremium())
                    {
                        total = total.add(new BigDecimal(2));
                    }
                    OrderHistory orderHistory = new OrderHistory(orderId, total);
                    historyTable.getItems().add(orderHistory);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBackToProducts(ActionEvent event) throws IOException
    {
        Parent root;
        Stage appStage;
        appStage=(Stage)historyTable.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("CustomerPanel.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }
}
