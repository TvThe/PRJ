/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class InsertCustomer extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffDBContext db = new StaffDBContext();
        ArrayList<Staff> staffs = db.getStaff();
        request.setAttribute("staffs", staffs);
        request.getRequestDispatcher("view/Customer/insert.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String raw_name = request.getParameter("name");
        String raw_phone = request.getParameter("phone");
        String raw_sid = request.getParameter("sid");

        int sid = Integer.parseInt(raw_sid);
        String name = raw_name; //check length
        String phone = raw_phone;

        Staff s = new Staff();
        s.setId(sid);
        Customer c = new Customer();
        c.setName(name);
        c.setPhone(phone);
        c.setStaff(s);

        CustomerDBContext db = new CustomerDBContext();
        db.insertCustomer(c);
        response.sendRedirect("searchcustomer");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
