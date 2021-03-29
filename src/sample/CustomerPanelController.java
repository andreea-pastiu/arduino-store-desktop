package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;

public class CustomerPanelController
{
    @FXML
    TableView resultsTable;
    @FXML
    Button viewCartButton;
    @FXML
    private void handleViewBoards(ActionEvent event)
    {
        resultsTable.getItems().removeAll(resultsTable.getItems());
        resultsTable.getColumns().removeAll(resultsTable.getColumns());
        TableColumn<ArduinoBoard, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ArduinoBoard, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<ArduinoBoard, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<ArduinoBoard, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<ArduinoBoard, String> column5 = new TableColumn<>("Supply Voltage");
        column5.setCellValueFactory(new PropertyValueFactory<>("supplyVoltage"));
        TableColumn<ArduinoBoard, String> column6 = new TableColumn<>("Digital Pins");
        column6.setCellValueFactory(new PropertyValueFactory<>("digitalPins"));
        TableColumn<ArduinoBoard, String> column7 = new TableColumn<>("Analog Pins");
        column7.setCellValueFactory(new PropertyValueFactory<>("analogPins"));
        TableColumn<ArduinoBoard, String> column8 = new TableColumn<>("Flash Memory");
        column8.setCellValueFactory(new PropertyValueFactory<>("flashMemory"));
        TableColumn<ArduinoBoard, String> column9 = new TableColumn<>("Frequency");
        column9.setCellValueFactory(new PropertyValueFactory<>("frequency"));
        TableColumn<ArduinoBoard, ArduinoBoard> addToCart = new TableColumn<>("");
        addToCart.setMinWidth(40);
        addToCart.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        addToCart.setCellFactory(param -> new TableCell<ArduinoBoard, ArduinoBoard>() {
            private final Button addToCartButton = new Button("Add to cart");

            @Override
            protected void updateItem(ArduinoBoard arduinoBoard, boolean empty) {
                super.updateItem(arduinoBoard, empty);

                if (arduinoBoard == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(addToCartButton);
                addToCartButton.setOnAction(event -> {
                    Boolean found = false;
                    for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
                    {
                        if(entry.getKey().getProductID() == arduinoBoard.getProductID())
                        {
                            entry.setValue(entry.getValue()+1);
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        Cart.AddProduct(arduinoBoard);
                    }
                    System.out.println("Added to cart");
                });
            }
        });
        resultsTable.getColumns().add(column1);
        resultsTable.getColumns().add(column2);
        resultsTable.getColumns().add(column3);
        resultsTable.getColumns().add(column4);
        resultsTable.getColumns().add(column5);
        resultsTable.getColumns().add(column6);
        resultsTable.getColumns().add(column7);
        resultsTable.getColumns().add(column8);
        resultsTable.getColumns().add(column9);
        resultsTable.getColumns().add(addToCart);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT p.Price, c.Name, p.Model, ab.* FROM ArduinoStore.dbo.Product p JOIN ArduinoStore.dbo.ArduinoBoard ab ON p.ProductId = ab.ProductId JOIN ArduinoStore.dbo.Company c on p.CompanyId = c.CompanyId WHERE IsDeleted = 0";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int productId = resultSet.getInt("ProductId");
                    BigDecimal price = resultSet.getBigDecimal("Price");
                    String company = resultSet.getString("Name");
                    String model = resultSet.getString("Model");
                    BigDecimal supplyVoltage = resultSet.getBigDecimal("SupplyVoltage");
                    int digitalPins = resultSet.getInt("DigitalPins");
                    int analogPins = resultSet.getInt("AnalogPins");
                    BigDecimal flashMemory = resultSet.getBigDecimal("FlashMemory");
                    BigDecimal frequency = resultSet.getBigDecimal("Frequency");
                    ArduinoBoard arduinoBoard = new ArduinoBoard(productId, price, company, model, supplyVoltage, digitalPins, analogPins, flashMemory, frequency);
                    resultsTable.getItems().add(arduinoBoard);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewBreadboards(ActionEvent event)
    {
        resultsTable.getItems().removeAll(resultsTable.getItems());
        resultsTable.getColumns().removeAll(resultsTable.getColumns());
        TableColumn<Breadboard, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<Breadboard, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Breadboard, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<Breadboard, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<Breadboard, String> column5 = new TableColumn<>("Width");
        column5.setCellValueFactory(new PropertyValueFactory<>("width"));
        TableColumn<Breadboard, String> column6 = new TableColumn<>("Length");
        column6.setCellValueFactory(new PropertyValueFactory<>("length"));
        TableColumn<Breadboard, String> column7 = new TableColumn<>("Tie Points");
        column7.setCellValueFactory(new PropertyValueFactory<>("tiePoints"));
        TableColumn<Breadboard, Breadboard> addToCart = new TableColumn<>("");
        addToCart.setMinWidth(40);
        addToCart.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        addToCart.setCellFactory(param -> new TableCell<Breadboard, Breadboard>() {
            private final Button addToCartButton = new Button("Add to cart");

            @Override
            protected void updateItem(Breadboard breadBoard, boolean empty) {
                super.updateItem(breadBoard, empty);

                if (breadBoard == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(addToCartButton);
                addToCartButton.setOnAction(event -> {
                    Boolean found = false;
                    for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
                    {
                        if(entry.getKey().getProductID() == breadBoard.getProductID())
                        {
                            entry.setValue(entry.getValue()+1);
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        Cart.AddProduct(breadBoard);
                    }
                    System.out.println("Added to cart");
                });
            }
        });
        resultsTable.getColumns().add(column1);
        resultsTable.getColumns().add(column2);
        resultsTable.getColumns().add(column3);
        resultsTable.getColumns().add(column4);
        resultsTable.getColumns().add(column5);
        resultsTable.getColumns().add(column6);
        resultsTable.getColumns().add(column7);
        resultsTable.getColumns().add(addToCart);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT p.Price, c.Name, p.Model, b.* FROM ArduinoStore.dbo.Product p JOIN ArduinoStore.dbo.Breadboard b ON p.ProductId = b.ProductId JOIN ArduinoStore.dbo.Company c on p.CompanyId = c.CompanyId WHERE IsDeleted = 0";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int productId = resultSet.getInt("ProductId");
                    BigDecimal price = resultSet.getBigDecimal("Price");
                    String company = resultSet.getString("Name");
                    String model = resultSet.getString("Model");
                    int width = resultSet.getInt("Width");
                    int length = resultSet.getInt("Length");
                    int tiePoints = resultSet.getInt("TiePoints");
                    Breadboard breadboard = new Breadboard(productId, price, company, model, width, length, tiePoints);
                    resultsTable.getItems().add(breadboard);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewLEDs(ActionEvent event)
    {
        resultsTable.getItems().removeAll(resultsTable.getItems());
        resultsTable.getColumns().removeAll(resultsTable.getColumns());
        TableColumn<LED, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<LED, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<LED, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<LED, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<LED, String> column5 = new TableColumn<>("Color");
        column5.setCellValueFactory(new PropertyValueFactory<>("color"));
        TableColumn<LED, String> column6 = new TableColumn<>("Diameter");
        column6.setCellValueFactory(new PropertyValueFactory<>("diameter"));
        TableColumn<LED, String> column7 = new TableColumn<>("LED Current");
        column7.setCellValueFactory(new PropertyValueFactory<>("current"));
        TableColumn<LED, LED> addToCart = new TableColumn<>("");
        addToCart.setMinWidth(40);
        addToCart.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        addToCart.setCellFactory(param -> new TableCell<LED, LED>() {
            private final Button addToCartButton = new Button("Add to cart");

            @Override
            protected void updateItem(LED LED, boolean empty) {
                super.updateItem(LED, empty);

                if (LED == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(addToCartButton);
                addToCartButton.setOnAction(event -> {
                    Boolean found = false;
                    for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
                    {
                        if(entry.getKey().getProductID() == LED.getProductID())
                        {
                            entry.setValue(entry.getValue()+1);
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        Cart.AddProduct(LED);
                    }
                    System.out.println("Added to cart");
                });
            }
        });
        resultsTable.getColumns().add(column1);
        resultsTable.getColumns().add(column2);
        resultsTable.getColumns().add(column3);
        resultsTable.getColumns().add(column4);
        resultsTable.getColumns().add(column5);
        resultsTable.getColumns().add(column6);
        resultsTable.getColumns().add(column7);
        resultsTable.getColumns().add(addToCart);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT p.Price, c.Name, p.Model, l.* FROM ArduinoStore.dbo.Product p JOIN ArduinoStore.dbo.LED l ON p.ProductId = l.ProductId JOIN ArduinoStore.dbo.Company c on p.CompanyId = c.CompanyId WHERE IsDeleted = 0";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int productId = resultSet.getInt("ProductId");
                    BigDecimal price = resultSet.getBigDecimal("Price");
                    String company = resultSet.getString("Name");
                    String model = resultSet.getString("Model");
                    String color = resultSet.getString("Color");
                    int diameter = resultSet.getInt("Diameter");
                    BigDecimal current = resultSet.getBigDecimal("LEDCurrent");
                    LED LED = new LED(productId, price, company, model, color, diameter, current);
                    resultsTable.getItems().add(LED);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewMotors(ActionEvent event)
    {
        resultsTable.getItems().removeAll(resultsTable.getItems());
        resultsTable.getColumns().removeAll(resultsTable.getColumns());
        TableColumn<Motor, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<Motor, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Motor, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<Motor, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<Motor, String> column5 = new TableColumn<>("Voltage");
        column5.setCellValueFactory(new PropertyValueFactory<>("voltage"));
        TableColumn<Motor, String> column6 = new TableColumn<>("Motor Current");
        column6.setCellValueFactory(new PropertyValueFactory<>("current"));
        TableColumn<Motor, String> column7 = new TableColumn<>("Rotation Speed");
        column7.setCellValueFactory(new PropertyValueFactory<>("rotationSpeed"));
        TableColumn<Motor, Motor> addToCart = new TableColumn<>("");
        addToCart.setMinWidth(40);
        addToCart.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        addToCart.setCellFactory(param -> new TableCell<Motor, Motor>() {
            private final Button addToCartButton = new Button("Add to cart");

            @Override
            protected void updateItem(Motor motor, boolean empty) {
                super.updateItem(motor, empty);

                if (motor == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(addToCartButton);
                addToCartButton.setOnAction(event -> {
                    Boolean found = false;
                    for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
                    {
                        if(entry.getKey().getProductID() == motor.getProductID())
                        {
                            entry.setValue(entry.getValue()+1);
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        Cart.AddProduct(motor);
                    }
                    System.out.println("Added to cart");
                });
            }
        });
        resultsTable.getColumns().add(column1);
        resultsTable.getColumns().add(column2);
        resultsTable.getColumns().add(column3);
        resultsTable.getColumns().add(column4);
        resultsTable.getColumns().add(column5);
        resultsTable.getColumns().add(column6);
        resultsTable.getColumns().add(column7);
        resultsTable.getColumns().add(addToCart);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT p.Price, c.Name, p.Model, m.* FROM ArduinoStore.dbo.Product p JOIN ArduinoStore.dbo.Motor m ON p.ProductId = m.ProductId JOIN ArduinoStore.dbo.Company c on p.CompanyId = c.CompanyId WHERE IsDeleted = 0";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int productId = resultSet.getInt("ProductId");
                    BigDecimal price = resultSet.getBigDecimal("Price");
                    String company = resultSet.getString("Name");
                    String model = resultSet.getString("Model");
                    BigDecimal voltage = resultSet.getBigDecimal("Voltage");
                    BigDecimal current = resultSet.getBigDecimal("MotorCurrent");
                    BigDecimal rotationSpeed = resultSet.getBigDecimal("RotationSpeed");
                    Motor motor = new Motor(productId, price, company, model, voltage, current, rotationSpeed);
                    resultsTable.getItems().add(motor);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewSensors(ActionEvent event)
    {
        resultsTable.getItems().removeAll(resultsTable.getItems());
        resultsTable.getColumns().removeAll(resultsTable.getColumns());
        TableColumn<Sensor, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<Sensor, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Sensor, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<Sensor, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<Sensor, String> column5 = new TableColumn<>("Type");
        column5.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Sensor, String> column6 = new TableColumn<>("Voltage");
        column6.setCellValueFactory(new PropertyValueFactory<>("voltage"));
        TableColumn<Sensor, String> column7 = new TableColumn<>("Digital Pin");
        column7.setCellValueFactory(new PropertyValueFactory<>("digitalPin"));
        TableColumn<Sensor, String> column8 = new TableColumn<>("Analog Pin");
        column8.setCellValueFactory(new PropertyValueFactory<>("analogPin"));
        TableColumn<Sensor, Sensor> addToCart = new TableColumn<>("");
        addToCart.setMinWidth(40);
        addToCart.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        addToCart.setCellFactory(param -> new TableCell<Sensor, Sensor>() {
            private final Button addToCartButton = new Button("Add to cart");

            @Override
            protected void updateItem(Sensor sensor, boolean empty) {
                super.updateItem(sensor, empty);

                if (sensor == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(addToCartButton);
                addToCartButton.setOnAction(event -> {
                    Boolean found = false;
                    for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
                    {
                        if(entry.getKey().getProductID() == sensor.getProductID())
                        {
                            entry.setValue(entry.getValue()+1);
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        Cart.AddProduct(sensor);
                    }
                    System.out.println("Added to cart");
                });
            }
        });
        resultsTable.getColumns().add(column1);
        resultsTable.getColumns().add(column2);
        resultsTable.getColumns().add(column3);
        resultsTable.getColumns().add(column4);
        resultsTable.getColumns().add(column5);
        resultsTable.getColumns().add(column6);
        resultsTable.getColumns().add(column7);
        resultsTable.getColumns().add(column8);
        resultsTable.getColumns().add(addToCart);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT p.Price, c.Name, p.Model, s.* FROM ArduinoStore.dbo.Product p JOIN ArduinoStore.dbo.Sensor s ON p.ProductId = s.ProductId JOIN ArduinoStore.dbo.Company c on p.CompanyId = c.CompanyId WHERE IsDeleted = 0";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int productId = resultSet.getInt("ProductId");
                    BigDecimal price = resultSet.getBigDecimal("Price");
                    String company = resultSet.getString("Name");
                    String model = resultSet.getString("Model");
                    String type = resultSet.getString("Type");
                    BigDecimal voltage = resultSet.getBigDecimal("Voltage");
                    Boolean digitalPin = resultSet.getBoolean("DigitalPin");
                    Boolean analogPin = resultSet.getBoolean("AnalogPin");
                    Sensor sensor = new Sensor(productId, price, company, model, type, voltage, digitalPin, analogPin);
                    resultsTable.getItems().add(sensor);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewWireSets(ActionEvent event)
    {
        resultsTable.getItems().removeAll(resultsTable.getItems());
        resultsTable.getColumns().removeAll(resultsTable.getColumns());
        TableColumn<WireSet, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<WireSet, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<WireSet, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<WireSet, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<WireSet, String> column5 = new TableColumn<>("Length");
        column5.setCellValueFactory(new PropertyValueFactory<>("length"));
        TableColumn<WireSet, String> column6 = new TableColumn<>("WiresNo");
        column6.setCellValueFactory(new PropertyValueFactory<>("wiresNo"));
        TableColumn<WireSet, WireSet> addToCart = new TableColumn<>("");
        addToCart.setMinWidth(40);
        addToCart.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        addToCart.setCellFactory(param -> new TableCell<WireSet, WireSet>() {
            private final Button addToCartButton = new Button("Add to cart");

            @Override
            protected void updateItem(WireSet wireSet, boolean empty) {
                super.updateItem(wireSet, empty);

                if (wireSet == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(addToCartButton);
                addToCartButton.setOnAction(event -> {
                    Boolean found = false;
                    for(HashMap.Entry<Product, Integer> entry : Cart.getCartItems().entrySet())
                    {
                        if(entry.getKey().getProductID() == wireSet.getProductID())
                        {
                            entry.setValue(entry.getValue()+1);
                            found = true;
                        }
                    }
                    if(!found)
                    {
                        Cart.AddProduct(wireSet);
                    }
                    System.out.println("Added to cart");
                });
            }
        });
        resultsTable.getColumns().add(column1);
        resultsTable.getColumns().add(column2);
        resultsTable.getColumns().add(column3);
        resultsTable.getColumns().add(column4);
        resultsTable.getColumns().add(column5);
        resultsTable.getColumns().add(column6);
        resultsTable.getColumns().add(addToCart);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT p.Price, c.Name, p.Model, ws.* FROM ArduinoStore.dbo.Product p JOIN ArduinoStore.dbo.WireSet ws ON p.ProductId = ws.ProductId JOIN ArduinoStore.dbo.Company c on p.CompanyId = c.CompanyId WHERE IsDeleted = 0";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int productId = resultSet.getInt("ProductId");
                    BigDecimal price = resultSet.getBigDecimal("Price");
                    String company = resultSet.getString("Name");
                    String model = resultSet.getString("Model");
                    int length = resultSet.getInt("Length");
                    int wiresNo = resultSet.getInt("WiresNo");
                    WireSet wireSet = new WireSet(productId, price, company, model, length, wiresNo);
                    resultsTable.getItems().add(wireSet);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewCartButton(ActionEvent event) throws IOException
    {
        Parent root;
        Stage appStage;
        appStage=(Stage)viewCartButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void handleOrderHistoryButton(ActionEvent event) throws IOException
    {
        Parent root;
        Stage appStage;
        appStage=(Stage)viewCartButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("OrderHistoryPage.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }
}
