var InterValObj; //timer变量，控制时间
var count=59;
var curCount;
var xhr=null;
if(window.XMLHttpRequest){
    xhr=new XMLHttpRequest();
}else{
    xhr = new ActiveXObject('Microsoft.XMLHTTP');
}
function PhoneOver() {
    document.getElementById("Mobile").style.border="1px solid black";
}
function PhoneOut() {
    document.getElementById("Mobile").style.border="1px solid #e4e4e4";
}
function codeOver() {
    document.getElementById("code").style.border="1px solid black";
}
function codeOut() {
    document.getElementById("code").style.border="1px solid #e4e4e4";
}
function pwd1Over() {
    document.getElementById("password1").style.border="1px solid black";
}
function pwd1Out() {
    document.getElementById("password1").style.border="1px solid #e4e4e4";
}
function pwd2Over() {
    document.getElementById("password2").style.border="1px solid black";
}
function pwd2Out() {
    document.getElementById("password2").style.border="1px solid #e4e4e4";
}


function userPwdLogin() {
    document.getElementById("pwdLogin").style.color="#57cb8f";
    document.getElementById("phoneLogin").style.color="rgba(0,0,0,.5)";
    document.getElementById("userPwdLogin").style.display="block";
    document.getElementById("userPhoneLogin").style.display="none";

}
function phoneLogin() {
    document.getElementById("pwdLogin").style.color="rgba(0,0,0,.5)" ;
    document.getElementById("phoneLogin").style.color="#57cb8f";
    document.getElementById("userPwdLogin").style.display="none";
    document.getElementById("userPhoneLogin").style.display="block";
}


/*=======================================注册模块=========================================*/
/*注册获取验证码*/
function sendRegisterMessage() {
    var mobile=document.getElementById("Mobile").value;
    if(mobile==="" || mobile==null || !/^[1][3,4,5,7,8][0-9]{9}$/.test(mobile)){
        document.getElementById("Mobile").style.border="1px solid red";
        $.message({
            message: '请输入正确手机号！',
            time:'3000',
            type: 'warning',
            showClose:true,
            autoClose:true,
        });
    }else{
        var custPhone = document.getElementById("Mobile").value;
        var setCode_url = "/customer/setRegisterCode?custPhone=" + custPhone;
        xhr.open("GET", setCode_url, true);
        xhr.onreadystatechange = sendMessageProcess
        xhr.send();
    }
    function sendMessageProcess() {
        if(xhr.readyState==4 && xhr.status==200) {
            var result = JSON.parse(xhr.responseText);
            if(result.data.registerCodeMsg===0){
                $.message({
                    message: '手机号已经注册！',
                    time:'3000',
                    type: 'warning',
                    showClose:true,
                    autoClose:true,
                });
            }
            if(result.data.registerCodeMsg===1){
                $.message({
                    message: '验证码发送成功！',
                    time:'3000',
                    type: 'success',
                    showClose:true,
                    autoClose:true,
                });
                curCount=count;
                document.getElementById("PhoneButton").setAttribute("disabled","true");
                document.getElementById("PhoneButton").style.cursor="auto";
                document.getElementById("PhoneButton").value=curCount+"s重新发送";
                InterValObj=window.setInterval(SetRemainTime,1000);
            }
        }
    }
}

