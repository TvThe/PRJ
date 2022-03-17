<%-- 
    Document   : login
    Created on : Feb 25, 2022, 3:03:02 PM
    Author     : LENNOVO
--%>

<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication</title>
        <%
            ArrayList<Account> login = (ArrayList<Account>) request.getAttribute("account");
        %>
        <script src="js/pagger.js" type="text/javascript"></script>
        
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header-login">
            <p><span style="color:red">Dịch</span> <span style="color:green ">Thuật</span><span style="color:blue"> Linh</span> <span style="color:yellow">Anh</span></p>
        </div>

        <div class="banner">
            <img src="image/banner5.png">

        </div>
        <div class="login-box">
            <h2>Login</h2>
            <p style="color: white; text-align: center; padding-bottom: 10px;">Sign in to your account below!</p>
            <form action="login" method="POST" onsubmit="return validateForm()" name="myForm" required>
                <div class="user-box">
                    <input type="text" name="username">
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input type="password" name="password">
                    <label>Password</label>
                </div>
                <a href="">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <button>Submit</button>
                </a>
            </form>
        </div>

        <div class="footer">

            <p>Address: 167 Tran Dang Ninh, Dich Vong Ward, Cau Giay District, Hanoi City </p>
            <p>Tel: 024 2242 9701 - 024 6327 8065</p>
            <p>Hotline: 0987 039 663 - 0915 018 968</p>
            <p>Email : Linhanh.co@gmail.com  ||  Website: www.dichthuatlinhanh.com.vn</p>

        </div>
    </body>
</html>
