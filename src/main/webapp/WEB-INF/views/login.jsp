<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <input type="text" name="username" placeholder="Name">
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło">
        </div>

        <div class="form-group form-group--buttons">
            <a href="${pageContext.request.contextPath}/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
        <c:if test="${param.error}">
            <div align="center">
                <p>Nieprawidłowe dane</p>
            </div>
        </c:if>
    </form>
</section>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />
