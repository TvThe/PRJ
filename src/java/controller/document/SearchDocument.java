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
public class SearchDocument extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDBContext dbCustomer = new CustomerDBContext();
        ArrayList<Customer> customer = dbCustomer.getCustomer();
        request.setAttribute("customer", customer);
        String raw_cid = request.getParameter("cid");
        int cid = Integer.parseInt(raw_cid);
        DocumentDBContext dbDocument = new DocumentDBContext();
        ArrayList<Document> document = dbDocument.getDocument(cid);
        request.setAttribute("document", document);
        request.setAttribute("cid", cid);
        request.getRequestDispatcher("/view/Document/document.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String payment = request.getParameter("payment");
        request.setAttribute("payment", payment);
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
