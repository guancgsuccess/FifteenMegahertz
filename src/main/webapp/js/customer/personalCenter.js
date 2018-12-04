let custId=null;
let xhr = null;
let isFollow=null;
let intro=null;
let isLike=null;
let storage=window.sessionStorage;
if (window.XMLHttpRequest) {
    xhr = new XMLHttpRequest();
} else {
    xhr = new ActiveXObject('Microsoft.XMLHTTP');
}

function operationOver(){
    document.getElementById("perslist").style.display="block";
}
function operationOut(){
    document.getElementById("perslist").style.display="none";
}
function dataSpan(){
    document.getElementById("dataSpan").style.color="black";
    document.getElementById("data").style.display="block";

    document.getElementById("bindingSpan").style.color="rgba(0,0,0,.5)";
    document.getElementById("binding").style.display="none";

    document.getElementById("passwordSpan").style.color="rgba(0,0,0,.5)";
    document.getElementById("password").style.display="none";
}
function bindingSpan(){
    document.getElementById("dataSpan").style.color="rgba(0,0,0,.5)";
    document.getElementById("data").style.display="none";

    document.getElementById("bindingSpan").style.color="black";
    document.getElementById("binding").style.display="block";

    document.getElementById("passwordSpan").style.color="rgba(0,0,0,.5)";
    document.getElementById("password").style.display="none";
}
function passwordSpan(){
    document.getElementById("dataSpan").style.color="rgba(0,0,0,.5)";
    document.getElementById("data").style.display="none";

    document.getElementById("bindingSpan").style.color="rgba(0,0,0,.5)";
    document.getElementById("binding").style.display="none";

    document.getElementById("passwordSpan").style.color="black";
    document.getElementById("password").style.display="block";
}
function emailInput() {
    if(document.getElementById("optionInputCustEmail").value!=="") {
        document.getElementsByClassName("optionDiv")[0].style.display = "block";
    }else {
        document.getElementsByClassName("optionDiv")[0].style.display = "none";
    }
}
function phoneInput(){
    if(document.getElementById("optionInputCustPhone").value!="") {
        document.getElementsByClassName("optionDiv")[1].style.display = "block";
    }else {
        document.getElementsByClassName("optionDiv")[1].style.display = "none";
    }
}



/*********************************************郭昌佶代码区***********************开始***************************/
/*查询积分充值*/
function queryPay(custId) {
    var  ajax=null;
    if(window.XMLHttpRequest){
        ajax=new XMLHttpRequest();
    }else{
        ajax = new ActiveXObject('Microsoft.XMLHTTP');
    }
    let fromData="custId="+custId;
    ajax.open("POST","/pay/callback2",false);
    ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
    ajax.onreadystatechange=function () {
        if(ajax.readyState===4&&ajax.status===200){
            if(ajax.responseText!==null){
                let jsText=JSON.parse(ajax.responseText);
                if(jsText.status===0){
                    $.message({
                        message: jsText.msg,
                        type: 'error'
                    });
                }else if(jsText.status===1) {
                    $.message({
                        message: jsText.msg,
                        type: 'success'
                    });
                }else if(jsText.status===2){
                    $.message({
                        message: jsText.msg,
                        type: 'error'
                    });
                }
            }
        }
    };
    ajax.send(fromData);
}

/*查询订单支付*/
function queryPay2(custId) {
    let ajax=null;
    if(window.XMLHttpRequest){
        ajax=new XMLHttpRequest();
    }else{
        ajax = new ActiveXObject('Microsoft.XMLHTTP');
    }
    let fromData="custId="+custId;
    ajax.open("POST","/pay/callback3",true);
    ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
    ajax.onreadystatechange=function () {
        if(ajax.readyState===4&&ajax.status===200){
            if(ajax.responseText!==null){
                let jsText=JSON.parse(ajax.responseText);
                if(jsText.status===0){
                    $.message({
                        message: jsText.msg,
                        type: 'error'
                    });
                }else if(jsText.status===1) {
                    $.message({
                        message: jsText.msg,
                        type: 'success'
                    });
                }else if(jsText.status===2){
                    $.message({
                        message: jsText.msg,
                        type: 'error'
                    });
                }
            }
        }
    };
    ajax.send(fromData);
}
/*********************************************郭昌佶代码区************************结束***************************/


/**
 * 个人中心资料获取
 */
