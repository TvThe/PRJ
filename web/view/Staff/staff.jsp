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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff List</title>
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

            function deleteStaff(id)
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
        <table border="1px">
            <tr>
                <td>Id </td>
                <td>Name</td>
                <td>Gender</td>
                <td>Phone</td>
                <td>Department</td>
                <td>Edit</td>
                <td>Del</td>
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
                <td> <a href="edit?id=<%=s.getId()%>"> <img src="image/edit.png"> </a> </td>
                <td><a href="#" onclick="deleteStaff(<%=s.getId()%>);" > <img src="image/delete.png"></a></td>
            </tr>
            <%}%>
        </table><br>
        <button> <a href="insert">New Staff</a> </button>

        <div class="footer">

            <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
            <p>Tel: 024 2242 9701 - 024 6327 8065</p>
            <p>Hotline: 0987 039 663 - 0915 018 968</p>
            <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

        </div>
    </body>
</html>
