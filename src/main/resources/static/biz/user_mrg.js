$(function() {
	$('.side-content').css('top', $('.app-heading').outerHeight());

	$('form').bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			userName: {
				validators: {
					notEmpty: {
						message: '用户名不能为空'
					}
				}
			},
			pwd: {
				validators: {
					notEmpty: {
						message: '密码不能为空'
					}
				}
			},
			role: {
				validators: {
					notEmpty: {
						message: '密码不能为空'
					}
				}
			}
		}
	}).on("success.form.bv", function(e) {
		$.ajax({
			type: 'post',
			url: 'userInfo',
			async: false,
			data: {
				id: $("#id").val(),
				userName: $("#userName").val(),
				password: $("#pwd").val(),
				role: $("#role").val()
			},
			success: function(data, status, xhr) {
				//console.log(data);
				alert("保存成功！");
                window.location.href="userInfo";
			}
		});
	});

    $(".addUser").click(function() {
        $("#userName").val("");
        $("#role").val(0);
        $("#myModal").modal('show');
    });

	$(".editUser").click(function() {
		var id = $(this).val();
		$("#myModal").modal('show');
        $.ajax({
            type: 'get',
            url: 'userInfo/'+id,
            success: function (data, status, xhr) {
                $("#userName").val(data.userName);
                $("#role").val(data.role);
                $("#id").val(data.id);
            }
        });
	});

    $(".deleteUser").click(function() {
        var r=confirm("确认删除吗？");
        var id = $(this).val();
        if(r) {
            $.ajax({
                type: 'get',
                url: 'delUser',
                data: {
                    userInfoId: id
                },
                success: function (data, status, xhr) {
                    alert("删除成功！");
                    window.location.reload();
                }
            });
        }
    });

});