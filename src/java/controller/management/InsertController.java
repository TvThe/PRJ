/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.management;

import controller.auth.BaseAuthenticationController;
import dal.DepartmentDBContext;
import dal.StaffDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.Staff;

public class InsertController extends BaseAuthenticationController {

    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DepartmentDBContext db = new DepartmentDBContext();
        ArrayList<Department> depts = db.getDepts();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("/view/Staff/insert.jsp").forward(request, response);
    }

    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_gender = request.getParameter("gender");
        String raw_phone = request.getParameter("phone");
        String raw_did = request.getParameter("did");

        int id = Integer.parseInt(raw_id);
        int did = Integer.parseInt(raw_did);
        String name = raw_name; //check length
        boolean gender = raw_gender.equals("male");
        String phone = raw_phone;

        Department d = new Department();
        d.setId(did);
        Staff s = new Staff();
        s.setId(id);
        s.setName(name);
        s.setGender(gender);
        s.setPhone(phone);
        s.setDept(d);

        StaffDBContext db = new StaffDBContext();
        db.insertStaff(s);
        response.sendRedirect("search");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