window.onload=function(){
    custId=storage.custId;
    queryPay(custId);
    queryPay2(custId);
    $("#jumpA").attr("href","javascript:myWorks(document.getElementById('targetPage').value)");
    xhr.open("GET", "/customer/personal?custId="+custId, true);
    xhr.onreadystatechange = personalProcess;
    xhr.send();
    function personalProcess() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var result = JSON.parse(xhr.responseText);

            if(result.data.personalMsg===2){
                $("#myHome").attr("href","javascript:goPersonalCenter("+result.data.customer.custId+")");
                document.getElementById("myWorksSpan").innerText="我的作品";
                document.getElementById("likeSpan").innerText="我的收藏";
                document.getElementById("myIdolsSpan").innerText="我的关注";
                document.getElementById("myFollowersSpan").innerText="我的追随者";
                document.getElementById("avatarMin").style.backgroundImage = "url(" + result.data.customer.custProfile + ")";
                document.getElementById("avatarCenter").style.backgroundImage = "url(" + result.data.customer.custProfile + ")";
                document.getElementById("levelSpan").innerText = result.data.customer.rangeLevel;
                document.getElementById("custNick").innerText=result.data.customer.custNick;
                document.getElementById("integral-remainder").innerText=result.data.customer.custCredits;
                document.getElementById("progress-bar").style.width = result.data.customer.rangeExp % 100 + "%";
                document.getElementById("progress-bar").innerText = result.data.customer.rangeExp % 100 + "/100";
                document.getElementById("myWorks").innerText=result.data.works;
                let myWork=document.getElementById("myWorks").innerText;
                if(myWork==0){
                    document.getElementById("page").style.display="none";
                    document.getElementById("not-found").style.display="block";
                    document.getElementById("content").style.display = "none";
                }else{
                    myWorks(1);
                }
                document.getElementById("like").innerText=result.data.ollections;
                document.getElementById("myIdols").innerText=result.data.idols;
                document.getElementById("myFollowers").innerText=result.data.follows;
                document.getElementById("pick-avatar-container").style.backgroundImage="url(" + result.data.customer.custProfile + ")";
                document.getElementById("optionInputCustNick").setAttribute("placeholder",result.data.customer.custNick);
                if(result.data.customer.custIntro==null){

                    document.getElementById("optionTextareaCustIntro").setAttribute("placeholder","简介");
                }else{
                    document.getElementById("optionTextareaCustIntro").setAttribute("placeholder",result.data.customer.custIntro);
                }
                if(result.data.customer.custEmail==null){
                    document.getElementById("optionInputCustEmail").setAttribute("placeholder","邮箱");
                }else{
                    document.getElementById("optionInputCustEmail").setAttribute("placeholder",result.data.customer.custEmail);
                }
                document.getElementById("optionInputCustPhone").setAttribute("placeholder",result.data.customer.custPhone);
            }else if(result.data.personalMsg===1) {
                document.getElementsByClassName("opera")[0].style.display="block";
                document.getElementsByClassName("opera")[1].style.display="block";
                document.getElementsByClassName("ring")[0].style.display="none";
                document.getElementsByClassName("avatar")[0].style.display="none";
                document.getElementById("myPurchaseSpan").style.display="none";

                document.getElementById("myWorksSpan").innerText="TA的作品";
                document.getElementById("likeSpan").innerText="TA的收藏";
                document.getElementById("myIdolsSpan").innerText="TA的关注";
                document.getElementById("myFollowersSpan").innerText="TA的追随者";

                document.getElementById("avatarCenter").style.backgroundImage = "url(" + result.data.otherCustomer.custProfile + ")";
                document.getElementById("levelSpan").innerText = result.data.otherCustomer.rangeLevel;
                document.getElementById("custNick").innerText=result.data.otherCustomer.custNick;
                document.getElementById("user-popular").style.display="none";
                document.getElementById("progress-bar").style.width = result.data.otherCustomer.rangeExp % 100 + "%";
                document.getElementById("progress-bar").innerText = result.data.otherCustomer.rangeExp % 100 + "/100";

                document.getElementById("myWorks").innerText=result.data.otherWorks;
                let myWork=document.getElementById("myWorks").innerText;
                if(myWork==0){
                    document.getElementById("page").style.display="none";
                    document.getElementById("not-found").style.display="block";
                    document.getElementById("content").style.display = "none";
                }else{
                    myWorks(1);
                }
                document.getElementById("like").innerText=result.data.otherOllections;
                document.getElementById("myIdols").innerText=result.data.otherIdols;
                document.getElementById("myFollowers").innerText=result.data.otherFollows;

            }else {
                $("#myHome").attr("href","javascript:goPersonalCenter("+result.data.customer.custId+")");
                document.getElementById("myPurchaseSpan").style.display="none";

                document.getElementById("myWorksSpan").innerText="TA的作品";
                document.getElementById("likeSpan").innerText="TA的收藏";
                document.getElementById("myIdolsSpan").innerText="TA的关注";
                document.getElementById("myFollowersSpan").innerText="TA的追随者";

                document.getElementById("avatarMin").style.backgroundImage = "url(" + result.data.customer.custProfile + ")";
                document.getElementById("avatarCenter").style.backgroundImage = "url(" + result.data.otherCustomer.custProfile + ")";
                document.getElementById("levelSpan").innerText = result.data.otherCustomer.rangeLevel;
                document.getElementById("custNick").innerText=result.data.otherCustomer.custNick;
                document.getElementById("user-popular").style.display="none";
                document.getElementById("progress-bar").style.width = result.data.otherCustomer.rangeExp % 100 + "%";
                document.getElementById("progress-bar").innerText = result.data.otherCustomer.rangeExp % 100 + "/100";

                document.getElementById("myWorks").innerText=result.data.otherWorks;
                let myWork=document.getElementById("myWorks").innerText;
                if(myWork==0){
                    document.getElementById("page").style.display="none";
                    document.getElementById("not-found").style.display="block";
                    document.getElementById("content").style.display = "none";
                }else{
                    myWorks(1);
                }
                document.getElementById("like").innerText=result.data.otherOllections;
                document.getElementById("myIdols").innerText=result.data.otherIdols;
                document.getElementById("myFollowers").innerText=result.data.otherFollows;
                document.getElementById("pick-avatar-container").style.backgroundImage="url(" + result.data.customer.custProfile + ")";
                document.getElementById("optionInputCustNick").setAttribute("placeholder",result.data.customer.custNick);
                if(result.data.customer.custIntro==null){
                    document.getElementById("optionTextareaCustIntro").setAttribute("placeholder","简介");
                }else{
                    document.getElementById("optionTextareaCustIntro").setAttribute("placeholder",result.data.customer.custIntro);
                }
                if(result.data.customer.custEmail==null){
                    document.getElementById("optionInputCustEmail").setAttribute("placeholder","邮箱");
                }else{
                    document.getElementById("optionInputCustEmail").setAttribute("placeholder",result.data.customer.custEmail);
                }
                document.getElementById("optionInputCustPhone").setAttribute("placeholder",result.data.customer.custPhone);
        }
        }
    }
}

/**
 * 头像修改
 */
function modifyHeadPortrait(portrait_url) {
    custId=storage.custId;
    if(portrait_url!=null) {
        var modifyHeadPortrait_url = "/customer/personal/modifyHeadPortrait?portraitUrl=" + portrait_url;
        xhr.open("GET", modifyHeadPortrait_url, true);
        xhr.onreadystatechange = modifyHeadPortraitProcess;
        xhr.send();
        function modifyHeadPortraitProcess() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var result = JSON.parse(xhr.responseText);
                if (result.data.modifyHeadPortraitMsg === 1) {
                    $.message({
                        message: '头像修改成功！',
                        time: '3000',
                        type: 'success',
                        autoClose: true
                    });
                    document.getElementById("pick-avatar-container").style.backgroundImage = "url(" + portrait_url + ")";
                    document.getElementById("avatarMin").style.backgroundImage = "url(" + portrait_url + ")";
                    if(custId == result.data.sessionCustId) {
                        document.getElementById("avatarCenter").style.backgroundImage = "url(" + portrait_url + ")";
                    }
                }else {
                    $.message({
                        message: '头像修改失败！',
                        time: '3000',
                        type: 'error',
                        autoClose: true
                    });
                }
            }
        }
    }
}

/**
 * 个人中心设置
 */
