package ItemController;

import db.ItemDBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

public class ViewItemController {
    public TableColumn colprice;
    public TableColumn colqty;
    public TableColumn colname;
    public TableColumn colcode;
    public TableView tblitem;

    public void btnReload(ActionEvent actionEvent) {
        realoadTable();
    }

    public  void realoadTable(){

        colcode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

        ItemDBConnection.getInstance().getDBList().forEach(item->{
            itemObservableList.add(item);
        });

      tblitem.setItems(itemObservableList);
    }
}
