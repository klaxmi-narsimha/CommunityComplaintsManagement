
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>President Login</title>
</head>

<body style="margin:0; padding:0; font-family:Arial,sans-serif; background:#f3f5f9;">

<div style="width:380px; margin:110px auto; padding:35px;
background:white; border-radius:8px;
box-shadow:0 2px 12px rgba(0,0,0,0.1);">

<h2 style="text-align:center; color:#183153; margin-bottom:8px;">
Welcome to KLN
</h2>

<h3 style="text-align:center; color:#183153; margin-top:0;">
Gated Community
</h3>

<p style="text-align:center; color:#777; font-size:14px; margin-bottom:30px;">
President Admin Login
</p>

<form action="${pageContext.request.contextPath}/home/presidentpanel" method="Get ">

<label style="font-size:14px; color:#333;">
Username
</label>

<input type="text" name="username" required
placeholder="Enter your username"
style="width:100%; padding:12px; margin:9px 0 20px;
box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

<label style="font-size:14px; color:#333;">
Password
</label>

<input type="password" name="password" required
placeholder="Enter your password"
style="width:100%; padding:12px; margin:9px 0 25px;
box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

<button type="submit"
style="width:100%; padding:12px; background:#183153;
color:white; border:none; border-radius:4px;
font-size:15px; cursor:pointer;">
Login
</button>

</form>

<p style="text-align:center; color:#888; font-size:12px; margin-top:25px;">
KLN Gated Community Management System
</p>

</div>

</body>
</html>
