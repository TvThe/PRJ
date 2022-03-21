///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller.document;
//
//import dal.DocumentDBContext;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.Document;
//
///**
// *
// * @author LENNOVO
// */
//public class Search extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//       
//        DocumentDBContext dbDocument = new DocumentDBContext();
//        String raw_page = request.getParameter("page");
//        if(raw_page ==null || raw_page.trim().length() ==0)
//            raw_page = "1";
//        int pageindex = Integer.parseInt(raw_page);
//        int pagesize = 10;
//        ArrayList<Document> documents = dbDocument.getDocument(pageindex, pagesize);
//        int totalrecords = dbDocument.countDocument();
//        int totalpage = (totalrecords%pagesize ==0)?totalrecords/pagesize
//                :(totalrecords/pagesize)+1;
//        request.setAttribute("totalpage", totalpage);
//        request.setAttribute("pageindex", pageindex);
//        request.setAttribute("pagesize", pagesize);
//        request.setAttribute("documents", documents);
//        request.getRequestDispatcher("/view/Document/document.jsp").forward(request, response);
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
