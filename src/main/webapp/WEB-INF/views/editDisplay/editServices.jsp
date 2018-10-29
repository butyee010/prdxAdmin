<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="resources/static" var="resources" />

<section class="services">
	<nav aria-label="breadcrumb">
	        <ol class="breadcrumb">
	            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_SERVICES', 'back')">Services</a></li>
	            <li class="breadcrumb-item active" aria-current="page">Edit Services</li>
	        </ol>
	    </nav>
	<form class="form" action="services/submitEdit" id="editServiceForm" enctype="multipart/form-data" method="POST">
		<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="services.addService()">Add</button>
	        </div>
	    </div>
		<table id="servicesTable" class="table table-striped table-responsive" cellspacing="0" width="100%">
			<thead>
				<tr align="center">
					<th width="10%">No.</th>
					<th width="20%">Service Name</th>
					<th width="25%">Service Desc</th>
					<th width="35%">Image</th>
					<th width="5%">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty serviceList}">
					<% int i = 1; %>
					<c:forEach var="service" items="${serviceList}">
						<tr>
							<td align="center" class="count-index"><%= i++ %></td>
							<td><input type="text" name="header" class="form-control" value="${service.header}"/></td>
							<td><textarea rows="5" cols="50" name="content" class="form-control">${service.content}</textarea></td>
							<td>
								<div>
									<label>Images Name: ${service.imgName}</label>
								</div>
								<hr/>
								<input type="file" name="fileImage" value=""/></td>
							<td align="center"><i class="material-icons btn-delete" onclick="services.deleteService(this)">delete</i></td>
						</tr>
				    </c:forEach>
				</c:if>
			</tbody>
		</table>
	</form>
	
	<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="services.openDialogEditServices()">Submit</button>
	        </div>
	    </div>
</section>

<script>
	services.initEditServices();

</script>