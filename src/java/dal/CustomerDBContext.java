package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Staff;

public class CustomerDBContext extends DBContext {
    public ArrayList<Customer> getCustomers()
    {
        ArrayList<Customer> customer = new ArrayList<>();
        try {
            String sql = "SELECT cid, cname from Customer";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                customer.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public ArrayList<Customer> getCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT c.cid,s.sname,c.cname,c.phone FROM \n"
                    + "Customer c INNER JOIN Staff s ON c.sid = s.sid\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
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
    public ArrayList<Customer> getCustomer(int pageindex, int pagesize) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "select * from\n"
                    + "(SELECT c.cid,s.sid,s.sname,c.cname,c.phone, ROW_NUMBER() over (order by cid asc) as row_index from Customer c INNER JOIN Staff s ON c.sid = s.sid) c\n"
                    + "where row_index >= ((?-1)*?+1) and row_index <= (?*?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                c.setPhone(rs.getString("phone"));
                Staff s = new Staff();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                c.setStaff(s);
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
    public Customer getCustomers(int id) {
        try {
            String sql = "SELECT c.cid,s.sid,s.sname,c.cname,c.phone FROM Customer c INNER JOIN Staff s ON c.sid = s.sid WHERE c.cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                c.setPhone(rs.getString("phone"));
                Staff s = new Staff();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                c.setStaff(s);
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateCustomer(Customer c) {
        String sql = "[Customer]\n"
                + "   SET [cname] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[sid] = ?\n"
                + " WHERE cid = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(4, c.getId());
            stm.setString(1, c.getName());
            stm.setString(2, c.getPhone());
            stm.setInt(3, c.getStaff().getId());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void insertCustomer(Customer c) {
        String sql = "INSERT INTO [dbo].[Customer]\n"
                + "           ([cname]\n"
                + "           ,[phone]\n"
                + "           ,[sid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, c.getName());
            stm.setString(2, c.getPhone());
            stm.setInt(3, c.getStaff().getId());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public int count()
    {
        try {
            String sql = "select count(*) as total from Customer c INNER JOIN Staff s ON c.sid = s.sid ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
