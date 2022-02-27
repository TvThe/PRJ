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

/**
 *
 * @author Sap-lap
 */
public class StaffDBContext extends DBContext {
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
}