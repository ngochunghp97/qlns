/**
 * 
 */
$(document).ready(function(){
	var $position = $("#position");
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8081/api/position",
		dataType: "json",
		success: function(data){
		console.log("success",data);
			for(var i in data){
			console.log("success",data[i]);
			}
			$.each(data[i], function(j, pos){
				$position.append('<option>'+pos.pos_name+'</option>')
			});
		},
		error: function(){
			alert("error loading");
		}
	});
});
$(document).ready(function(){
	var $department = $("#department");
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8081/api/department",
		dataType: "json",
		success: function(data){
		console.log("success",data);
			for(var i in data){
			console.log("success",data[i]);
			}
			$.each(data[i], function(j, de){
				$department.append('<option>'+de.de_name+'</option>')
			});
		},
		error: function(){
			alert("error loading");
		}
	});
});