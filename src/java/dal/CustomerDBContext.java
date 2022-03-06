package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Staff;

/**
 *
 * @author LENNOVO
 */
public class CustomerDBContext extends DBContext {
    public ArrayList<Customer> getCustomer()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT s.sname,c.cname,c.phone FROM \n" +
                    "Customer c INNER JOIN Staff s ON c.sid = s.sid\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Customer c = new Customer();
                c.setName(rs.getString("cname"));
                c.setPhone(rs.getString("phone"));
                Staff s = new Staff();
                s.setName(rs.getString("sname"));
                c.setStaff(s);
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
}
