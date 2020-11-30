<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

<section class="list">
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Ilość</th>
                <th>Rodzaj</th>
                <th>Adres</th>
                <th>Data odbioru</th>
                <th>Komentarz</th>
                <th>Instytucja</th>
                <th>Darczyńca</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${donations}" var="donation" varStatus="status">
                <tr>
                    <td>${status.index}</td>
                    <td>${donation.quantity}x</td>
                    <td>
                        <c:forEach items="${donation.categories}" var="category" varStatus="s">
                            ${category.name}<c:if test="${not s.last}">, </c:if>
                        </c:forEach>
                    </td>
                    <td>${donation.zipCode} ${donation.city}, ${donation.street}</td>
                    <td>${donation.pickUpTime} ${donation.pickUpDate}</td>
                    <td>${donation.pickUpComment}</td>
                    <td>${donation.institution.name}</td>
                    <td>${donation.user.username}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<section class="list">
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Użytkownik</th>
                <th>E-mail</th>
                <th>Dołączył</th>
                <th>Aktywny</th>
                <th>Liczba dotacji</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr>
                    <td>${status.index}</td>
                    <td>${user.username}x</td>
                    <td>${user.email}</td>
                    <td>${user.registeredOn}</td>
                    <td>${user.enabled}</td>
                    <td>${user.donations.size()}</td>
                    <td><a href="/admin/user/ban/${user.id}">${user.enabled ? "Zablokuj" : "Odblokuj"}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
</header>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />