<%-- 
    Document   : edit
    Created on : Feb 10, 2022, 1:06:01 PM
    Author     : SAP-LAP-FPT
--%>

<%@page import="model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Department"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
        <%
            ArrayList<Department> depts
                    = (ArrayList<Department>) request.getAttribute("depts");

            Staff s = (Staff) request.getAttribute("staff");
        %>
    </head>
    <body>
        <form action="edit" method="POST">
            Id: <%=s.getId()%> <input type="hidden" name="id" value="<%=s.getId()%>"/> <br/>
            Name: <input type="name" name="name" value="<%=s.getName()%>" /> <br/>
            Gender: <input type="radio" 
                           <%=s.isGender() ? "checked=\"checked\"" : ""%>
                           value="male" name="gender"/> Male 
            <input type="radio" value="female" 
                   <%=!s.isGender() ? "checked=\"checked\"" : ""%>
                   name="gender"/> Female <br/>
            Phone: <input type="text" name="phone" value="<%=s.getPhone()%>" /> <br/>
            Department: <select name="did">
                <% for (Department d : depts) {
                %>
                <option  
                    <%=(s.getDept().getId() == d.getId()) ? "selected=\"selected\"" : ""%>
                    value="<%=d.getId()%>"><%=d.getName()%></option>
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
