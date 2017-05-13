
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>FCGO- RECON</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value='static/css/bootstrap.min.css' />" rel="stylesheet">

    <link href="<c:url value='static/css/sb-admin.css' />" rel="stylesheet">
    <link href ="<c:url value='static/css/jquery-ui.css' />" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<c:url value='static/css/plugins/morris.css' />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value='static/font-awesome/css/font-awesome.min.css' />" rel="stylesheet" type="text/css">
    
     <script src="<c:url value='static/js/jquery.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='static/js/bootstrap.min.js' />"></script>
    
    <script src="<c:url value='static/js/jquery-ui.min.js'/>"></script>
<!--    <script src="<c:url value='static/ls/index.js'/>"></script>-->
     
    <!-- Morris Charts JavaScript -->
<!--    
    <script src="<c:url value='static/js/plugins/morris/raphael.min.js'/>"></script>
    <script src="<c:url value='static/js/plugins/morris/morris.min.js'/>"></script>
    <script src="<c:url  value='static/js/plugins/morris/morris-data.js'/>"></script>-->


</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Financial Comptroller General Office</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
               
               
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Admin <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li>
                            <a href="javascript:formSubmit()"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                        </c:if>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a id="dashboard" href="javascript:void(0);" onclick="openDashboard()"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a id="entryform" href="javascript:void(0);" onclick="openForm()"><i class="fa fa-fw fa-edit"></i>Data Entry</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-table"></i>Reports</a>
                    </li>
                    
           
                </ul>
            </div>
            
            <sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
            </sec:authorize>
            
            <script>
                
            function openDashboard(){
                
              //  $("#page-wrapper").css("display","block");
                document.getElementById('page-wrapper').style.display = 'block';
                document.getElementById('entrybox-1').style.display = 'none';
             //   $("#entrybox-1").css("display","none");
            }
            
            function openForm(){
             
                document.getElementById('page-wrapper').style.display = 'none';
                document.getElementById('entrybox-1').style.display = 'block';
            }        
            
            function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
            
             
                </script>           
            <!-- /.navbar-collapse -->
        </nav>
        
        <div class="container-fluid" style="margin-left: 5px">

        <div id="page-wrapper">

            

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

               
                <!-- /.row -->

                
                <!-- /.row -->

                
                <!-- /.row -->

                
                <!-- /.row -->

           
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
     
        <div id="entrybox-1">
           
            <div class = "form-group row">
                <label class = "col-sm-1 col-form-label">Bud Year:</label>
                
                <div class="col-sm-2">
                  
                    <select class="form-control" id="budyearselect" name="bud-year">
                        <option value="2073/74">2073/74</option>
                        <option value="2072/73">2072/73</option>
                        <option value="2071/72">2071/72</option>
                        <option value="2070/71">2070/71</option>
                        <option value="2069/70">2069/70</option>
        </select>
                </div>
                
            </div>
                
                <div class ="form-group row">
                    <label class="col-sm-1 col-form-label">Month:</label>
                    <div class = "col-sm-2">
                        <select class="form-control" id="monthselect" name="month">
                            <option value="1">Baishak</option>
                            <option value="2">Jestha</option>
                            <option value="3">Asar</option>
                            <option value="4">Shrawan</option>
                            <option value="5">Bhadra</option>
                            <option value="6">Asoj</option>
                            <option value="7">Kartik</option>
                            <option value="8">Mangsir</option>
                            <option value="9">Poush</option>
                            <option value="10">Magh</option>
                            <option value="11">Falgun</option>
                            <option value="12">Chaitra</option>
                        </select>
                        
                    </div>
                </div>
                
                 
                
                <div class="form-group-row">
                    <label class="col-sm-1 col-form-label">Budget Head:</label>
                    <div class="col-sm-2 ui-widget">
                        <input type="text" id="bud-head1" name="bud-head" onkeyup="getValue()" onclick="getValue()" class="form-control">
                    </div>
                    <div class = "col-sm-3">
                        <input type="text" class="form-control" id="test" readonly>
                    </div>
                    <div class="col-sm-2">
                        <select class="form-control" id="bud-type" name="bud-type">
                            <option value="3">Chalu</option>
                            <option value="4">Pujigat</option>
                        </select>
                        
                    </div>
                </div>
                
                
            <table id="tableentry" class ="table table-striped table-hover table-bordered">
                    
                     <thead>
    <tr>
      <th>Economic code</th>
      <th>Economic Name</th>
      <th>Donor code</th>
      <th>Donor name</th>
      <th>Source Type</th>
      <th>Amount</th>
      <th id="iconhead"></th>
    </tr>
  </thead>
  <tbody>
      
      
      
      <tr class="tblRow">
