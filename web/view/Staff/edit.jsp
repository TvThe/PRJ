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
                        <li><a href="insert">Add Staff</a></li>
                        <li><a href="searchcustomer">Customer</a></li>
                        <li><a href="login"> Log Out</a></li>
                    </ul>
                </div>
            </div>

            <div class="body" id="staff">
                <p style="font-size: 30px;"><span style="color: red">Edit</span> <span style="color: blue">Staff</span></p>
                    <form action="edit" method="POST">
                        <table border="1px" id="table">
                            <tr>
                                <td>
                                    Id:
                                </td>
                                <td>
                                    <%=s.getId()%> <input type="hidden" name="id" value="<%=s.getId()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Name:
                                </td>
                                <td>
                                    <input type="name" name="name" value="<%=s.getName()%>" class="input"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Gender:
                                </td>
                                <td>
                                    <input type="radio" <%=s.isGender() ? "checked=\"checked\"" : ""%> value="male" name="gender" class="gender"/> Male 
                                    <input type="radio" value="female" <%=!s.isGender() ? "checked=\"checked\"" : ""%> name="gender" class="gender"/> Female <br/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Phone:
                                </td>
                                <td>
                                    <input type="text" name="phone" value="<%=s.getPhone()%>" class="input" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Department:
                                </td>
                                <td>
                                    <select name="did">
                                        <% for (Department d : depts) {
                                        %>
                                        <option  
                                            <%=(s.getDept().getId() == d.getId()) ? "selected=\"selected\"" : ""%>
                                            value="<%=d.getId()%>"><%=d.getName()%></option>
                                        <%}%>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>

                                </td>
                                <td>
                                    <input type="submit" value="Save" class="save"/>
                                </td>
                            </tr>
                        </table>
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
