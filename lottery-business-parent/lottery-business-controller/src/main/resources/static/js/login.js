function showLogin() {
    $(".overCurtain").fadeIn("slow");
    $(".hide-center").fadeIn("slow");
}

$("#close").click(function () {
    $(".hide-center").fadeOut("slow");
    $(".overCurtain").fadeOut("slow");
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
            if (res.code == "200") {
                $(".hide-center").fadeOut("slow");
                $(".overCurtain").fadeOut("slow");
            }
            else {
                alert(res.message);
            }
        },
        error: function () {
            alert("登录失败！");
        },
    });
})