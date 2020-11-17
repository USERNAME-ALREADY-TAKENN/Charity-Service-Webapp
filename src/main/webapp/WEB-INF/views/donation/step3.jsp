<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/fragments/header.jsp" />
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Przekaż dar
        </h1>
        <form:form method="post" modelAttribute="donation" action="/step/4" cssClass="donation-form">
            <form:input path="zipCode" placeholder="kod pocztowy" /><br>
            <form:input path="street" placeholder="ulica" /><br>
            <form:input path="city" placeholder="Miejscowość" /><br>
            <form:input path="quantity" placeholder="ilość" /><br>
            <form:textarea path="pickUpComment" placeholder="komentarz" /><br>
            <form:input type="date" path="pickUpDate" /><br>
            <form:input type="time" path="pickUpTime" /><br>
            <button type="submit">Dalej</button>
        </form:form>
    </div>
</div>
</header>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />