/**
 * 
 */
$(document).ready(function(){
	var $emName = $("#em-name");
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8081/api/employee",
		dataType: "json",
		success: function(data){
			for(var i in data){

			}			
			$.each(data[i], function(j, em){
				$emName.append("<option value='"+em.em_id+"'>"+em.name+'</option>')
			});
		},
		error: function(){
			alert("error loading");
		}
	});
});
$(document).ready(function(){
	var $deName = $("#de-name");
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8081/api/department",
		dataType: "json",
		success: function(data){

			for(var i in data){

			}
			$.each(data[i], function(j, de){
				$deName.append("<option value='"+de.de_id+"'>"+de.de_name+'</option>')
			});
		},
		error: function(){
			alert("error loading");
		}
	});
});