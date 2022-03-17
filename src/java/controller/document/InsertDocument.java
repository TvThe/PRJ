/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.document;

import controller.auth.BaseAuthenticationController;
import dal.CustomerDBContext;
import dal.DocumentDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Document;

/**
 *
 * @author LENNOVO
 */
public class InsertDocument extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CustomerDBContext db = new CustomerDBContext();
        ArrayList<Customer> customers = db.getCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("view/Document/insert.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_name = request.getParameter("name");
        String raw_page = request.getParameter("page");
        String raw_price = request.getParameter("price");
        String raw_cid = request.getParameter("cid");
                
        String name = raw_name; //check length
        int page = Integer.parseInt(raw_page);
        int price = Integer.parseInt(raw_price);
        int cid = Integer.parseInt(raw_cid);

        Customer c = new Customer();
        c.setId(cid);
        Document dc = new Document();
        dc.setName(name);
        dc.setPages(page);
        dc.setPrice(price);
        dc.setCustomer(c);

        DocumentDBContext db = new DocumentDBContext();
        db.insertDocument(dc);
        response.sendRedirect("searchcustomer");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
