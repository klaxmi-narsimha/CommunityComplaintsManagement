
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>President Dashboard</title>
</head>

<body style="margin:0; padding:30px 10px; font-family:Arial,sans-serif; background:#f3f5f9;">

    <h2 style="color:#183153; margin:5px 0 30px 0;">
        Community Management
    </h2>

    <div style="display:grid;
                grid-template-columns:repeat(auto-fit,minmax(280px,1fr));
                gap:30px;">

        <!-- Residents List -->

        <a href="residentslist"
        style="background:white; padding:45px 38px;
        border-radius:10px; text-decoration:none;
        color:#183153; box-shadow:0 3px 10px rgba(0,0,0,0.06);">

            <h2>Residents List</h2>

            <p style="color:#777; font-size:18px;">
                View all registered community residents.
            </p>

        </a>


        <!-- View Complaints -->

        <a href="complaints"
        style="background:white; padding:45px 38px;
        border-radius:10px; text-decoration:none;
        color:#183153; box-shadow:0 3px 10px rgba(0,0,0,0.06);">

            <h2>View Complaints</h2>

            <p style="color:#777; font-size:18px;">
                Review and update complaint status.
            </p>

        </a>


        <!-- All Complaints -->

        <a href="allcomplaints"
        style="background:white; padding:45px 38px;
        border-radius:10px; text-decoration:none;
        color:#183153; box-shadow:0 3px 10px rgba(0,0,0,0.06);">

            <h2>All Complaints</h2>

            <p style="color:#777; font-size:18px;">
                View all submitted complaints.
            </p>

        </a>


        <!-- Resolved Complaints -->

        <a href="resolvedcomplaints"
        style="background:white; padding:45px 38px;
        border-radius:10px; text-decoration:none;
        color:#183153; box-shadow:0 3px 10px rgba(0,0,0,0.06);">

            <h2>Resolved Complaints History</h2>

            <p style="color:#777; font-size:18px;">
                View previously resolved complaints.
            </p>

        </a>

    </div>

</body>
</html>
