<%-- 
    Document   : insert
    Created on : Feb 8, 2022, 2:50:32 PM
    Author     : Sap-lap
--%>

<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
        <%
            ArrayList<Department> depts = 
                    (ArrayList<Department>) request.getAttribute("depts");
        %>
    </head>
    <body>
        <form action="insert" method="POST">
            Id: <input type="text" name="id"/> <br/>
            Name: <input type="name" name="name" /> <br/>
            Gender: <input type="radio" value="male" name="gender"/> Male 
            <input type="radio" value="female" name="gender"/> Female <br/>
            Phone: <input type="text" name="phone"/> <br/>
            Department: <select name="did">
                <% for (Department d : depts) {
                %>
                <option value="<%=d.getId()%>"><%=d.getName()%></option>
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