/*用户注册*/
function userRegister() {
    var custPhone = document.getElementById("Mobile").value;
    var code = document.getElementById("code").value;
    var pwd1 = document.getElementById("password1").value;
    var custPassword = document.getElementById("password2").value;
    if (custPhone == "" || custPhone == null) {
        $.message({
            message: '请输入手机号！',
            time: '3000',
            type: 'warning',
            showClose: true,
            autoClose: true,
        });
    } else if (pwd1 == "" || pwd1 == null || !/^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d][\w_-]{6,20}$/.test(pwd1)) {
        $.message({
            message: '密码由字母数字组成,请重新输入!',
            time: '3000',
            type: 'warning',
            showClose: true,
            autoClose: true,
        });
    } else if (custPassword != pwd1) {
        $.message({
            message: '两次密码不一致！',
            time: '3000',
            type: 'warning',
            showClose: true,
            autoClose: true,
        });
    } else  if (document.getElementById("regAgreementCheckbox").checked == false) {
        $.message({
            message: '请同意服务条款！',
            time: '3000',
            type: 'warning',
            showClose: true,
            autoClose: true,
        });
    } else {
        var register_url = "/customer/register?custPhone=" + custPhone + "&custPassword=" + custPassword + "&getCode=" + code;
        xhr.open("GET", register_url, true);
        xhr.onreadystatechange = registerPrcess;
        xhr.send();
    }
    function registerPrcess() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var result = JSON.parse(xhr.responseText);
            if (result.data.registerMsg === 5) {
                $.message({
                    message: '手机号已经注册！',
                    time: '3000',
                    type: 'warning',
                    showClose: true,
                    autoClose: true
                });
            }
            if (result.data.registerMsg === 4) {
                $.message({
                    message: '验证码失效，请重新获取。',
                    time: '3000',
                    type: 'info',
                    showClose: true,
                    autoClose: true
                });
            }
            if (result.data.registerMsg === 3) {
                $.message({
                    message: '验证码错误！',
                    time: '3000',
                    type: 'info',
                    showClose: true,
                    autoClose: true
                });
            }
            if (result.data.registerMsg === 1) {
                $.message({
                    message: '注册失败！',
                    time: '3000',
                    type: 'error',
                    showClose: true,
                    autoClose: true
                });
            }
            if (result.data.registerMsg === 2) {
                $.message({
                    message: '注册成功！',
                    time: '3000',
                    type: 'success',
                    showClose: true,
                    autoClose: true
                });
                setTimeout("registerJump()", 3000)
            }
        }
    }
}

/*注册成功跳转页面*/
function registerJump() {
    window.location.href="/login.html";
}


/*=======================================登录模块=========================================*/

window.onload=function () {
    var phone = $.cookie("phone"); //获取cookie中的用户名
    var pwd = $.cookie("password"); //获取cookie中的登陆密码
    if(pwd){
        var b = new Base64();
        document.getElementsByClassName("logAgreementCheckbox")[0].checked=true;
        document.getElementById("userPwd").value=b.decode(pwd);
    }
    if(phone){
        document.getElementById("userName").value=phone;
    }
};


/*手机或邮箱密码登录*/
function userLogin() {
    var userName = document.getElementById("userName").value;
    var userPwd = document.getElementById("userPwd").value;
    var loginIp=returnCitySN['cip'];
    if (userName == "" || userName == null) {
        $.message({
            message: '手机号或邮箱格式错误！',
            time: '3000',
            type: 'warning',
            showClose: true,
            autoClose: true,
        });
    }else {
        var login_url = "/customer/login?custPhoneOrEmail=" + userName + "&custPassword=" + userPwd + "&getLoginIp=" + loginIp;
        xhr.open("GET", login_url, true);
        xhr.onreadystatechange = loginProcess;
        xhr.send();
    }
    function loginProcess() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var result = JSON.parse(xhr.responseText);
            if (result.data.loginMsg === 1) {
                $.message({
                    message: '登录成功！',
                    time: '3000',
                    type: 'success',
                    showClose: true,
                    autoClose: true
                });
                if(document.getElementsByClassName("logAgreementCheckbox")[0].checked===true){
                    var b = new Base64();
                    $.cookie("phone",userName);
                    $.cookie("password",b.encode(userPwd))
                   }
                setTimeout("loginJump()", 3000);
            }
            if (result.data.loginMsg === 0) {
                $.message({
                    message: '用户名或密码错误！',
                    time: '3000',
                    type: 'error',
                    showClose: true,
                    autoClose: true
                });
            }
        }
    }
}




