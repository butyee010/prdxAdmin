<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.Random"%>
<spring:url value="/resources/static" var="resources" />

<% 	
	Random rn = new Random();
	int random = rn.nextInt(1000)+1;
%>

<section class="our-works">
	<nav aria-label="breadcrumb">
	        <ol class="breadcrumb">
	            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_OUR_WORKS', 'back')">Our Works</a></li>
	            <li class="breadcrumb-item active" aria-current="page">Edit Our Works</li>
	        </ol>
	    </nav>
	<% boolean top = true; %>
	<c:if test="${not empty ourWorksMap}">
		<c:forEach var="ourWorksItemMap" items="${ourWorksMap}">
			<% if (top) { %>
				<section class="row content section-content" style="padding-top: 0">
			<% } else { %>
				<section class="row content section-content">
			<% } %>
				<c:forEach var="ourWorks" items="${ourWorksItemMap.value}">
					<div class="col-sm-4 thumbnail">
						<div>
							<img class="d-block w-100 img-radius" onclick="ourWorks.openSubOurWorks('${ourWorks.header}')" src="${ourWorks.imgPath}" alt="${ourWorks.imgName}">
						</div>
						<div class="content">
							<label class="big-font">${ourWorks.header}</label>
						</div>
						<div class="normal-font padding-left">
							<p>${ourWorks.content}</p>
						</div>
					</div>
				</c:forEach>
			</section>
			<% top = false; %>
		</c:forEach>
	</c:if>
	<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="ourWorks.openDialogEditOurWorks()">Submit</button>
	        </div>
	    </div>
</section>