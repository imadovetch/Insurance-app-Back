<%--
  Created by IntelliJ IDEA.
  User: Jay Cen
  Date: 7/2/2022
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>
<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />
    Name: <input type="text" name="assuranceid"><br /> <br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>