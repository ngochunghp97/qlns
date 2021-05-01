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
	if (validateData(name, birthday, gender, address, startDate, major)) {
		//call api-insert data
		alert("Data valid");
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
	if (gender < 1) {
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