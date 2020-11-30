<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user" action="/register" method="post" autocomplete="false">
        <div class="form-group">
            <form:input path="username" placeholder="Name" />
            <form:errors path="username" />
        </div>
        <div class="form-group">
            <form:input path="email" type="email" placeholder="Email" />
            <form:errors path="email" />
        </div>
        <div class="form-group">
            <form:password path="password" placeholder="Hasło" />
            <form:errors path="password" />
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło">
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Załóż konto</button>
            <a href="${pageContext.request.contextPath}/login" class="btn btn--without-border">Zaloguj się</a>
        </div>
    </form:form>
</section>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />
