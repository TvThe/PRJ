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
            ArrayList<Staff> staffs = 
                    (ArrayList<Staff>) request.getAttribute("staffs");
        %>
    </head>
    <body>
        <form action="insertcustomer" method="POST">
            Name: <input type="name" name="name" /> <br/>
            Phone: <input type="text" name="phone"/> <br/>
            Staff: <select name="sid">
                <% for (Staff s : staffs) {
                %>
                <option value="<%=s.getId()%>"><%=s.getName()%></option>
                <%}%>
            </select> <br/>
            <input type="submit" value="Save"/>
        </form>
            
            <div class="footer">
            
            <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
            <p>Tel: 024 2242 9701 - 024 6327 8065</p>
            <p>Hotline: 0987 039 663 - 0915 018 968</p>
            <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

        </div>
    </body>
</html>
