<%-- 
    Document   : edit
    Created on : Feb 10, 2022, 1:06:01 PM
    Author     : SAP-LAP-FPT
--%>

<%@page import="model.Customer"%>
<%@page import="model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Department"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer Page</title>
        <%
            ArrayList<Staff> staffs
                    = (ArrayList<Staff>) request.getAttribute("staffs");

            Customer c = (Customer) request.getAttribute("customer");
        %>
    
    <body>
        <form action="editcustomer" method="POST">
            Id: <%=c.getId()%> <input type="hidden" name="id" value="<%=c.getId()%>"/> <br/>
            Name: <input type="name" name="name" value="<%=c.getName()%>" /> <br/>
            Phone: <input type="text" name="phone" value="<%=c.getPhone()%>" /> <br/>
            Staff: <select name="sid">
                <% for (Staff s : staffs) {
                %>
                <option  
                    <%=(c.getStaff().getId() == s.getId()) ? "selected=\"selected\"" : ""%>
                    value="<%=s.getId()%>"><%=s.getName()%></option>
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

