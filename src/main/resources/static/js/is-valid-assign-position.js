/**
 * 
 */
document.getElementById("error").style.display = "none";

function assign() {
	var emId = document.getElementById("em-name").value;
	var posId = document.getElementById("pos-name").value;

	if (validateData(emId, posId)) {
		//call api-insert data
				$.ajax({
					type: "POST",
					url: "http://localhost:8081/api/assign-position",
					contentType: "application/json",
					data: JSON.stringify({
						"em_id": emId,
						"pos_id": posId
					}),
					success: function() {
						alert("Đã thêm gán vị trí mới");
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




function validateData(emId, posId) {
	if (emId === 0) {
		return false;
	}
	if (posId === 0) {
		return false;
	}

	return true;
}
function goBack() {
	window.history.back();
}