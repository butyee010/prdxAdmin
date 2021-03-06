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
		            <button type="button" class="btn btn-primary" onclick="ourWorks.addOurWorksSubGroup()">Add</button>
		        </div>
		    </div>
	    	<table id="ourworksSubGroupTable" class="table table-striped table-responsive" cellspacing="0" width="100%">
				<thead>
					<tr align="center">
						<th width="10%">No.</th>
						<th width="20%">Sub Our Works Header</th>
						<th width="25%">Sub Our Works Content</th>
						<th width="35%">Image</th>
						<th width="5%">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty ourWorksSubBean.itemSubOurWorksMap}">
						<%
							int i = 1;
						%>
						<c:forEach var="itemSub" items="${ourWorksSubBean.itemSubOurWorksMap}">
							<tr>
								<td align="center" class="count-index"><%=i++%></td>
								<td><input type="text" name="header" class="form-control" value="${itemSub.value.topicName}"/></td>
								<td><textarea rows="5" cols="50" name="content" class="form-control">${itemSub.value.content}</textarea></td>
								<td>
									<div>
										<label>Images Name: ${itemSub.value.imgName}</label>
									</div>
									<hr /> <input type="file" name="fileImage" value="" />
								</td>
								<td align="center"><i class="material-icons btn-delete"
									onclick="ourWorks.deleteOurWorksSubGroup(this)">delete</i></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
       	<div class="row button-box">
	        <div class="box">
	            <button type="button" class="btn btn-primary" onclick="ourWorks.openDialogEditSubOurWorksGroup()">Submit</button>
	        </div>
	    </div>
