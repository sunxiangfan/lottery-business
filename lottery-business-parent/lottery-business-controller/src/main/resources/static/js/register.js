function showRegister() {
    $("#formbody-register input").val("");
    $("#formbody-register img").remove();

    $(".overCurtain").fadeIn("slow");
    $(".hide-center-register").fadeIn("slow");
    var bigImg = document.createElement("img");
    bigImg.src = "http://localhost:8080/captcha/getCaptcha";
    bigImg.width = "70";
    bigImg.height = "42";
    var myDiv = document.getElementById('yanzhengma');
    myDiv.appendChild(bigImg);
}

$("#close-register").click(function () {
    $(".hide-center-register").fadeOut("slow");
    $(".overCurtain").fadeOut("slow");
})

$("#BSignIn-register").click(function () {
    var loginName = $("#registerName").val();
    var loginPswd = $("#registerPswd").val();
    var captcha = $("#captcha").val();
    var data = {"loginName": loginName, "loginPswd": loginPswd, "captcha": captcha};
    data = JSON.stringify(data);
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        contentType: 'application/json;charset=UTF-8',
        type: "post",
        dataType: "json",
        url: '/user/register',
        data: data,
        success: function (res) {
            if (res.code == "200") {
                $(".hide-center-register").fadeOut("slow");
                $(".overCurtain").fadeOut("slow");
            } else {
                alert(res.message);
            }
        },
        error: function () {
            alert("注册失败！");
        },
    });
})