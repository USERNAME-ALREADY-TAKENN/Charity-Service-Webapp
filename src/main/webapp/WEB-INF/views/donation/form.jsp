<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/fragments/header.jsp" />

<form:form modelAttribute="donation">
    <form:checkboxes path="categories" items="${categories}"/>
    <form:select path="institution" items="${institutions}"/>
    <form:input path="zipCode" />
    <form:input path="street" />
    <form:input path="city"/>
    <form:input path="quantity"/>
    <form:textarea path="pickUpComment"/>
    <form:input type="date" path="pickUpDate"/>
    <form:input type="time" path="pickUpTime" />
</form:form>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />