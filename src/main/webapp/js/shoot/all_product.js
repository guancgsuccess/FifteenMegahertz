/**
 * Created by F on 2018/10/5.
 */

$(document).ready(function () {
    $('ul.citem-list li').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
    });
});

function showPhotographerName(tag){
    tag.children[1].style.display = "none";
    tag.children[2].style.display = "inline";
}

function hide(tag){
    tag.children[1].style.display = "block";
    tag.children[2].style.display = "none";
}

function show1(tag){
    tag.style.background = "url(../../images/shoot/more_info_bg_hover.png) no-repeat";
}

function hide1(tag){
    tag.style.background = "url(../../images/shoot/more_info_bg.png) no-repeat";
}

function show2(tag){
    tag.children[1].style.visibility = "visible";
}

function hide2(tag){
    tag.children[1].style.visibility = "hidden";
}

function showFirst() {
    document.getElementById("category-ul-first").style.display = "block";
    document.getElementById("category-ul-second").style.display = "none";
    document.getElementById("category-ul-third").style.display = "none";
    document.getElementById("next-page-first").style.display = "block";
    document.getElementById("next-page-second").style.display = "none";
    document.getElementById("next-page-third").style.display = "none";
}

function showSecond() {
    document.getElementById("category-ul-first").style.display = "none";
    document.getElementById("category-ul-second").style.display = "block";
    document.getElementById("category-ul-third").style.display = "none";
    document.getElementById("next-page-first").style.display = "none";
    document.getElementById("next-page-second").style.display = "block";
    document.getElementById("next-page-third").style.display = "none";
}

function showThird() {
    document.getElementById("category-ul-first").style.display = "none";
    document.getElementById("category-ul-second").style.display = "none";
    document.getElementById("category-ul-third").style.display = "block";
    document.getElementById("next-page-first").style.display = "none";
    document.getElementById("next-page-second").style.display = "none";
    document.getElementById("next-page-third").style.display = "block";
}

function showHZ() {
    document.getElementById("category-ul-hz").style.display = "block";
    document.getElementById("category-ul-sz").style.display = "none";
    document.getElementById("category-ul-cd").style.display = "none";
    document.getElementById("category-ul-yn").style.display = "none";
    document.getElementById("next-page-hz").style.display = "block";
    document.getElementById("next-page-sz").style.display = "none";
    document.getElementById("next-page-cd").style.display = "none";
    document.getElementById("next-page-yn").style.display = "none";
}

function showSZ() {
    document.getElementById("category-ul-hz").style.display = "none";
    document.getElementById("category-ul-sz").style.display = "block";
    document.getElementById("category-ul-cd").style.display = "none";
    document.getElementById("category-ul-yn").style.display = "none";
    document.getElementById("next-page-hz").style.display = "none";
    document.getElementById("next-page-sz").style.display = "block";
    document.getElementById("next-page-cd").style.display = "none";
    document.getElementById("next-page-yn").style.display = "none";
}

function showCD() {
    document.getElementById("category-ul-hz").style.display = "none";
    document.getElementById("category-ul-sz").style.display = "none";
    document.getElementById("category-ul-cd").style.display = "block";
    document.getElementById("category-ul-yn").style.display = "none";
    document.getElementById("next-page-hz").style.display = "none";
    document.getElementById("next-page-sz").style.display = "none";
    document.getElementById("next-page-cd").style.display = "block";
    document.getElementById("next-page-yn").style.display = "none";
}

function showYN() {
    document.getElementById("category-ul-hz").style.display = "none";
    document.getElementById("category-ul-sz").style.display = "none";
    document.getElementById("category-ul-cd").style.display = "none";
    document.getElementById("category-ul-yn").style.display = "block";
    document.getElementById("next-page-hz").style.display = "none";
    document.getElementById("next-page-sz").style.display = "none";
    document.getElementById("next-page-cd").style.display = "none";
    document.getElementById("next-page-yn").style.display = "block";
}
