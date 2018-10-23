<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="resources/static" var="resources" />

<section class="container gallery-container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_GALLERY')">${gallerySubBean.galleryName}</a></li>
            <li class="breadcrumb-item active" aria-current="page">${gallerySubBean.subGalleryName}</li>
        </ol>
    </nav>
    <div class="tz-gallery">
        <div class="row">
        	<c:if test="${not empty gallerySubBean.carouselList}">
        		<% int i = 0; %>
				<c:forEach var="carousel" items="${gallerySubBean.carouselList}">
		            <div class="col-sm-6 col-md-4">
		                <a class="lightbox" onclick="gallery.openJssorSubGalley('${i}')">
		                    <img src="${carousel.imgPath}" alt="${carousel.imgName}">
		                </a>
		            </div>
		            <% i++; %>
				</c:forEach>
			</c:if>
        </div>
    </div>
</section>

<script>
    $(document).ready(function () {
        //baguetteBox.run('.tz-gallery');
    });
</script>