/*手机号快捷登录*/
//获取登录验证码
function sendLoginMessage() {
    var mobile = document.getElementById("Mobile").value;
    if (mobile === "" || mobile == null || !/^[1][3,4,5,7,8][0-9]{9}$/.test(mobile)) {
        document.getElementById("Mobile").style.border = "1px solid red";
        $.message({
            message: '请输入正确手机号！',
            time: '3000',
            type: 'warning',
            showClose: true,
            autoClose: true,
        });
    } else {
        var custPhone = document.getElementById("Mobile").value;
        var setCode_url = "/customer/setLoginCode?custPhone=" + custPhone;
        xhr.open("GET", setCode_url, true);
        xhr.onreadystatechange = setLoginCodeProcess;
        xhr.send();
    }
    function setLoginCodeProcess() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var result = JSON.parse(xhr.responseText);
            if (result.data.loginCodeMsg === 0) {
                $.message({
                    message: '手机号未注册！',
                    time: '3000',
                    type: 'warning',
                    autoClose: true,
                });
            }
            if (result.data.loginCodeMsg === 1) {
                $.message({
                    message: '验证码发送成功！',
                    time: '3000',
                    type: 'success',
                    autoClose: true,
                });
                curCount = count;
                document.getElementById("PhoneButton").setAttribute("disabled", "true");
                document.getElementById("PhoneButton").style.cursor = "auto";
                document.getElementById("PhoneButton").value = curCount + "s重新发送";
                InterValObj = window.setInterval(SetRemainTime, 1000);
            }
        }
    }
}
//用户验证码登录
function userCodeLogin(){
    var custPhone=document.getElementById("Mobile").value;
    if(custPhone==="" || custPhone==null){
        $.message({
            message: '请输入手机号！',
            time: '3000',
            type: 'warning',
            showClose: true,
            autoClose: true,
        });
    }else{
        //获取登录IP
        var loginIp=returnCitySN['cip'];
        var code=document.getElementById("code").value;
        var quickLogin_url="/customer/userCodeLogin?custPhone="+custPhone+"&getCode="+code+"&getLoginIp="+loginIp;
        xhr.open("GET",quickLogin_url,true);
        xhr.onreadystatechange=codeLoginProcess;
        xhr.send();
    }
    function codeLoginProcess() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var result = JSON.parse(xhr.responseText);
            if (result.data.codeLoginMsg === 0) {
                $.message({
                    message: '两次手机号不一致!',
                    time: '3000',
                    type: 'info',
                    autoClose: true
                });
            }
            if (result.data.codeLoginMsg === 1) {
                $.message({
                    message: '用户不存在！',
                    time: '3000',
                    type: 'info',
                    autoClose: true
                });
            }
            if (result.data.codeLoginMsg === 2) {
                $.message({
                    message: '登录成功！3秒后自动跳转',
                    time: '3000',
                    type: 'success',
                    autoClose: true
                });
                setTimeout("loginJump()", 3000);
            }
            if (result.data.codeLoginMsg === 3) {
                $.message({
                    message: '验证码错误！',
                    time: '3000',
                    type: 'error',
                    autoClose: true
                });
            }
            if (result.data.codeLoginMsg === 4) {
                $.message({
                    message: '验证码失效！',
                    time: '3000',
                    type: 'error',
                    autoClose: true
                });
            }
        }
    }
}

/*登陆成功跳转页面*/
function loginJump() {
    window.location.href="/index.html";
}



/*=======================================验证码计时控制=========================================*/
function SetRemainTime() {
    if(curCount==1){
        window.clearInterval(InterValObj);
        document.getElementById("PhoneButton").removeAttribute("disabled");
        document.getElementById("PhoneButton").value="发送验证码";
        document.getElementById("PhoneButton").style.cursor="pointer";
    }else {
        curCount--;
        document.getElementById("PhoneButton").value=curCount+"s重新发送";
    }
}
















