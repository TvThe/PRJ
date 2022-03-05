/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author LENNOVO
 */
public class CustomerDBContext extends DBContext {
    public ArrayList<Customer> getCustomer()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT cname,phone FROM Customer";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Customer c = new Customer();
                c.setName(rs.getString("cname"));
                c.setPhone(rs.getString("phone"));
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
}
