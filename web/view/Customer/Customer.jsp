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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
        <%
            ArrayList<Customer> customer = (ArrayList<Customer>) request.getAttribute("customer");
            ArrayList<Staff> staffs = (ArrayList<Staff>) request.getAttribute("staffs");
            Integer totalpage = (Integer)request.getAttribute("totalpage");
            Integer pageindex = (Integer)request.getAttribute("pageindex");
        %>
        <script src="js/pagger.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="header-home">
            <div class="logo">
                <img src="image/logo.png">
                <p><span style="color:red">Dịch</span> <span style="color:green ">Thuật</span><span style="color:blue"> Linh</span> <span style="color:yellow">Anh</span></p>
            </div>
            <div class="menu">
                <ul>
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="#">Introduce</a></li>
                    <li><a href="#">Support</a></li>
                    <li><a href="search">Staff</a></li>
                    <li><a href="insert">Add Staff</a></li>
                    <li><a href="searchcustomer">Customer</a></li>
                    <li><a href="login"> Log Out</a></li>
                </ul>
            </div>
        </div>
        <div class="customer">
            <p style="font-size: 30px; margin-left: 90px"><span style="color:red">List </span> <span style="color:blue">Customer </span></p>
        <div class="customer-table">
            <table border="1px">
                <tr>
                    <td>ID</td>
                    <td>STAFF'S</td>                
                    <td>CUSTOMER'S NAME</td>
                    <td>PHONE</td>
                    <td>Document</td>
                    <td>Edit</td>
                </tr>
                <% for (Customer c : customer) {
                %>
                <tr>
                    <td><%= c.getId()%></td>
                    <td><%=c.getStaff().getName()%></td>
                    <td><%=c.getName()%></td>
                    <td><%=c.getPhone()%></td>
                <form action="searchdocument" method="GET" name="cid">
                    <td><a href="searchdocument?cid=<%= c.getId()%>" ><img src="image/view.png"></a> </td>
                </form>
                <td> <a href="editcustomer?id=<%=c.getId()%>"> <img src="image/edit.png"> </a> </td>
                </tr>
                <%}%>
            </table>
        </div>
            <a href="insertcustomer" class="add">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                New Customer</a>
        </div>
       <div id="paggerbot" class="container"> </div>
       <script class="pagger">
            pagger('paggerbot',<%=pageindex%>,<%=totalpage%>,2);
        </script>
            
        <div class="footer">

            <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
            <p>Tel: 024 2242 9701 - 024 6327 8065</p>
            <p>Hotline: 0987 039 663 - 0915 018 968</p>
            <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

        </div>
    </body>
</html>
