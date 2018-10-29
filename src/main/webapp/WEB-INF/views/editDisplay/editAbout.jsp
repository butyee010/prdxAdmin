<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<section class="about">
		<form id="editAboutForm">
			<nav aria-label="breadcrumb">
		        <ol class="breadcrumb">
		            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_ABOUT', 'back')">About</a></li>
		            <li class="breadcrumb-item active" aria-current="page">Edit About</li>
		        </ol>
		    </nav>
	        <section class="row content " style="padding-top: 0">
	            <div class="col-sm-12 form-group">
	            	<input type="text" name="contentHeader1" class="form-control" value="${aboutBean.contentHeader1}"/>
	                <p><textarea rows="5" cols="50" class="form-control" name="contentDesc1">${aboutBean.contentDesc1}</textarea></p>
	            </div>
	        </section>
	        <section class="row content">
	            <div class="col-sm-4 form-group">
	            	<input type="text" name="contentHeader2" class="form-control" value="${aboutBean.contentHeader2}"/>
	                <p><textarea rows="5" cols="50" class="form-control" name="contentDesc2">${aboutBean.contentDesc2}</textarea></p>
	            </div>
	            <div class="col-sm-8 form-group">
	            	<input type="text" name="contentHeader3" class="form-control" value="${aboutBean.contentHeader3}"/>
	                <p><textarea rows="5" cols="50" class="form-control" name="contentDesc3">${aboutBean.contentDesc3}</textarea></p>
	            </div>
	        </section>
	        <section class="row content form-group" style="padding-top: 0">
	            <div class="col-sm-12">
	                <input type="text" name="contentHeader4" class="form-control" value="${aboutBean.contentHeader4}"/>
	                <p><textarea rows="5" cols="50" class="form-control" name="contentDesc4">${aboutBean.contentDesc4}</textarea></p>
	            </div>
	        </section>
	        <div class="row button-box">
		        <div class="box">
		            <button type="button" class="btn btn-primary" onclick="about.openDialogEditAbout()">Submit</button>
		        </div>
		    </div>
	    </form>
    </section>