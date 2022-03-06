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
            ArrayList<Account> login= (ArrayList<Account>) request.getAttribute("account");
        %>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header-login">
            <h1 >Dich thuật Linh Anh</h1>
        </div>
        <div class="login">
            <form action="login" method="POST">
                <h1>Sign in to your account below</h1>
                <p><input type="text" name="username" placeholder="Username"></p>
                <p><input type="password" name="password" placeholder="Password"></p>
                <p><input type="checkbox" value="remember" name="remember"/> Remember Me!</p>
                <Button>Sign in</Button>
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
