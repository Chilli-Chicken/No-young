/**
 * Created by xx on 05/01/2018.
 */
$(function () {
    var options = {
        url: 'ctrl',
        type: 'post',
        beforeSubmit: function (formData, jqForm, options) {
            for (var i=0; i < formData.length; i++) {
                var norm = formData[i];
                if (isNaN(norm.value)) {
                    alert("请输入数字");
                    $("input[name = "+ formData[i].name +"]").focus();
                    return false;
                }
            }
        },
        success: function (data, status, xhr) {
            if(data.success == 'true') {
                alert('保存成功！');
            } else {
                alert('保存失败！');
            }
            window.location.reload();
        }
    };
    $('#fdForm').ajaxForm(options);
    $('#pdForm').ajaxForm(options);

    $('button').click(function() {
        var acu = $(this).attr('acu');
        var key = $(this).attr('key');
        if(acu) {
            var result = clear(acu, key, "1");
            if(result.success == "true") {
                setTimeout('clear("'+acu+'", "'+key+'", "0")', 2000);
                alert("操作成功！");
                // var result1 = clear(acu, key, "0");
                // if(result1.success == 'true') {
                // } else {
                //     alert("操作失败！");
                // }
            } else {
                alert("操作失败");
            }
        }
    });


});

function clear(acu, key, value) {
    var result;
    $.ajax({
        type: 'post',
        url: 'clear',
        async: false,
        dataType: "json",
        data: {
            acu: acu,
            key: key,
            value: value
        },
        success: function(data, status, xhr) {
            result = data;
        }
    });
    return result;
}