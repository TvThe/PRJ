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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
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
    </body>
</html>
