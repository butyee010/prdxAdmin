<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/static" var="resources" />

<section class="gallery-container">
		<nav aria-label="breadcrumb">
	        <ol class="breadcrumb">
	            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_GALLERY', 'back')">Gallery</a></li>
	            <li class="breadcrumb-item active" aria-current="page">Edit Gallery</li>
	        </ol>
	    </nav>
	    
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#galleryGroup" onclick="gallery.tabGalleryGroup()">Gallery</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#galleryJssor" onclick="gallery.tabGalleryJssor()">Gallery Jssor</a>
  </li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
  <div class="tab-pane active" id="galleryGroup"></div>
  <div class="tab-pane fade" id="galleryJssor"></div>
</div>
	
 </section>
 
<script type='text/javascript'>
	gallery.tabGalleryGroup();
</script>