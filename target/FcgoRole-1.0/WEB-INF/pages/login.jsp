<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        
        <title>Login page</title>
        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/sb-admin.css' />" rel="stylesheet"/>
    <link href ="<c:url value='/static/css/jquery-ui.css' />" rel="stylesheet"/>
        <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"/>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>   
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        
        <script src="<c:url value='/static/js/jquery.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    
    <script src="<c:url value='/static/js/jquery-ui.min.js'/>"></script>
        
    </head>
    
    <body>
        <div id="mainWrapper">
            <div class="login-container">
                <div class="login-card">
                    <div class="login-form">
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger">
                                    <p>${error}</p>
                                </div>
                            </c:if>
                            <c:if test="${not empty msg}">
                                <div class="alert alert-success">
                                    <p>${msg}</p>
                                </div>
                            </c:if>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                <input type="text" class="form-control" id="username" name="username" onkeyup="getCredentials()" placeholder="Enter Username" required>
                            </div>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                            </div>
                            <div class="input-group input-sm">
                                <div class="row">
                                    <div class="col-sm-4"><input type="text" class="form-control" id="userrole" name="userrole" disabled placeholder="usertype"></div>
                                    <div class="col-sm-8"><input type="text" class="form-control" id="usertitle" name="usertitle" disabled placeholder="correspondant"></div>
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                 
                            <div class="form-actions" style="margin-top: 20px;">
                                <input type="submit"
                                       class="btn btn-block btn-primary btn-default" name="submit" value="submit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                            
                            <script>
                                function getCredentials(){
                                    var username = $('#username').val();
                                    var apiurl = "http://localhost:8080/FcgoRole/api/getuserdata?username=" + username;
                                    $.ajax({
                                       type: 'GET',
                                       url: apiurl,
                                    //   contentType :"application/json; charset=utf-8",
                                       dataType: 'json',
                                       success: function(data){
                                           if(data.status == "success"){
                                               $("#userrole").val(data.message);
                                               $("#usertitle").val(data.data);
                                           }else{
                                               alert("error");
                                           }
                                       },
                                       failure:function(errMsg){
                                           alert("toit "+ errMsg);
                                       }  
                                    });
                                }
                            </script>
                                
 
    </body>
    
</html>