
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resident Login</title>
</head>

<body style="margin:0; padding:0; font-family:Arial, sans-serif; background:#f3f5f9;">

<div style="width:360px; margin:100px auto; padding:35px;
background:white; border-radius:8px; box-shadow:0 2px 12px rgba(0,0,0,0.1);">

<h2 style="text-align:center; color:#183153;">
Resident Login
</h2>

<p style="text-align:center; color:#777; font-size:13px;">
Welcome back to your KLN community portal
</p>

<form action="${pageContext.request.contextPath}/home/residentpanel" method="Get">

<label>Email Address</label>
<input type="email" name="email" required
style="width:100%; padding:12px; margin:10px 0 20px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

<label>Password</label>
<input type="password" name="password" required
style="width:100%; padding:12px; margin:10px 0 25px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

<button type="submit"
style="width:100%; padding:12px; background:#183153; color:white; border:none; border-radius:4px; font-size:15px; cursor:pointer;">
Login
</button>

</form>

<p style="text-align:center; font-size:14px; margin-top:22px;">
New resident?
<a href="${pageContext.request.contextPath}/home/register" style="color:#183153; text-decoration:none;">Create Account</a>
</p>

</div>
</body>
</html>
