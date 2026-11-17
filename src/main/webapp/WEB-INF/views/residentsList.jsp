<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.kln.model.ResidentEntity" %>

<%
    List<ResidentEntity> residents =
        (List<ResidentEntity>) request.getAttribute("residents");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Residents List</title>
</head>

<body style="margin:0; font-family:Arial,sans-serif; background:#f3f5f9;">

    <div style="padding:35px;">

        <h2 style="color:#183153; margin-top:0;">
            All Registered Residents
        </h2>

        <p style="color:#777;">
            KLN Gated Community - Residents Information
        </p>

        <div style="background:white; padding:25px; margin-top:30px;
        border-radius:7px; box-shadow:0 2px 8px rgba(0,0,0,0.05);">

            <h3 style="color:#183153; margin-top:0;">
                Residents Details
            </h3>

            <hr style="border:0; border-top:1px solid #eee;">

            <table style="width:100%; border-collapse:collapse; text-align:center;">

                <tr style="background:#183153; color:white;">
                    <th style="padding:13px;">Resident ID</th>
                    <th style="padding:13px;">Name</th>
                    <th style="padding:13px;">Username</th>
                    <th style="padding:13px;">Block</th>
                    <th style="padding:13px;">Flat Number</th>
                    <th style="padding:13px;">Mobile</th>
                    <th style="padding:13px;">Email</th>
                </tr>

                <%
                    if (residents != null && !residents.isEmpty()) {
                        for (ResidentEntity resident : residents) {
                %>

                <tr style="border-bottom:1px solid #eee;">
                    <td style="padding:12px;"><%= resident.getResidentId() %></td>
                    <td style="padding:12px;"><%= resident.getName() %></td>
                    <td style="padding:12px;"><%= resident.getUserName() %></td>
                    <td style="padding:12px;"><%= resident.getBlock() %></td>
                    <td style="padding:12px;"><%= resident.getFlatNo() %></td>
                    <td style="padding:12px;"><%= resident.getMobileNo() %></td>
                    <td style="padding:12px;"><%= resident.getEmail() %></td>
                </tr>

                <%
                        }
                    } else {
                %>

                <tr>
                    <td colspan="7" style="padding:20px; color:#777;">
                        No residents registered yet.
                    </td>
                </tr>

                <%
                    }
                %>

            </table>

        </div>

        <a href="dashboard"
           style="display:inline-block; padding:12px 25px;
           background:#183153; color:white; text-decoration:none;
           border-radius:4px; margin-top:25px;">

            Back to President Dashboard

        </a>

    </div>

</body>
</html>
