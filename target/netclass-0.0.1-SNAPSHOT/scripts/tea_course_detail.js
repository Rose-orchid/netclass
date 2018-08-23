function loadCourse() {
    var courseId = getCookie("courseId");
    // 根据课程Id展示课程信息
    $.ajax({
        url: path + "/teacher/loadCourse.do",
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
                var courseIntro = result.data.course_intro;
                var courseNotice = result.data.course_notice;
                $("#courseName").text(courseName);
                addCookie("courseName", courseName);
                $("#teacherName").text(teacherName);
                addCookie("teacherName", teacherName);
                $("#courseNotice").text(courseNotice);
                $("#courseIntro").text(courseIntro);
            }
            listFiles();
        },
        error: function () {
            //alert("展示课程详情失败!");
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

function upload() {
    var teacherName = getCookie("teacherName");
    var courseName = getCookie("courseName");
    var wareDescribe = $("#wareDescribe").val();
    if ($("#file1").val().length > 0 && wareDescribe.length > 0 ) {
        $.ajaxFileUpload({
            url: path + '/file/upload.do', // 用于文件上传的服务器端请求地址
            secureuri: false, // 是否需要安全协议，一般设置为false
            fileElementId: 'file1', // 文件上传域的ID
            dataType: 'JSON', // 返回值类型 一般设置为json
            type: "post",
            data: {
                "wareDescribe":wareDescribe,
                "teacherName": teacherName,
                "courseName": courseName
            },
            success: function (str) {
            	$("#upload_").css("display","none");
                alert(str);
            },
            error: function (str) {
                alert(str);
            }
        });
    } else {
        alert("文件描述未填写或未选择文件!");
    }
}

function download() {
    var fileName = $(this).data("fileName");
    var courseName = getCookie("courseName");
    var teacherName = getCookie("teacherName");
    var url = path + "/file/newdownload.do?fileName="+fileName+"&courseName="+courseName+"&teacherName="+teacherName;
    window.open(url);
}

function updateNotice() {
    var courseId = getCookie("courseId");
    var courseNotice = $("#courseNotice").val();
    if (courseNotice != null) {
        $.ajax({
            url: path + "/teacher/updateNotice.do",
            data: {"courseId": courseId, "courseNotice": courseNotice},
            type: "post",
            dataType: "json",
            success: function (result) {
                if (result.status == 1) {
                    alert("更新成功");
                } else {
                    alert("更新失败!!!");
                }
            },
            error: function () {
                alert("更新失败");
            }
        });
    } else {
        alert("更新内容不能为空!");
    }
}

function loadMessage() {
    var teacherId = getCookie("userId");
    var courseId = getCookie("courseId");
    $.ajax({
        url: path + "/teacher/loadMessage.do",
        data: {"courseId": courseId, "teacherId": teacherId},
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
                sdiv += "</p></div>";
                sdiv += "<div id='message'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                sdiv += message;
                sdiv += "</div>";
                sdiv += "<div><button id='reply' class='btn btn-default'>回复</button>"
                sdiv += "</div>";
                var $div = $(sdiv);
                $div.data("time", list[i].record_time);
                $div.data("deliverId", list[i].record_deliver_id);
                $div.data("deliverName", deliverName);
                $("#message_list").append($div);
            }
        }
    })
}

function replyMessage() {
    var sdiv = "";
    sdiv += "<div class='replyArea'>";
    sdiv += "<textarea class='msgArea form-control' style='width: 697px;height: 140px;'></textarea>";
    sdiv += "<button type='button' id='cancel'class='btn btn-default' style='height:30px; position: absolute;right: 20px;top: 100px;'>取消</button>";
    sdiv += "<button type='button' id='sureReply' class='btn btn-default' style='height:30px; position: absolute;right: 90px;top: 100px;'>回复</button>";
    sdiv += "</div>";
    $(this).parent().parent().after(sdiv);
}

function sendMsgToStu() {
    var $div = $(this).parent().prev();
    var message = $(".msgArea").val();
    if (message != "") {
        var courseId = getCookie("courseId");
        var studentId = $div.data("deliverId");
        var studentName = $div.data("deliverName");
        var time = $div.data("time");
        var teacherId = getCookie("userId");
        var teacherName = getCookie("teacherName");
        //alert(time + teacherId + teacherName);
        $.ajax({
            url: path + "/teacher/sendMsg.do",
            data: {
                "courseId": courseId,
                "studentId": studentId,
                "studentName": studentName,
                "teacherId": teacherId,
                "teacherName": teacherName,
                "message": message,
                "time": time
            },
            type: "post",
            dataType: "json",
            success: function (result) {
                if (result.status == 1) {
                    alert("发送成功");
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