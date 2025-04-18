package ItemController;

import db.ItemDBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Item;

import java.io.IOException;

public class AddItemController {
    public TextField txtcode;
    public TextField txtname;
    public TextField txtprice;
    public TextField txtqty;
    public Button btnAddItem;

    public void btnView(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/itemView/ViewItem.fxml"))));
        stage.show();
    }

    public void btnsearch(ActionEvent actionEvent) throws IOException {

    Stage stage = new Stage();
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/itemView/SearchItem.fxml"))));
    stage.show();
    }

    public void btnAddCustomer(ActionEvent actionEvent) {

        String code = txtcode.getText();
        String name = txtname.getText();
        Integer qty = Integer.parseInt(txtqty.getText());
        Double price = Double.parseDouble(txtprice.getText());

        Item item = new Item(code,name,qty,price);

        ItemDBConnection.getInstance().getDBList().add(item);
        new Alert(Alert.AlertType.INFORMATION,"Item Added Sucessfully").show();
        clearData();
    }

    public void clearData(){

           txtcode.clear();
           txtname.clear();
           txtprice.clear();
           txtqty.clear();
    }
}
