function changepage1() {
    var active_type = document.getElementsByClassName("active_detail");
    active_type[0].style.cssText="color:inherit";
    active_type[1].style.cssText="color: darkgray";
    active_type[2].style.cssText="color: darkgray"
}

function changepage2() {
    var active_type = document.getElementsByClassName("active_detail");
    active_type[1].style.cssText="color:inherit";
    active_type[0].style.cssText="color: darkgray";
    active_type[2].style.cssText="color: darkgray"
}

function changepage3() {
    var active_type = document.getElementsByClassName("active_detail");
    active_type[2].style.cssText="color:inherit";
    active_type[0].style.cssText="color: darkgray";
    active_type[1].style.cssText="color: darkgray"
}



