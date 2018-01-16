<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shop-Client</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}
        .table {
            width: 50%
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .row.content {height:auto;}
            .table {width:50%}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/hello">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/hello">Strona główna</a></li>
                <li class="active"><a href="/products">Produkty</a></li>
                <li><a href="/order">Zamówienia</a></li>
                <li><a href="/new_order">Złóż zamówienie</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-lg-12 text-left">
            <h3>Produkty w naszym sklepie:</h3>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Lp.</th>
                    <th scope="col">Nazwa</th>
                    <th scope="col">Opis</th>
                    <th scope="col">Kolor</th>
                    <th scope="col">Typ</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}" varStatus="counter">
                    <tr>
                        <td scope="row"><c:out value="${product.id}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.description}"/></td>
                        <td><c:out value="${product.color}"/></td>
                        <td><c:out value="${product.productType.name}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>