<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h2>Registration</h2>
    <form action="/register" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation"><br>

        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender"><br>
        
        <label for="mobile">mobile:</label>
        <input type="tel" id="mobile" name="mobile"><br>
        
        <label for="state">State:</label>
        <input type="text" id="state" name="state"><br>

        <label for="country">Country:</label>
        <input type="text" id="country" name="country"><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
