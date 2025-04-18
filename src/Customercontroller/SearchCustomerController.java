package Customercontroller;

import db.CustomerDBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

public class SearchCustomerController {
    public TextField txtsalary;
    public TextField txtphone;
    public TextField txtaddress;
    public TextField txtemail;
    public TextField txtname;
    public TextField txtid;

    public void btnDelete(ActionEvent actionEvent) {

        String phone = txtphone.getText();
        if (phone.isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please input Phone Number To Delete").show();
        }

        Customer deleteCustomer = null;

        for (Customer customer : CustomerDBConnection.getInstance().getDBList()){
            if (customer.getPhone().equalsIgnoreCase(phone)){

                deleteCustomer = customer;

                break;

            }
else {

    new Alert(Alert.AlertType.WARNING,"This Number is Not Found").show();
            }

        }

        if (deleteCustomer!=null){

            CustomerDBConnection.getInstance().getDBList().remove(deleteCustomer);
            new Alert(Alert.AlertType.INFORMATION,"Delete Successfully").show();
        }

    }

    public void btnUpdate(ActionEvent actionEvent) {

        String phone = txtphone.getText();

        if (phone.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please input Phone Number to Search").show();
            return;
        }

        boolean trueNumber = false;

        for (Customer customer : CustomerDBConnection.getInstance().getDBList()) {
            if (customer.getPhone().equalsIgnoreCase(phone)) {

                customer.setName(txtname.getText());
                customer.setId(Integer.parseInt(txtid.getText()));
                customer.setAddress(txtaddress.getText());
                customer.setEmail(txtemail.getText());
                customer.setSalary(Double.parseDouble(txtsalary.getText()));

                trueNumber = true;
                break;
            }
        }

        if (trueNumber) {
            new Alert(Alert.AlertType.INFORMATION, "Customer Updated Successfully").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Customer Not Found").show();
        }
    }


    public void btnSearchCustomer(ActionEvent actionEvent) {
        String phone =  txtphone.getText();
       if (phone.isEmpty()){

           new Alert(Alert.AlertType.WARNING,"Please input the Number").show();
              return;
       }

        Customer c1 = null;

       for(Customer customer : CustomerDBConnection.getInstance().getDBList()){

           if (customer.getPhone().equalsIgnoreCase(phone)){

               c1 = customer;
               break;

           }


       }
       if (c1 != null){

           txtname.setText(c1.getName());
           txtid.setText(String.valueOf(c1.getId()));
           txtaddress.setText(c1.getAddress());
           txtemail.setText(c1.getEmail());
           txtsalary.setText(String.valueOf(c1.getSalary()));


       }

    }

}