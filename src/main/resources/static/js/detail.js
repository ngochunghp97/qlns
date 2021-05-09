/**
 * 
 */
function goBack() {
	window.history.back();
}
function detail(id) {
	var emId = id;
	window.location.href = "http://localhost:8081/employee-detail/" + emId;
}
function deleteEm(id){
	var emId = id;
	console.log(emId);
	$.ajax({
		method: 'DELETE',
		url: "http://localhost:8081/api/employee/" + emId,
		contentType: "application/json",
		success: function(data) {
				console.log(data);
				alert("Đã xóa một nhân viên");
				window.location.href = "http://localhost:8081/employee/";
		},
		error: function(data) {
			console.log(data);
			alert("error loading");
		}
	});
}
function detailPos(id) {
	window.location.href = "http://localhost:8081/position-detail/" + id;
}
function detailDe(id) {
	window.location.href = "http://localhost:8081/department-detail/" + id;
}
function repairPos(id) {
	window.location.href = "http://localhost:8081/position-update/" + id;
}
function repairDe(id) {
	window.location.href = "http://localhost:8081/department-update/" + id;
}
function repairEm(id){
	window.location.href = "http://localhost:8081/employee-update/" + id;
}