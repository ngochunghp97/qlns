/**
 * 
 */
$(function(){
	var $position = $('#position');
	
	$.ajax({
		type:'GET',
		url:'http://localhost:8081/api/position',
		success: function(position){
			$.each(positon, function(i, pos){
				$position.append('<option>'+pos.posName+'</option>')
			});
		}
	});
});