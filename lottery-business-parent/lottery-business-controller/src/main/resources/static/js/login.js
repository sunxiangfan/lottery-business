function showLogin() {
    $("#loginForm").dialog({
        height: 200,
        width: 300,
        // 模态开启
        modal: true,
        // 是否可拖拽
        draggable: true,
        // 最小宽度
        minWidth: 300,
        //当用户按 Esc 键之后，是否应该关闭对话框，默认为 true
        closeOnEscape: true,
        title:"登录"
    });
}

function LoginCheck() {
    var loginName = $("#loginName").val();
    var loginPswd = $("#loginPswd").val();
    var data = {"loginName":loginName,"loginPswd":loginPswd};
    data = JSON.stringify(data);
    $.ajax({
        contentType: 'application/json;charset=UTF-8',
        type: "post",
        dataType: "json",
        url: '/user/login',
        data: data,
        success: function (res) {
            if (res.Message == "success") {
                $("#loginForm").dialog('close');
            }
            else {
                alert("请重新输入1");
            }
        },
        error: function () {
            alert("请重新输入");
        },
    });
}