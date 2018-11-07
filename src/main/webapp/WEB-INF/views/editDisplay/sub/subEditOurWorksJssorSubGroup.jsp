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

	    	<div class="row button-box">
		        <div class="box">
		            <button type="button" class="btn btn-primary" onclick="ourWorks.addOurWorksJssor()">Add</button>
		        </div>
		    </div>
	    	<table id="ourworksSubGroupTable" class="table table-striped table-responsive" cellspacing="0" width="100%">
				<thead>
					<tr align="center">
						<th width="10%">No.</th>
						<th width="100%">Image</th>
						<th width="10%">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty carouselList}">
						<%
							int i = 1;
						%>
						<c:forEach var="carousel" items="${carouselList}">
							<tr>
								<td align="center" class="count-index"><%=i++%></td>
								<td>
									<div>
										<label>Images Name: ${carousel.imgName}</label>
									</div>
									<hr /> <input type="file" name="fileImage" value="" />
								</td>
								<td align="center"><i class="material-icons btn-delete"
									onclick="ourWorks.deleteOurWorksJssor(this)">delete</i></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
       	<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="ourWorks.openDialogEditOurWorksJssor()">Submit</button>
	        </div>
	    </div>