<!-- <td><input type="text" class="col-sm-1 form-control"></td>
  <td>Pugi</td>-->
<td><input type="text" id="eco-code1" name="" onkeyup="getEconomicData(1)" onclick="getEconomicData(1)" class="col-sm-1 form-control"></td>
<td><input type="text" id="eco-name1"  class="col-sm-1 form-control" readonly></td>
<td><input type="text" id="don-code1" onclick="getDonorData(1)" onkeyup="getDonorData(1)" class="col-sm-1 form-control"></td>
<td><input type="text" id="don-name1" class="col-sm-1 form-control" readonly></td>
<td><div class="row"><div class="col-sm-3"><input id="source-code1" onkeyup="getSourceTypeData(1)" onclick="getSourceTypeData(1)" type="text" class="form-control"></div><label id="source-type1" class ="col-sm-8 col-form-label"></label></div></td>
<td><input type="text" id="amount1" class="col-sm-1 form-control"></td>
<td id="icon1"><span class="glyphicon glyphicon-ok" id="true1"  style="color: green"></span> <span class="glyphicon glyphicon-remove" id="false1" onclick="evaluateData(1)" style="color: red"></span></td>
      </tr>
      
         <tr class="tblRow">
<!--  <td><input type="text" class="col-sm-1 form-control"></td>
  <td><label>Chalu</label></td>-->
<td><input type="text" id="eco-code2" onkeyup="getEconomicData(2)" onclick="getEconomicData(2)" class="col-sm-1 form-control"></td>
<td><input type="text" id="eco-name2" class="col-sm-1 form-control" readonly></td>
<td><input type="text" id="don-code2" onkeyup="getDonorData(2)" onclick="getDonorData(2)" class="col-sm-1 form-control"></td>
  <td><input type="text" id="don-name2" class="col-sm-1 form-control" readonly></td>
  <td><div class="row"><div class="col-sm-3"><input id="source-code2" onkeyup="getSourceTypeData(2)" onclick="getSourceTypeData(2)" type="text" class="form-control"></div><label id="source-type2" class ="col-sm-8 col-form-label"></label></div></td>
  <td><input type="text" class="col-sm-1 form-control" id="amount2"></td>
  <td id="icon2"><span class="glyphicon glyphicon-ok" id="true2"  style="color: green"></span><span class="glyphicon glyphicon-remove" id="false2" onclick="evaluateData(2)" style="color: red"></span></td>
      </tr>
      
         <tr class="tblRow">
<!--  <td><input type="text" class="col-sm-1 form-control"></td>
  <td>Pugi</td>-->
<td><input type="text" id="eco-code3" onkeyup="getEconomicData(3)" onclick="getEconomicData(3)" class="col-sm-1 form-control"></td>
<td><input type="text" id="eco-name3" class="col-sm-1 form-control" readonly></td>
<td><input type="text" id="don-code3" onkeyup="getDonorData(3)" onclick="getDonorData(3)" class="col-sm-1 form-control"></td>
  <td><input type="text" id="don-name3" class="col-sm-1 form-control" readonly></td>
  <td><div class="row"><div class="col-sm-3"><input id="source-code3" onkeyup="getSourceTypeData(3)" onclick="getSourceTypeData(3)" type="text" class="form-control"></div><label id="source-type3" class ="col-sm-8 col-form-label"></label></div></td>
  <td><input type="text" class="col-sm-1 form-control" id="amount3"></td>
  <td id="icon3"><span class="glyphicon glyphicon-ok" id="true3" style="color: green"></span><span class="glyphicon glyphicon-remove" id="false3" onclick="evaluateData(3)" style="color: red"></span></td>
      </tr>
      
       <tr class="tblRow">
<!--  <td><input type="text" class="col-sm-1 form-control"></td>
  <td>Chalu</td>-->
