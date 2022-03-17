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

public class SearchCustomer extends BaseAuthenticationController{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffDBContext dbStaff = new StaffDBContext();
        ArrayList<Staff> staffs = dbStaff.getStaff(0);
        request.setAttribute("staffs", staffs);
        CustomerDBContext dbCustomer = new CustomerDBContext();
        String raw_page = request.getParameter("page");
        if(raw_page ==null || raw_page.trim().length() ==0)
            raw_page = "1";
        int pageindex = Integer.parseInt(raw_page);
        int pagesize = 10;
        ArrayList<Customer> customer = dbCustomer.getCustomer(pageindex, pagesize);
        int totalrecords = dbCustomer.count();
        int totalpage = (totalrecords%pagesize ==0)?totalrecords/pagesize
                :(totalrecords/pagesize)+1;
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/view/Customer/Customer.jsp").forward(request, response);

    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
