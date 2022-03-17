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

public class SearchController extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DepartmentDBContext dbDept = new DepartmentDBContext();
        ArrayList<Department> depts = dbDept.getDepts();
        request.setAttribute("depts", depts);
        String raw_did = request.getParameter("did");
        raw_did = (raw_did==null || raw_did.length() ==0)?"-1":raw_did;
        int did = Integer.parseInt(raw_did);
        StaffDBContext dbStaff = new StaffDBContext();
        ArrayList<Staff> staffs = dbStaff.getStaff(did);
        request.setAttribute("staffs", staffs);
        request.setAttribute("did", did);
        request.getRequestDispatcher("view/Staff/staff.jsp").forward(request, response);
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
