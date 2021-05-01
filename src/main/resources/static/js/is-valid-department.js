/**
 * 
 */
document.getElementById("error").style.display = "none";

function addNew() {
	var department = document.getElementById("department").value;
	var deCode = document.getElementById("de-code").value;

	if (validateData(department, deCode)) {
		//call api-insert data
		alert("Data valid");
		document.getElementById("error").style.display = "none";
	} else {
		//show lỗi
		alert("Data invalid");
		document.getElementById("error").style.display = "block";
	}
}

function validateData(department, deCode) {
	if (department === "") {
		return false;
	}
	if (deCode === "") {
		return false;
	}
	
	return true;
}