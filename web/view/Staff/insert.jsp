<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Staff Page</title>
        <%
            ArrayList<Department> depts
                    = (ArrayList<Department>) request.getAttribute("depts");
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
            
            <div class="body" id="staff">  
                <div class="body-insert">
                <form action="insert" method="POST">
                    <p><span style="color: red">Insert</span> <span style="color: blue">Staff</span></p>
                    <table border="1px" class="insert-staff">

                        <tr>
                            <td>
                                Name:
                            </td>
                            <td>
                                <input type="name" name="name" class="input" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Gender:
                            </td>
                            <td>
                                <input type="radio" value="male" name="gender" class="gender"/> Male 
                                <input type="radio" value="female" name="gender" class="gender"/> Female <br/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Phone:
                            </td>
                            <td>
                                <input type="text" name="phone" class="input"/>
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
                                    <option value="<%=d.getId()%>"><%=d.getName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>

                    </table>
                    <input type="submit" value="Save" class="save"/>
                </form>
            </div>
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
