/**
 * Created by xx on 26/12/2017.
 */
$(function() {

    $('#login').click(function() {
        var userName = $('#userName').val();
        var password = $('#password').val();
        if(userName == "") {
            alert("请输入用户名！");
            return false;
        }
        if(password == "") {
            alert("请输入密码！");
            return false;
        }
        $.ajax({
            type: 'post',
            url: 'doLogin',
            async: false,
            dataType: "json",
            data: {
                userName: userName,
                password: password
            },
            success: function(data1, status, xhr) {
                if(data1.success == 'true') {
                    window.location.href="userInfo";
                } else {
                    $('#userName').val('');
                    $('#password').val('');
                    alert("用户名密码错误！");
                }
            }
        });
        return false;
    });

});