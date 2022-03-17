<%-- 
    Document   : insert
    Created on : Feb 8, 2022, 2:50:32 PM
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
        <title>Insert Customer Page</title>
        <%
            ArrayList<Staff> staffs
                    = (ArrayList<Staff>) request.getAttribute("staffs");
        %>
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
                    <li><a href="searchcustomer">Customer</a></li>
                    <li><a href="login"> Log Out</a></li>
                </ul>
            </div>
        </div>
        <div class="insert-customer">
            <form action="insertcustomer" method="POST">
                <table border="1px" solid="red">
                    <p><span style="color:red">Insert </span><span style="color:blue">Customer</span></p>
                    <tr>
                        <td>
                            Name:
                        </td>
                        <td>
                            <input type="name" name="name" /> <br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Phone:
                        </td>
                        <td>
                            <input type="text" name="phone"/>
                        </td>
                    </tr>
                    </tr>
                    <tr>
                        <td>
                            Staff:
                        </td>
                        <td>
                            <select name="sid">
                                <% for (Staff s : staffs) {
                                %>
                                <option value="<%=s.getId()%>"><%=s.getName()%></option>
                                <%}%>
                            </select>   
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Save" class="save"/>
            </form>
        </div>
        <div class="footer">

            <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
            <p>Tel: 024 2242 9701 - 024 6327 8065</p>
            <p>Hotline: 0987 039 663 - 0915 018 968</p>
            <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

        </div>
    </body>
</html>
