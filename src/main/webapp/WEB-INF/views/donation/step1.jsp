<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/fragments/header.jsp" />
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Przekaż dar
            </h1>
            <form:form method="post" modelAttribute="donation" action="/step/2" cssClass="donation-form">
                <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id" />
                <button type="submit">Dalej</button>
            </form:form>
        </div>
    </div>
</header>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />