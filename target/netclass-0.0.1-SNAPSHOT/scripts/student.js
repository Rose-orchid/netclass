function listMyCourse() {
    $("#con").html("<div style='height: 50px'><span style='font-size: 26px;position: absolute;top: 10px;left: 60px;'>已选课程：</span></div><ul id='con_ul'></ul>");
    var studentId = getCookie("userId");
    $.ajax({
        url: path + "/student/listMyCourse.do",
        type: "post",
        data: {"studentId": studentId},
        dataType: "json",
        success: function (result) {
            if (result.status == 1) {
                $("#con_ul").html("");
                var course = result.data;
                var ul = "#con_ul";
                for (var i = 0; i < course.length; i++) {
                    var courseId = course[i].course_id;
                    var courseName = course[i].course_name;
                    var teacherName = course[i].course_teacher_name;
                    createCourseLi(courseId, courseName, teacherName, ul);
                }
            }
        },
        error: function () {
            alert("查询我的课程失败!");
        }

    })
}

function closeAlertWindow() {
    //情况div内容
    $("#stuAlertAddCourse").css("display","none");
    //隐藏背景色
    //$(".opacity_bg").hide();
};

function alert_MyInfo() {
    $("#con").html("");
    $("#con").load("stuInfo.html");
    $("body").css("background-color","#eeeeee");
}

function createCourseLi(courseId, courseName, teacherName, ul) {
    var sli = "";
    sli += '<li title="点击查看课程详情">';
    sli += '<img src=';
    sli += '\'images\\course_img.png\'';
    sli += '>';
    sli += '<p>';
    sli += '课 程: ';
    sli += courseName;
    sli += '</p>';
    sli += '<p>';
    sli += '教 师: ';
    sli += teacherName;
    sli += '</p>';
    sli += '</li>';
    var $li = $(sli);
    $li.data("courseId", courseId);
    $(ul).append($li);
};

function listAllCourse() {
    $("#con").html("<div style='height: 50px'><span style='font-size: 26px;position: absolute;top: 10px;left: 60px;'>可选课程：</span></div><ul id='courseList_ul'></ul>");
    var studentId = getCookie("userId");
    $.ajax({
        url: path + "/student/listAllCourse.do",
        type: "post",
        data: {"studentId": studentId},
        dataType: "json",
        success: function (result) {
            if (result.status == 1) {
                $("#con_ul").html("");
                var course = result.data;
                var ul = "#courseList_ul";
                for (var i = 0; i < course.length; i++) {
                    var courseId = course[i].course_id;
                    var courseName = course[i].course_name;
                    var teacherName = course[i].course_teacher_name;
                    createCourseLi(courseId, courseName, teacherName, ul);
                }
            }
        },
        error: function () {
            alert("查询全部课程失败")
        }
    });
}

function sureAddCourse() {
    $("#alert_con").html("");
    $.ajax({
        url: path + "/student/addCourse.do",
        data: {"courseId": courseId, "studentId": studentId},
        type: "post",
        dataType: "json",
        success: function (result) {
            if (result.status == 1) {
                alert("添加课程成功");
                listAllCourse();
            }
        },
        error: function () {
            alert("添加课程失败");
        }
    })
}

function alertAddCourse() {
    courseId = $(this).data("courseId");
    //setCookie("courseId",courseId);
    studentId = getCookie("userId");
    $("#stuAlertAddCourse").css("display","inline");
}

function loadCourseDetail() {
    courseId = $(this).data("courseId");
    setCookie("courseId", courseId);
    window.open("stuCourseDetail.html");
}