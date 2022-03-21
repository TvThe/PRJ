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
import model.Department;
import model.Staff;

public class StaffDBContext extends DBContext {
    public ArrayList<Staff> getStaff()
    {
        ArrayList<Staff> staffs = new ArrayList<>();
        try {
            String sql = "SELECT sid,sname FROM Staff";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Staff s = new Staff();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                staffs.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffs;
    }
    public ArrayList<Staff> getStaff(int did)
    {
        ArrayList<Staff> staffs = new ArrayList<>();
        try {
            String sql = "SELECT s.sid,s.sname,s.gender,s.phone,d.did,d.dname FROM \n" +
                    "Staff s INNER JOIN Department d ON s.did = d.did\n";
            if(did > -1)
                sql += " WHERE d.did = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            if(did > -1)
                stm.setInt(1, did);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Staff s = new Staff();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                s.setDept(d);
                staffs.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffs;
    }
    
    public Staff getStaffs(int id)
    {
        try {
            String sql = "SELECT s.sid,s.sname,s.gender,s.phone,d.did,d.dname FROM Staff s INNER JOIN Department d ON s.did = d.did WHERE s.sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                Staff s = new Staff();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                s.setDept(d);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void updateStaff(Staff s)
    {
        String sql = "UPDATE [Staff]\n" +
                    "   SET [sname] = ?\n" +
                    "      ,[gender] = ?\n" +
                    "      ,[phone] = ?\n" +
                    "      ,[did] = ?\n" +
                    " WHERE [sid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(5, s.getId());
            stm.setString(1, s.getName());
            stm.setBoolean(2, s.isGender());
            stm.setString(3, s.getPhone());
            stm.setInt(4, s.getDept().getId());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void insertStaff(Staff s)
    {
        String sql = "INSERT INTO [Staff]\n" +
                        "           ([sname]\n" +
                        "           ,[gender]\n" +
                        "           ,[phone]\n" +
                        "           ,[did])\n" +
                        "     VALUES\n" +
                        "           (?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getName());
            stm.setBoolean(2, s.isGender());
            stm.setString(3, s.getPhone());
            stm.setInt(4, s.getDept().getId());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void deleteStaff(int id)
    {
        String sql = "DELETE [Staff]\n" +
                    " WHERE [sid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
