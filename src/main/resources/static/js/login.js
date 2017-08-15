/**
 * Created by ydlx on 2017/5/13.
 */
$(function(){
    $("#btn_login").bind('click', function () {
        $("#tips").hide();
        var loginAccount = $("#loginAccount").val();
        var password = $("#password").val();
        if(loginAccount.length ==0 ){
            $("#tips").html("账号不能为空!");
            $("#tips").show();
            return;
        }
        if(password.length == 0){
            $("#tips").html("密码不能为空!");
            $("#tips").show();
            return;
        }
        $.ajax({
            type: 'POST',
            url:  $path_base + 'getKey',
            success: function(data){
                if (data.resultCode == '00000000') {
                    var postData = {};
                    postData.loginAccount = loginAccount;
                    postData.password = passwordEncrypt(password, data.data.pubExponent, data.data.pubModules);
                    $.ajax({
                        type: 'POST',
                        url: $path_base + 'login',
                        data: postData,
                        beforeSend: function () {
                            $("#btn_login").attr('disabled', 'disabled');
                        },
                        success: function (data) {
                            if(data.resultCode == '00000000'){
                                window.location.href = $path_base + "index";
                            }else{
                                $("#tips").html("用户名不存或者密码错误,请重新输入!");
                                $("#tips").show();
                                $("#btn_login").removeAttr('disabled');
                            }
                        },
                        error: function () {
                            $("#tips").html("系统错误!");
                            $("#tips").show();
                            $("#btn_login").removeAttr('disabled');
                        }});
                } else {
                    $("#tip").html("发生错误，请稍候再试!");
                    $("#tips").show();
                    $("#btn_login").removeAttr('disabled');
                }
            },
            error:function () {
                $("#tips").html("系统错误!");
                $("#tips").show();
                $("#btn_login").removeAttr('disabled');
            }
        });
    });
});

//表单密码加密(RSA)
function passwordEncrypt(password, exponent, modules) {
    RSAUtils.setMaxDigits(200);
    var key = new RSAUtils.getKeyPair(exponent, '', modules);
    var encrypedPwd = RSAUtils.encryptedString(key, password);
    return encrypedPwd;
}
