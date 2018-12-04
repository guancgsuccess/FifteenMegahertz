function changepage1() {
    var active_type = document.getElementsByClassName("nav_list_active");
    active_type[0].style.cssText="color: white";
    active_type[1].style.cssText="color: hsla(0,0%,100%,.6);";
    active_type[2].style.cssText="color: hsla(0,0%,100%,.6);"
}

function changepage2() {
    var active_type = document.getElementsByClassName("nav_list_active");
    active_type[1].style.cssText="color: white";
    active_type[0].style.cssText="color: hsla(0,0%,100%,.6);";
    active_type[2].style.cssText="color: hsla(0,0%,100%,.6);"
}

function changepage3() {
    var active_type = document.getElementsByClassName("nav_list_active");
    active_type[2].style.cssText="color: white";
    active_type[0].style.cssText="color: hsla(0,0%,100%,.6);";
    active_type[1].style.cssText="color: hsla(0,0%,100%,.6);"
}