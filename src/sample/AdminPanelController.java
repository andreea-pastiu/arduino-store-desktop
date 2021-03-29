package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminPanelController
{
    ArrayList<Company> companies = new ArrayList<Company>();
    @FXML
    VBox arduinoBoardBox;
    @FXML
    VBox breadboardBox;
    @FXML
    VBox LEDBox;
    @FXML
    VBox motorBox;
    @FXML
    VBox sensorBox;
    @FXML
    VBox wireSetBox;
    @FXML
    HBox priceBox;
    @FXML
    HBox companyBox;
    @FXML
    HBox modelBox;
    @FXML
    HBox addBox;
    @FXML
    TextField priceInput;
    @FXML
    TextField modelInput;
    @FXML
    TextField boardSupplyVoltageInput;
    @FXML
    TextField boardDigitalPinsInput;
    @FXML
    TextField boardAnalogPinsInput;
    @FXML
    TextField boardFlashMemoryInput;
    @FXML
    TextField boardFrequencyInput;
    @FXML
    ComboBox companyComboBox;
    @FXML
    TextField breadboardWidthInput;
    @FXML
    TextField breadboardLengthInput;
    @FXML
    TextField breadboardTiePointsInput;
    @FXML
    TextField LEDColorInput;
    @FXML
    TextField LEDDiameterInput;
    @FXML
    TextField LEDCurrentInput;
    @FXML
    TextField motorVoltageInput;
    @FXML
    TextField motorCurrentInput;
    @FXML
    TextField motorRotationSpeedInput;
    @FXML
    TextField sensorTypeInput;
    @FXML
    TextField sensorVoltageInput;
    @FXML
    TextField sensorDigitalPinInput;
    @FXML
    TextField sensorAnalogPinInput;
    @FXML
    TextField wireSetLengthInput;
    @FXML
    TextField wireSetWiresNoInput;
    @FXML
    TableView tableDelete;
    @FXML
    public void initialize() {
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT * FROM ArduinoStore.dbo.Company";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int companyId = resultSet.getInt("CompanyID");
                    String name = resultSet.getString("Name");
                    Company current = new Company(companyId, name);
                    companies.add(current);
                    companyComboBox.getItems().add(name);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddArduinoBoard(ActionEvent event)
    {
        addBox.setVisible(true);
        addBox.setManaged(true);
        priceBox.setVisible(true);
        priceBox.setManaged(true);
        companyBox.setVisible(true);
        companyBox.setManaged(true);
        modelBox.setVisible(true);
        modelBox.setManaged(true);
        arduinoBoardBox.setVisible(true);
        arduinoBoardBox.setManaged(true);
        breadboardBox.setVisible(false);
        breadboardBox.setManaged(false);
        LEDBox.setVisible(false);
        LEDBox.setManaged(false);
        motorBox.setVisible(false);
        motorBox.setManaged(false);
        sensorBox.setVisible(false);
        sensorBox.setManaged(false);
        wireSetBox.setVisible(false);
        wireSetBox.setManaged(false);
        tableDelete.setVisible(false);
        tableDelete.setManaged(false);
        System.out.println("add board");
    }
    @FXML
    private void handleAddBreadboard(ActionEvent event)
    {
        addBox.setVisible(true);
        addBox.setManaged(true);
        priceBox.setVisible(true);
        priceBox.setManaged(true);
        companyBox.setVisible(true);
        companyBox.setManaged(true);
        modelBox.setVisible(true);
        modelBox.setManaged(true);
        arduinoBoardBox.setVisible(false);
        arduinoBoardBox.setManaged(false);
        breadboardBox.setVisible(true);
        breadboardBox.setManaged(true);
        LEDBox.setVisible(false);
        LEDBox.setManaged(false);
        motorBox.setVisible(false);
        motorBox.setManaged(false);
        sensorBox.setVisible(false);
        sensorBox.setManaged(false);
        wireSetBox.setVisible(false);
        wireSetBox.setManaged(false);
        tableDelete.setVisible(false);
        tableDelete.setManaged(false);
        System.out.println("add breadboard");
    }
    @FXML
    private void handleAddLED(ActionEvent event)
    {
        addBox.setVisible(true);
        addBox.setManaged(true);
        priceBox.setVisible(true);
        priceBox.setManaged(true);
        companyBox.setVisible(true);
        companyBox.setManaged(true);
        modelBox.setVisible(true);
        modelBox.setManaged(true);
        arduinoBoardBox.setVisible(false);
        arduinoBoardBox.setManaged(false);
        breadboardBox.setVisible(false);
        breadboardBox.setManaged(false);
        LEDBox.setVisible(true);
        LEDBox.setManaged(true);
        motorBox.setVisible(false);
        motorBox.setManaged(false);
        sensorBox.setVisible(false);
        sensorBox.setManaged(false);
        wireSetBox.setVisible(false);
        wireSetBox.setManaged(false);
        tableDelete.setVisible(false);
        tableDelete.setManaged(false);
        System.out.println("add LED");
    }
    @FXML
    private void handleAddMotor(ActionEvent event)
    {
        addBox.setVisible(true);
        addBox.setManaged(true);
        priceBox.setVisible(true);
        priceBox.setManaged(true);
        companyBox.setVisible(true);
        companyBox.setManaged(true);
        modelBox.setVisible(true);
        modelBox.setManaged(true);
        arduinoBoardBox.setVisible(false);
        arduinoBoardBox.setManaged(false);
        breadboardBox.setVisible(false);
        breadboardBox.setManaged(false);
        LEDBox.setVisible(false);
        LEDBox.setManaged(false);
        motorBox.setVisible(true);
        motorBox.setManaged(true);
        sensorBox.setVisible(false);
        sensorBox.setManaged(false);
        wireSetBox.setVisible(false);
        wireSetBox.setManaged(false);
        tableDelete.setVisible(false);
        tableDelete.setManaged(false);
        System.out.println("add motor");
    }
    @FXML
    private void handleAddSensor(ActionEvent event)
    {
        addBox.setVisible(true);
        addBox.setManaged(true);
        priceBox.setVisible(true);
        priceBox.setManaged(true);
        companyBox.setVisible(true);
        companyBox.setManaged(true);
        modelBox.setVisible(true);
        modelBox.setManaged(true);
        arduinoBoardBox.setVisible(false);
        arduinoBoardBox.setManaged(false);
        breadboardBox.setVisible(false);
        breadboardBox.setManaged(false);
        LEDBox.setVisible(false);
        LEDBox.setManaged(false);
        motorBox.setVisible(false);
        motorBox.setManaged(false);
        sensorBox.setVisible(true);
        sensorBox.setManaged(true);
        wireSetBox.setVisible(false);
        wireSetBox.setManaged(false);
        tableDelete.setVisible(false);
        tableDelete.setManaged(false);
        System.out.println("add sensor");
    }
    @FXML
    private void handleAddWireSet(ActionEvent event)
    {
        addBox.setVisible(true);
        addBox.setManaged(true);
        priceBox.setVisible(true);
        priceBox.setManaged(true);
        companyBox.setVisible(true);
        companyBox.setManaged(true);
        modelBox.setVisible(true);
        modelBox.setManaged(true);
        arduinoBoardBox.setVisible(false);
        arduinoBoardBox.setManaged(false);
        breadboardBox.setVisible(false);
        breadboardBox.setManaged(false);
        LEDBox.setVisible(false);
        LEDBox.setManaged(false);
        motorBox.setVisible(false);
        motorBox.setManaged(false);
        sensorBox.setVisible(false);
        sensorBox.setManaged(false);
        wireSetBox.setVisible(true);
        wireSetBox.setManaged(true);
        tableDelete.setVisible(false);
        tableDelete.setManaged(false);
        System.out.println("add wire set");
    }
    @FXML
    private void boardButtonAddAction(ActionEvent event)
    {
        BigDecimal price = new BigDecimal(priceInput.getText());
        String company = companyComboBox.getValue().toString();
        int companyId = companies.stream().filter(c -> c.getName() == company).findFirst().get().getCompanyId();
        String model = modelInput.getText();
        BigDecimal supplyVoltage = new BigDecimal(boardSupplyVoltageInput.getText());
        int digitalPins = Integer.parseInt(boardDigitalPinsInput.getText());
        int analogPins = Integer.parseInt(boardAnalogPinsInput.getText());
        BigDecimal flashMemory = new BigDecimal(boardFlashMemoryInput.getText());
        BigDecimal frequency = new BigDecimal(boardFrequencyInput.getText());
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Product VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                preparedStatement.setBigDecimal(1, price);
                preparedStatement.setInt(2, companyId);
                preparedStatement.setString(3, model);
                preparedStatement.setBoolean(4, false);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                    int productId = resultSet.getInt(1);
                    PreparedStatement preparedStatementBoard = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.ArduinoBoard VALUES(?,?,?,?,?,?); SELECT SCOPE_IDENTITY()");
                    preparedStatementBoard.setInt(1, productId);
                    preparedStatementBoard.setBigDecimal(2, supplyVoltage);
                    preparedStatementBoard.setInt(3, digitalPins);
                    preparedStatementBoard.setInt(4, analogPins);
                    preparedStatementBoard.setBigDecimal(5, flashMemory);
                    preparedStatementBoard.setBigDecimal(6, frequency);
                    preparedStatementBoard.execute();
                    ResultSet resultSetBoard = preparedStatementBoard.getGeneratedKeys();
                    if(resultSetBoard.next())
                    {
                        System.out.println("board insert ok");
                    }
                    else
                    {
                        System.out.println("failed to add board");
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void breadboardButtonAddAction(ActionEvent event)
    {
        BigDecimal price = new BigDecimal(priceInput.getText());
        String company = companyComboBox.getValue().toString();
        int companyId = companies.stream().filter(c -> c.getName() == company).findFirst().get().getCompanyId();
        String model = modelInput.getText();
        int width = Integer.parseInt(breadboardWidthInput.getText());
        int length = Integer.parseInt(breadboardLengthInput.getText());
        int tiePoints = Integer.parseInt(breadboardTiePointsInput.getText());
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Product VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                preparedStatement.setBigDecimal(1, price);
                preparedStatement.setInt(2, companyId);
                preparedStatement.setString(3, model);
                preparedStatement.setBoolean(4, false);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                    int productId = resultSet.getInt(1);
                    PreparedStatement preparedStatementBreadboard = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Breadboard VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                    preparedStatementBreadboard.setInt(1, productId);
                    preparedStatementBreadboard.setInt(2, width);
                    preparedStatementBreadboard.setInt(3, length);
                    preparedStatementBreadboard.setInt(4, tiePoints);
                    preparedStatementBreadboard.execute();
                    ResultSet resultSetBreadboard = preparedStatementBreadboard.getGeneratedKeys();
                    if(resultSetBreadboard.next())
                    {
                        System.out.println("breadboard insert ok");
                    }
                    else
                    {
                        System.out.println("failed to add breadboard");
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void LEDButtonAddAction(ActionEvent event)
    {
        BigDecimal price = new BigDecimal(priceInput.getText());
        String company = companyComboBox.getValue().toString();
        int companyId = companies.stream().filter(c -> c.getName() == company).findFirst().get().getCompanyId();
        String model = modelInput.getText();
        String color = LEDColorInput.getText();
        int diameter = Integer.parseInt(LEDDiameterInput.getText());
        BigDecimal LEDCurrent = new BigDecimal(LEDCurrentInput.getText());
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Product VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                preparedStatement.setBigDecimal(1, price);
                preparedStatement.setInt(2, companyId);
                preparedStatement.setString(3, model);
                preparedStatement.setBoolean(4, false);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                    int productId = resultSet.getInt(1);
                    PreparedStatement preparedStatementLED = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.LED VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                    preparedStatementLED.setInt(1, productId);
                    preparedStatementLED.setString(2, color);
                    preparedStatementLED.setInt(3, diameter);
                    preparedStatementLED.setBigDecimal(4, LEDCurrent);
                    preparedStatementLED.execute();
                    ResultSet resultSetLED = preparedStatementLED.getGeneratedKeys();
                    if(resultSetLED.next())
                    {
                        System.out.println("LED insert ok");
                    }
                    else
                    {
                        System.out.println("failed to add LED");
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void motorButtonAddAction(ActionEvent event)
    {
        BigDecimal price = new BigDecimal(priceInput.getText());
        String company = companyComboBox.getValue().toString();
        int companyId = companies.stream().filter(c -> c.getName() == company).findFirst().get().getCompanyId();
        String model = modelInput.getText();
        BigDecimal voltage = new BigDecimal(motorVoltageInput.getText());
        BigDecimal motorCurrent = new BigDecimal(motorCurrentInput.getText());
        BigDecimal rotationSpeed = new BigDecimal(motorRotationSpeedInput.getText());
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Product VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                preparedStatement.setBigDecimal(1, price);
                preparedStatement.setInt(2, companyId);
                preparedStatement.setString(3, model);
                preparedStatement.setBoolean(4, false);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                    int productId = resultSet.getInt(1);
                    PreparedStatement preparedStatementMotor = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Motor VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                    preparedStatementMotor.setInt(1, productId);
                    preparedStatementMotor.setBigDecimal(2, voltage);
                    preparedStatementMotor.setBigDecimal(3, motorCurrent);
                    preparedStatementMotor.setBigDecimal(4, rotationSpeed);
                    preparedStatementMotor.execute();
                    ResultSet resultSetMotor = preparedStatementMotor.getGeneratedKeys();
                    if(resultSetMotor.next())
                    {
                        System.out.println("motor insert ok");
                    }
                    else
                    {
                        System.out.println("failed to add motor");
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void sensorButtonAddAction(ActionEvent event)
    {
        BigDecimal price = new BigDecimal(priceInput.getText());
        String company = companyComboBox.getValue().toString();
        int companyId = companies.stream().filter(c -> c.getName() == company).findFirst().get().getCompanyId();
        String model = modelInput.getText();
        String type = sensorTypeInput.getText();
        BigDecimal voltage = new BigDecimal(sensorVoltageInput.getText());
        Boolean digitalPin = Boolean.parseBoolean(sensorDigitalPinInput.getText());
        Boolean analogPin = Boolean.parseBoolean(sensorAnalogPinInput.getText());
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Product VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                preparedStatement.setBigDecimal(1, price);
                preparedStatement.setInt(2, companyId);
                preparedStatement.setString(3, model);
                preparedStatement.setBoolean(4, false);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                    int productId = resultSet.getInt(1);
                    PreparedStatement preparedStatementSensor = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Sensor VALUES(?,?,?,?,?); SELECT SCOPE_IDENTITY()");
                    preparedStatementSensor.setInt(1, productId);
                    preparedStatementSensor.setString(2, type);
                    preparedStatementSensor.setBigDecimal(3, voltage);
                    preparedStatementSensor.setBoolean(4, digitalPin);
                    preparedStatementSensor.setBoolean(5, analogPin);
                    preparedStatementSensor.execute();
                    ResultSet resultSetSensor = preparedStatementSensor.getGeneratedKeys();
                    if(resultSetSensor.next())
                    {
                        System.out.println("sensor insert ok");
                    }
                    else
                    {
                        System.out.println("failed to add sensor");
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void wireSetButtonAddAction(ActionEvent event)
    {
        BigDecimal price = new BigDecimal(priceInput.getText());
        String company = companyComboBox.getValue().toString();
        int companyId = companies.stream().filter(c -> c.getName() == company).findFirst().get().getCompanyId();
        String model = modelInput.getText();
        int length = Integer.parseInt(wireSetLengthInput.getText());
        int wiresNo = Integer.parseInt(wireSetWiresNoInput.getText());
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.Product VALUES(?,?,?,?); SELECT SCOPE_IDENTITY()");
                preparedStatement.setBigDecimal(1, price);
                preparedStatement.setInt(2, companyId);
                preparedStatement.setString(3, model);
                preparedStatement.setBoolean(4, false);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                    int productId = resultSet.getInt(1);
                    PreparedStatement preparedStatementWireSet = conn.prepareStatement("INSERT INTO ArduinoStore.dbo.WireSet VALUES(?,?,?); SELECT SCOPE_IDENTITY()");
                    preparedStatementWireSet.setInt(1, productId);
                    preparedStatementWireSet.setInt(2, length);
                    preparedStatementWireSet.setInt(3, wiresNo);
                    preparedStatementWireSet.execute();
                    ResultSet resultSetWireSet = preparedStatementWireSet.getGeneratedKeys();
                    if(resultSetWireSet.next())
                    {
                        System.out.println("wire set insert ok");
                    }
                    else
                    {
                        System.out.println("failed to add wire set");
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteProducts(ActionEvent event)
    {
        addBox.setVisible(false);
        addBox.setManaged(false);
        priceBox.setVisible(false);
        priceBox.setManaged(false);
        companyBox.setVisible(false);
        companyBox.setManaged(false);
        modelBox.setVisible(false);
        modelBox.setManaged(false);
        arduinoBoardBox.setVisible(false);
        arduinoBoardBox.setManaged(false);
        breadboardBox.setVisible(false);
        breadboardBox.setManaged(false);
        LEDBox.setVisible(false);
        LEDBox.setManaged(false);
        motorBox.setVisible(false);
        motorBox.setManaged(false);
        sensorBox.setVisible(false);
        sensorBox.setManaged(false);
        wireSetBox.setVisible(false);
        wireSetBox.setManaged(false);
        tableDelete.setVisible(true);
        tableDelete.setManaged(true);
        tableDelete.getItems().clear();
        tableDelete.getColumns().clear();
        TableColumn<Product, String> column1 = new TableColumn<>("Product ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<Product, String> column2 = new TableColumn<>("Price($)");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Product, String> column3 = new TableColumn<>("Company");
        column3.setCellValueFactory(new PropertyValueFactory<>("company"));
        TableColumn<Product, String> column4 = new TableColumn<>("Model");
        column4.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn<Product, Product> delete = new TableColumn<>("");
        delete.setMinWidth(40);
        delete.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delete.setCellFactory(param -> new TableCell<Product, Product>() {
            private final Button deleteButton = new Button("Delete");

            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);

                if (product == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(deleteButton);
                deleteButton.setOnAction(event -> {
                    try {
                        String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
                        Connection conn = DriverManager.getConnection(dbURL);
                        if (conn != null) {
                            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE ArduinoStore.dbo.Product SET IsDeleted = 1 WHERE ProductId = ?");
                            preparedStatement.setInt(1, product.getProductID());
                            preparedStatement.execute();
                            tableDelete.getItems().remove(product);
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
        tableDelete.getColumns().add(column1);
        tableDelete.getColumns().add(column2);
        tableDelete.getColumns().add(column3);
        tableDelete.getColumns().add(column4);
        tableDelete.getColumns().add(delete);
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;initialCatalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String query = "SELECT p.ProductId, p.Price, c.Name, p.Model FROM ArduinoStore.dbo.Product p JOIN ArduinoStore.dbo.Company c ON p.CompanyId = c.CompanyId WHERE IsDeleted = 0";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                while(resultSet.next())
                {
                    int productId = resultSet.getInt("ProductId");
                    BigDecimal price = resultSet.getBigDecimal("Price");
                    String company = resultSet.getString("Name");
                    String model = resultSet.getString("Model");
                    Product product = new Product(productId, price, company, model);
                    tableDelete.getItems().add(product);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
