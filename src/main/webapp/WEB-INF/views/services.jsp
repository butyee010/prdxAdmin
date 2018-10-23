<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="resources/static" var="resources" />

<section class="services">
	<c:if test="${not empty serviceList}">
		<c:forEach var="service" items="${serviceList}">
		    <section class="row content section-content thumbnail" style="padding-top: 0">
		        <div class="col-sm-4">
		            <img class="d-block img-radius block-img-circle" src="${service.imgPath}" alt="${service.imgName}">
		        </div>
		        <div class="col-sm-8 block-content" style="padding-left: 0rem;">
		            <label class="label-header">${service.header}</label>
		            <p>${service.content}</p>
		        </div>
		    </section>
	    </c:forEach>
	</c:if>
</section>