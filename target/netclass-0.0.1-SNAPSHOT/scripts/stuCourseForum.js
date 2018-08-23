function loadForum() {
	var courseId = getCookie("courseId");
	$.ajax({
		url : path + "/student/loadForum.do",
		data : {
			"courseId" : courseId
		},
		type : "post",
		dataType : "json",
		success : function(result) {
			$("#bbs_list").html("");
            var list = result.data;
            for (var i = 0; i < list.length; i++) {
                var userId = list[i].forum_user_id;
                var title = list[i].forum_title;
                var content = list[i].forum_content;
                var time = list[i].forum_time;
                var sdiv = "";
                sdiv += "<div class='tiezi'>";
                sdiv += "<img src='images/touxiang.png'><a class='userName'>";
                sdiv += userId;
                sdiv += "</a><span class='title'>";
                sdiv += title;
                sdiv += "</span><hr><span class='content'>";
                sdiv += content;
                sdiv += "</span><span class='time'>";
                sdiv += time;
                sdiv += "</span></div>";
                var $div = $(sdiv);
                $("#bbs_list").append($div);
            }
        },
		error : function() {
			alert("加载失败");
		}
	})
}

function deliveForum(){
	var title = $("#title").val();
	var content = $("#content").val();
	var courseId = getCookie("courseId");
	var userId = getCookie("userId");
	if(title != ""){
		$.ajax({
			url: path + "/student/sendForum.do",
			data:{	"title":title,
					"content":content,
					"courseId":courseId,
					"userId":userId},
			type:"post",
			dataType:"json",
			success:function(){
				alert("发帖成功");
				loadForum();
			},
			error:function(){
				alert("发帖失败");
			}
		})
	}else {
		alert("标题不能为空");
	}
	
}
