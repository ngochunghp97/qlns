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
	var $posName = $("#pos-name");
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8081/api/position",
		dataType: "json",
		success: function(data){

			for(var i in data){

			}
			$.each(data[i], function(j, pos){
				$posName.append("<option value='"+pos.pos_id+"'>"+pos.pos_name+'</option>')
			});
		},
		error: function(){
			alert("error loading");
		}
	});
});