<%@page import="model.Staff"%>
<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff List</title>
        <%
            ArrayList<Department> depts = (ArrayList<Department>) request.getAttribute("depts");
            ArrayList<Staff> staffs = (ArrayList<Staff>) request.getAttribute("staffs");
            int did = (Integer) request.getAttribute("did");
        %>
        <script>
            function submitSearchForm()
            {
                document.getElementById("searchForm").submit();
            }

            function deleteStaff(id)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = "delete?id=" + id;
                }
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
                <div class="menu">
                    <ul>
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="#">Introduce</a></li>
                        <li><a href="#">Support</a></li>
                        <li><a href="insert">Add Staff</a></li>
                        <li><a href="searchcustomer">Customer</a></li>
                        <li><a href="login"> Log Out</a></li>
                    </ul>
                </div>
            </div>

            <div class="body" id="staff">
                <div class="search-staff">
                    <form id="searchForm" method="GET" action="search"> 
                        Department: <select name="did" onchange="submitSearchForm();">
                            <option value="-1">----SELECT A DEPARTMENT----</option>
                            <% for (Department d : depts) {
                            %>
                            <option 
                                <%=(d.getId() == did) ? "selected=\"selected\"" : ""%>
                                value="<%=d.getId()%>"><%=d.getName()%></option>
                            <%}%>
                        </select> <br/>
                    </form>
                    <br/>
                </div>
                <div class="table">
                    <table border="1px">
                        <tr>
                            <td>Id </td>
                            <td>Name</td>
                            <td>Gender</td>
                            <td>Phone</td>
                            <td>Department</td>
                            <td>Edit</td>
                            <td>Del</td>
                        </tr>
                        <% for (Staff s : staffs) {
                        %>
                        <tr>
                            <td><%=s.getId()%></td>
                            <td><%=s.getName()%></td>
                            <td><%
                                if (s.isGender() == true) {
                                %>
                                <a>Male</a>
                                <%
                                } else {
                                %>
                                <a>Female</a>
                                <%
                                    }
                                %>
                            </td>
                            <td><%=s.getPhone()%></td>
                            <td><%=s.getDept().getName()%></td>
                            <td> <a href="edit?id=<%=s.getId()%>"> <img src="image/edit.png"> </a> </td>
                            <td><a href="#" onclick="deleteStaff(<%=s.getId()%>);" > <img src="image/delete.png"></a></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
                <a href="insert" class="add">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    New Staff</a>
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
