<%-- 
    Document   : search
    Created on : Jan 20, 2022, 1:18:10 PM
    Author     : Sap-lap
--%>

<%@page import="model.Customer"%>
<%@page import="model.Staff"%>
<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
        <%
            ArrayList<Customer> customer = (ArrayList<Customer>) request.getAttribute("customer");
            ArrayList<Staff> staffs = (ArrayList<Staff>) request.getAttribute("staffs");
            int sid = (Integer) request.getAttribute("sid");
        %>
        <script>
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
        <br/>
        <table border="1px">
            <tr>
                <td>CUSTOMER'S NAME</td>
                <td>PHONE</td>
                <td></td>
                <td>STAFF'S</td>
            </tr>
            <% for (Customer c : customer) {
            %>
            <tr>
                <td><%=c.getName()%></td>
                <td><%=c.getPhone()%></td>
                <td><a href="#">Document</a> </td>
                <td><%=c.getStaff().getName()%></td>
            </tr>
            <%}%>
        </table>
        <br/>
        <button> <a href="../customer/insert">New Customer</a> </button>
        
        <div class="footer">
            
            <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
            <p>Tel: 024 2242 9701 - 024 6327 8065</p>
            <p>Hotline: 0987 039 663 - 0915 018 968</p>
            <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

        </div>
    </body>
</html>
