<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="resources/static" var="resources" />

<section class="home">
    <section id="carouselPrdx" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        	<c:if test="${not empty homeBean.carouselList}">
				<% int i = 0; %>
				<c:set var="frist" value="true"/>
				<c:forEach var="carousel" items="${homeBean.carouselList}">
					<c:choose>
						<c:when test="${frist}">
							<li data-target="#carouselPrdx" data-slide-to="<%=i%>" class="active"></li>
						</c:when>
						<c:otherwise>
							<li data-target="#carouselPrdx" data-slide-to="<%=i%>"></li>
						</c:otherwise>
						</c:choose>
				<c:set var="frist" value="false"/>
				<% i++; %>
				</c:forEach>
			</c:if>
        </ol>
        <div class="carousel-inner">
        	<c:if test="${not empty homeBean.carouselList}">
				<c:set var="frist" value="true"/>
				<c:forEach var="carousel" items="${homeBean.carouselList}">
					<c:choose>
						<c:when test="${frist}">
							<div class="carousel-item active">
				                <img class="d-block w-100" src="${carousel.imgPath}" alt="${carousel.imgName}">
				            </div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
				                 <img class="d-block w-100" src="${carousel.imgPath}" alt="${carousel.imgName}">
				            </div>
						</c:otherwise>
					</c:choose>
				<c:set var="frist" value="false"/>
				</c:forEach>
			</c:if>
        </div>
        <a class="carousel-control-prev" href="#carouselPrdx" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselPrdx" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </section>

    <section class="row content-padding content-margin-top">
        <div class="col-sm-12 section-header text-center">
            ${homeBean.headerRef1}
        </div>
        <div class="col-sm-12 text-center">
            ${homeBean.contentRef1}
        </div>
    </section>

    <section class="row content-padding content-margin-top">
        <div class="col-sm-12">
            <img class="d-block w-100 img-radius" style="height: ${homeBean.imgHightSizeRef2};" src="${homeBean.imgPathRef2}" alt="${homeBean.imgNameRef2}">
        </div>
    </section>

    <section class="row content">
        <div class="col-sm-6">
            <img class="d-block w-100 img-radius" src="${homeBean.imgPathRef3}"
                alt="${homeBean.imgNameRef3}">
        </div>
        <div class="col-sm-6">
            <h3 class="pb-1 mb-2 border-bottom"><span class="text-primary">${homeBean.headerRef3}</span></h3>
            <div class="mb-3">
                <div>${homeBean.contentRef3}</div>
            </div>
        </div>
    </section>
</section>

<script type='text/javascript'>
    $(document).ready(function () {
        $('#carouselPrdx').carousel({
            interval: 2000
        });
    });
</script>