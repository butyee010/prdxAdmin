<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<section class="contact">
	<form id="editContactForm">
		<nav aria-label="breadcrumb">
		        <ol class="breadcrumb">
		            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_CONTACT', 'back')">Contact</a></li>
		            <li class="breadcrumb-item active" aria-current="page">Edit Contact</li>
		        </ol>
		    </nav>
		    
		<div class="form-group">
			<div class="row">
			 	<div class="col-sm-12">
			 		<label>Location Name</label>
			 		<input type="text" name="locationName" class="form-control" value="${contactBean.locationName}"/>
			 	</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
			 	<div class="col-sm-12">
			 		<label>Location Info</label>
			 		<textarea rows="5" cols="50" name="locationInfo" class="form-control">${contactBean.locationInfo}</textarea>
			 	</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
			 	<div class="col-sm-6">
			 		<label>Latitude</label>
			 		<input type="text" name="latitude" class="form-control" value="${contactBean.latitude}"/>
			 	</div>
			 	<div class="col-sm-6">
			 		<label>Longitude</label>
			 		<input type="text" name="longitude" class="form-control" value="${contactBean.longitude}"/>
			 	</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
			 	<div class="col-sm-6">
			 		<label>Direct large map url</label>
			 		<input type="text" name="directLargeMapUrl" class="form-control" value="${contactBean.directLargeMapUrl}"/>
			 	</div>
			 	<div class="col-sm-6">
			 		<label>Direct url</label>
			 		<input type="text" name="directUrl" class="form-control" value="${contactBean.directUrl}"/>
			 	</div>
			</div>
		</div>
		
		<div class="form-group">
		    <section class="row" style="padding-top: 0;">
		        <div class="col-sm-12">
		            <p> 
		                <span>Address:&nbsp;<input type="text" name="address" class="form-control" value="${contactBean.address}"/></span><br>
		                <span>Telephone:&nbsp;<input type="text" name="tel" class="form-control" value="${contactBean.tel}"/></span><br>
		                <span>E-mail:&nbsp;<input type="text" name="email" class="form-control" value="${contactBean.email}"/></span>
		            </p>
		        </div>
		    </section>
	    </div>
	    <div class="row button-box">
		        <div class="box">
		            <button type="button" class="btn btn-primary" onclick="contact.openDialogEditContact()">Submit</button>
		        </div>
		 </div>
	 </form>
</section>