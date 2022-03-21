/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.search;

import dal.CustomerDBContext;
import dal.DocumentDBContext;
import dal.StaffDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Document;
import model.Staff;

public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_name = request.getParameter("search");
        String name = "%" + raw_name + "%";
        StaffDBContext dbStaff = new StaffDBContext();
        ArrayList<Staff> staffs = dbStaff.getStaff(0);
        request.setAttribute("staffs", staffs);
        CustomerDBContext dbCustomer = new CustomerDBContext();
        ArrayList<Customer> customer = dbCustomer.getCustomers(name);
        Customer c = new Customer();
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/view/Search/find.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_name = request.getParameter("search");
        String name = "%" + raw_name + "%";
        CustomerDBContext dbCustomer = new CustomerDBContext();
        ArrayList<Customer> customer = dbCustomer.getCustomer(0);
        request.setAttribute("customer", customer);
        DocumentDBContext dbDoc = new DocumentDBContext();
        ArrayList<Document> document = dbDoc.getDocument(name);
        request.setAttribute("document", document);
        request.getRequestDispatcher("/view/Document/document.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
