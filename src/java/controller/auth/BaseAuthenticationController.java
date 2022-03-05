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
import javax.servlet.http.HttpSession;
import model.Account;

public abstract class BaseAuthenticationController extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null)//not login, some cookies
            {
                String username = null;
                String password = null;
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        username = cooky.getValue();
                    }
                    if (cooky.getName().equals("password")) {
                        password = cooky.getValue();
                    }
                }
                if (username == null || password == null) {
                    return false;
                } else {
                    AccountDBContext db = new AccountDBContext();
                    account = db.getAccount(username, password);
                    if (account != null) {
                        request.getSession().setAttribute("account", account);
                        return true;
                    } else {
                        return false;
                    }
                }
            } else //not login, not cookie
            {
                return false;
            }
        } else {
            String url = request.getServletPath();
            AccountDBContext db = new AccountDBContext();
            int role = db.checkRole(account.getUsername(), url);
            return role >= 1;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            //process business
            processGet(request, response);
        } else {
            response.getWriter().println("access denied!");
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processPost(request, response);
        } else {
            response.getWriter().println("access denied!");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
