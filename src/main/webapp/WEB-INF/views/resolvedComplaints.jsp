
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.kln.model.Complaint" %>
<%@ page import="com.kln.model.ResidentEntity" %>

<%
    List<Complaint> complaints =
        (List<Complaint>) request.getAttribute("complaints");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Complaints</title>
</head>

<body style="margin:0; font-family:Arial,sans-serif; background:#f3f5f9;">

    <div style="padding:35px;">

        <h2 style="color:#183153; margin-top:0;">
            All Complaints
        </h2>

        <p style="color:#777;">
            KLN Gated Community - Complaint Management
        </p>

        <div style="background:white; padding:25px; margin-top:30px;
        border-radius:7px; box-shadow:0 2px 8px rgba(0,0,0,0.05);">

            <h3 style="color:#183153; margin-top:0;">
                Complaints Details
            </h3>

            <hr style="border:0; border-top:1px solid #eee;">

            <table style="width:100%; border-collapse:collapse; text-align:center;">

                <tr style="background:#183153; color:white;">
                    <th style="padding:13px;">Complaint ID</th>
                    <th style="padding:13px;">Resident ID</th>
                    <th style="padding:13px;">Resident Name</th>
                    <th style="padding:13px;">Block</th>
                    <th style="padding:13px;">Flat No</th>
                    <th style="padding:13px;">Category</th>
                    <th style="padding:13px;">Subject</th>
                    <th style="padding:13px;">Description</th>
                    <th style="padding:13px;">Remark</th>
                    <th style="padding:13px;">Status</th>
                </tr>

                <%
                    if (complaints != null && !complaints.isEmpty()) {

                        for (Complaint c : complaints) {

                            ResidentEntity resident = c.getResident();
                %>

                <tr style="border-bottom:1px solid #eee;">

                    <td style="padding:12px;">
                        <%= c.getComplaintId() %>
                    </td>

                    <td style="padding:12px;">
                        <%= resident.getResidentId() %>
                    </td>

                    <td style="padding:12px;">
                        <%= resident.getName() %>
                    </td>

                    <td style="padding:12px;">
                        <%= resident.getBlock() %>
                    </td>

                    <td style="padding:12px;">
                        <%= resident.getFlatNo() %>
                    </td>

                    <td style="padding:12px;">
                        <%= c.getCategory() %>
                    </td>

                    <td style="padding:12px;">
                        <%= c.getSubject() %>
                    </td>
                     </td>
                     
                     <td style="padding:12px;">
                        <%= c.getDescription() %>
                    </td>
                    
                    <td style="padding:12px;">
                        <%= c.getResolutionRemark() %>
                    </td>

                    <td style="padding:12px;">
                        <%= c.getStatus() %>
                    </td>

                </tr>

                <%
                        }
                    } else {
                %>

                <tr>
                    <td colspan="8" style="padding:20px; color:#777;">
                        No complaints found.
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
