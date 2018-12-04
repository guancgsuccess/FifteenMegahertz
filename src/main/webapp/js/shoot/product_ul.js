var url_getInfo = "/shoot/productInfo";
var url_getAppraise = "/shoot/get";
var url_addAppraise = "/shoot/save";

window.onload = function () {
    refreshInfo();
    refreshAppraise();
}

var xhr = null;

/**
 * 获得套餐详情信息并发送请求
 */
function refreshInfo() {
    if (window.XMLHttpRequest){
        xhr = new XMLHttpRequest()
    } else {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

    var id = window.location.href.split('?')[1];
    url_getInfo = "/shoot/productInfo/" + id;
    xhr.open("GET",url_getInfo,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadInfo;
    xhr.send();
}

/**
 * 加载套餐详情信息
 */
function loadInfo() {
    if (xhr.readyState==4&&xhr.status==200){
        var json = JSON.parse(xhr.responseText);

        var tittle = document.getElementsByClassName("tittle")[0];
        var price = document.getElementsByClassName("price")[0];
        var location = document.getElementsByClassName("product-priceInfoContent")[0];
        var picSmallList = document.getElementsByClassName("product-picSmallList")[0];
        var images = document.getElementById("mg-images");

        document.getElementById("bi").src = json.data.shootList[0].img2Path;
        picSmallList.childNodes[0].childNodes[2].src = json.data.shootList[0].img2Path;
        picSmallList.childNodes[2].childNodes[2].src = json.data.shootList[0].img3Path;
        picSmallList.childNodes[4].childNodes[2].src = json.data.shootList[0].img4Path;
        picSmallList.childNodes[6].childNodes[2].src = json.data.shootList[0].img5Path;
        picSmallList.childNodes[8].childNodes[2].src = json.data.shootList[0].img6Path;

        tittle.innerText = json.data.shootList[0].shootDesc;
        price.children[0].innerText = json.data.shootList[0].shootPrice;
        location.innerText = json.data.shootList[0].shootLoc;
        images.childNodes[0].childNodes[0].src = json.data.shootList[0].img7Path;
        images.childNodes[2].childNodes[0].src = json.data.shootList[0].img8Path;

        var shootId = window.location.href.split('?')[1];

        var buttonBox = document.getElementsByClassName("modal-footer")[0];
        var orderUrl2 = json.data.shootList[0].shootPrice + "?" + shootId + "?0?" + json.data.custId;
        buttonBox.innerHTML = "";
        buttonBox.innerHTML += "<button id=\"pay-button1\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" data-toggle=\"modal\" data-target=\"#myModal1\" onclick=\"\" style=\"display: none\"></button>\n" +
            "<button id=\"pay-button\" type=\"button\" class=\"btn btn-primary\" onclick=\"clickPayButton('" + orderUrl2 + "')\">立即下单</button>";
    }
}

function clickPayButton(url) {
    var code = document.getElementsByClassName("modal-code-input")[0].value;
    if (code!=""){
        receiveCode(url);
    }else {
        $.message({
            message: "验证码不能为空",
            type: 'warning'
        });
    }
}

var xhr1 = null;

/**
 * 获得所有评论并发送请求
 * @param url 含分页信息的url
 */
function refreshAppraise(url) {
    if (xhr1==null){
        url = url_getAppraise;
    }
    if (window.XMLHttpRequest) {
        xhr1 = new XMLHttpRequest();
    }else {
        xhr1 = new ActiveXObject("Microsoft.XMLHTTP");
    }

    var id = window.location.href.split('?')[1];
    url +=  "/" + id;
    xhr1.open("GET",url,true);
    xhr1.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr1.onreadystatechange = loadAppraise;
    xhr1.send();
}

/**
 * 加载所有评论并分页
 */
function loadAppraise() {
    if (xhr1.readyState==4&&xhr1.status==200){
        var json = JSON.parse(xhr1.responseText);

        var list = document.getElementsByClassName("user-comment-list")[0];

        var comment = document.getElementById("user-comment-header");
        comment.innerText = "(" + json.data.page.totalRecord + ")";

        list.innerHTML = "";
        for (var i in json.data.page.modelList){
            list.innerHTML += "<div style=\"margin-top: -30px\">\n" +
                "                    <div class=\"user-comment-avator\" style=\"background-image: url(" + json.data.appraiseList[i].custProfile + ");\"></div>\n" +
                "                    <div class=\"user-comment-username\">" + json.data.appraiseList[i].custNick + "</div>\n" +
                "                    <div class=\"user-comment-content\">\n" +
                "                        <div class=\"user-comment-labels\">\n" +
                "                            <div class=\"user-comment-labelTittle\">\n" +
                "                                行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程\n" +
                "                                <br>\n" +
                "                            </div>\n" +
                "                            <div class=\"user-comment-label\">\n" +
                "                                <div></div>\n" +
                "                                <br>\n" +
                "                            </div>\n" +
                "                            <div class=\"user-comment-range1\" id=\"" + json.data.page.modelList[i].appraiseId + "\"></div>\n" +
                "                        </div>\n" +
                "                        <div class=\"user-comment-detail\" alt=\"0\">" + json.data.page.modelList[i].appraiseContent + "</div>\n" +
                // "                        <div class=\"user-comment-pictures\">\n" +
                // "                            <img class=\"user-comment-picture\" src=\"../../images/home/c1.jpg\" onclick=\"showPicture0()\">\n" +
                // "                            <img class=\"user-comment-picture\" src=\"../../images/home/c2.jpg\" onclick=\"showPicture1()\">\n" +
                // "                            <img class=\"user-comment-picture\" src=\"../../images/home/c3.jpg\" onclick=\"showPicture2()\">\n" +
                // "                        </div>\n" +
                // "                        <div class=\"user-comment-bigPicBox\" id=\"0\" alt=\"3\" style=\"background-size: 660px;background-image: url('../../images/home/d1.jpg');display: none\" onmouseover=\"showIcon()\" onmouseout=\"hideIcon()\">\n" +
                // "                            <div class=\"user-comment-bigPicBox-left\" style=\"visibility: hidden\" onclick=\"getPre()\"></div>\n" +
                // "                            <div class=\"user-comment-bigPicBox-right\" style=\"visibility: hidden\" onclick=\"getNext()\"></div>\n" +
                // "                        </div>\n" +
                // "                        <div class=\"emg\" style=\"display: none; position: absolute; margin-left: 255px; margin-top: -300px; width: 150px; height: 40px; line-height: 40px; text-align: center; background: rgba(0, 0, 0, 0.5); color: rgb(255, 255, 255); font-size: 14px; border-radius: 5px; z-index: 100;\"></div>\n" +
                "                        <div class=\"user-comment-createtime\">" + getMyDate(json.data.page.modelList[i].appraiseCreateTime) + "</div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                </div>"
            var rangeCount = json.data.page.modelList[i].appraiseRange;

            var label = document.getElementsByClassName("user-comment-label")[i].childNodes[1];
            if (rangeCount==1){
                label.innerText = "不满意";
            } else if (rangeCount>1&&rangeCount<4){
                label.innerText = "一般";
            } else {
                label.innerText = "非常满意";
            }

            var range = document.getElementById(json.data.page.modelList[i].appraiseId);
            range.innerHTML = "";
            for (var i=0;i<rangeCount;i++){
                range.innerHTML += "<img src='../../images/shoot/star-on.png' style=\"width: 20px;\">";
            }
        }

        var pagearea = document.getElementById("pagearea");
        pagearea.innerHTML = "";

        if (json.data.page.currentPageCode != 1){
            var url_pre_page = url_getAppraise+"/"+(json.data.page.currentPageCode-1);
            var href = 'javascript:refreshAppraise("'+url_pre_page+'")';
            var prePageEle = "<a href='"+href+"'>上一页</a>";
            pagearea.innerHTML += prePageEle;
        }

        var currentPageEle = "<span>当前是第</span><span>"+json.data.page.currentPageCode+"</span><span>页</span>";
        pagearea.innerHTML += currentPageEle;

        if (json.data.page.currentPageCode!=json.data.page.totalPages&&json.data.page.totalPages!=1&&json.data.page.totalPages!=0){
            var url_next_page = url_getAppraise + "/" + (json.data.page.currentPageCode+1);
            var href = 'javascript:refreshAppraise("'+url_next_page+'")';
            var nextPageEle = "<a href='"+href +"'>下一页</a>";
            pagearea.innerHTML+=nextPageEle;
        }

        var otherEle = "<span>共</span><span>"+json.data.page.totalPages+"</span><span>页</span>\n"+"<input id=\"comment-input\" type=\"text\" name=\"\">\n" +
            "<button onclick=\"skip()\">跳转</button>";
        pagearea.innerHTML+=otherEle;
    }
}

/**
 * 跳转到指定页码
 */
function skip() {
    var url_skip = url_getAppraise + "/" + document.getElementById("comment-input").value;
    refreshAppraise(url_skip);
}

var xhr2 = null;

/**
 * 添加评论
 */
function addAppraise() {
    if (window.XMLHttpRequest) {
        xhr2 = new XMLHttpRequest();
    }else {
        xhr2 = new ActiveXObject("Microsoft.XMLHTTP");
    }

    var shootId = window.location.href.split('?')[1];
    var appraiseRange = 0;
    var range = document.getElementsByClassName("user-comment-range")[0].children;
    for (var i=0;i<range.length;i++) {
        if (range[i].src=="http://localhost:8080/images/shoot/star-on.png"){
            appraiseRange = i+1;
        }
    }
    var content = document.getElementsByClassName("textarea-fw")[0].value;
    var appraiseContent = null;
    if (content==""||content=="来秀一波..."){
        $.message({
            message:'发表失败',
            type:'error'
        });
    }else {
        $.message('发表成功');
        appraiseContent = content;
        document.getElementsByClassName("textarea-fw")[0].value = "";
        var data = {"shootId":shootId , "appraiseRange":appraiseRange,"appraiseContent":appraiseContent};
        var jsonstr = JSON.stringify(data);

        xhr2.open("POST",url_addAppraise);
        xhr2.setRequestHeader("Content-type", "application/json;charset=utf-8");
        xhr2.onreadystatechange = function(){refreshAppraise(url_getAppraise)} ;
        xhr2.send(jsonstr);
    }

}

var InterValObj;
var count=59;
var curCount;
var xhr3 = null

/**
 * 发送验证码
 */
function sendContactTelCode () {
    if(window.XMLHttpRequest){
        xhr3=new XMLHttpRequest();
    }else{
        xhr3 = new ActiveXObject('Microsoft.XMLHTTP');
    }

    var phoneNumber = document.getElementsByClassName("modal-body-phone-input")[0].value;
    if (phoneNumber=="" || phoneNumber==null || !/^[1][3,4,5,7,8][0-9]{9}$/.test(phoneNumber)){
        $.message({
            message: '请输入正确手机号！',
            time:'3000',
            type: 'warning',
            showClose:true,
            autoClose:true,
        });
    }else {
        var orderPhone = document.getElementsByClassName("modal-body-phone-input")[0].value;
        var setCode_url = "/shoot/setContactTelCode?orderPhone=" + orderPhone;
        xhr3.open("GET",setCode_url,true);
        xhr3.onreadystatechange = sendMessageAgain;
        xhr3.send();
    }
}

/**
 * 若发送失败则重新发送
 */
function sendMessageAgain() {
    if (xhr3.readyState==4&&xhr3.status==200) {
        var json = JSON.parse(xhr3.responseText);
        if (json.msg = "success"){
            $.message({
                message: '验证码发送成功！',
                time:'3000',
                type: 'success',
                showClose:true,
                autoClose:true,
            });
            curCount = count;
            document.getElementById("send-code-button").setAttribute("disabled","true");
            document.getElementById("send-code-button").style.cursor = "auto";
            document.getElementById("send-code-button").innerText = curCount + "s后重新发送";
            InterValObj=window.setInterval(setReduceTime,1000);
        }
    }

}

/**
 * 设定等待多少秒后才可再次发送验证码
 */
function setReduceTime() {
    if(curCount==1){
        window.clearInterval(InterValObj);
        document.getElementById("send-code-button").removeAttribute("disabled");
        document.getElementById("send-code-button").innerText="发送验证码";
        document.getElementById("send-code-button").style.cursor="pointer";
    }else {
        curCount--;
        document.getElementById("send-code-button").innerText=curCount+"s后重新发送";
    }
}







