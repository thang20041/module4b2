<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="/student/edit/${id}" method="post">
    <div class="form-group">
        <input name='id' type="text" class="form-control" aria-describedby="emailHelp" value="${editStudent.id}" hidden="hidden">
        <label>Name</label>
        <input name='name' type="text" class="form-control" aria-describedby="emailHelp" value="${editStudent.name}">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input name="email" type="text" class="form-control" value="${editStudent.email}">
    </div>
    <div class="form-group">
        <label>Date Of Birth</label>
        <input name="dateOfBirth" type="text" class="form-control" value="${editStudent.dob}">
    </div>
    <div class="form-group">
        <label>Address</label>
        <input name="address" type="text" class="form-control" value="${editStudent.address}">
    </div>
    <div class="form-group">
        <label>Phone Number</label>
        <input name="phoneNumber" type="text" class="form-control" value="${editStudent.phone}">
    </div>
    <div class="form-group">
        <label>Class</label>
        <Select name="classRoomId" value="${editStudent.clazz.name}">
            <c:forEach var="item" items="${clasezList}">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </Select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