function modifyData() {
    custId=storage.custId;
    var dataDisplay = document.getElementById("data").style.display;
    var bindingDisplay = document.getElementById("binding").style.display;
    var passwordDisplay = document.getElementById("password").style.display;

    //修改用户名和个性签名
    if (dataDisplay === "block") {
        var custNick = document.getElementById("optionInputCustNick").value;
        var custIntro = document.getElementById("optionTextareaCustIntro").value;
        if (custNick == null || custNick == "") {
            $.message({
                message: '用户名不能为空！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });
        } else if (custNick.length > 20) {
            $.message({
                message: '用户名不能大于20个字符！',
                time: '3000',
                type: 'warning',
                autoClose: true
            });
        } else if (custIntro.length > 128) {
            $.message({
                message: '个性签名过长！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });
        } else {
            var modifyNickAndIntro_url = "/customer/personal/modifyNickAndIntro?custNick=" + custNick + "&custIntro=" + custIntro;
            xhr.open("GET", modifyNickAndIntro_url, true);
            xhr.onreadystatechange = modifyNickAndIntroProcess;
            xhr.send();
        }

        function modifyNickAndIntroProcess() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var result = JSON.parse(xhr.responseText);
                if (result.data.modifyNickAndIntroMsg === 1) {
                    $.message({
                        message: '修改成功！',
                        time: '3000',
                        type: 'success',
                        autoClose: true
                    });
                    if(custId == result.data.sessionCustId){
                    document.getElementById("custNick").innerText = custNick;
                    }
                  }
                if(result.data.modifyNickAndIntroMsg === 0){
                    $.message({
                        message: '修改失败！',
                        time: '3000',
                        type: 'error',
                        autoClose: true
                    });
                }
            }
        }
    }

    //修改手机和邮箱
    if (bindingDisplay === "block") {

    }

    //修改密码
    if (passwordDisplay === "block") {
        var oldPassword = document.getElementById("oldPassword").value;
        var newPassword = document.getElementById("newPassword").value;
        var repeatNewPassword = document.getElementById("repeatNewPassword").value;
        if (oldPassword == null || oldPassword === "") {
            $.message({
                message: '原密码不能为空！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });

        } else if (!/^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d][\w_-]{6,20}$/.test(oldPassword)) {
            $.message({
                message: '原密码不符合规范！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });

        } else if (newPassword == null || newPassword === "") {
            $.message({
                message: '新密码不能为空！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });

        } else if (!/^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d][\w_-]{6,20}$/.test(newPassword)) {
            $.message({
                message: '新密码不符合规范！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });

        } else if (repeatNewPassword == null || repeatNewPassword === "") {
            $.message({
                message: '重复密码不能为空！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });
        } else if (!/^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d][\w_-]{6,20}$/.test(repeatNewPassword)) {
            $.message({
                message: '重复密码不符合规范！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });

        } else if (newPassword !== repeatNewPassword) {
            $.message({
                message: '重复密码和新密码不一致！',
                time: '3000',
                type: 'warning',
                showClose: false,
                autoClose: true
            });
        } else {
            var modifyPassword_url = "/customer/personal/modifyPassword?oldPwd=" + oldPassword + "&repeatNewPassword=" + repeatNewPassword;
            xhr.open("GET", modifyPassword_url, true);
            xhr.onreadystatechange = modifyPasswordProcess;
            xhr.send();

            function modifyPasswordProcess() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var result = JSON.parse(xhr.responseText);
                    if (result.data.modifyPasswordMsg === 0) {
                        $.message({
                            message: '原密码错误！',
                            time: '3000',
                            type: 'warning',
                            autoClose: true
                        });
                    }
                    if (result.data.modifyPasswordMsg === 1) {
                        $.message({
                            message: '密码修改成功！',
                            time: '3000',
                            type: 'success',
                            autoClose: true
                        });
                    }
                    if (result.data.modifyPasswordMsg === 2) {
                        $.message({
                            message: '密码修改失败！',
                            time: '3000',
                            type: 'error',
                            showClose: false,
                            autoClose: true
                        });
                    }
                }
            }
        }
    }
}

/**
 * 用户退出
 */
function signOut() {
    let signOut_url="/customer/signOut"
    xhr.open("GET",signOut_url,true);
    xhr.onreadystatechange=signOutProcess;
    xhr.send();
    function signOutProcess() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let result = JSON.parse(xhr.responseText);
            if(result.data.signOutMsg==1){
                window.location.href="/index.html";
            }
        }
    }
}

/**
 * 作品
 */
function myWorks(count) {
    custId=storage.custId;
    if(count===null){
        count=1;
    }
    device.innerHTML = "";
    document.getElementsByClassName("pagination")[0].innerHTML="";
    document.getElementsByClassName("span")[0].style.color = "black";
    document.getElementsByClassName("span")[1].style.color = "rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[2].style.color = "rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[3].style.color = "rgba(0,0,0,.5)";
    document.getElementById("myPurchaseSpan").style.color = "rgba(0,0,0,.5)";
    document.getElementById("photographers").style.display = "none";
    document.getElementById("order-container").style.display="none";
    document.getElementById("not-found").style.display = "none";
    let myWork=document.getElementById("myWorks").innerText;
    if(myWork==0){
       document.getElementsByClassName("loading")[0].style.display="block";
      setTimeout("document.getElementById(\"page\").style.display = \"none\"; \n" +
          "       document.getElementById(\"not-found\").style.display = \"block\"; \n" +
          "        document.getElementById(\"content\").style.display = \"none\";\n" +
          "        document.getElementsByClassName(\"loading\")[0].style.display= \"none\";",3000)
    }else {
        document.getElementById("not-found").style.display = "none";
        document.getElementById("content").style.display = "block";
        var myWorks_url = "/image/personal/myWorks?currentPage=" + count + "&custId=" + custId;

        xhr.open("GET", myWorks_url, true);
        xhr.onreadystatechange = documentReadyState;
        xhr.send();
        document.getElementsByClassName("loading")[0].style.display="block";
        function documentReadyState() {
            if (document.readyState === "complete") {
                document.getElementsByClassName("loading")[0].style.display= "none";
                document.getElementById("page").style.display = "block";
                myWorksProcess();
            }
        }
        function myWorksProcess() {
            let pageButton = document.getElementsByClassName("pagination")[0];
                if (xhr.readyState === 4 && xhr.status === 200) {
                    let result = JSON.parse(xhr.responseText);
                    if (result.data.pagemodel.currentPageCode === 1) {
                        var preLi = "<li class='disabled'>" +
                            "<a href='javascript:void(0);' aria-label='Previous' >" +
                            "<span aria-hidden='true' class='disabled'>上一页</span>" +
                            "</a>" +
                            "</li>";
                    } else {
                        var preLi = "<li>" +
                            "<a onclick='myWorks(" + ((result.data.pagemodel.currentPageCode) - 1) + ")' href='#' aria-label='Previous' >" +
                            "<span aria-hidden='true'>上一页</span>" +
                            "</a>" +
                            "</li>";
                    }
                    pageButton.innerHTML = preLi +
                        "<li class='active'>" +
                        "<span>当前第" + result.data.pagemodel.currentPageCode + "页,共<span id='totalPage'>" + result.data.pagemodel.totalPages + "</span>页</span>" +
                        "</li>";

                    if (result.data.pagemodel.currentPageCode === result.data.pagemodel.totalPages || result.data.pagemodel.totalPages === 0) {
                        var nextLi = "<li class='disabled'>" +
                            "<a href='javascript:void(0);' aria-label='Next'>" +
                            "<span aria-hidden='true' class='disabled'>下一页</span>" +
                            "</a>" +
                            "</li>";
                    } else {
                        var nextLi = "<li>" +
                            "<a onclick='myWorks(" + ((result.data.pagemodel.currentPageCode) + 1) + ")'  href='#' aria-label='Next'>" +
                            "<span aria-hidden='true'>下一页</span>" +
                            "</a>" +
                            "</li>";
                    }
                    pageButton.innerHTML += nextLi;

                    if (result.data.sessionCustId == custId) {
                        for (let i = 0; i <= result.data.pagemodel.modelList.length; i++) {
                            device.innerHTML +=
                                "<div class='item' onmouseover='deleteButtonOver(" + i + ")' onmouseout='deleteButtonOut(" + i + ")'>" +
                                "<a href='javascript:goDetail(" + result.data.pagemodel.modelList[i].imageId + ")' onclick=''><img src='" + result.data.pagemodel.modelList[i].imageCompressPath + "'></a>" +
                                "<button  id='deleteButton" + i + "' style='display: none'  onclick='deleteImage(" + result.data.pagemodel.modelList[i].imageId + ")'>删除</button>" +
                                "</div>";
                            $("#device").gridalicious({
                                gutter: 20,
                                width: 300,
                                animate: true,
                            })
                        }
                    } else {
                        for (let i = 0; i <= result.data.pagemodel.modelList.length; i++) {
                            if(result.data.pagemodel.modelList[i].isLike===1){
                                isLike="已收藏";
                            }else {
                                isLike="收藏"
                            }
                            device.innerHTML +=
                                "<div class='item' onmouseover='deleteButtonOver(" + i + ")' onmouseout='deleteButtonOut(" + i + ")'>" +
                                "<a href='javascript:goDetail(" + result.data.pagemodel.modelList[i].imageId + ")' onclick=''><img src='" + result.data.pagemodel.modelList[i].imageCompressPath + "'></a>" +
                                "<button  id='deleteButton" + i + "'  style='display: none' onclick='otherUserLike(" + result.data.pagemodel.modelList[i].imageId + ",this)'>" + isLike + "</button>" +
                                "</div>";
                            $("#device").gridalicious({
                                gutter: 20,
                                width: 300,
                                animate: true,
                            })
                        }
                    }
                }
             }
           }
        }

/**
 * 收藏（喜欢）
 */
function myLike(count) {
    custId=storage.custId;
    device.innerHTML = "";
    document.getElementsByClassName("pagination")[0].innerHTML="";
    document.getElementsByClassName("span")[0].style.color = "rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[1].style.color = "black";
    document.getElementsByClassName("span")[2].style.color = "rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[3].style.color = "rgba(0,0,0,.5)";
    document.getElementById("myPurchaseSpan").style.color = "rgba(0,0,0,.5)";
    document.getElementById("photographers").style.display = "none";
    document.getElementById("order-container").style.display="none";
    document.getElementById("not-found").style.display = "none";
    let like=document.getElementById("like").innerText;
    if (count === null) {
        count = 1;
    }
    if (like == 0) {
        document.getElementsByClassName("loading")[0].style.display="block";
        setTimeout("document.getElementById(\"page\").style.display = \"none\";\n" +
            "        document.getElementById(\"not-found\").style.display = \"block\";\n" +
            "        document.getElementById(\"content\").style.display = \"none\";" +
            "        document.getElementsByClassName(\"loading\")[0].style.display=\"none\";",3000)
    } else {
        document.getElementById("not-found").style.display = "none";
        document.getElementById("content").style.display = "block";
        let myLikes_url = "/image/personal/myLikes?currentPage=" + count+"&custId="+custId;
        xhr.open("GET", myLikes_url, true);
        xhr.onreadystatechange = documentReadyState;
        xhr.send();
        document.getElementsByClassName("loading")[0].style.display="block";
        function documentReadyState() {
            if (document.readyState === "complete") {
                document.getElementsByClassName("loading")[0].style.display= "none";
                document.getElementById("page").style.display = "block";
                myLikesProcess();
            }
        }
        function myLikesProcess() {
            let pageButton = document.getElementsByClassName("pagination")[0];
            if (xhr.readyState === 4 && xhr.status === 200) {
                let result = JSON.parse(xhr.responseText);
                if (result.data.pagemodel.currentPageCode === 1) {
                    var preLi = "<li class='disabled'>" +
                        "<a href='javascript:void(0);' aria-label='Previous' >" +
                        "<span aria-hidden='true' class='disabled'>上一页</span>" +
                        "</a>" +
                        "</li>";
                } else {
                    var preLi = "<li>" +
                        "<a onclick='myLike("+ ((result.data.pagemodel.currentPageCode) - 1)+")' href='#' aria-label='Previous' >" +
                        "<span aria-hidden='true'>上一页</span>" +
                        "</a>" +
                        "</li>";
                }
                pageButton.innerHTML = preLi +
                    "<li class='active'>" +
                    "<span>当前第" + result.data.pagemodel.currentPageCode + "页,共<span id='totalPage'>" + result.data.pagemodel.totalPages + "</span>页</span>" +
                    "</li>";

                if (result.data.pagemodel.currentPageCode === result.data.pagemodel.totalPages || result.data.pagemodel.totalPages === 0) {
                    var nextLi = "<li class='disabled'>" +
                        "<a href='javascript:void(0);' aria-label='Next'>" +
                        "<span aria-hidden='true' class='disabled'>下一页</span>" +
                        "</a>" +
                        "</li>";
                } else {
                    var nextLi = "<li>" +
                        "<a onclick='myLike("+ ((result.data.pagemodel.currentPageCode) + 1)+")' href='#' aria-label='Next'>" +
                        "<span aria-hidden='true'>下一页</span>" +
                        "</a>" +
                        "</li>";
                }
                pageButton.innerHTML += nextLi;

                if(result.data.sessionCustId==custId){
                for (let i = 0; i <= result.data.pagemodel.modelList.length; i++) {
                    device.innerHTML +=
                        "<div class='item' onmouseover='deleteButtonOver("+i+")' onmouseout='deleteButtonOut("+i+")'>" +
                        "<a href='javascript:goDetail("+result.data.pagemodel.modelList[i].imageId+")'><img src='" + result.data.pagemodel.modelList[i].imageCompressPath +"'></a>" +
                        "<button id='deleteButton"+i+"' style='display: none' onclick='removeMylikes("+result.data.pagemodel.modelList[i].imageId+")'>取消收藏</button>"+
                        "</div>";
                    $("#device").gridalicious({
                        gutter: 20,
                        width: 300,
                        animate: true,
                    })
                }
                }else{
                    for (let i = 0; i <= result.data.pagemodel.modelList.length; i++) {
                        if(result.data.pagemodel.modelList[i].isLike===1){
                            isLike="已收藏";
                        }else {
                            isLike="收藏"
                        }

                        device.innerHTML +=
                            "<div class='item' onmouseover='deleteButtonOver("+i+")' onmouseout='deleteButtonOut("+i+")'>" +
                            "<a href='javascript:goDetail("+result.data.pagemodel.modelList[i].imageId+")'><img src='" + result.data.pagemodel.modelList[i].imageCompressPath +"'></a>" +
                            "<button id='deleteButton"+i+"' style='display: none' onclick='otherUserLike("+result.data.pagemodel.modelList[i].imageId+",this)' >"+isLike+"</button>"+
                            "</div>";
                        $("#device").gridalicious({
                            gutter: 20,
                            width: 300,
                            animate: true,
                        })
                    }
                }
            }
        }
    }
}

/**
 * 关注
 */
function myIdols(count) {
    custId=storage.custId;
    photographers.innerText = "";
    document.getElementsByClassName("pagination")[0].innerHTML="";
    document.getElementsByClassName("span")[0].style.color = "rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[1].style.color = "rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[2].style.color = "black";
    document.getElementsByClassName("span")[3].style.color = "rgba(0,0,0,.5)";
    document.getElementById("myPurchaseSpan").style.color = "rgba(0,0,0,.5)";
    document.getElementById("order-container").style.display="none";
    document.getElementById("not-found").style.display = "none";
    let myIdol = document.getElementById("myIdols").innerText;
    if (myIdol == 0) {
        document.getElementsByClassName("loading")[0].style.display="block";
        setTimeout(" document.getElementById(\"page\").style.display = \"none\";\n" +
            "        document.getElementById(\"not-found\").style.display = \"block\";\n" +
            "        document.getElementById(\"content\").style.display = \"none\";\n" +
            "        document.getElementById(\"photographers\").style.display = \"none\";" +
            "        document.getElementsByClassName(\"loading\")[0].style.display=\"none\";",3000)

    } else {
        document.getElementById("not-found").style.display = "none";
        document.getElementById("content").style.display = "none";
        document.getElementById("photographers").style.display = "block";
        var myIdol_url = "/image/personal/myIdols?currentPage=" + count+"&custId="+custId;
        xhr.open("GET", myIdol_url, true)
        xhr.onreadystatechange = documentReadyState;
        xhr.send();
        document.getElementsByClassName("loading")[0].style.display="block";
        function documentReadyState() {
            if (document.readyState === "complete") {
                document.getElementsByClassName("loading")[0].style.display= "none";
                document.getElementById("page").style.display = "block";
                myIdolProcess();
            }
        }
        function myIdolProcess() {
            var pageButton = document.getElementsByClassName("pagination")[0];
            var photographers = document.getElementById("photographers");
            if (xhr.readyState === 4 && xhr.status === 200) {
                var result = JSON.parse(xhr.responseText);

                if (result.data.pagemodel.currentPageCode === 1) {
                    var preLi = "<li class='disabled'>" +
                        "<a href='javascript:void(0);' aria-label='Previous' >" +
                        "<span aria-hidden='true' class='disabled'>上一页</span>" +
                        "</a>" +
                        "</li>";
                } else {
                    var preLi = "<li>" +
                        "<a href='javascript:myIdols(" + ((result.data.pagemodel.currentPageCode) - 1) + ");' aria-label='Previous' >" +
                        "<span aria-hidden='true'>上一页</span>" +
                        "</a>" +
                        "</li>";
                }
                pageButton.innerHTML = preLi +
                    "<li class='active'>" +
                    "<span>当前第" + result.data.pagemodel.currentPageCode + "页,共<span id='totalPage'>" + result.data.pagemodel.totalPages + "</span>页</span>" +
                    "</li>";

                if (result.data.pagemodel.currentPageCode === result.data.pagemodel.totalPages || result.data.pagemodel.totalPages === 0) {
                    var nextLi = "<li class='disabled'>" +
                        "<a href='javascript:void(0);' aria-label='Next'>" +
                        "<span aria-hidden='true' class='disabled'>下一页</span>" +
                        "</a>" +
                        "</li>";
                } else {
                    var nextLi = "<li>" +
                        "<a href='javascript:myIdols(" + ((result.data.pagemodel.currentPageCode) + 1) + ");' aria-label='Next'>" +
                        "<span aria-hidden='true'>下一页</span>" +
                        "</a>" +
                        "</li>";
                }
                pageButton.innerHTML += nextLi;

                if(result.data.sessionCustId==custId) {
                    for (let i = 0; i < result.data.pagemodel.modelList.length; i++) {
                        if(result.data.pagemodel.modelList[i].custIntro==null || result.data.pagemodel.modelList[i].custIntro===""){
                            intro="想要个签，不存在的！";
                        }else{
                            intro=result.data.pagemodel.modelList[i].custIntro;
                        }

                        photographers.innerHTML +=
                            " <div  class='photographer-item'>" +
                            "                <div  class='user'>" +
                            "                    <a  href='javascript:void(0)' onclick='goPersonalCenter(" + result.data.pagemodel.modelList[i].custId + ")' style='height: 148px;'>" +
                            "                        <div  class='avatar' style='background: url(" + result.data.pagemodel.modelList[i].custProfile + ")'></div>" +
                            "                    </a>" +
                            "                    <div  class='user-info-item'>" +
                            "                        <div class='name'>" + result.data.pagemodel.modelList[i].custNick + "</div>" +
                            "                        <div  class='follow followed' onclick='cancelIdolUser("+result.data.pagemodel.modelList[i].custId+")'>已关注</div>" +
                            "                        <div  class='instruction'>" + intro + "</div>" +
                            "                    </div>" +
                            "                </div>" +
                            "                <div class='images' id='images'>"

                        let images = document.getElementsByClassName("images");
                        if (result.data.pagemodel.modelList[i].images.length === 0) {
                            images[i].innerHTML += "<div  class='no-images'>" +
                                "        这个人很懒，还没发布过作品~~~" +
                                "      </div>"
                        }
                        for (let j = 0; j < result.data.pagemodel.modelList[i].images.length; j++) {
                            images[i].innerHTML +=
                                "                    <a  href='javascript:goDetail(" + result.data.pagemodel.modelList[i].images[j].imageId + ")' target='_blank' >" +
                                "                        <div  width='242px' height='148px'  style='background: url(" + result.data.pagemodel.modelList[i].images[j].comprePath + ")'>" +
                                "                        </div>" +
                                "                    </a>" +
                                "                </div>" +
                                "            </div>"
                        }
                    }
                }else{
                    for (let i = 0; i < result.data.pagemodel.modelList.length; i++) {
                        if(result.data.pagemodel.modelList[i].isFollow===1){
                            isFollow="已关注";
                        }else {
                            isFollow="关注";
                        }
                        if(result.data.pagemodel.modelList[i].custIntro==null || result.data.pagemodel.modelList[i].custIntro===""){
                            intro="想要个签，不存在的！";
                        }else{
                            intro=result.data.pagemodel.modelList[i].custIntro;
                        }

                        photographers.innerHTML +=
                            " <div  class='photographer-item'>" +
                            "                <div  class='user'>" +
                            "                    <a  href='javascript:void(0)' onclick='goPersonalCenter(" + result.data.pagemodel.modelList[i].custId + ")' style='height: 148px;'>" +
                            "                        <div  class='avatar' style='background: url(" + result.data.pagemodel.modelList[i].custProfile + ")'></div>" +
                            "                    </a>" +
                            "                    <div  class='user-info-item'>" +
                            "                        <div class='name'>" + result.data.pagemodel.modelList[i].custNick + "</div>" +
                            "                        <div  class='follow followed' onclick='cancelIdolOther("+ result.data.pagemodel.modelList[i].custId +",this)'>" +isFollow+ "</div>" +
                            "                        <div  class='instruction'>" + intro + "</div>" +
                            "                    </div>" +
                            "                </div>" +
                            "                <div class='images' id='images'>"

                        let images = document.getElementsByClassName("images");
                        if (result.data.pagemodel.modelList[i].images.length === 0) {
                            images[i].innerHTML += "<div  class='no-images'>" +
                                "        这个人很懒，还没发布过作品~~~" +
                                "      </div>"
                        }
                        for (let j = 0; j < result.data.pagemodel.modelList[i].images.length; j++) {
                            images[i].innerHTML +=
                                "                    <a  href='javascript:goDetail(" + result.data.pagemodel.modelList[i].images[j].imageId + ")' target='_blank' >" +
                                "                        <div  width='242px' height='148px'  style='background: url(" + result.data.pagemodel.modelList[i].images[j].comprePath + ")'>" +
                                "                        </div>" +
                                "                    </a>" +
                                "                </div>" +
                                "            </div>"
                        }
                    }
                }
            }
        }
    }
}

/**
 * 追随者
 */
function myFollowers(count) {
    custId=storage.custId;
    photographers.innerText="";
    document.getElementsByClassName("pagination")[0].innerHTML="";
    document.getElementsByClassName("span")[0].style.color="rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[1].style.color="rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[2].style.color="rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[3].style.color="black";
    document.getElementById("myPurchaseSpan").style.color = "rgba(0,0,0,.5)";
    document.getElementById("order-container").style.display="none";
    document.getElementById("not-found").style.display = "none";
    let myFollower= document.getElementById("myFollowers").innerText;
    if (myFollower == 0) {
        document.getElementsByClassName("loading")[0].style.display="block";
        setTimeout(" document.getElementById(\"page\").style.display = \"none\";\n" +
            "        document.getElementById(\"not-found\").style.display = \"block\";\n" +
            "        document.getElementById(\"content\").style.display = \"none\";\n" +
            "        document.getElementById(\"photographers\").style.display = \"none\";" +
            "        document.getElementsByClassName(\"loading\")[0].style.display=\"none\";",3000)
    } else {
        document.getElementById("not-found").style.display = "none";
        document.getElementById("content").style.display = "none";
        document.getElementById("photographers").style.display = "block";
        var myFollowers_url = "/image/personal/myFollowers?currentPage=" + count+"&custId="+custId;
        xhr.open("GET", myFollowers_url, true);
        xhr.onreadystatechange = documentReadyState;
        xhr.send();
        document.getElementsByClassName("loading")[0].style.display="block";
        function documentReadyState() {
            if (document.readyState === "complete") {
                document.getElementsByClassName("loading")[0].style.display= "none";
                document.getElementById("page").style.display = "block";
                myFollowersProcess();
            }
        }
        function myFollowersProcess() {
            var pageButton = document.getElementsByClassName("pagination")[0];
            var photographers = document.getElementById("photographers");
            if (xhr.readyState === 4 && xhr.status === 200) {
                var result = JSON.parse(xhr.responseText);
                if (result.data.pagemodel.currentPageCode === 1) {
                    var preLi = "<li class='disabled'>" +
                        "<a href='javascript:void(0);' aria-label='Previous' >" +
                        "<span aria-hidden='true' class='disabled'>上一页</span>" +
                        "</a>" +
                        "</li>";
                } else {
                    var preLi = "<li>" +
                        "<a href='javascript:myFollowers("+((result.data.pagemodel.currentPageCode)-1)+");' aria-label='Previous' >" +
                        "<span aria-hidden='true'>上一页</span>" +
                        "</a>" +
                        "</li>";
                }
                pageButton.innerHTML = preLi +
                    "<li class='active'>" +
                    "<span>当前第" + result.data.pagemodel.currentPageCode + "页,共<span id='totalPage'>" + result.data.pagemodel.totalPages + "</span>页</span>" +
                    "</li>";

                if (result.data.pagemodel.currentPageCode === result.data.pagemodel.totalPages || result.data.pagemodel.totalPages === 0) {
                    var nextLi = "<li class='disabled'>" +
                        "<a href='javascript:void(0);' aria-label='Next'>" +
                        "<span aria-hidden='true' class='disabled'>下一页</span>" +
                        "</a>" +
                        "</li>";
                } else {
                    var nextLi = "<li>" +
                        "<a href='javascript:myFollowers("+((result.data.pagemodel.currentPageCode)+1)+");' aria-label='Next'>" +
                        "<span aria-hidden='true'>下一页</span>" +
                        "</a>" +
                        "</li>";
                }
                pageButton.innerHTML += nextLi;

                    for (let i = 0; i < result.data.pagemodel.modelList.length; i++) {
                        if(result.data.pagemodel.modelList[i].isFollow===1){
                            isFollow="已关注";
                        }else {
                            isFollow="关注";
                        }
                        if(result.data.pagemodel.modelList[i].custIntro==null || result.data.pagemodel.modelList[i].custIntro===""){
                            intro="想要个签，不存在的！";
                        }else{
                            intro=result.data.pagemodel.modelList[i].custIntro;
                        }
                        photographers.innerHTML +=
                            " <div  class='photographer-item'>" +
                            "                <div  class='user'>" +
                            "                    <a  href='javascript:void(0)' onclick='goPersonalCenter(" + result.data.pagemodel.modelList[i].custId + ")' style='height: 148px;'>" +
                            "                        <div  class='avatar' style='background: url(" + result.data.pagemodel.modelList[i].custProfile + ")'></div>" +
                            "                    </a>" +
                            "                    <div  class='user-info-item'>" +
                            "                        <div class='name'>" + result.data.pagemodel.modelList[i].custNick + "</div>" +
                            "                        <div  class='follow followed' onclick='cancelIdolOther("+ result.data.pagemodel.modelList[i].custId +",this)'>" +isFollow+ "</div>" +
                            "                        <div  class='instruction'>" + intro + "</div>" +
                            "                    </div>" +
                            "                </div>" +
                            "                <div class='images' id='images'>"

                        let images = document.getElementsByClassName("images");
                        if (result.data.pagemodel.modelList[i].images.length === 0) {
                            images[i].innerHTML += "<div  class='no-images'>" +
                                "        这个人很懒，还没发布过作品~~~" +
                                "      </div>"
                        }
                        for (let j = 0; j < result.data.pagemodel.modelList[i].images.length; j++) {
                            images[i].innerHTML +=
                                "                    <a  href='javascript:goDetail(" + result.data.pagemodel.modelList[i].images[j].imageId + ")' target='_blank' >" +
                                "                        <div  width='242px' height='148px'  style='background: url(" + result.data.pagemodel.modelList[i].images[j].comprePath + ")'>" +
                                "                        </div>" +
                                "                    </a>" +
                                "                </div>" +
                                "            </div>"
                        }
                    }
                }
            }
        }
}


/**
 * 购买记录*/
function myPurchase() {
    document.getElementsByClassName("pagination")[0].innerHTML="";
    document.getElementsByClassName("span")[0].style.color="rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[1].style.color="rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[2].style.color="rgba(0,0,0,.5)";
    document.getElementsByClassName("span")[3].style.color="rgba(0,0,0,.5)";
    document.getElementById("myPurchaseSpan").style.color = "black";
    document.getElementById("not-found").style.display="none";
    document.getElementById("content").style.display="none";
    document.getElementById("photographers").style.display="none";
    document.getElementById("page").style.display="none";
    let ajax=new XMLHttpRequest();
    ajax.open("GET","/customer/order/get/list",true);
    ajax.onreadystatechange=documentReadyState;
    ajax.send(null);
    document.getElementsByClassName("loading")[0].style.display="block";
    document.getElementById("order-container").style.display="none";
    function documentReadyState() {
        if (document.readyState === "complete") {
            document.getElementsByClassName("loading")[0].style.display= "none";
            document.getElementById("order-container").style.display="block";
            myPurchaseProcess();
        }
    }
    function myPurchaseProcess() {
    if(ajax.readyState===4&&ajax.status===200){
        let imageorder=document.getElementsByClassName("image-order")[0];
        imageorder.innerHTML="<tr>\n" +
            "                            <td>订单编号</td>\n" +
            "                            <td>作品名称</td>\n" +
            "                            <td>下单时间</td>\n" +
            "                            <td>订单价格</td>\n" +
            "                            <td>下载链接</td>\n" +
            "                        </tr>";
        let jsText=JSON.parse(ajax.responseText);
        for(let i in jsText.data.orderList){
            let date=new Date(jsText.data.orderList[i].orderCreateTime);
            let dateTime=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
            imageorder.innerHTML+="<tr>\n" +
                "                            <td>"+jsText.data.orderList[i].orderNumber+"</td>\n" +
                "                            <td><a href='javascript:goDetail("+jsText.data.orderList[i].imageId+")'>"+jsText.data.orderList[i].imageName+"</a></td>\n" +
                "                            <td>"+dateTime+"</td>\n" +
                "                            <td>"+jsText.data.orderList[i].orderPrice+"&nbsp;积分</td>\n" +
                "                            <td><a href='"+jsText.data.orderList[i].imageLink+"'>下载</a></td>\n" +
                "                        </tr>";
        }
    }
}
}

/**
 * 登录用户的删除图片
 */
function deleteImage(imageId) {
    document.documentElement.style.overflowY = 'hidden';
    $.jq_Confirm({
        message : "是否删除此作品？",
        btnOktext : "确定",
        btnCanceltext : "取消",
        btnOkClick : function() {
            document.documentElement.style.overflowY = 'scroll';
            var deleteImage_url = "/image/deleteImage/"+imageId;
            xhr.open("GET", deleteImage_url, true)
            xhr.onreadystatechange = myDeleteImageProcess;
            xhr.send();
            function myDeleteImageProcess() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var result = JSON.parse(xhr.responseText);
                    if(result.data.deleteImageMsg!=0){
                        $.message({
                            message: '删除成功',
                            time:'3000',
                            type: 'success',
                            autoClose:true
                        });
                        document.getElementById("myWorks").innerText=result.data.works;
                        document.getElementById("like").innerText =result.data.likes;
                        myWorks(1)
                    }else{
                        $.message({
                            message: '删除失败',
                            time:'3000',
                            type: 'error',
                            autoClose:true
                        });
                    }

                }
            }
        },
        btnCancelClick : function() {
            document.documentElement.style.overflowY = 'scroll';
        }
    });

}

/**
 * 登录用户的移除收藏
 */
function removeMylikes(imageId) {
    document.documentElement.style.overflowY = 'hidden';
    $.jq_Confirm({
        message : "是否取消收藏此作品？",
        btnOktext : "确定",
        btnCanceltext : "取消",
        btnOkClick : function() {
            document.documentElement.style.overflowY = 'scroll';
            var removeMylikes_url = "/image/removeMylikes/"+imageId;
            xhr.open("DELETE", removeMylikes_url, true)
            xhr.onreadystatechange = removeMylikesProcess;
            xhr.send();
            function removeMylikesProcess() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    let jsText = JSON.parse(xhr.responseText);
                    if (jsText.status === 1) {
                        $.message({
                            message: jsText.msg,
                            time: '3000',
                            type: 'success',
                            autoClose: true
                        });
                        document.getElementById("like").innerText =jsText.data.likes;
                        myLike(1);
                    }
                }
            }
        },
        btnCancelClick : function() {
            document.documentElement.style.overflowY = 'scroll';
        }
    });
}

/**
 * 登录用户面向其他用户的收藏和取消收藏
 */
function otherUserLike(imageId,ele) {
    if (ele.innerText === "收藏") {
        let insertMyLike_url = "/image/insertMyLikes/" + imageId;
        xhr.open("GET", insertMyLike_url, true);
        xhr.onreadystatechange = otherUserLikeProcess
        xhr.send();
        function otherUserLikeProcess() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let jsText = JSON.parse(xhr.responseText);
                if (jsText.data.custId != null) {
                    if (jsText.status === 1) {
                        $.message({
                            message: jsText.msg,
                            time: '3000',
                            type: 'success',
                            autoClose: true
                        });
                        ele.innerText = "已收藏"
                    }
                }else {
                    $.message({
                        message: '请先登录！',
                        time: '3000',
                        type: 'warning',
                        autoClose: true
                    });
                }
            }
        }
    }else {
        document.documentElement.style.overflowY = 'hidden';
        $.jq_Confirm({
            message: "是否取消收藏此作品？",
            btnOktext: "确定",
            btnCanceltext: "取消",
            btnOkClick: function () {
                document.documentElement.style.overflowY = 'scroll';
                var removeMylikes_url = "/image/removeMylikes/" + imageId;
                xhr.open("DELETE", removeMylikes_url, true)
                xhr.onreadystatechange = removeMylikesProcess;
                xhr.send();
                function removeMylikesProcess() {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        let jsText = JSON.parse(xhr.responseText);
                        if (jsText.data.custId != null) {
                            if (jsText.status === 1) {
                                $.message({
                                    message: jsText.msg,
                                    time: '3000',
                                    type: 'success',
                                    autoClose: true
                                });
                                ele.innerText = "收藏"
                            }
                        }else {
                            $.message({
                                message: '请先登录！',
                                time: '3000',
                                type: 'warning',
                                autoClose: true
                            });
                        }
                    }
                }
            },
            btnCancelClick: function () {
                document.documentElement.style.overflowY = 'scroll';
            }
        });
        }
    }
