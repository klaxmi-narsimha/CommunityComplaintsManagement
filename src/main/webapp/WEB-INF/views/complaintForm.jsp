
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Raise Complaint</title>
</head>

<body style="margin:0; padding:30px 10px; font-family:Arial,sans-serif; background:#f3f5f9;">

<div style="width:450px; margin:40px auto; padding:30px;
background:white; border-radius:8px;
box-shadow:0 2px 12px rgba(0,0,0,0.08);">

    <h2 style="text-align:center; color:#183153; margin-bottom:8px;">
        Raise a Complaint
    </h2>

    <p style="text-align:center; color:#777; font-size:14px;">
        KLN Gated Community
    </p>

    <form action="${pageContext.request.contextPath}/home/submitcomplaint"
          method="post">

<label for="category">Complaint Category</label>
<select id="category" name="category" required
        style="width:100%; padding:12px; margin:8px 0 18px; border:1px solid #ccc; border-radius:6px;">
    <option value="">-- Select Complaint Category --</option>
    <option value="Plumbing">Plumbing</option>
    <option value="Cleaning">Cleaning</option>
    <option value="Electricity">Electricity</option>
    <option value="Water Supply">Water Supply</option>
    <option value="Lift / Elevator">Lift / Elevator</option>
    <option value="Security">Security</option>
    <option value="Parking">Parking</option>
    <option value="Garbage Collection">Garbage Collection</option>
    <option value="Noise Disturbance">Noise Disturbance</option>
    <option value="Garden / Maintenance">Garden / Maintenance</option>
    <option value="Common Area Maintenance">Common Area Maintenance</option>
    <option value="Others">Others</option>
</select>
        <label style="color:#333; font-size:14px;">
            Complaint Subject
        </label>

        <input type="text" name="subject" required
        placeholder="Enter complaint subject"
        style="width:100%; padding:12px; margin:9px 0 20px;
        box-sizing:border-box; border:1px solid #ccc;
        border-radius:4px;">

        <label style="color:#333; font-size:14px;">
            Complaint Description
        </label>

        <textarea name="description" required rows="5"
        placeholder="Describe your complaint..."
        style="width:100%; padding:12px; margin:9px 0 20px;
        box-sizing:border-box; border:1px solid #ccc;
        border-radius:4px; resize:vertical;"></textarea>

        <button type="submit"
        style="width:100%; padding:12px;
        background:#183153; color:white;
        border:none; border-radius:4px;
        font-size:15px; cursor:pointer;">
            Submit Complaint
        </button>

    </form>

    <p style="text-align:center; margin-top:22px; font-size:14px;">
        <a href="back"
        style="color:#183153; text-decoration:none;">
            Back to Dashboard
        </a>
    </p>

</div>

</body>
</html>