<td><input type="text" id="eco-code4" onkeyup="getEconomicData(4)" onclick="getEconomicData(4)" class="col-sm-1 form-control"></td>
  <td><input type="text" id="eco-name4" class="col-sm-1 form-control" readonly></td>
  <td><input type="text" id="don-code4" onkeyup="getDonorData(4)" onclick="getDonorData(4)" class="col-sm-1 form-control"></td>
  <td><input type="text" id="don-name4" class="col-sm-1 form-control" readonly></td>
  <td><div class="row"><div class="col-sm-3"><input id="source-code4" onkeyup="getSourceTypeData(4)" onclick="getSourceTypeData(4)" type="text" class="form-control"></div><label id="source-type4" class ="col-sm-8 col-form-label"></label></div></td>
  <td><input type="text" class="col-sm-1 form-control" id="amount4" ></td>
  <td id="icon4"><span class="glyphicon glyphicon-ok" id="true4" style="color: green"></span><span class="glyphicon glyphicon-remove" id="false4" onclick="evaluateData(4)" style="color: red"></span></td>
      </tr>
      
       <tr class="tblRow">
<!--  <td><input type="text" class="col-sm-1 form-control"></td>
  <td>Chalu</td>-->
<td><input type="text" id="eco-code5" onkeyup="getEconomicData(5)" onclick="getEconomicData(5)" class="col-sm-1 form-control"></td>
  <td><input type="text" id="eco-name5" class="col-sm-1 form-control" readonly></td>
  <td><input type="text" id="don-code5" onkeyup="getDonorData(5)" onclick="getDonorData(5)" class="col-sm-1 form-control"></td>
  <td><input type="text" id="don-name5" class="col-sm-1 form-control" readonly></td>
  <td><div class="row"><div class="col-sm-3"><input id="source-code5" onkeyup="getSourceTypeData(5)" onclick="getSourceTypeData(5)" type="text" class="form-control"></div><label id="source-type5" class ="col-sm-8 col-form-label"></label></div></td>
  <td><input type="text" class="col-sm-1 form-control" id="amount5"></td>
  <td id="icon5"><span class="glyphicon glyphicon-ok" id="true5" style="color: green"></span><span class="glyphicon glyphicon-remove" id="false5" onclick="evaluateData(5)" style="color: red"></span></td>
      </tr>
      
  </tbody>
               
                    
                    </table>
                  <div>
                <div class="col-sm-1" style="display: inline-block;margin-top: 20px"><button class="btn btn-danger" onclick="checkTranData()">Check</button></div>
                <div class="col-sm-1" style="display: inline-block"><button type="submit" id="btnsubmit" class="btn btn-primary" onclick="submitData()" style="margin-top:20px" disabled>Submit</button></div>
                </div>
           
            
          
           
        </div>
        <!--entry box  -->
        </div>
       
        
        <div class="modal fade" id="popupData" role="dialog">
            
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="row">  <h3 class="modal-title">Evaluate Data</h3><h4>Total:</h4><h4 id="totalamount"></h4> </div>
                    </div>
                    <div class="modal-body">

                        <table id="tranEvaluateTable" class ="table table-striped table-hover table-bordered" style="width: 900px">
                            
                            <thead>
                                <tr>
                                    <th>Economic Code</th>
                                    <th>Expenditure Title</th>
                                    <th>Donor Code</th>
                                    <th>Donor Name</th>
                                    <th>Source Code</th>
                                    <th>Source Type</th>
                                    <th>Cheque No.</th>
                                    <th>Expenditure Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                               
                            </tbody>
                            
                        </table>
                                
                                </div>
                           
                            
                        
                    
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                    
                </div>
                
                
                
            </div>
        </div>
        <!-- modal -->
        
                
    </div>    <!-- wrapper  -->
 
       <script>
           $(document).ready(function(){
              $("#entrybox-1").css("display","none");
           //   looptable();
           
        
           
           var tablelength = $('#tableentry tr').length;
              var count;
              for(count = 1 ; count <= tablelength ; count++){
                  
                  $("#icon"+count).hide();
              }
              
           
              
              $("#iconhead").hide();
               var budCode = [];
               var economicCode = [];
             var donorCode = [];
              var sourceCode = [];
             
                                <c:forEach var="project" items="${Allproject}">
                                  
                                    budCode.push("${project.PROJECT_CODE}" + "        " + "${project.PROJECT_EDESC}");
                                 // budCode.push("${project.PROJECT_EDESC}");
                                                               
                                </c:forEach>
                                    
                               <c:forEach var="economic" items="${Alleconomic}">
                       economicCode.push("${economic.ECONOMIC_CODE5}" + "        "+ "${economic.ECONOMIC_EDESC5}");
                           </c:forEach>
               
           <c:forEach var="donor" items="${Alldonor}">
           donorCode.push("${donor.DONOR_CODE}"+"        "+"${donor.DONOR_EDESC}");               
           </c:forEach>
               
           <c:forEach var="source" items="${Allsourcetype}">
                sourceCode.push("${source.SOURCE_TYPE_CODE}"+"        "+"${source.SOURCE_TYPE_EDESC}");
           </c:forEach>
                                    $("#bud-head1").autocomplete({
                                       source: budCode
                                    });
                                    $('#eco-code1').autocomplete({
                                        source:economicCode 
                                    });
                                    $('#eco-code2').autocomplete({
                                        source:economicCode
                                    });
                                    $('.economiccode').autocomplete({
                                       source:economicCode 
                                    });
                                    $('#eco-code3').autocomplete({
                                        source:economicCode
                                    });
                                    $('#eco-code4').autocomplete({
                                        source:economicCode
                                    });
                                    $('#eco-code5').autocomplete({
                                        source:economicCode
                                    });
                                    $('#don-code1').autocomplete({
                                        source:donorCode
                                    });
                                    $('#don-code2').autocomplete({
                                        source:donorCode
                                    });
                                    $('#don-code3').autocomplete({
                                        source:donorCode
                                    });
                                    $('#don-code4').autocomplete({
                                        source:donorCode
                                    });
                                    $('#don-code5').autocomplete({
                                        source:donorCode
                                    });
                                    $('#source-code1').autocomplete({
                                        source: sourceCode
                                    });
                                      $('#source-code2').autocomplete({
                                        source: sourceCode
                                    });
                                      $('#source-code3').autocomplete({
                                        source: sourceCode
                                    });
                                      $('#source-code4').autocomplete({
                                        source: sourceCode
                                    });
                                      $('#source-code5').autocomplete({
                                        source: sourceCode
                                    });
                                    
                                     $('.tblRow:last-child() td:eq(5)').on("keydown", function(event){
                                     if(event.keyCode == 40){
                                         var rowcount = $('#tableentry tr').length;
                                         var table = "<tr class='tblRow'>";
                    table = table + "<td><input id='eco-code"+rowcount+"' type='text' name='' onkeyup='getEconomic("+rowcount+")' class='col-sm-1 form-control'></td>";
                    table = table + "<td><input id='eco-name"+rowcount+"' type='text' class='col-sm-1 form-control' readonly></td>";
                    table = table + "<td><input id='don-code"+rowcount+"' type='text'  onkeyup='getDonor("+rowcount+")' class='col-sm-1 form-control'></td>";
                    table = table + "<td><input id='don-name"+rowcount+"' type='text' class='col-sm-1 form-control' readonly></td>";
                    table = table + "<td><div class='row'><div class='col-sm-3'><input onkeyup='getSourceType("+rowcount+")' type='text' class='form-control sourcetype'></div><label id='source-type"+rowcount+"' class ='col-sm-8 col-form-label'></label></div></td>";
                    table = table + "<td><input id='amount"+rowcount+"' type='text' class='col-sm-1 form-control amount'></td>";
                    table = table + "<td id='icon"+rowcount+"'><span class='glyphicon glyphicon-ok' id='true"+rowcount+"'  style='color: green'></span> <span class='glyphicon glyphicon-remove' id='false"+rowcount+"' onclick='evaluateData("+rowcount+")' style='color: red'></span></td>"; 
                    table = table + "</tr>";
                    
                    $("#tableentry").append(table);
                    debugger;
                    hideicon(rowcount);
                                     }
                                     });
                      
           });
           function getTableCount(){
               return $("#tableentry tr").length;
           }
           function hideicon(rowcount){
               alert("test hideicon");
               var count;
               for( count = 1 ; count <= rowcount ; count++){
                     $("#icon"+count).hide();
               }
           }
        function getValue(){
           //debugger;
           var fetchedCode = $("#bud-head1").val();
           var token = fetchedCode.split("        ");
           $("#bud-head1").val(token[0]);
           $("#test").val(token[1]); 
}
function looptable(){
    var table = "<tr>";
    table = table + "<td><input type='text' name='' onkeyup='getEconomic()' class='col-sm-1 form-control economiccode'></td>";
   table = table + "<td><input type='text' class='col-sm-1 form-control economicname' readonly></td>";
    table = table + "<td><input type='text'  onkeyup='getDonor()' class='col-sm-1 form-control doncode'></td>";
table = table + "<td><input type='text' class='col-sm-1 form-control donname' readonly></td>";
table = table + "<td><div class='row'><div class='col-sm-3'><input onkeyup='getSourceType()' type='text' class='form-control sourcetype'></div><label id='source-type1' class ='col-sm-8 col-form-label'></label></div></td>";
table = table + "<td><input type='text' class='col-sm-1 form-control amount'></td>";
table = table + "<td class='icon'><span class='glyphicon glyphicon-ok true'  style='color: green'></span> <span class='glyphicon glyphicon-remove false' onclick='evaluateData(1)' style='color: red'></span></td>"; 
table = table + "</tr>";

for(var a = 1; a<=4;a++){
document.getElementById("tabletest").insertRow(-1).innerHTML = table;
}
    }
    
    function addrow(){
        document.onkeydown = function(e){
            if(e.keyCode == 40){
                alert("down key pressed");
            }
        }
    }
    function submitData(){
     debugger;
     var count = $('#tableentry tr').length;
     var budyear = $("#budyearselect").val();
     var month = $("#monthselect").val();
     var acccode = $("#bud-head1").val() + $("#bud-type").val();
     
     for(var i = 1 ; i < count ; i++){  
     var ecocode = $("#eco-code" + i).val();
     if(ecocode != ""){
     var doncode = $("#don-code" + i).val();
     var sourcetypecode = $("#source-code"+i).val();
     var amount = $("#amount"+i).val();
     var submitobject = JSON.stringify({"budYear":budyear,"monthId":month,"accCode":acccode,"ecoCode":ecocode,
                                       "donorCode":doncode,"sourceType":sourcetypecode,"poCode":"27-305-04","amount":amount});
       $.ajax({
           type: 'POST',
           url:"http://localhost:8080/FcgoTest/api/savepotran",
           data: submitobject,
           contentType :  "application/json; charset=utf-8",
           async: false,
           dataType: 'json',
           success: function (data) {
               debugger;
               if(data.status == "success"){
                   alert("data saved successfully");
                   $("#entrybox-1").children('input').val('');
               }else{
                   alert("error in saving data");
               }

    },
    failure:function(errMsg){
          alert("tiot " + errMsg);
           }
           });
       }
    }
}
    
   

    function getTableData()
    {
        $("table#tabletest > tbody >tr").each(function(){
           var economicCode = $('td:eq(0) input').val();
           
            
        });
    }