function btnClose(){
    document.documentElement.style.overflowY = 'scroll';
}
/**
 * 登录用户的取消关注
*/
function cancelIdolUser(custId) {
        xhr.open("DELETE","/customer/deleteIdols/"+custId,true);
        xhr.onreadystatechange=cancelIdolProcess;
        xhr.send();
        function cancelIdolProcess() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let result= JSON.parse(xhr.responseText);
                $.message({
                    message: result.msg,
                    time: '3000',
                    type: 'success',
                    autoClose: true
                });
                    document.getElementById("myIdols").innerText=result.data.idols;
                    myIdols(1);
            }
        }
}

/**
 *登录用户面向其他用户的关注
 */
function cancelIdolOther(custId,ele) {
    //当前id
    currentId=storage.custId;

    if(ele.innerText === "关注"){
        xhr.open("GET","/customer/idols/save/"+custId,true);
        xhr.onreadystatechange=cancelIdolOtherProcess;
        xhr.send();
        function cancelIdolOtherProcess() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let result = JSON.parse(xhr.responseText);

               if(currentId==result.data.sessionCustId){
                    document.getElementById("myIdols").innerText=result.data.idols;
                }

                if(result.data.saveIdolsMsg===1){
                    $.message({
                        message: '关注成功!',
                        time: '3000',
                        type: 'success',
                        autoClose: true
                    });
                    ele.innerText="已关注";
                }
                if(result.data.saveIdolsMsg===0){
                    $.message({
                        message: '请先登录！',
                        time: '3000',
                        type: 'warning',
                        autoClose: true
                    });
                }
              if(result.data.saveIdolsMsg===2){
                $.message({
                    message: '不能自己关注自己！',
                    time: '3000',
                    type: 'warning',
                    autoClose: true
                });
            }
          }
        }
    }else {
        xhr.open("DELETE", "/customer/deleteIdols/" + custId, true);
        xhr.onreadystatechange =deleteIdosProcess
        xhr.send();
            function deleteIdosProcess() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let result = JSON.parse(xhr.responseText);
                if(currentId==result.data.sessionCustId){
                    document.getElementById("myIdols").innerText=result.data.idols;
                }
                $.message({
                    message: result.msg,
                    time: '3000',
                    type: 'success',
                    autoClose: true
                });
                ele.innerText = "关注";
            }
        }
    }
}

