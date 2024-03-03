<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Email</th>
                <th>mobileno</th>
                <th>Email</th>
                <th>address</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.designation}</td>
                    <td>${employee.email}</td>
                    <td>${employee.mobileno}</td>
                     <td>${employee.address}</td>
                    <td>
                        <form action="/employees/delete/${employee.id}" method="post">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>Add Employee</h2>
    <form action="/employees/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
       
        <label for="mobile">Mobile:</label>
        <input type="tel" id="mobile" name="mobileno" required><br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br>
        <input type="submit" value="Add Employee">
    </form>
</body>
</html>
