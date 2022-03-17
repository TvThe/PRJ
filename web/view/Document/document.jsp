<%-- 
    Document   : search
    Created on : Jan 20, 2022, 1:18:10 PM
    Author     : Sap-lap
--%>

<%@page import="model.Document"%>
<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
        <%
            ArrayList<Document> document = (ArrayList<Document>) request.getAttribute("document");
            
        %>
        <script>
            function deleteDocument(id)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = "deletedocument?id=" + id;
                }
            }
        </script>
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
        
        <div class="document">
            <p><span style="color: red">Insert </span> <span style="color: blue">Document </span></p>
            <div class="table">
        <table border="1px">
            <tr>            
                <td>DOCUMENT'S NAME</td>
                <td>PAGES</td>
                <td>PRICE</td>
                <td>TOTAL PRICE</td>
                <td>Del</td>
            </tr>
            <% for (Document dc : document) {
            %>
            <tr>
                <td><%=dc.getName()%></td>
                <td><%=dc.getPages() %></td>
                <td><%=dc.getPrice() %></td>
                <td><%=dc.getPages() * dc.getPrice() %>VND</td>
                <td><a href="#" onclick="deleteDocument(<%= dc.getId() %>);" > <img src="image/delete.png"></a></td>
            </tr>
            <%}%>
        </table>
        </div>
        <a href="insertdocument" class="add">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                New Document</a>
        </div>
        
        <div class="footer">
            
            <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
            <p>Tel: 024 2242 9701 - 024 6327 8065</p>
            <p>Hotline: 0987 039 663 - 0915 018 968</p>
            <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

        </div>
    </body>
</html>
