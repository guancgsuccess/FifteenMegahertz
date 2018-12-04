$(document).ready(function () {
    $('ul.nav-list li').click(function(){
        $(this).addClass('isActive').siblings().removeClass('isActive');
    });
    $('div.tab-content div').click(function(){
        $(this).addClass('tab-item-font').siblings().removeClass('tab-item-font');
    });
})

function getMyDate(str) {
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay);
    return oTime;
}

//补零操作
function addZero(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}

function showTableBox() {
    document.getElementById("has-gutter-ul").style.display = "block";
    document.getElementById("has-gutter-ul1").style.display = "none";
    document.getElementById("has-gutter-ul2").style.display = "none";
}

function showTableBox1() {
    document.getElementById("has-gutter-ul").style.display = "none";
    document.getElementById("has-gutter-ul1").style.display = "block";
    document.getElementById("has-gutter-ul2").style.display = "none";
}

function showTableBox2() {
    document.getElementById("has-gutter-ul").style.display = "none";
    document.getElementById("has-gutter-ul1").style.display = "none";
    document.getElementById("has-gutter-ul2").style.display = "block";
}