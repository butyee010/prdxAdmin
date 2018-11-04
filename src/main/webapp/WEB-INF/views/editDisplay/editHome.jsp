<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="resources/static" var="resources" />

<section class="home">
	<nav aria-label="breadcrumb">
	        <ol class="breadcrumb">
	            <li class="breadcrumb-item"><a href="#" onclick="menuPortal.menuPortalAction('PAGE_HOME', 'back')">Home</a></li>
	            <li class="breadcrumb-item active" aria-current="page">Edit Home</li>
	        </ol>
	    </nav>
	    
	<form class="form" action="home/submitEdit" id="editHomeForm" enctype="multipart/form-data" method="POST">
		<!-- section 1 carouselPrdx -->
		<label>Section 1</label>
		<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="home.addImageRef1()">Add</button>
	        </div>
	    </div>
		<table id="homeRef1Table" class="table table-striped table-responsive" cellspacing="0" width="100%">
			<thead>
				<tr align="center">
					<th width="10%">No.</th>
					<th width="35%">Image</th>
					<th width="5%">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty homeBean.carouselList}">
					<% int i = 1; %>
					<c:forEach var="carousel" items="${homeBean.carouselList}">
						<tr>
							<td align="center" class="count-index"><%= i++ %></td>
							<td>
								<div>
									<label>Images Name: ${carousel.imgName}</label>
								</div>
								<hr/>
								<input type="file" name="homeRef1FileImage" value=""/></td>
							<td align="center"><i class="material-icons btn-delete" onclick="home.deleteImageRef1(this)">delete</i></td>
						</tr>
				    </c:forEach>
				</c:if>
			</tbody>
		</table>
	    <section class="row">
	    	<div class="col-sm-12 form-group">
	        	<input type="text" name="headerRef1" class="form-control" value="${homeBean.headerRef1}"/>
	            <p><textarea rows="5" cols="50" class="form-control" name="contentRef1">${homeBean.contentRef1}</textarea></p>
	        </div>
	    </section>
		<br/>
		<hr/>
		<!-- section 2 Process with Paradise -->
		<label>Section 2</label>
	    <table id="homeRef2Table" class="table table-striped" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th width="100%">Image</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div>
							<label>Images Name: ${homeBean.imgNameRef2}</label>
						</div>
						<hr/>
						<input type="file" name="homeRef2FileImage" value=""/>
					</td>
				</tr>
			</tbody>
		</table>
		<br/>
		<hr/>
		<label>Section 3</label>
		<!-- section 3 Why Paradise -->
		<table id="homeRef3Table" class="table table-striped table-responsive" cellspacing="0" width="100%">
			<thead>
				<tr align="center">
					<th width="30%">Topic Name</th>
					<th width="30%">Topic Desc</th>
					<th width="40%">Image</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="headerRef3" class="form-control" value="${homeBean.headerRef3}"/></td>
					<td><textarea rows="5" cols="50" name="contentRef3" class="form-control">${homeBean.contentRef3}</textarea></td>
					<td>
						<div>
							<label>Images Name: ${homeBean.imgNameRef3}</label>
						</div>
						<hr/>
						<input type="file" name="homeRef3FileImage" value=""/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	    
    <div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="home.openDialogEditHome()">Submit</button>
	        </div>
	    </div>
</section>

<script type='text/javascript'>
    
</script>