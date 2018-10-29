<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/static" var="resources" />

<form class="form" action="gallery/submitEdit" id="editGalleryForm" enctype="multipart/form-data" method="POST">
	    	<div class="row button-box">
		        <div class="box">
		            <button type="button" class="btn btn-primary" onclick="gallery.addGallery()">Add</button>
		        </div>
		    </div>
	    	<table id="galleryTable" class="table table-striped table-responsive" cellspacing="0" width="100%">
				<thead>
					<tr align="center">
						<th width="10%">No.</th>
						<th width="20%">Gallery Header</th>
						<th width="25%">Gallery Content</th>
						<th width="35%">Image</th>
						<th width="5%">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty galleryList}">
						<% int i = 1; %>
						<c:forEach var="gallery" items="${galleryList}">
							<tr>
								<td align="center" class="count-index"><%= i++ %></td>
								<td><input type="text" name="header" class="form-control" value="${gallery.header}"/></td>
								<td><textarea rows="5" cols="50" name="content" class="form-control">${gallery.content}</textarea></td>
								<td>
									<div>
										<label>Images Name: ${gallery.imgName}</label>
									</div>
									<hr/>
									<input type="file" name="fileImage" value=""/></td>
								<td align="center"><i class="material-icons btn-delete" onclick="gallery.deleteGallery(this)">delete</i></td>
							</tr>
					    </c:forEach>
					</c:if>
				</tbody>
			</table>
	    </form>
	    
       	<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="gallery.openDialogEditGallery()">Submit</button>
	        </div>
	    </div>