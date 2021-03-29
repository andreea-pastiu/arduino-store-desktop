package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class Controller {
    public Controller()
    {
    }
    @FXML
    TextField usernameTextbox;
    @FXML
    PasswordField passwordField;
    @FXML
    Button btnLogin;
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException
    {
        Parent root;
        Stage appStage;
        try {
            // Code here.
            String dbURL = "jdbc:sqlserver://localhost:1433;user=sa;password=password1234;Initial Catalog=ArduinoStore;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                String username = usernameTextbox.getText();
                String password = passwordField.getText();
                String query = "SELECT a.AccountID FROM ArduinoStore.dbo.Account a JOIN ArduinoStore.dbo.Administrator ad ON a.AccountId = ad.AccountId WHERE Username = '" + username + "' and password = '" + password + "'";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
                if(resultSet.next())
                {
                    int userId = resultSet.getInt("AccountID");
                    appStage=(Stage)btnLogin.getScene().getWindow();
                    root=FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
                    Scene scene=new Scene(root);
                    appStage.setScene(scene);
                    appStage.show();
                    System.out.println(userId);
                }
                else
                {
                    String customerQuery = "SELECT a.AccountID, c.PremiumAccount  FROM ArduinoStore.dbo.Account a JOIN ArduinoStore.dbo.Customer c ON a.AccountId = c.AccountId WHERE Username = '" + username + "' and password = '" + password + "'";
                    resultSet = stmt.executeQuery(customerQuery);
                    if(resultSet.next())
                    {
                        int userId = resultSet.getInt("AccountID");
                        Boolean premiumAccount = resultSet.getBoolean("PremiumAccount");
                        Customer.setAccountId(userId);
                        Customer.setIsPremium(premiumAccount);
                        appStage=(Stage)btnLogin.getScene().getWindow();
                        root=FXMLLoader.load(getClass().getResource("CustomerPanel.fxml"));
                        Scene scene=new Scene(root);
                        appStage.setScene(scene);
                        appStage.show();
                        System.out.println(userId);
                    }
                    else
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Invalid username or password");
                        alert.show();
                        System.out.println("invalid username or password");
                    }
                }
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