function showOrder() {
    document.getElementsByClassName("table-box")[0].style.display="block";
    document.getElementById("shoot-order-container").style.display="none";
}


function goDetail(id) {
    storage.id=id;
    window.open('/view/image_info');
}
function goPersonalCenter(custId) {
    storage.setItem("custId",custId);
    window.open('/view/personal');
    event.stopPropagation();
}
function deleteButtonOver(i) {
    document.getElementById("deleteButton"+i).style.display="block";
}
function deleteButtonOut(i) {
    document.getElementById("deleteButton"+i).style.display="none";
}

/*===========================================方鹏代码区===================================*/

var xhr1 = null;
/**
 * 显示所有订单
 */
function showShootOrder() {
    if (window.XMLHttpRequest){
        xhr1 = new XMLHttpRequest();
    } else {
        xhr1 = ActiveXObject("Microsoft.XMLHTTP");
    }
    document.getElementsByClassName("table-box")[0].style.display = "none";
    document.getElementById("shoot-order-container").style.display = "block";
    xhr1.open("GET","/shoot/all",true);
    xhr1.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr1.onreadystatechange = loadOrder1;
    xhr1.send();
}

var xhr2 = null;
/**
 * 删除订单
 * @param id 要删除的订单Id
 */
function deleteOrder(id) {
    if (window.XMLHttpRequest){
        xhr2 = new XMLHttpRequest();
    } else {
        xhr2 = ActiveXObject("Microsoft.XMLHTTP");
    }

    $.message('取消成功');

    var url = "/shoot/orderDelete" + "/" + id
    xhr2.open("DELETE",url);
    xhr2.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr2.onreadystatechange = showShootOrder;
    xhr2.send();

}

