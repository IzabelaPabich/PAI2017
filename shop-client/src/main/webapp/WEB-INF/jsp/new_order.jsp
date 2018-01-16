<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
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
        .selectWidth{
            margin-left: 10px;
            width: 10%;
        }
        .inputWidth{
            margin-left: 10px;
            width: 10%;
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .row.content {height:auto;}
            .selectWidth{width:10%; margin-left: 10px;}
            .inputWidth{width:10%; margin-left: 10px;}
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
                <li><a href="/products">Produkty</a></li>
                <li><a href="/order">Zamówienia</a></li>
                <li class="active"><a href="/new_order">Złóż zamówienie</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-lg-12 text-left">
            <h3>Nowe zamówienie</h3>
            <form role="form" class="form-horizontal" action="/new_order" method="POST" modelAttribute="newOrderForm">
                <div class="form-group">
                    <label for="product">Produkt</label>
                    <select class="form-control selectWidth" id="product" name="name">
                        <c:forEach var="product" items="${products}" varStatus="counter">
                        <option><c:out value="${product.id}"/>, <c:out value="${product.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="quantity">Ilość</label>
                    <input type="text" class="form-control inputWidth" id="quantity" placeholder="Ilość" name="quantity"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Złóż zamówienie</button>
            </form>
            <c:if test="${not empty newOrder.id}">
                <h4>Zamówienie na <c:out value="${newOrder.orderedProduct.name}"/> w ilości <c:out value="${newOrder.quantity}"/> zostało złożone.</h4>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>