/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.auth;

import dal.AccountDBContext;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
public class Authentic extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/Auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountDBContext db = new AccountDBContext();
        Account account = db.getAccount(username, password);
        if (account != null) {
            request.getSession().setAttribute("account", account);
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);
                c_user.setMaxAge(24 * 3600 * 7);
                c_pass.setMaxAge(24 * 3600 * 7);
                response.addCookie(c_user);
                response.addCookie(c_pass);
            }
            response.sendRedirect("search");
        } else {
            response.getWriter().println("login failed!");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
