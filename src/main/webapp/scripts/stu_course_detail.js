function loadCourse() {
    var courseId = getCookie("courseId");
    // 根据课程Id展示课程信息
    $.ajax({
        url: path + "/student/loadCourse.do",
        type: "post",
        data: {
            "courseId": courseId
        },
        dataType: "json",
        success: function (result) {
            if (result != null) {
                // var course = result.date;
                var courseName = result.data.course_name;
                var teacherName = result.data.course_teacher_name;
                var teacherId = result.data.course_teacher_id;
                var courseNotice = result.data.course_notice;
                var courseIntro = result.data.course_intro;
                $("#courseName").text(courseName);
                addCookie("courseName", courseName);
                $("#teacherName").text(teacherName);
                addCookie("teacherName", teacherName);
                addCookie("teacherId", teacherId);
                $("#courseNotice").text(courseNotice);
                $("#courseIntro").text(courseIntro);
            }
        },
        error: function () {
            // alert("展示课程详情失败!");
        }
    })

}

function listFiles() {
    var teacherName = getCookie("teacherName");
    var courseName = getCookie("courseName");
    $("#files_ul").html("");
    $.ajax({
        url: path + "/file/loadFiles.do",
        type: "post",
        data: {
            "teacherName": teacherName,
            "courseName": courseName
        },
        dataType: "json",
        success: function (list) {
            for(var i=0;i<list.length;i++){
            	var fileName = list[i].courseware_name;
            	var describe = list[i].courseware_describe;
            	var time = list[i].courseware_time;
            	createFileLi(fileName, describe,time,i+1);
            }
        },
        error: function () {

        }
    });
}

function createFileLi(fileName, describe,time, i) {
    var sli = "";
    sli += '<li title="点击下载文件">';
    sli += i+'. ';
    sli += '<a class="file">';
    sli += describe;
    sli += '</a>';
    sli += "<span>上传时间：";
    sli += time;
    sli += '</span></li><br>';
    var $li = $(sli);
    $li.data("fileName", fileName);
    $("#files_ul").append($li);
}

function download() {
    var fileName = $(this).data("fileName");
    var courseName = getCookie("courseName");
    var teacherName = getCookie("teacherName");
    var url = path + "/file/newdownload.do?fileName=" + fileName + "&courseName=" + courseName + "&teacherName=" + teacherName;
    window.open(url);
}

function sendMsgToTea() {
    var message = $("#area1").val();
    if (message != "") {
        var courseId = getCookie("courseId");
        var studentId = getCookie("userId");
        var studentName = getCookie("studentName");
        var teacherId = getCookie("teacherId");
        var teacherName = getCookie("teacherName");
        $.ajax({
            url: path + "/student/sendMsg.do",
            data: {
                "courseId": courseId,
                "studentId": studentId,
                "studentName": studentName,
                "teacherId": teacherId,
                "teacherName": teacherName,
                "message": message
            },
            type: "post",
            dataType: "json",
            success: function (result) {
                if (result.status == 1) {
                    alert("发送成功");
                    $("#area1").val("");
                    loadMessage();
                }
            },
            error: function () {
                alert("发送失败");
            }
        })
    }
    else {
        alert("发送内容不能为空!");
    }
}

function loadMessage() {
    var studentId = getCookie("userId");
    var courseId = getCookie("courseId");
    var teacherId = getCookie("teacherId");
    $.ajax({
        url: path + "/student/loadMessage.do",
        data: {"courseId": courseId, "studentId": studentId, "teacherId": teacherId},
        type: "post",
        dataType: "json",
        success: function (result) {
            $("#message_list").html("");
            var list = result.data;
            for (var i = 0; i < list.length; i++) {
                var deliverName = list[i].record_deliver_name;
                var receiverName = list[i].record_receiver_name;
                var message = list[i].record_message;
                var time = list[i].record_time;
                var sdiv = "";
                sdiv += "<div class='record'>";
                sdiv += "<div id='title'>";
                sdiv += deliverName;
                sdiv += "对";
                sdiv += receiverName;
                sdiv += "说:";
                sdiv += "<p id='time'>";
                sdiv += time;
                sdiv += "</p>";
                sdiv += "</div>";
                sdiv += "<div id='message'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                sdiv += message;
                sdiv += "</div>";
                sdiv += "</div>";
                var $div = $(sdiv);
                $div.data("deliverId", list[i].record_deliver_id);
                $div.data("deliverName", deliverName);
                $div.data("time", list[i].record_deliver_time);
                $("#message_list").append($div);
            }
        }
    })
}

function upload() {
	var courseId = getCookie("courseId");
	var studentId = getCookie("userId");
    var teacherName = getCookie("teacherName");
    var courseName = getCookie("courseName");
    if ($("#file1").val().length > 0) {
        $.ajaxFileUpload({
            url: path + '/file/uploadHomework.do', // 用于文件上传的服务器端请求地址
            secureuri: false, // 是否需要安全协议，一般设置为false
            fileElementId: 'file1', // 文件上传域的ID
            dataType: 'JSON', // 返回值类型 一般设置为json
            type: "post",
            data: {
                "teacherName": teacherName,
                "courseName": courseName,
                "studentId" : studentId,
                "courseId" : courseId
            },
            success: function (str) {
                alert(str);
            },
            error: function (str) {
                alert(str);
            }
        });
    } else {
        alert("请选择文件!");
    }
}