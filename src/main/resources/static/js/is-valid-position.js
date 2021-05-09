/**
 * 
 */
document.getElementById("error").style.display = "none";

function addNew() {
	var posName = document.getElementById("pos-name").value;
	var posCode = document.getElementById("pos-code").value;
	var posDesc = document.getElementById("pos-desc").value;

	if (validateData(posName, posCode)) {
		//call api-insert data
		$.ajax({
			type: 'post',
			url: '/api/position/create',
			contentType: 'application/json',
			data: JSON.stringify({
				"pos_name": posName,
				"pos_code": posCode,
				"pos_desc": posDesc
			}),
			success: function() {
				alert("Đã thêm một vị trí mới");
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




function validateData(posName, posCode) {
	if (posName === "") {
		return false;
	}
	if (posCode === "") {
		return false;
	}

	return true;
}
function goBack() {
	window.history.back();
}
