<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Random"%>
<% 	
	// Check if this is where the JSESSIONID is being set
	if (response.containsHeader("SET-COOKIE"))
	{
	   String sessionid = request.getSession().getId();
	   response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionid + "; Path=/; HttpOnly; secure");
	}
	request.setCharacterEncoding("UTF-8");
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
	response.setHeader("Pragma","no-cache"); //HTTP 1.0 
	response.setDateHeader ("Expires", 0);
	Random rn = new Random();
	int random = rn.nextInt(1000)+1;
%>
<spring:url value="/resources/static" var="resources" />
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title><spring:message code="web.title"/></title>

	<link rel="shortcut icon" type="image/png" href="${resources}/images/paradise-ex-favicon.png?r=<%=random%>">

    <link href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.css">

    <link rel="stylesheet" href="${resources}/css/theme/main.css?r=<%=random%>">
    <link rel="stylesheet" href="${resources}/js/vendor/DataTables-1.9.4/media/css/jquery.dataTables.css?r=<%=random%>">
	

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
        
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>


    <!-- script core -->
    <script type="text/javascript" src="${resources}/js/vendor/jquery-ui-1.12.1.js"></script>
	<script type="text/javascript" src="${resources}/js/vendor/DataTables-1.9.4/media/js/jquery.dataTables.min.js?r=<%=random%>"></script>    
    
    <script type="text/javascript" src="${resources}/js/app/core/core.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/app/core/menuPortal.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/app/core/moment.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/app/core/session.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/vendor/jssor.slider-27.5.0.min.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/app/core/menuEditPortal.js?r=<%=random%>"></script>
    
    <script type="text/javascript" src="${resources}/js/app/portal/about.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/app/portal/contact.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/app/portal/gallery.js?r=<%=rn%>"></script>
    <script type="text/javascript" src="${resources}/js/app/portal/home.js?r=<%=random%>"></script>
    <script type="text/javascript" src="${resources}/js/app/portal/ourWorks.js?r=<%=rn%>"></script>
    <script type="text/javascript" src="${resources}/js/app/portal/services.js?r=<%=random%>"></script>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCdl-muJF6qgXrgLGrWXHdp5JXgXExIsrk"
        async defer></script>
</head>

<body>
    <div class="">
        <div class="app-menu-side">
            <div class="">
                <nav class="navbar">
                    <ul class="navbar-nav text-uppercase">
                    	<li class="nav-item active">
		                	<a class="nav-link js-scroll-trigger" onclick="menuPortal.menuPortalAction('PAGE_HOME', this)">Home</a>
		                </li>
                    	<c:if test="${not empty menuList}">
							<c:forEach var="menu" items="${menuList}">
		                        <li class="nav-item">
		                            <a class="nav-link js-scroll-trigger" onclick="${menu.script}">${menu.name}</a>
		                        </li>
							</c:forEach>
						</c:if>
                    </ul>
                </nav>
            </div>
        </div>

		<div class="app-container">
	        <div class="mainContent">
	            <div id="container">
	                
	            </div>
	        </div>
	
	        <div class="page-footer">
	            <div class="row content">
	                <div class="col-sm-4">
	                    ${footerBean.labelLeft}
	                </div>
	                <div class="col-sm-8 text-right">
	                    ${footerBean.labelRight}
	                </div>
	            </div>
	            <div class="row justify-content-center text-center content">
	                    <div class="col-12 col-md-10">
	                        <div class="text-grey small mb-1">${footerBean.centerRef1}</div>
	                        <div class="text-grey small mb-3">${footerBean.centerRef2}</div>
	                    </div>
	                </div>
	        </div>
	
	         <!-- Loading -->
	        <div id="loading" class="loading-background-image">
	            <div class="spinner">
	                <div class="bounce1"></div>
	                <div class="bounce2"></div>
	                <div class="bounce3"></div>
	            </div>
	        </div>
	        
	        <!-- Modal -->
	        <div class="modal fade" style="z-index: 10500;" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	            <div class="modal-dialog" role="document">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                </div>
	                <div class="modal-body"></div>
	                <div class="modal-footer"></div>
	            </div>
	            </div>
	        </div>
	        
	        <!-- dialog -->
	        <div class="modal" id="mainDialog" tabindex="-1" role="dialog">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">Modal title</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <p>Modal body text goes here.</p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary" id="dialogSubmit">Save changes</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
	
	        <div id="jssor-content" class="background-image">
	            <div class="close-area" onclick="closeJssor()">
	                <div class="icon-close"></div>
	            </div>
	            <div class="jssor-content-area"></div>
	        </div>
	    </div>
    </div>

    <script type='text/javascript'>
        $(document).ready(function () {
            ajaxCall({
                type: 'POST',
          			url: "home",
          			replaceid: '#container',
          			onSuccess: function() {
    				
                }
            });
        });
    </script>
</body>

</html>