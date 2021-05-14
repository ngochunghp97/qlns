/**
 * 
 */
document.getElementById("error").style.display = "none";
document.getElementById("error-2").style.display = "none";
function goBack() {
	window.history.back();
}
function addUser() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var repeatPass = document.getElementById("repeat-password").value;

	if (validateData(username, password, repeatPass)) {
		if (validatePass(password, repeatPass)) {
			$.ajax({
				type: "POST",
				url: "/api/user",
				contentType: "application/json",
				data: JSON.stringify({
					"username": username,
					"password": password
				}),
				success: function() {
					alert("Đã thêm một user mới");
					goBack();
				},
				error: function() {
					alert("error creating");
				}
			});
			document.getElementById("error").style.display = "none";
			document.getElementById("error-2").style.display = "none";
		} else {
			//show lỗi
			alert("Mật khẩu không giống nhau");
			document.getElementById("error").style.display = "none";
			document.getElementById("error-2").style.display = "block";			
		}
	} else{
		alert("Data invalid");
		document.getElementById("error").style.display = "block";
	}

}
function validateData(username, password, repeatPass) {
	if (username === "") {
		return false;
	}
	if (password === "") {
		return false;
	}
	if (repeatPass === "") {
		return false;
	}
	return true;
}
function validatePass(password, repeatPass) {
	if (password === repeatPass) {
		return true;
	}
	return false;
}