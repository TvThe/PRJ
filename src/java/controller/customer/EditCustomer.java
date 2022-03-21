package controller.customer;

import controller.auth.BaseAuthenticationController;
import dal.CustomerDBContext;
import dal.StaffDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Staff;

public class EditCustomer extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        StaffDBContext staffDB = new StaffDBContext();
        ArrayList<Staff> staffs = staffDB.getStaff();
        request.setAttribute("staffs", staffs);
        
        CustomerDBContext customerDB = new CustomerDBContext();
        Customer customer = customerDB.getCustomers(id);
        request.setAttribute("customer", customer);
        
        request.getRequestDispatcher("view/Customer/edit.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_cid =request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_phone = request.getParameter("phone");
        String raw_sid = request.getParameter("sid");
        
        int cid = Integer.parseInt(raw_cid);
        int sid = Integer.parseInt(raw_sid);
        String name = raw_name; //check length
        String phone = raw_phone;
        
        Staff s = new Staff();
        s.setId(sid);
        Customer c = new Customer();
        c.setId(cid);
        c.setName(name);
        c.setPhone(phone);
        c.setStaff(s);
        CustomerDBContext db = new CustomerDBContext();
        db.updateCustomer(c);
        
        response.sendRedirect("searchcustomer");

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
