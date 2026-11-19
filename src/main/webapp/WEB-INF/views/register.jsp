
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resident Registration</title>
</head>

<body style="margin:0; padding:0; font-family:Arial, sans-serif; background:#f3f5f9;">

<div style="width:420px; margin:40px auto; padding:30px;
background:white; border-radius:8px; box-shadow:0 2px 12px rgba(0,0,0,0.1);">

<h2 style="text-align:center; color:#183153; margin-bottom:5px;">
Resident Registration
</h2>

<p style="text-align:center; color:#777; font-size:13px;">
Create your community resident account
</p>

<form action="${pageContext.request.contextPath}/home/residentregister"
      method="post"
      onsubmit="return checkPassword()">

    <label>Full Name</label>
    <input type="text" name="name" required
    style="width:100%; padding:11px; margin:8px 0 15px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <label>UserName</label>
    <input type="text" name="userName" required
    style="width:100%; padding:11px; margin:8px 0 15px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <label>Block</label>
    <input type="text" name="block" required placeholder="Example: A"
    style="width:100%; padding:11px; margin:8px 0 15px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <label>FlatNumber</label>
    <input type="number" name="flatNumber" required
    style="width:100%; padding:11px; margin:8px 0 15px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <label>Mobile Number</label>
    <input type="tel" name="mobileNo" pattern="[0-9]{10}" required
    style="width:100%; padding:11px; margin:8px 0 15px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <label>Email Address</label>
    <input type="email" name="email" required
    style="width:100%; padding:11px; margin:8px 0 15px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <label>Create Password</label>
    <input type="password" id="password" name="password" required
    style="width:100%; padding:11px; margin:8px 0 8px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <label>Confirm Password</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required
    oninput="checkPasswordMatch()"
    style="width:100%; padding:11px; margin:8px 0 5px; box-sizing:border-box; border:1px solid #ccc; border-radius:4px;">

    <span id="passwordMessage" style="font-size:13px;"></span>

    <button type="submit"
    style="width:100%; padding:12px; margin-top:15px; background:#183153; color:white; border:none; border-radius:4px; font-size:15px; cursor:pointer;">

        Register

    </button>

</form>

<p style="text-align:center; font-size:14px; margin-top:20px;">
Already registered?
<a href="${pageContext.request.contextPath}" style="color:#183153; text-decoration:none;">Login here</a>
</p>
</div>
<script>
function checkPasswordMatch() {

    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var message = document.getElementById("passwordMessage");

    if (confirmPassword === "") {
        message.textContent = "";
    }
    else if (password === confirmPassword) {
        message.textContent = "Passwords match";
        message.style.color = "green";
    }
    else {
        message.textContent = "Passwords do not match";
        message.style.color = "red";
    }
}

function checkPassword() {

    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {
        alert("Password and Confirm Password must be the same.");
        return false;
    }

    return true;
}
</script>

</body>
</html>