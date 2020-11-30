<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="!isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/login#form" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="${pageContext.request.contextPath}/register#form" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="logged-user">
                    Witaj <sec:authentication property="name"/>
                    <ul class="dropdown">
                        <li><a href="${pageContext.request.contextPath}/profile">Profil</a></li>
                        <li><a href="${pageContext.request.contextPath}/donation/list">Moje zbiórki</a></li>
                        <sec:authorize access="hasAuthority('ADMIN')">
                            <li><a href="${pageContext.request.contextPath}/admin">Panel administratora</a></li>
                        </sec:authorize>
                        <li><a href="${pageContext.request.contextPath}/logout">Wyloguj</a></li>
                    </ul>
                </li>
            </sec:authorize>
        </ul>

        <ul>
            <li><a href="${pageContext.request.contextPath}/" class="btn btn--without-border active">Start</a></li>
            <li><a href="${pageContext.request.contextPath}/#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="${pageContext.request.contextPath}/#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="${pageContext.request.contextPath}/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="${pageContext.request.contextPath}/donation/add" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="${pageContext.request.contextPath}/#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
