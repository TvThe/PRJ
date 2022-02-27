<%-- 
    Document   : search
    Created on : Jan 20, 2022, 1:18:10 PM
    Author     : Sap-lap
--%>

<%@page import="model.Staff"%>
<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff</title>
        <%
            ArrayList<Department> depts = (ArrayList<Department>) request.getAttribute("depts");
            ArrayList<Staff> staffs = (ArrayList<Staff>) request.getAttribute("staffs");
            int did = (Integer) request.getAttribute("did");
        %>
        <script>
            function submitSearchForm()
            {
                document.getElementById("searchForm").submit();
            }

            function deleteStudent(id)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = "delete?id=" + id;
                }
            }

        </script>
    </head>
    <body>
        <form id="searchForm" method="GET" action="search"> 
            Department: <select name="did" onchange="submitSearchForm();">
                <option value="-1">----SELECT A DEPARTMENT----</option>
                <% for (Department d : depts) {
                %>
                <option 
                    <%=(d.getId() == did) ? "selected=\"selected\"" : ""%>
                    value="<%=d.getId()%>"><%=d.getName()%></option>
                <%}%>
            </select> <br/>
        </form>
        <br/>
        <% if (staffs.size() > 0) { %>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Phone</td>
                <td>Department</td>
                <td></td>
            </tr>
            <% for (Staff s : staffs) {
            %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%
                    if (s.isGender() == true) {
                    %>
                    <a>Male</a>
                    <%
                    } else {
                    %>
                        <a>Female</a>
                    <%
                    }
                    %>
                </td>
                <td><%=s.getPhone()%></td>
                <td><%=s.getDept().getName()%></td>
                <td><a href="edit?id=<%=s.getId()%>">Edit</a> 
                    <a href="#" onclick="deleteStudent(<%=s.getId()%>);" >Delete</a></td>
            </tr>
            <%}%>
        </table>
        <%}else {%>
        No record to display.
        <%}%>
        <br/>
        <a href="insert">Insert</a>
    </body>
</html>
