
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
            //    var url = "http://localhost:8080/FcgoTest/api/getDescByCode?code="+fetchedCode;
             //  var test = asdfasd
            //    $.ajax({
            //        url:url,
            //        type:'GET',
               //     data:JSON.stringify{(left:test)}
            //        dataType:'json',
            //        contentType:'application/json',
            //        success: function (data){
            //            var testt = data.data;
            //            $("#test").val(testt);
            //        }
           //     });
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
     var count = $('#tableentry tr').length;
     var budyear = $("#budyearselect").val();
     var month = $("#monthselect").val();
     var acccode = $("bud-head1").val() + $("bud-type").val();
     
     for(var i = 1 ; i <= count ; i++){
     var ecocode = $("#eco-code" + i).val();
     var doncode = $("#don-code" + i).val();
     var sourcetypecode = $("#source-code"+i).val();
     var amount = $("#amount"+i).val();
     
    }
}

    function getTableData()
    {
        $("table#tabletest > tbody >tr").each(function(){
           var economicCode = $('td:eq(0) input').val();
           
            
        });
    }

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
//     var amount = $("#amount"+index).val();
//    $("#ecocodeinput").text(ecocode);
//    $("#econameinput").text(econame);
//    $("#doncodeinput").text(donCode);
//    $("#donnameinput").text(donname);
//    $("#sourcecodeinput").text(sourceCode);
//    $("#sourcetypeinput").text(sourcetype);
//    $("#amountinput").text(amount);
    $("#popupData").modal('show');
}
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
            var tranobject = JSON.stringify({"id":counter,"budYear":budYear,"month":month,"accCode":accCode,"ecoCode":ecocode,"sourceType":sourceCode,
                      "donorCode":donCode,"amount":amount});
            
             $.ajax({
           type: 'POST',
           url:"http://localhost:8080/FcgoTest/api/reconcile",
           data: tranobject,
           contentType :  "application/json; charset=utf-8",
           dataType: 'json',
           async: false,
           success:function(data){
               debugger;
               alert("ya hoo" + data.data);
               $("#iconhead").show();
               $("#icon"+counter).show();
               if(data.data == "true"){
                  
                   $("#false"+counter).css("display","none");
               }else
                   $("#true"+counter).css("display","none");    
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
    
//    var url = "http://localhost:8080/FcgoTest/api/getEconomicByCode?code="+ecofetchedcode;
//    
//    $.ajax({
//        url:url,
//        type:'GET',
//        dataType: 'json',
//        contentType: 'application/json',
//        success: function (data){
//         var datafromdb = data.data;
//         $('#eco-name' + index).val(datafromdb);
//        }
//    });
      var token = ecofetchedcode.split("        ");
      $("#eco-code"+index).val(token[0]);
      $("#eco-name"+index).val(token[1]);
      
      
    
}

function getDonorData(index){
    
    var donorfetchedcode = $('#don-code'+index).val();
//    var url = "http://localhost:8080/FcgoTest/api/getDonorByCode?code="+donorfetchedcode;
//    
//    $.ajax({
//        url:url,
//        type:'GET',
//        dataType: 'json',
//        contentType: 'application/json',
//        success: function(data){
//            var datafromdb = data.data;
//            $('#don-name'+index).val(datafromdb);
//        }
//    });

   var token = donorfetchedcode.split("        ");
   $('#don-code'+index).val(token[0]);
   $('#don-name'+index).val(token[1]);
   
    
}

   function getSourceTypeData(index){
   
       var sourcefetchedcode = $('#source-code'+index).val();
//       var url = "http://localhost:8080/FcgoTest/api/getSourceByCode?code="+sourcefetchedcode;
//       
//       $.ajax({
//           url:url,
//           type:'GET',
//           dataType: 'json',
//           contentType: 'application/json',
//           success: function (data){
//               var datafromdb = data.data;
//               $('#source-type'+index).text(datafromdb);
//           }
//       });

       var token = sourcefetchedcode.split("        ");
       $("#source-code"+index).val(token[0]);
       $("#source-type"+index).text(token[1]);
   }
   
    
