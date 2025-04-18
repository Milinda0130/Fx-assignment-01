package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDBConnection {

    private static CustomerDBConnection instance;
    private List<Customer> customerList;
private CustomerDBConnection(){

 customerList = new ArrayList<>();

}

    public List<Customer> getDBList() {
        return customerList;
    }

    public static CustomerDBConnection getInstance(){

   return instance==null?instance=new CustomerDBConnection():instance;
    }
}
