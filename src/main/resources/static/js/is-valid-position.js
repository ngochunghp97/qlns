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
			type: 'POST',
			url: '/api/position',
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

function update() {
	var posName = document.getElementById("pos-name").value;
	var posCode = document.getElementById("pos-code").value;
	var posDesc = document.getElementById("pos-desc").value;
	var id = document.getElementById("pos-id").innerHTML;

	if (validateData(posName, posCode)) {
		//call api-insert data
		$.ajax({
			type: 'PUT',
			url: '/api/position/'+id,
			contentType: 'application/json',
			data: JSON.stringify({
				"pos_name": posName,
				"pos_code": posCode,
				"pos_desc": posDesc
			}),
			success: function(data) {
				console.log(data);
				alert("Đã sửa một vị trí");
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