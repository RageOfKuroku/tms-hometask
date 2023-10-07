<%@ page import="java.util.List" %>

<%@ page import="hometask.org.hometask.domain.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
    </style>
</head>
<body>
Lib++
<hr>
<form action="/add" method="post"><br>
    Title: <label><input type="text" name="title"></label><br>
    Descr: <label><input type="text" name="description"></label><br>
    Pages: <label><input type="text" name="pages"></label><br>
    Author:<label><input type="text" name="author"></label><br>
    <input type="submit" value="Add">
    <hr>


    <table class="table">
        <thead class="thead">
        <tr>
            <th scope="col">Название книги</th>
            <th scope="col">Автор</th>
            <th scope="col">Страниц</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.books}" var="book">
            <tbody>
            <tr>
                <th scope="row">${book.title}</th>
                <td>${book.author}</td>
                <td>${book.pages}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>

</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
