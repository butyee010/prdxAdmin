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
	<ul class="nav nav-tabs">
	  <li class="nav-item">
	    <a class="nav-link active" data-toggle="tab" href="#ourworksGroup" onclick="ourWorks.tabOurWorksGroup()">Our Works</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#ourworksSubGroup" onclick="ourWorks.tabOurWorksSubGroup()">Our Works Sub</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#ourworksJssor" onclick="ourWorks.tabOurWorksJssor()">Our Works Jssor</a>
	  </li>
	</ul>
	
	<!-- Tab panes -->
	<div class="tab-content">
	  <div class="tab-pane active" id="ourworksGroup"></div>
	  <div class="tab-pane fade" id="ourworksSubGroup"></div>
	  <div class="tab-pane fade" id="ourworksJssor"></div>
	</div>
</section>

<script type='text/javascript'>
	ourWorks.tabOurWorksGroup();
</script>