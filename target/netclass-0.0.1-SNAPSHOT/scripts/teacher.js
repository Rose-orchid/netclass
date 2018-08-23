function addCourse() {

    var userId = getCookie("userId");
    var teacherName = getCookie("teacherName");
    var courseName = $("#courseName").val().trim();
    var courseIntro = $("#courseIntro").val().trim();
    $.ajax({
        url: path + "/teacher/addCourse.do",
        type: "post",
        data: {"userId": userId, "teacherName": teacherName, "className": courseName, "classIntro": courseIntro},
        dataType: "json",
        success: function (result) {
            if (result.status == 2) {
                alert("添加课程成功!");
                $("#con").html(" ");
                listmyclass();
            }
        },
        error: function () {
            alert("添加课程失败!");
        }
    })
}


function listmyclass() {
    var userId = getCookie("userId");
    $.ajax({
        url: path + "/teacher/listCourse.do",
        type: "post",
        data: {"userId": userId},
        dataType: "json",
        success: function (result) {
            if (result.status == 2) {
                $("#_con").html("<ul id='con_ul'></ul>");
                // $("#con_ul").html("");
                var course = result.data;
                for (var i = 0; i < course.length; i++) {
                    var courseId = course[i].course_id;
                    var courseName = course[i].course_name;
                    //var courseNotice = course[i].course_notice;
                    createCourseLi(courseId, courseName);
                }
            }
        },
        error: function () {
            alert("显示我的课程失败!");
        }

    })
}

function alertaddclass() {
    $("#_con").html("");
    $("#_con").load("teaAddCourse.html");
    $("body").css("background-color","#eeeeee");
}

function alertMyInfo() {
    $("#_con").html("");
    $("#_con").load("teaInfo.html");
    $("body").css("background-color","#eeeeee");
}

//关闭对话框
function closeAlertWindow() {
    //情况div内容
    $("#_con").html("");
    //隐藏背景色
    //$(".opacity_bg").hide();
};

function createCourseLi(courseId, courseName) {
    var sli = "";
    sli += '<li title="点击查看课程详情">';
    sli += '<img src=';
    sli += '\'images\\course_img.png\'';
    sli += '>';
    sli += '<h3>';
    sli += '&nbsp;&nbsp;课程名:';
    sli += courseName;
    sli += '</h3>';
    sli += '</li>';
    var $li = $(sli);
    $li.data("courseId", courseId);
    $("#con_ul").append($li);
};

function loadCourseDetail() {
    var courseId = $(this).data("courseId");
    addCookie("courseId", courseId);
    window.open("teaCourseDetail.html");
}