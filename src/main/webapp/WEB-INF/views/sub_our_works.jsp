<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="resources/static" var="resources" />

<section class="sub-our-works">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_OUR_WORKS', 'back')">${ourWorksSubBean.ourWorksName}</a></li>
            <li class="breadcrumb-item active" aria-current="page">${ourWorksSubBean.subOurWorksName}</li>
        </ol>
    </nav>
    <c:if test="${not empty ourWorksSubBean.itemSubOurWorksMap}">
        <% int i = 0; %>
		<c:forEach var="itemSub" items="${ourWorksSubBean.itemSubOurWorksMap}">
			<section class="row content section-content" style="padding-top: 0">
		        <div class="col-sm-4">
		            <img class="d-block w-100 img-radius" src="${itemSub.value.imgPath}" alt="${itemSub.value.imgName}" onclick="ourWorks.openJssorSubOurWorks('${ourWorksSubBean.subOurWorksName}' ,'${itemSub.key}')">
		        </div>
		        <div class="col-sm-8 block-content">
		            <label class="label-header">${itemSub.value.topicName}</label>
		            <p>${itemSub.value.content}</p>
		        </div>
		    </section>
		</c:forEach>
	</c:if>
</section>