<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/static" var="resources" />

<form class="form" style="padding-top: 1rem;" action="gallery/submitEditJssor" id="editGalleryJssorForm" enctype="multipart/form-data" method="POST">
	<div class="col-sm-12 form-group">
		<select class="form-control" name="galleryGroup">
			<c:if test="${not empty galleryList}">
				<c:forEach var="gallery" items="${galleryList}">
					<option value="${gallery.header}">${gallery.header}</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
	<div id="galleryJssorTable"></div>
</form>
<div class="row button-box">
	<div class="box">
		<button type="button" class="btn btn-primary" onclick="gallery.openDialogEditGalleryJssor()">Submit</button>
	</div>
</div>

<script type="text/javascript">
	gallery.onLoadEditGalleryJssor();
</script>