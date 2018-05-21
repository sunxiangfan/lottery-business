function showLogin() {

    $(".overCurtain").fadeIn("slow");
    $(".hide-center").fadeIn("slow");
}

$("#close").click(function () {
    $(".hide-center").fadeOut("slow")
    $(".overCurtain").fadeOut("slow")
})

$("#BSignIn").click(function () {
    var loginName = $("#loginName").val();
    var loginPswd = $("#loginPswd").val();
    var data = {"loginName": loginName, "loginPswd": loginPswd};
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
})