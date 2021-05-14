/**
 * 
 */
document.getElementById("error").style.display = "none";

function addNew() {
	var name = document.getElementById("name").value;
	var birthday = document.getElementById("birthday").value;
	var gender = document.getElementById("gender").value;
	var address = document.getElementById("address").value;
	var startDate = document.getElementById("start-date").value;
	var major = document.getElementById("major").value;
	var endDate = document.getElementById("end-date").value;
	var experience = document.getElementById("experience").value;
	var language = document.getElementById("language").value;
	var computer = document.getElementById("computer").value;

	if (validateData(name, birthday, gender, address, startDate, major)) {
		//call api-insert data
		$.ajax({
					type: "POST",
					url: "/api/employee",
					contentType: "application/json",
					data: JSON.stringify({
						"name": name,
						"birthday": birthday,
						"gender": gender,
						"address": address,
						"start_date": startDate,
						"major": major,
						"end_date": endDate,
						"experience": experience,
						"language": language,
						"computer": computer
						
					}),
					success: function() {
						alert("Đã thêm một nhân viên mới");
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

function validateData(name, birthday, gender, address, startDate, major) {
	if (name === "") {
		return false;
	}
	if (birthday === "") {
		return false;
	}
	if (gender === 0) {
		return false;
	}
	if (address === "") {
		return false;
	}
	if (startDate === "") {
		return false;
	}
	if (major === "") {
		return false;
	}
	
	return true;
}

function goBack() {
  window.history.back();
}
function update() {
	var name = document.getElementById("name").value;
	var birthday = document.getElementById("birthday").value;
	var gender = document.getElementById("gender").value;
	var address = document.getElementById("address").value;
	var startDate = document.getElementById("start-date").value;
	var major = document.getElementById("major").value;
	var endDate = document.getElementById("end-date").value;
	var experience = document.getElementById("experience").value;
	var language = document.getElementById("language").value;
	var computer = document.getElementById("computer").value;
	var id = document.getElementById("em-id").innerHTML;

	if (validateData(name, birthday, gender, address, startDate, major)) {
		//call api-insert data
		$.ajax({
					type: "PUT",
					url: "/api/employee/"+id,
					contentType: "application/json",
					data: JSON.stringify({
						"name": name,
						"birthday": birthday,
						"gender": gender,
						"address": address,
						"start_date": startDate,
						"major": major,
						"end_date": endDate,
						"experience": experience,
						"language": language,
						"computer": computer
						
					}),
					success: function() {
						alert("Đã sửa một nhân viên");
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