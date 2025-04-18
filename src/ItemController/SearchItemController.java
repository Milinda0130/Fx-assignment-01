package ItemController;

import db.ItemDBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Item;

public class SearchItemController {
    public TextField txtcode;
    public TextField txtname;
    public TextField txtqty;
    public TextField txtprice;

    public void btnSearchItem(ActionEvent actionEvent) {

        String code = txtcode.getText();

        if (code.isEmpty()){

            new Alert(Alert.AlertType.WARNING,"PLease input the Code To Search").show();
          return;
        }

        Item itm = null;

        for (Item item : ItemDBConnection.getInstance().getDBList()) {

            if (item.getCode().equalsIgnoreCase(code)){

                itm = item;
                break;
            }
        }

        if (itm!=null){

            txtname.setText(itm.getName());
            txtprice.setText(String.valueOf(itm.getPrice()));
            txtqty.setText(String.valueOf(itm.getQty()));
        }

    }

    public void btnUpdate(ActionEvent actionEvent) {

        String code = txtcode.getText();
        if (code.isEmpty()){

            new Alert(Alert.AlertType.WARNING,"Please Input to code Update").show();
            return;

        }

        boolean Truecode = false;

        for (Item item : ItemDBConnection.getInstance().getDBList()){

            if (item.getCode().equalsIgnoreCase(code)){

                item.setName(txtname.getText());
                item.setPrice(Double.parseDouble(txtprice.getText()));
                item.setQty(Integer.parseInt(txtqty.getText()));

                Truecode = true;

            }

        }

        if (Truecode){

            clearData();
            new Alert(Alert.AlertType.INFORMATION,"Item Update Successfully").show();
        }

        else {

            clearData();
            new Alert(Alert.AlertType.WARNING,"Item Not Found").show();

        }

    }

    public void btnDelete(ActionEvent actionEvent) {

        String code =  txtcode.getText();
        if (code.isEmpty()){

            new Alert(Alert.AlertType.WARNING,"Please Input code to delete").show();

        }

       Item deleteItem = null;

        for (Item item : ItemDBConnection.getInstance().getDBList()){

            if (item.getCode().equalsIgnoreCase(code)){

                deleteItem = item;

                break;
            }
            else {

                new Alert(Alert.AlertType.WARNING,"Customer Not Found").show();
                clearData();
            }
        }

        if (deleteItem!=null){
            ItemDBConnection.getInstance().getDBList().remove(deleteItem);
            new Alert(Alert.AlertType.CONFIRMATION,"Item Delete Successfully").show();
            clearData();
        }
    }

    public void clearData(){

        txtcode.clear();
        txtname.clear();
        txtprice.clear();
        txtqty.clear();
    }
}