/**
 * 加载所有订单
 */
function loadOrder1() {
    if (xhr1.readyState==4&&xhr1.status==200){
        var json = JSON.parse(xhr1.responseText);
        var block = document.getElementById("has-gutter-table");
        block.innerHTML = "<tr>\n" +
            "                                <td class=\"shoot-th\">下单时间</td>\n" +
            "                                <td>订单 ID</td>\n" +
            "                                <td>订单内容</td>\n" +
            "                                <td>拍摄时间</td>\n" +
            "                                <td>价格</td>\n" +
            "                                <td >地址</td>\n" +
            "                                <td>联系方式</td>\n" +
            "                                <td></td>\n" +
            "                                <td></td>\n" +
            "                            </tr>";
        if (json.data !== null){
            // document.getElementsByClassName("table-empty-text")[0].style.display = "none";
            for (var i in json.data.orderList){
                var orderCreateTime = getMyDate(json.data.orderList[i].orderCreateTime);
                var shootTime = getMyDate(json.data.orderList[i].shootTime);
                var href = "javascript:deleteOrder("+json.data.orderList[i].orderId+")";
                if (json.data.orderList[i].orderPay==0){
                    block.innerHTML += "<tr>\n" +
                        "                                       <td class=\"shoot-th\">" + orderCreateTime + "</td>\n" +
                        "                                        <td >"+ json.data.orderList[i].orderId +"</td>\n" +
                        "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                        "                                        <td >" + shootTime + "</td>\n" +
                        "                                        <td >" + json.data.orderList[i].shootPrice + "</td>\n" +
                        "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                        "                                        <td >" + json.data.orderList[i].orderPhone + "</td>\n" +
                        "                                        <td >\n" +
                        "                                            <a href=\"/pay/go2shootPay/"+ json.data.orderList[i].shootPrice +"/"+ json.data.orderList[i].orderId + "\" target='_blank'>支付</a>\n" +
                        "                                        </td>\n" +
                        "                                        <td>\n" +
                        "                                            <a href=\""+ href + "\">取消</a>\n" +
                        "                                        </td>\n" +
                        "                                       </tr>";
                } else{
                    block.innerHTML += "<tr>\n" +
                        "                                       <td>" + orderCreateTime + "</td>\n" +
                        "                                        <td>"+ json.data.orderList[i].orderId +"</td>\n" +
                        "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                        "                                        <td >" + shootTime + "</td>\n" +
                        "                                        <td >" + json.data.orderList[i].shootPrice + "</td>\n" +
                        "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                        "                                        <td>" + json.data.orderList[i].orderPhone + "</td>\n" +
                        "                                        <td></td>\n" +
                        "                                        <td>已支付</td>\n" +
                        "                                       </tr>";
                }

            }
        }

        var block1 = document.getElementById("has-gutter-table1");
        block1.innerHTML = "<tr>\n" +
            "                                <td class=\"shoot-th\">下单时间</td>\n" +
            "                                <td>订单 ID</td>\n" +
            "                                <td>订单内容</td>\n" +
            "                                <td>拍摄时间</td>\n" +
            "                                <td>价格</td>\n" +
            "                                <td>地址</td>\n" +
            "                                <td>联系方式</td>\n" +
            "                                <td></td>\n" +
            "                                <td></td>\n" +
            "                            </tr>";
        for (var i in json.data.orderList) {
            if (json.data.orderList[i].orderPay==0){
                // document.getElementsByClassName("table-empty-text1")[0].style.display = "none";
                var orderCreateTime1 = getMyDate(json.data.orderList[i].orderCreateTime);
                var shootTime1 = getMyDate(json.data.orderList[i].shootTime);
                var href = "javascript:deleteOrder(" +json.data.orderList[i].orderId+ ")";
                block1.innerHTML += "<tr>\n" +
                    "                                   <td class=\"shoot-th\">" + orderCreateTime1 + "</td>\n" +
                    "                                        <td>"+ json.data.orderList[i].orderId +"</td>\n" +
                    "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                    "                                        <td>" + shootTime1 + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootPrice + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].orderPhone + "</td>\n" +
                    "                                        <td>\n" +
                    "                                            <a href=\"/pay/go2shootPay/"+ json.data.orderList[i].shootPrice +"/"+ json.data.orderList[i].orderId +"\" target='_blank'>支付</a>\n" +
                    "                                        </td>\n" +
                    "                                        <td>\n" +
                    "                                            <a href=\""+ href + "\">取消</a>\n" +
                    "                                        </td>\n" +
                    "                                    </tr>";
            }

        }

        var block2 = document.getElementById("has-gutter-table2");
        block2.innerHTML = "<tr>\n" +
            "                                <td class=\"shoot-th\">下单时间</td>\n" +
            "                                <td>订单 ID</td>\n" +
            "                                <td>订单内容</td>\n" +
            "                                <td>拍摄时间</td>\n" +
            "                                <td>价格</td>\n" +
            "                                <td>地址</td>\n" +
            "                                <td>联系方式</td>\n" +
            "                                <td></td>\n" +
            "                                <td></td>\n" +
            "                            </tr>";
        for (var i in json.data.orderList) {
            if (json.data.orderList[i].orderPay==1){
                // document.getElementsByClassName("table-empty-text2")[0].style.display = "none";
                var orderCreateTime2 = getMyDate(json.data.orderList[i].orderCreateTime);
                var shootTime2 = getMyDate(json.data.orderList[i].shootTime);
                block2.innerHTML += "<tr>\n" +
                    "                                       <td class=\"shoot-th\">" + orderCreateTime2 + "</td>\n" +
                    "                                        <td>"+ json.data.orderList[i].orderId +"</td>\n" +
                    "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                    "                                        <td >" + shootTime2 + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootPrice + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].orderPhone + "</td>\n" +
                    "                                        <td></td>\n" +
                    "                                        <td>已支付</td>\n" +
                    "                                     </tr>";
            }

        }


    }
}



