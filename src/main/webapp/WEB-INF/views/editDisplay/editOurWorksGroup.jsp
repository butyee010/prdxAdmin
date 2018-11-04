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

<form class="form" action="ourWorks/submitEditOurWorksGroup" id="editOurWorksGroupForm" enctype="multipart/form-data" method="POST">
	    	<div class="row button-box">
		        <div class="box">
		            <button type="button" class="btn btn-primary" onclick="ourWorks.addOurWorksGroup()">Add</button>
		        </div>
		    </div>
	    	<table id="ourworksGroupTable" class="table table-striped table-responsive" cellspacing="0" width="100%">
				<thead>
					<tr align="center">
						<th width="10%">No.</th>
						<th width="20%">Our Works Header</th>
						<th width="25%">Our Works Content</th>
						<th width="35%">Image</th>
						<th width="5%">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty ourWorksMap}">
						<% int i = 1; %>
						<c:forEach var="ourWorksItemMap" items="${ourWorksMap}">
							<c:forEach var="ourWorks" items="${ourWorksItemMap.value}">
								<tr>
									<td align="center" class="count-index"><%= i++ %></td>
									<td><input type="text" name="header" class="form-control" value="${ourWorks.header}"/></td>
									<td><textarea rows="5" cols="50" name="content" class="form-control">${ourWorks.content}</textarea></td>
									<td>
										<div>
											<label>Images Name: ${ourWorks.imgName}</label>
										</div>
										<hr/>
										<input type="file" name="fileImage" value=""/></td>
									<td align="center"><i class="material-icons btn-delete" onclick="ourWorks.deleteOurWorksGroup(this)">delete</i></td>
								</tr>
							</c:forEach>
					    </c:forEach>
					</c:if>
				</tbody>
			</table>
	    </form>
	    
       	<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="ourWorks.openDialogEditOurWorksGroup()">Submit</button>
	        </div>
	    </div>