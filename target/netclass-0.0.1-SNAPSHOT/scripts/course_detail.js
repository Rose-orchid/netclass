function loadCourse() {
	var courseId = getCookie("courseId");
	// 根据课程Id展示课程信息
	$.ajax({
		url : path + "/course/findCourse.do",
		type : "post",
		data : {
			"courseId" : courseId
		},
		dataType : "json",
		success : function(result) {
			if (result != null) {
				// var course = result.date;
				var courseName = result.data.course_name;
				var teacherName = result.data.course_teacher_name;
				var courseNotice = result.data.course_notice;
				$("#courseName").text(courseName);
				addCookie("courseName", courseName);
				$("#teacherName").text(teacherName);
				addCookie("teacherName", teacherName);
				$("#courseNotice").text(courseNotice);
			}
            listFiles();
		},
		error : function() {
			//alert("展示课程详情失败!");
		}
	})

}

function listFiles() {
	var teacherName = getCookie("teacherName");
	var courseName = getCookie("courseName");
	$("#files_ul").html("");
	$.ajax({
		url : path + "/file/loadFiles.do",
		type : "post",
		data : {
			"teacherName" : teacherName,
			"courseName" : courseName
		},
		dataType : "json",
		success : function(filesMap) {
			for (var key in filesMap) {
				var fileName = key;
				var filePath = filesMap[key];
				//$("#files_ul").append("<li><a href=\'"+path+"/file/down.do?fileName="+fileName+"&filePath="+filePath+"\'>"+fileName+"</a></li><br>");
                createFileLi(fileName, filePath);
			}
		},
		error : function() {

		}
	});
}
function createFileLi(fileName, filePath) {
    var sli = "";
    sli += '<li>';
    sli += '<a>';
    sli += fileName;
    sli += '+';
    sli += filePath;
    sli += '</a>';
    sli += '</li>';
    var $li = $(sli);
    $li.data("filePath", filePath);
    $("#files_ul").append($li);
}
function upload() {
	var teacherName = getCookie("teacherName");
	var courseName = getCookie("courseName");
	if ($("#file1").val().length > 0) {
		$.ajaxFileUpload({
			url : path + '/file/upload.do', // 用于文件上传的服务器端请求地址
			secureuri : false, // 是否需要安全协议，一般设置为false
			fileElementId : 'file1', // 文件上传域的ID
			dataType : 'JSON', // 返回值类型 一般设置为json
			type : "post",
			data : {
				"teacherName" : teacherName,
				"courseName" : courseName
			},
			success : function(str) {
				alert(str);
			},
			error : function(str) {
				alert(str);
			}
		});
	} else {
		alert("请选择文件!");
	}
}

function download() {
	 var filePath = $(this).data("filePath");
	 $.ajax({
	 	url:path + "/file/download.do",
	data:{"filePath":filePath},
	type:"post",
	success:function () {
		alert("下载成功");
	 },
	error:function () {
		alert("下载失败");
	     }
	 })
}