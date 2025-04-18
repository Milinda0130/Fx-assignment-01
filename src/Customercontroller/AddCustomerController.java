package Customercontroller;

import db.CustomerDBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;

public class AddCustomerController   {
    public TextField txtsalary;
    public TextField txtphone;
    public TextField txtaddress;
    public TextField txtemail;
    public TextField txtname;
    public TextField txtid;


    public void btnItem(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/itemView/AddItem.fxml")))); // updated path
        stage.show(); // this is essential

    }


    public void btnView(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();

        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../customerView/ViewCustomerTable.fxml"))));
        stage.show();

    }

    public void btnsearch(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/customerView/SearchCustomer.fxml"))));
        stage.show();
    }

    public void btnAddCustomer(ActionEvent actionEvent) {

        Integer id = Integer.parseInt(txtid.getText());
        String name = txtname.getText();
        String email = txtemail.getText();
        String address = txtaddress.getText();
        String phone = txtphone.getText();
        Double salary = Double.parseDouble(txtsalary.getText());
        Customer customer = new Customer(id, name, email, address, phone, salary);


        CustomerDBConnection.getInstance().getDBList().add(customer);


        new Alert(Alert.AlertType.INFORMATION, "Customer Added Succesfully").show();

     clearData();


    }

    public void clearData(){

        txtid.clear();
        txtname.clear();
        txtemail.clear();
        txtaddress.clear();
        txtphone.clear();
        txtsalary.clear();
    }
}
