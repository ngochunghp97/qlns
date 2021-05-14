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
function deleteEm(id) {
	var cf = confirm("Bạn xác nhận sẽ xóa nhân viên này?");
	if (cf) {
		$.ajax({
			method: 'DELETE',
			url: "/api/employee/" + id,
			contentType: "application/json",
			success: function() {
				alert("Đã xóa một nhân viên");
				window.location.href = "http://localhost:8081/employee/";
			},
			error: function() {
				alert("error deleting");
			}
		});
	}
}
function deleteDe(id) {
	var cf = confirm("Bạn xác nhận sẽ xóa phòng ban này?");
	if (cf) {
		$.ajax({
			method: 'DELETE',
			url: "/api/department/" + id,
			contentType: "application/json",
			success: function() {
				alert("Đã xóa một phòng ban");
				window.location.href = "http://localhost:8081/department/";
			},
			error: function() {
				alert("error deleting");
			}
		});
	}
}
function deletePos(id) {
	var cf = confirm("Bạn xác nhận sẽ xóa vị trí này?");
	if (cf) {
		$.ajax({
			method: 'DELETE',
			url: "/api/position/" + id,
			contentType: "application/json",
			success: function() {
				alert("Đã xóa một vị trí");
				window.location.href = "http://localhost:8081/position/";
			},
			error: function() {
				alert("error deleting");
			}
		});
	}
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
function repairEm(id) {
	window.location.href = "http://localhost:8081/employee-update/" + id;
}