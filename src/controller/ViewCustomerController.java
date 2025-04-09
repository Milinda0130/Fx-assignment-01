package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

public class ViewCustomerController {

    public TableColumn colid;
    public TableColumn colname;
    public TableColumn colemail;
    public TableColumn coladdress;
    public TableColumn colphone;
    public TableColumn colsalary;
    public TableView tblCustomer;

    public void btnReload(ActionEvent actionEvent) {
    reloadTable();

    }

    public void btnAddCustomer(ActionEvent actionEvent) {
    }

    public void btnSearch(ActionEvent actionEvent) {
    }

    public void reloadTable(){

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colsalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

       DBConnection.getInstance().getDBList().forEach(customer ->{
           customerObservableList.add(customer);
               }

       );

       tblCustomer.setItems(customerObservableList);
    }
}
