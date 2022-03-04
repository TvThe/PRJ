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
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.Staff;

/**
 *
 * @author SAP-LAP-FPT
 */
public class EditController extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        DepartmentDBContext deptDB = new DepartmentDBContext();
        ArrayList<Department> depts = deptDB.getDepts();
        request.setAttribute("depts", depts);
        
        StaffDBContext staffDB = new StaffDBContext();
        Staff staff = staffDB.getStaffs(id);
        request.setAttribute("staff", staff);
        
        request.getRequestDispatcher("view/Staff/edit.jsp").forward(request, response);
    }

    @Override
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
        db.updateStaff(s);
        
        //response.getWriter().println("Student " + s.getId() + " is already added!");
        response.sendRedirect("search");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
