<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/static" var="resources" />

<% 	
	Random rn = new Random();
	int random = rn.nextInt(1000)+1;
%>
<script type="text/javascript" src="${resources}/js/app/portal/gallery.js?r=<%=rn%>"></script>

<section class="gallery-container">
        <div class="tz-gallery">
            <div class="row">
	            <c:if test="${not empty galleryList}">
					<c:forEach var="gallery" items="${galleryList}">
		                <div class="col-sm-6 col-md-4">
		                    <div class="thumbnail">
		                        <a class="lightbox-thumbnail" onclick="gallery.openJssorSubGalley('${gallery.header}')">
		                            <img src="${gallery.imgPath}" alt="${gallery.imgName}">
		                        </a>
		                        <div class="caption">
		                            <h3>${gallery.header}</h3>
		                            <p>${gallery.content}</p>
		                        </div>
		                    </div>
		                </div>
					</c:forEach>
				</c:if>
            </div>
        </div>
    </section>