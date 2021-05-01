/**
 * 
 */
document.getElementById("error").style.display = "none";

function addNew() {
	var position = document.getElementById("position").value;
	var posCode = document.getElementById("pos-code").value;

	if (validateData(position, posCode)) {
		//call api-insert data
		alert("Data valid");
		document.getElementById("error").style.display = "none";
	} else {
		//show lỗi
		alert("Data invalid");
		document.getElementById("error").style.display = "block";
	}
}

function validateData(position, posCode) {
	if (position === "") {
		return false;
	}
	if (posCode === "") {
		return false;
	}
	
	return true;
}