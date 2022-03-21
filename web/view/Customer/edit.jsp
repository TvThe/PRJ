
<%@page import="model.Customer"%>
<%@page import="model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Department"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer Page</title>
        <%
            ArrayList<Staff> staffs
                    = (ArrayList<Staff>) request.getAttribute("staffs");

            Customer c = (Customer) request.getAttribute("customer");
        %>
    </head>
    <body>
        <div class="container">
            <div class="header">
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


            <div class="body" style="font-size: 30px;">
                <form action="editcustomer" method="POST">
                    <p><span style="color: blue">Edit </span><span style="color: green">Customer</span></p>
                    <table border="1px" style="margin-left: 810px;">
                        <tr>
                            <td>
                                Id:
                            </td>
                            <td>
                                <%=c.getId()%> <input type="hidden" name="id" value="<%=c.getId()%>"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Name:
                            </td>
                            <td>
                                <input type="text" name="name" value="<%=c.getName()%>" style="padding: 5px; margin: 4px 5px;" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Phone:
                            </td>
                            <td>
                                <input type="text" name="phone" value="<%=c.getPhone()%>" style="padding: 5px; margin: 4px 5px;" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Staff:
                            </td>
                            <td>
                                <select name="sid" style="padding: 5px 15px; margin-bottom: 6px;">
                                    <% for (Staff s : staffs) {
                                    %>
                                    <option  
                                        <%=(c.getStaff().getId() == s.getId()) ? "selected=\"selected\"" : ""%>
                                        value="<%=s.getId()%>"><%=s.getName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                    </table>
                                <input type="submit" value="Save" class="save" style="padding: 7px 15px; margin-top: 15px; border-radius: 5px; font-size: 20px;"/>
                </form>

            </div>
            <div class="footer">

                <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
                <p>Tel: 024 2242 9701 - 024 6327 8065</p>
                <p>Hotline: 0987 039 663 - 0915 018 968</p>
                <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

            </div>
        </div>
    </body>
</html>

