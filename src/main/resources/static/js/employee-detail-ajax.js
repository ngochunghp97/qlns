/**
 * 
 */
$(document).ready(function() {
	var $posName = $("#pos-name");
	var emId = document.getElementById("em-id").innerHTML;
	$.ajax({
		type: "GET",
		url: "http://localhost:8081/api/employee/pos-detail/" + emId,
		dataType: "json",
		success: function(data) {
				$posName.append("<td>" + data.data.posName + '</td>');
		},
		error: function() {
			alert("error loading");
		}
	});
});
$(document).ready(function() {
	var $deName = $("#de-name");
	var emId = document.getElementById("em-id").innerHTML;
	$.ajax({
		type: "GET",
		url: "http://localhost:8081/api/employee/de-detail/" + emId,
		dataType: "json",
		success: function(data) {
				$deName.append("<td>" + data.data.deName + '</td>');
		},
		error: function() {
			alert("error loading");
		}
	});
});
function goBack() {
	window.history.back();
}