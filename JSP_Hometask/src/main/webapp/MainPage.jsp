<%@ page import="java.util.List" %>

<%@ page import="domain.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <%
        Object booksObj = request.getAttribute("books");
        if(booksObj != null) {
            List<Book> books = (List<Book>) request.getAttribute("books");

            for (Book book : books) {
                try {
                    out.println("<tbody>");
                    out.println("<tr>");
                    out.println("<th scope='row'>" + book.getTitle() + "</th>");
                    out.println("<th scope='row'>" + book.getAuthor() + "</td>");
                    out.println("<th scope='row'>" + book.getPages() + "</td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                } catch (Exception exc) {
                    request.getRequestDispatcher("/error.jsp").forward(request,response);
                }
            }

        }


    %>
    </table>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
