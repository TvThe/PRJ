package controller.customer;

import dal.CustomerDBContext;
import dal.StaffDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Staff;

public class SearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffDBContext dbStaff = new StaffDBContext();
        ArrayList<Staff> staffs = dbStaff.getStaff(0);
        request.setAttribute("staffs", staffs);
        CustomerDBContext dbCustomer = new CustomerDBContext();
        ArrayList<Customer> customer = dbCustomer.getCustomer();
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("../view/Customer/Customer.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
