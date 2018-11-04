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

<form class="form" style="padding-top: 1rem;" action="ourWorks/submitEditOurWorksJssor" id="editOurWorksJssorForm" enctype="multipart/form-data" method="POST">
	<div class="col-sm-12 form-group">
		<label>Select Our Works Group</label>
		<select class="form-control" name="ourworksGroup">
			<c:if test="${not empty ourWorksMap}">
				<c:forEach var="ourWorksItemMap" items="${ourWorksMap}">
					<c:forEach var="ourWorks" items="${ourWorksItemMap.value}">
						<option value="${ourWorks.header}">${ourWorks.header}</option>
					</c:forEach>
				</c:forEach>
			</c:if>
		</select>
	</div>
	<div class="col-sm-12 form-group">
		<label>Select Our Works Sub Group</label>
		<select class="form-control" name="ourworksSubGroup"></select>
	</div>
	<div id="ourworksJssorContent"></div>
</form>

<script type="text/javascript">
	ourWorks.onLoadEditOurWorksJssor();
</script>