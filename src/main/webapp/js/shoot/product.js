/**
 * Created by F on 2018/10/5.
 */

var page_num=2;
$(document).ready(function () {
    $('div.user-comment-pictures img').click(function(){
        $(this).addClass('user-comment-picture-focus').siblings().removeClass('user-comment-picture-focus');
    });
})

function imgOver(img){
    document.getElementById("bi").src = img.children[1].src;
    img.className = "hover";
}

function imgOut(img){
    img.className = "";
}

function showPicture0(){
    document.getElementsByClassName("user-comment-bigPicBox")[0].id = "0";
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.backgroundSize = "660px";
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.backgroundImage = "url('../../images/home/d1.jpg')"
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.display = "block";
}

function showPicture1() {
    document.getElementsByClassName("user-comment-bigPicBox")[0].id = "1";
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.backgroundSize = "auto 495px";
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.backgroundImage = "url('../../images/home/d2.jpg')"
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.display = "block";
}

function showPicture2() {
    document.getElementsByClassName("user-comment-bigPicBox")[0].id = "2";
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.backgroundSize = "660px";
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.backgroundImage = "url('../../images/shoot/d3.jpg')";
    document.getElementsByClassName("user-comment-bigPicBox")[0].style.display = "block";
}


function show(tag){
    var height = document.getElementById("user-comment-navs").style.height;
    if(height == "43px"){
        tag.innerText = "收起全部^";
        document.getElementById("user-comment-navs").style.height = "auto";
    }else{
        tag.innerText = "查看全部V";
        document.getElementById("user-comment-navs").style.height = "43px";
    }
}

function showIcon() {
    document.getElementsByClassName("user-comment-bigPicBox-left")[0].style.visibility = "visible";
    document.getElementsByClassName("user-comment-bigPicBox-right")[0].style.visibility = "visible";
}

function hideIcon() {
    document.getElementsByClassName("user-comment-bigPicBox-left")[0].style.visibility = "hidden";
    document.getElementsByClassName("user-comment-bigPicBox-right")[0].style.visibility = "hidden";
}

function getNext() {
    var id = document.getElementsByClassName("user-comment-bigPicBox")[0].id;
    if(id==0){
        showPicture1();
        document.getElementsByClassName("user-comment-pictures")[0].children[1].className = "user-comment-picture user-comment-picture-focus";
        document.getElementsByClassName("user-comment-pictures")[0].children[0].className = "user-comment-picture";
    }else if(id==1){
        showPicture2();
        document.getElementsByClassName("user-comment-pictures")[0].children[2].className = "user-comment-picture user-comment-picture-focus";
        document.getElementsByClassName("user-comment-pictures")[0].children[1].className = "user-comment-picture";
    }else{
        document.getElementsByClassName("emg")[0].innerText = "已经是最后一张了";
        document.getElementsByClassName("emg")[0].style.display = "block";
        fadeout();
    }
}

function getPre() {
    var id = document.getElementsByClassName("user-comment-bigPicBox")[0].id;
    if(id==2){
        showPicture1();
        document.getElementsByClassName("user-comment-pictures")[0].children[1].className = "user-comment-picture user-comment-picture-focus";
        document.getElementsByClassName("user-comment-pictures")[0].children[2].className = "user-comment-picture";
    }else if(id==1){
        showPicture0();
        document.getElementsByClassName("user-comment-pictures")[0].children[0].className = "user-comment-picture user-comment-picture-focus";
        document.getElementsByClassName("user-comment-pictures")[0].children[1].className = "user-comment-picture";
    }else{
        document.getElementsByClassName("emg")[0].innerText = "已经是第一张了";
        document.getElementsByClassName("emg")[0].style.display = "block";
        fadeout();
    }
}

function fadeout () {
    var ele = document.getElementsByClassName("emg")[0];
    var stepLength = 1/50;
    if (!parseFloat(ele.style.opacity)) {
        ele.style.opacity = 1;
    }
    function step () {
        if (parseFloat(ele.style.opacity)-stepLength > 0) {
            ele.style.opacity = parseFloat(ele.style.opacity)-stepLength;
        } else {
            ele.style.opacity = 0;
            clearInterval(setIntervalId);
        }
    }
    var setIntervalId = setInterval(step, 20);
}

function cleanText(text) {
    text.style.color = "#333";
}

function reduction(text) {
    if (text.value==""){
        text.style.color = "#bfbfbf";
    }
}

function showStar(star) {
    var imgs = document.getElementsByClassName("user-comment-range")[0].children;
    for (var i=0;i<star.name;i++){
        imgs[i].src = "../../images/shoot/star-on.png";
    }
    for (var i=star.name;i<imgs.length;i++){
        imgs[i].src = "../../images/shoot/star-off.png";
    }
}

function getMyDate(str) {
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth() + 1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear + '-' + addZero(oMonth) + '-' + addZero(oDay) + ' ' + addZero(oHour) + ':' +
            addZero(oMin) + ':' + addZero(oSen);
    return oTime;
}

//补零操作
function addZero(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}










