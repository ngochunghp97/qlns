/**
 * 
 */
document.getElementById("error").style.display = "none";

function addNew() {
	var deName = document.getElementById("de-name").value;
	var deCode = document.getElementById("de-code").value;
	var deDesc = document.getElementById("de-desc").value;

	if (validateData(deName, deCode)) {
		//call api-insert data
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/api/department",
			contentType: "application/json",
			data: JSON.stringify({
				"de_name": deName,
				"de_code": deCode,
				"de_desc": deDesc
			}),
			success: function() {
				alert("Đã thêm một phòng ban mới");
				goBack();
			},
			error: function() {
				alert("error creating");
			}
		});
		document.getElementById("error").style.display = "none";
	} else {
		//show lỗi
		alert("Data invalid");
		document.getElementById("error").style.display = "block";
	}
}

function validateData(deName, deCode) {
	if (deName === 0) {
		return false;
	}
	if (deCode === 0) {
		return false;
	}

	return true;
}
function goBack() {
	window.history.back();
}
function update() {
	var deName = document.getElementById("de-name").value;
	var deCode = document.getElementById("de-code").value;
	var deDesc = document.getElementById("de-desc").value;
	var id = document.getElementById("de-id").innerHTML;

	if (validateData(deName, deCode)) {
		//call api-insert data
		$.ajax({
			type: "PUT",
			url: "http://localhost:8081/api/department/" + id,
			contentType: "application/json",
			data: JSON.stringify({
				"de_name": deName,
				"de_code": deCode,
				"de_desc": deDesc
			}),
			success: function() {
				alert("Đã sửa một phòng ban");
				goBack();
			},
			error: function() {
				alert("error updating");
			}
		});
		document.getElementById("error").style.display = "none";
	} else {
		//show lỗi
		alert("Data invalid");
		document.getElementById("error").style.display = "block";
	}
}