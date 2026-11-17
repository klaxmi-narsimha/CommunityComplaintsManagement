
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resident Dashboard</title>
</head>

<body style="margin:0; font-family:Arial,sans-serif; background:#f3f5f9;">

    <div style="background:#1e293b; color:white; padding:20px 40px;
                display:flex; justify-content:space-between; align-items:center;">

        <h2 style="margin:0;">KLN Community</h2>

        <a href="${pageContext.request.contextPath}/logout"
           style="color:white; text-decoration:none; background:#dc3545;
                  padding:10px 18px; border-radius:6px;">
            Logout
        </a>
    </div>

    <div style="max-width:1000px; margin:40px auto; padding:20px;">

        <h2 style="color:#1e293b;">Resident Dashboard</h2>
        <p style="color:#64748b;">Welcome to your community portal.</p>

        <div style="background:white; padding:25px; border-radius:10px;
                    box-shadow:0 3px 12px rgba(0,0,0,0.08); margin-top:25px;">

            <h3 style="color:#1e293b;">Resident Details</h3>

            <p><b>Name:</b> ${loggedResident.name}</p>
            <p><b>Username:</b> ${loggedResident.userName}</p>
            <p><b>Block:</b> ${loggedResident.block}</p>
            <p><b>Flat Number:</b> ${loggedResident.flatNo}</p>
            <p><b>Mobile Number:</b> ${loggedResident.mobileNo}</p>
            <p><b>Email:</b> ${loggedResident.email}</p>

        </div>

        <div style="display:flex; gap:20px; margin-top:30px; flex-wrap:wrap;">

            <a href="complaintform"
               style="flex:1; min-width:200px; background:#2563eb;
                      color:white; padding:25px; text-align:center;
                      text-decoration:none; border-radius:10px;
                      font-size:18px; font-weight:bold;">
                + Raise a Complaint
            </a>

            <a href="residentcomplaints"
               style="flex:1; min-width:200px; background:#0f766e;
                      color:white; padding:25px; text-align:center;
                      text-decoration:none; border-radius:10px;
                      font-size:18px; font-weight:bold;">
                My Complaints
            </a>

        </div>

    </div>

</body>
</html>
