/**
 * 
 */
document.getElementById("error").style.display = "none";

function assign() {
	var emId = document.getElementById("em-name").value;
	var deId = document.getElementById("de-name").value;

	if (validateData(emId, deId)) {
		//call api-insert data
				$.ajax({
					type: "POST",
					url: "http://localhost:8081/api/assign-department",
					contentType: "application/json",
					data: JSON.stringify({
						"em_id": emId,
						"de_id": deId
					}),
					success: function() {
						alert("Đã thêm gán phòng ban mới");
						goBack();
					},
					error: function() {
						alert("error assigning");
					}
				});
		document.getElementById("error").style.display = "none";
	} else {
		//show lỗi
		alert("Data invalid");
		document.getElementById("error").style.display = "block";
	}
}




function validateData(emId, deId) {
	if (emId === 0) {
		return false;
	}
	if (deId === 0) {
		return false;
	}

	return true;
}
function goBack() {
	window.history.back();
}