// id transaction is incorrect then provide the po to explore the data with censored view of the amount
function evaluateData(index){  
    debugger;
    var budYear = $("#budyearselect").val();
    var ecocode = $("#eco-code"+index).val();
    var donCode = $("#don-code"+index).val();
    var accCode = $("#bud-head1").val() + $("#bud-type").val();
    
     var tranIncorrectObject = JSON.stringify({"bud_year":budYear,"accCode":accCode,"economicCode":ecocode,
                                               "donorCode":donCode,"poCode":"27-305-04"});
        
        $.ajax({
            type: 'POST',
           url:"http://localhost:8080/FcgoTest/api/evaluateIncorrect",
           data: tranIncorrectObject,
           contentType :  "application/json; charset=utf-8",
           //async: false,
           dataType: 'json',
           success: function (data) {
               debugger;
                    var response = data.data;
                    var trHTML = '';
                    var totalExpense = 0;
                    $.each(response,function(i, item){
                       
                        var expense = item.expenditure_amount;
                        totalExpense = totalExpense + expense; 
                        var chequenum = item.chequeNo;
                        var cheqnum = chequenum.replace(",","");
                      //   var expense2 = expense.replace(/\,/g,"");
                      if(!expense.includes(".")){
                         var str1 = expense.slice(0,-2)+'**.00';
                     }
                         
                           trHTML += '<tr style ="margin-top:10px;"><td align="center">' + item.ecoCode + '</td><td align="center">' + item.ecoName + '</td><td align="center">' + item.donorCode + '</td><td align="center">'+item.donorName + 
                                   '</td><td align="center">' +item.sourceCode + '</td><td align="center">'+ item.sourceType +'</td><td align="center">'+cheqnum+'</td><td align="center">' +'Rs.'+ str1  + '</td></tr>';
                    });
                    $('#tranEvaluateTable').append(trHTML);
                    $('#totalamount').text(totalExpense);
                    }, 
           failure:function(errMsg){
               alert("tiot " + errMsg);
           }
            
        });

    $("#popupData").modal('show');
}
// checks the data of each line item and shows a correct or incorrect sign in the rightmost column
var counter=0;
 function checkTranData(){

    debugger;
    var budYear = $("#budyearselect").val();
    var month = "baishak";
    var accCode = $("#bud-head1").val() + $("#bud-type").val();
    for( counter = 1 ; counter <= 5; counter++){
        var ecocode = $("#eco-code"+counter).val();
        var a = counter;
        if(ecocode != ""){
       //     var ecocode = $('#eco-code'+counter).val();
            var donCode = $("#don-code"+counter).val();
            var sourceCode = $("#source-code"+counter).val();
            var amount = $("#amount"+counter).val();
            var tranobject = JSON.stringify({"budYear":budYear,"month_id":month,"accCode":accCode,"ecoCode":ecocode,"sourceType":sourceCode,
                      "donorCode":donCode,"poCode":"27-305-04","amount":amount});
            
             $.ajax({
           type: 'POST',
           url:"http://localhost:8080/FcgoTest/api/reconcile",
           data: tranobject,
           contentType :  "application/json; charset=utf-8",
           dataType: 'json',
           async: false,
           success:function(data){
              
               alert("ya hoo" + data.data);
               $("#iconhead").show();
               $("#icon"+counter).show();
               if(data.data == "true"){
                   $("#false"+counter).css("display","none");
                 
               }else{
                   $("#true"+counter).css("display","none");
                  
               }
           },
           failure:function(errMsg){
               alert("tiot " + errMsg);
           }
          
       });
            
        }else{
            $(".icon"+counter).css("display","none");
        }
    }
   // var ecocode = $('#eco-code1').val();
   // var donCode = $('#don-code1').val();
   // var sourceCode = $('#source-code1').val();
   // var amount = $('#amount1').val();
   // var tranobject = JSON.stringify({"id":1,"budYear":budYear,"month":month,"accCode":accCode,"ecoCode":ecocode,"sourceType":sourceCode,
   //                   "donorCode":donCode,"amount":amount});
       
        var tablelength = $('#tableentry tr').length;
        var iconcount = 0;
        var codecount = 0;
        debugger;
           for(var k = 1 ; k < tablelength ; k++ ){
                  if($("#eco-code"+k) != null){
                      debugger;
                      codecount =+ 1;
                  if($('#true' + k).is(':visible')){
                      iconcount =+ 1;
                  }
              }
              }
              
              if(codecount == iconcount){
                $("#btnsubmit").prop('disabled',false);
              }
      
    }
    
    
    function addTableRow(){
        var markup = "<tr><td>"+"<input type='text' id='eco-code6' onkeyup='getEconomicData(6)' class='col-sm-1 form-control'></td>"+
  "<td><input type='text' id='eco-name6' class='col-sm-1 form-control' readonly></td>"+    
  "<td><input type='text' id='don-code6' onkeyup='getDonorData(6)' class='col-sm-1 form-control'></td>"+
  "<td><input type='text' id='don-name6' class='col-sm-1 form-control' readonly></td>"+
  "<td><div class='row'><div class='col-sm-3'><input id='source-code5' onkeyup='getSourceTypeData(6)' type='text' class='form-control'></div><label id='source-type6' class ='col-sm-8 col-form-label'></label></div></td>"+
  "<td><input type='text' class='col-sm-1 form-control' id='amount6'></td>"+
  "<td id='icon6'><span class='glyphicon glyphicon-ok' id='true6' style='color: green'></span><span class='glyphicon glyphicon-remove' id='false6' onclick='evaluateData(6)' style='color: red'></span></td>";
  
     
     $("table.tableentry tbody ").append(markup);
     
    }
function getEconomicData(index){
    
    var ecofetchedcode  = $("#eco-code"+index).val();
    console.log("fetched data :",ecofetchedcode);
      var token = ecofetchedcode.split("        ");
      $("#eco-code"+index).val(token[0]);
      $("#eco-name"+index).val(token[1]);
      
      
    
}

function getDonorData(index){
    
    var donorfetchedcode = $('#don-code'+index).val();
   var token = donorfetchedcode.split("        ");
   $('#don-code'+index).val(token[0]);
   $('#don-name'+index).val(token[1]);
   
    
}

   function getSourceTypeData(index){
   
       var sourcefetchedcode = $('#source-code'+index).val();
       var token = sourcefetchedcode.split("        ");
       $("#source-code"+index).val(token[0]);
       $("#source-type"+index).text(token[1]);
   }

        </script>
   
 
</body>


</html>

   