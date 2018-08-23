function listTeacher() {

    $("#_con2").css("display", "none");
    $("#_con3").css("display", "none");
    $("#_con1").css("display", "inline");

    $.ajax({
        url:path+"/admin/listTeacher.do",
        type:"post",
        dataType:"json",
        success:function (result) {
            if(result.status == 1){
                $("#teacher_table").html("");
                var teacher = result.data;
                for (var i = 0; i < teacher.length; i++) {
                    var teacherId = teacher[i].teacher_id;
                    var teacherName = teacher[i].teacher_name;
                    createTeacherTr(teacherId, teacherName, i);
                }
            }
        },
        error:function () {
            alert("加载教师失败");
        }
    })
}

function createTeacherTr(teacherId, teacherName, i) {
    var sli = "";
    sli += "<tr><td>";
    sli += i+1;
    sli += "</td><td>";
    sli += teacherId;
    sli += "</td><td>";
    sli += teacherName;
    sli += "</td><td><a class='update_password'>修改密码</a></td>" +
    		"<td><a class='delete_teacher'>删除教师</a></td></tr>";
    var $li = $(sli);
    $li.data("teacherId", teacherId);
    $("#teacher_table").append($li);
}

function addTeacher() {
    var ok = true;
    var userId = $("#teacherId").val();
    var username = $("#teacherName").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();
    if (userId == "" || username == "") {
        ok = false;
        alert("用户名或密码不能为空");
    }
    if (password != password2) {
        ok = false;
        alert("两次输入的密码不一致")
    }
    if (ok) {
        $.ajax({
            url: path + "/admin/addTeacher.do",
            type: "post",
            data: {"userId": userId, "username": username, "password": password},
            dataType: "json",
            success: function () {
                alert("添加成功");
                listTeacher();

            },
            error: function () {
                alert("添加失败");
            }
        })
    }
}