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
import model.Document;

public class DocumentDBContext extends DBContext {
    public ArrayList<Document> getDocument(String name)
    {
        ArrayList<Document> document = new ArrayList<>();
        try {
            String sql = "SELECT dc.dcid, dc.dcname,dc.page,dc.[price/1page], c.cname, c.cid FROM Document dc INNER JOIN Customer c ON dc.cid = c.cid where dc.dcname like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Document dc = new Document();
                dc.setId(rs.getInt("dcid"));
                dc.setName(rs.getString("dcname"));
                dc.setPages(rs.getInt("page"));
                dc.setPrice(rs.getInt("price/1page"));
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                dc.setCustomer(c);
                document.add(dc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;
    }

    public ArrayList<Document> getDocument(int pageindex, int pagesize) {
        ArrayList<Document> document = new ArrayList<>();
        try {
            String sql = "select * from (SELECT dc.dcid,c.cid,c.cname,dc.dcname,dc.page, dc.[price/1page], ROW_NUMBER() over (order by dcid asc) as row_index from Document dc INNER JOIN Customer c ON dc.cid = c.cid) dc\n"
                    + "where row_index >= ((@pageindex-1)*@pagesize+1) and row_index <= (@pageindex*@pagesize)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Document dc = new Document();
                dc.setId(rs.getInt("dcid"));
                dc.setName(rs.getString("dcname"));
                dc.setPages(rs.getInt("page"));
                dc.setPrice(rs.getInt("[price/1page]"));
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                dc.setCustomer(c);
                document.add(dc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;
    }

    public ArrayList<Document> getDocument() {
        ArrayList<Document> document = new ArrayList<>();
        try {
            String sql = "SELECT dc.dcid,dc.dcname,page, dc.[price/1page],c.cid FROM Document dc INNER JOIN Customer c ON dc.cid = c.cid\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Document dc = new Document();
                dc.setId(rs.getInt("dcid"));
                dc.setName(rs.getString("dcname"));
                dc.setPages(rs.getInt("page"));
                dc.setPrice(rs.getInt("price/1page"));
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
                dc.setCustomer(c);
                document.add(dc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;
    }

    public Document getDocuments(int id) {
        try {
            String sql = "SELECT dc.dcid,c.cid,dc.dcname,c.cname,dc.page, dc.[price/1page] FROM Document dc INNER JOIN Customer c ON dc.cid = c.cid WHERE dc.dcid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Document dc = new Document();
                dc.setId(rs.getInt("dcid"));
                dc.setName(rs.getString("dcname"));
                dc.setPages(rs.getInt("page"));
                dc.setPrice(rs.getInt("price/1page"));
                Customer c = new Customer();
                c.setId(rs.getInt("sid"));
                dc.setCustomer(c);
                return dc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Document> getDocument(int cid) {
        ArrayList<Document> documents = new ArrayList<>();
        try {
            String sql = "SELECT dc.dcid,dc.dcname,page, dc.[price/1page],c.cid FROM \n"
                    + "Document dc INNER JOIN Customer c ON dc.cid = c.cid\n";
            if (cid > -1) {
                sql += " WHERE c.cid = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (cid > -1) {
                stm.setInt(1, cid);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Document dc = new Document();
                dc.setId(rs.getInt("dcid"));
                dc.setName(rs.getString("dcname"));
                dc.setPages(rs.getInt("page"));
                dc.setPrice(rs.getInt("price/1page"));
                Customer c = new Customer();
                c.setId(rs.getInt("cid"));
                dc.setCustomer(c);
                documents.add(dc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documents;
    }

    public void updateDocument(Document dc) {
        String sql = "UPDATE [dbo].[Document]\n"
                + "   SET [dcname] = ?\n"
                + "      ,[page] = ?\n"
                + "      ,[price/1page] = ?\n"
                + "      ,[cid] = ?\n"
                + " WHERE dcid=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(5, dc.getId());
            stm.setString(1, dc.getName());
            stm.setInt(2, dc.getPages());
            stm.setInt(3, dc.getPrice());
            stm.setInt(4, dc.getCustomer().getId());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void deleteDocument(int id) {
        String sql = "DELETE [Document]\n"
                + " WHERE [dcid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void insertDocument(Document dc) {
        String sql = "INSERT INTO [dbo].[Document]\n"
                + "           ([dcname]\n"
                + "           ,[page]\n"
                + "           ,[price/1page]\n"
                + "           ,[cid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, dc.getName());
            stm.setInt(2, dc.getPages());
            stm.setInt(3, dc.getPrice());
            stm.setInt(4, dc.getCustomer().getId());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DocumentDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public int countDocument(int id)
    {
        try {
            String sql = "select count(*) as total from Document dc INNER JOIN Customer c ON dc.cid = c.cid where c.cid =? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
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
