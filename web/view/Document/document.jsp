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
        <script src="js/pagger.js" type="text/javascript"></script>
        <%
            ArrayList<Document> document = (ArrayList<Document>) request.getAttribute("document");
            ArrayList<Document> documents = (ArrayList<Document>) request.getAttribute("documents");
            Integer totalpage = (Integer) request.getAttribute("totalpage");
            Integer pageindex = (Integer) request.getAttribute("pageindex");

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

            function check() {
                document.getElementById("myCheck").checked = true;
            }

            function uncheck() {
                document.getElementById("myCheck").checked = false;
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="logo">
                    <img src="image/logo.png">
                    <p><span style="color:red">Dịch</span> <span style="color:green ">Thuật</span><span style="color:blue"> Linh</span> <span style="color:yellow">Anh</span></p>
                </div>
                <div class="container-1">
                    <form action="searchinfo" method="POST">
                        <div class="box" >
                            <div class="container-1">
                                <table>
                                    <tr>
                                        <td>
                                            <span class="icon"><i class="fa fa-search"></i></span>
                                        </td>
                                        <td>
                                            <input type="search" id="search" name="search" placeholder="Search document..." />
                                        </td>
                                        <td>
                                            <input type="submit" value="Search" class="submit" style="margin-top: 60px; padding:7px 5px; ">
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </form>
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

            <div class="body">
                <p><span style="color: red; font-size: 30px; margin-top: 25px;">Insert </span> <span style="color: blue; font-size: 30px; margin-top: 25px;">Document </span></p>
                <div class="table" style="margin-left: 680px; margin-top: 15px; margin-bottom: 30px;">
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
                            <td><%=dc.getPages()%></td>
                            <td><%=dc.getPrice()%></td>
                            <td><%=dc.getPages() * dc.getPrice()%>VND</td>
                            <td><a href="#" onclick="deleteDocument(<%= dc.getId()%>);" > <img src="image/delete.png"></a></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
                <a href="insertdocument" class="add" style="background: bisque; color: black; text-decoration: none; border-radius: 8px; padding:5px 5px; font-size: 25px;">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    New Document</a>

                <div class="footer">

                    <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
                    <p>Tel: 024 2242 9701 - 024 6327 8065</p>
                    <p>Hotline: 0987 039 663 - 0915 018 968</p>
                    <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

                </div>
            </div>
    </body>
</html>
