function userLogin() {

	var userId = $("#userId").val();
	var password = $("#password").val();
	var userType = $("input:radio:checked").val();

	$("#userId_span").html("");
	$("#password_span").html("");
	$("#userType_span").html("");

	var ok = true;

	if (userId == "") {
		$("#userId_span").html("请输入用户ID");
		ok = false;
	}
	if (password == "") {
		$("#password_span").html("请输入密码");
		ok = false;
	}
	if (userType == null) {
		$("#userType_span").html("请选择用户类型");
		ok = false;
	}
	
	if (ok) {
		$.ajax({
			url : path + "/user/login.do",
			type : "post",
			data : {
				"userId" : userId,
				"password" : password,
				"userType" : userType
			},
			dataType : "json",
			success : function(result) {
				if (result.status == 1) {
					var studentName = result.data.student_name;
					addCookie("userId", userId);
					addCookie("studentName", studentName);
					window.location.href = "student.html";
				} else if (result.status == 2) {
					var teacherName = result.data.teacher_name;
					addCookie("userId", userId);
					addCookie("teacherName", teacherName);
					window.location.href = "teacher.html";
				} else if (result.status == 3) {
					var adminName = result.data.admin_name;
					addCookie("userId", userId);
					addCookie("adminName", adminName);
					window.location.href = "admin.html";
				} else {
					alert("登录失败");
				}
			},
			error : function() {
				alert("登录错误!");
			}
		});
	}
}