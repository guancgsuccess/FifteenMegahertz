var url_getShootTheme = "/shoot/theme";
var url_getShoot="/shoot/getByPage";
var url_getPhotographer = "/shoot/photographer";
var url_getImageInfo = "/shoot/image";
var url_getShootByLoc = "/shoot/getAllByLoc";

window.onload = function () {
    getCust();
    refreshShootTheme();
    refreshShoot();
    refreshShoot1();
    refreshShoot2();
    refreshPhotographer();
    refreshImageInfo();
    refreshShootByLoc();
    refreshShootByLoc1();
    refreshShootByLoc2();
    refreshShootByLoc3();
}

/**
 * 获得用户登陆状态
 */
function getCust(){
        let ajax=null;
        if(window.XMLHttpRequest){
            ajax=new XMLHttpRequest();
        }else{
            ajax=new ActiveXObject("Microsoft.XMLHTTP");
        }
        let regist=document.getElementById("regist");
        let login=document.getElementById("nav-login");
        let navUl=document.getElementById("nav-ul");
        let userInfo=document.getElementById("userInfo");
        ajax.open("GET","/customer/isLogin",true);
        ajax.setRequestHeader("x-requested-with","XMLHttpRequest");
        ajax.onreadystatechange=function () {
            if(ajax.readyState===4&&ajax.status===200){
                let jsText=JSON.parse(ajax.responseText);
                if(jsText.status===3){
                    regist.style.display="none";
                    login.style.display="none";
                    navUl.innerHTML+="<li id='userInfo'>" +
                        "<a href='javascript:goPersonalCenter("+jsText.data.custId+")' >" +
                        "<div class='avatar' id='avatarMin' style='background: url("+jsText.data.custProfile+")'></div>" +
                        "<span id='username'>"+jsText.data.custNick+"</span>" +
                        "</a>" +
                        "</li>";
                }else{
                    if(userInfo!=null){
                        userInfo.style.display="none";
                    }
                }
            }
        };
        ajax.send(null);
    }

var xhr3 = null;

/**
 * 获得套餐分类，并发送请求
 */
function refreshShootTheme() {
    if (window.XMLHttpRequest){
        xhr3 = new XMLHttpRequest();
    } else{
        xhr3 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhr3.open("GET",url_getShootTheme,true);
    xhr3.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr3.onreadystatechange = loadShootTheme;
    xhr3.send();
}

/**
 * 加载套餐分类
 */
function loadShootTheme() {
    if (xhr3.readyState==4&&xhr3.status==200){
        var result = JSON.parse(xhr3.responseText);
        var citem = document.getElementsByClassName("citem-list")[0];

        for (var i in result.data.shootThemeList){
            citem.children[i].innerText = result.data.shootThemeList[i].shootThemeName;
        }
    }
}


var xhr = null;

/**
 * 获得所有套餐，并发送请求
 * @param url 含当前套餐页码的url
 */
function refreshShoot(url) {
    if (xhr==null){
        url = url_getShoot;
    }
    if (window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open("GET",url,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadShoot;
    xhr.send();
}

/**
 * 加载所有套餐
 */
function loadShoot() {
        if (xhr.readyState==4&&xhr.status==200){
            var result = JSON.parse(xhr.responseText);

            var category = document.getElementById("category-ul-first");

            for (var i in result.data.shootThemeList[0].page.modelList){
                category.innerHTML += "<li class=\"category-item\">\n" +
                    "                <a class=\"js-href\" href=\"/view/productInfo?" + result.data.shootThemeList[0].page.modelList[i].shootId  + "\" target=\"_blank\">\n" +
                    "                    <img src=\"" + result.data.shootThemeList[0].page.modelList[i].img1Path + "\">\n" +
                    "                    <a class=\"address-days\">" + result.data.shootThemeList[0].page.modelList[i].shootLoc + " | 1天</a>\n" +
                    "                   <div class=\"msg\">\n" +
                    "                        <p class=\"msg-tittle\">"+ result.data.shootThemeList[0].page.modelList[i].shootDesc + "</p>\n" +
                    "                        <div class=\"msg-price\">\n" +
                    "                            ¥\n" +
                    "                            <span>" + result.data.shootThemeList[0].page.modelList[i].shootPrice +"</span>\n" +
                    "                            元起\n" +
                    "                        </div>\n" +
                    "                    </div>" +
                    "                </a>\n" +
                    "            </li>";
            }

            var pagearea = document.getElementById("next-page-first");
            pagearea.innerHTML = "";

            if (result.data.shootThemeList[0].page.currentPageCode!=result.data.shootThemeList[0].page.totalPages){
                var url_next_page = url_getShoot + "/page/" + (result.data.shootThemeList[0].page.currentPageCode+1);
                var href = 'javascript:refreshShoot("'+url_next_page+'")';
                var nextPageEle = "<a href='"+ href + "'>加载更多</a>";
                pagearea.innerHTML += nextPageEle;
            }
        }
}

var xhr1= null;

/**
 * 获得所有套餐，并发送请求
 * @param url 含当前套餐页码的url
 */
function refreshShoot1(url) {
    if (xhr1==null){
        url = url_getShoot;
    }
    if (window.XMLHttpRequest){
        xhr1 = new XMLHttpRequest();
    } else {
        xhr1 = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr1.open("GET",url,true);
    xhr1.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr1.onreadystatechange = loadShoot1;
    xhr1.send();
}

/**
 * 加载所有套餐
 */
function loadShoot1() {
    if (xhr1.readyState==4&&xhr1.status==200){
        var result = JSON.parse(xhr1.responseText);

        var category = document.getElementById("category-ul-second");

        for (var i in result.data.shootThemeList[1].page.modelList){
            category.innerHTML += "<li class=\"category-item\">\n" +
                "                <a class=\"js-href\" href=\"/view/productInfo?" + result.data.shootThemeList[1].page.modelList[i].shootId  + "\" target=\"_blank\">\n" +
                "                    <img src=\"" + result.data.shootThemeList[1].page.modelList[i].img1Path + "\">\n" +
                "                    <a class=\"address-days\">" + result.data.shootThemeList[1].page.modelList[i].shootLoc + " | 1天</a>\n" +
                "                   <div class=\"msg\">\n" +
                "                        <p class=\"msg-tittle\">"+ result.data.shootThemeList[1].page.modelList[i].shootDesc + "</p>\n" +
                "                        <div class=\"msg-price\">\n" +
                "                            ¥\n" +
                "                            <span>" + result.data.shootThemeList[1].page.modelList[i].shootPrice +"</span>\n" +
                "                            元起\n" +
                "                        </div>\n" +
                "                    </div>" +
                "                </a>\n" +
                "            </li>";
        }
        var pagearea = document.getElementById("next-page-second");
        pagearea.innerHTML = "";

        if (result.data.shootThemeList[1].page.currentPageCode!=result.data.shootThemeList[1].page.totalPages){
            var url_next_page = url_getShoot + "/page/" + (result.data.shootThemeList[1].page.currentPageCode+1);
            var href = 'javascript:refreshShoot1("'+url_next_page+'")';
            var nextPageEle = "<a href='"+ href + "'>加载更多</a>";
            pagearea.innerHTML += nextPageEle;
        }
    }
}

var xhr2= null;

/**
 * 获得所有套餐，并发送请求
 * @param url 含当前套餐页码的url
 */
function refreshShoot2(url) {
    if (xhr2==null){
        url = url_getShoot;
    }
    if (window.XMLHttpRequest){
        xhr2 = new XMLHttpRequest();
    } else {
        xhr2 = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr2.open("GET",url,true);
    xhr2.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr2.onreadystatechange = loadShoot2;
    xhr2.send();
}

/**
 * 加载所有套餐
 */
function loadShoot2() {
    if (xhr2.readyState==4&&xhr2.status==200){
        var result = JSON.parse(xhr2.responseText);

        var category = document.getElementById("category-ul-third");

        for (var i in result.data.shootThemeList[2].page.modelList){
            category.innerHTML += "<li class=\"category-item\">\n" +
                "                <a class=\"js-href\" href=\"/view/productInfo?" + result.data.shootThemeList[2].page.modelList[i].shootId  + "\" target=\"_blank\">\n" +
                "                    <img src=\"" + result.data.shootThemeList[2].page.modelList[i].img1Path + "\">\n" +
                "                    <a class=\"address-days\">"+ result.data.shootThemeList[2].page.modelList[i].shootLoc + " | 1天</a>\n" +
                "                   <div class=\"msg\">\n" +
                "                        <p class=\"msg-tittle\">"+ result.data.shootThemeList[2].page.modelList[i].shootDesc + "</p>\n" +
                "                        <div class=\"msg-price\">\n" +
                "                            ¥\n" +
                "                            <span>" + result.data.shootThemeList[2].page.modelList[i].shootPrice +"</span>\n" +
                "                            元起\n" +
                "                        </div>\n" +
                "                    </div>" +
                "                </a>\n" +
                "            </li>";
        }
        var pagearea = document.getElementById("next-page-third");
        pagearea.innerHTML = "";

        if (result.data.shootThemeList[2].page.currentPageCode!=result.data.shootThemeList[2].page.totalPages){
            var url_next_page = url_getShoot + "/page/" + (result.data.shootThemeList[2].page.currentPageCode+1);
            var href = 'javascript:refreshShoot2("'+url_next_page+'")';
            var nextPageEle = "<a href='"+ href + "'>加载更多</a>";
            pagearea.innerHTML += nextPageEle;
        }
    }
}

var xhr4 = null;
/**
 * 获得点击量最高作品用户的信息并发送请求
 */
function refreshPhotographer() {
    if (window.XMLHttpRequest) {
        xhr4 = new XMLHttpRequest();
    }else {
        xhr4 = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xhr4.open("GET",url_getPhotographer,true);
    xhr4.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr4.onreadystatechange = loadPhotographer;
    xhr4.send();
}

/**
 * 获得点击量最高的作品的用户信息
 */
function loadPhotographer() {
    if (xhr4.readyState==4&&xhr4.status==200){
        var json = JSON.parse(xhr4.responseText);

        var photographers = document.getElementById("photographer-list");

        for (var i in json.data.customerList){
            photographers.children[i].childNodes[3].innerText = json.data.customerList[i].custNick;
            photographers.children[i].childNodes[5].childNodes[1].innerText = json.data.customerList[i].custNick;
            photographers.children[i].childNodes[1].src = json.data.customerList[i].noComprePath+"-shooter";
            photographers.children[i].childNodes[5].href = "javascript:goPersonalCenter('"+json.data.customerList[i].custId+"')";
        }
    }
}

var xhr5 = null;

/**
 * 获得欣赏作品的信息并发送请求
 */
function refreshImageInfo() {
    if (window.XMLHttpRequest){
        xhr5 = new XMLHttpRequest();
    } else {
        xhr5 = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xhr5.open("GET",url_getImageInfo,true);
    xhr5.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr5.onreadystatechange = loadImageInfo;
    xhr5.send();
}

/**
 * 加载欣赏作品的信息
 */
function loadImageInfo() {
    if (xhr5.readyState==4&&xhr5.status==200){
        var json = JSON.parse(xhr5.responseText);

        var content = document.getElementsByClassName("enjoy-content")[0];
        for (var i in json.data.imageList){
            content.children[i].childNodes[3].childNodes[3].childNodes[1].childNodes[1].innerText = json.data.imageList[i].imageName;
            content.children[i].childNodes[3].childNodes[3].childNodes[3].innerText = "@" + json.data.imageList[i].custNick;
            content.children[i].childNodes[3].childNodes[1].href = "javascript:goImageDetail('"+ json.data.imageList[i].imageId + "')";
            content.children[i].childNodes[3].childNodes[3].childNodes[1].href = "javascript:goImageDetail('"+ json.data.imageList[i].imageId + "')";
            content.children[i].childNodes[3].childNodes[3].childNodes[3].href = "javascript:goPersonalCenter('"+json.data.imageList[i].custId+"')";
        }
    }
}

//打开作品详情页面
function goImageDetail(id) {
    let storage=window.sessionStorage;
    storage.id=id;
    window.open('/view/image_info');
}


var xhr6 = null;
/**
 * 获得套餐根据地点的分类并发送请求
 * @param url 当前页码的url
 */
function refreshShootByLoc(url) {
    if (xhr6==null){
        url = url_getShootByLoc;
    }
    if (window.XMLHttpRequest){
        xhr6 = new XMLHttpRequest();
    } else {
        xhr6 = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr6.open("GET",url,true);
    xhr6.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr6.onreadystatechange = loadShootByLoc;
    xhr6.send();
}

/**
 * 加载所有套餐
 */
function loadShootByLoc() {
    if (xhr6.readyState==4&&xhr6.status==200){
        var json = JSON.parse(xhr6.responseText);

        var category = document.getElementById("category-ul-hz");

        for (var i in json.data.shootLocList[0].page.modelList){
            category.innerHTML += "<li class=\"category-item\">\n" +
                "                <a class=\"js-href\" href=\"/view/productInfo?" + json.data.shootLocList[0].page.modelList[i].shootId  + "\" target=\"_blank\">\n" +
                "                    <img src=\"" + json.data.shootLocList[0].page.modelList[i].img1Path + "\">\n" +
                "                    <a class=\"address-days\">" + json.data.shootLocList[0].page.modelList[i].shootLoc + " | 1天</a>\n" +
                "                   <div class=\"msg\">\n" +
                "                        <p class=\"msg-tittle\">"+ json.data.shootLocList[0].page.modelList[i].shootDesc + "</p>\n" +
                "                        <div class=\"msg-price\">\n" +
                "                            ¥\n" +
                "                            <span>" + json.data.shootLocList[0].page.modelList[i].shootPrice +"</span>\n" +
                "                            元起\n" +
                "                        </div>\n" +
                "                    </div>" +
                "                </a>\n" +
                "            </li>";
        }

        var pagearea = document.getElementById("next-page-hz");
        pagearea.innerHTML = "";

        if (json.data.shootLocList[0].page.currentPageCode!=json.data.shootLocList[0].page.totalPages){
            var url_next_page = url_getShootByLoc + "/page/" + (json.data.shootLocList[0].page.currentPageCode+1);
            var href = 'javascript:refreshShootByLoc("'+url_next_page+'")';
            var nextPageEle = "<a href='"+ href + "'>加载更多</a>";
            pagearea.innerHTML += nextPageEle;
        }
    }
}

var xhr7 = null;

/**
 * 获得所有套餐根据地点分类并发送请求
 * @param url 含当前页码的url
 */
function refreshShootByLoc1(url) {
    if (xhr7==null){
        url = url_getShootByLoc;
    }
    if (window.XMLHttpRequest){
        xhr7 = new XMLHttpRequest();
    } else {
        xhr7 = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr7.open("GET",url,true);
    xhr7.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr7.onreadystatechange = loadShootByLoc1;
    xhr7.send();
}

/**
 * 加载所有套餐
 */
function loadShootByLoc1() {
    if (xhr7.readyState==4&&xhr7.status==200){
        var json = JSON.parse(xhr7.responseText);

        var category = document.getElementById("category-ul-sz");

        for (var i in json.data.shootLocList[1].page.modelList){
            category.innerHTML += "<li class=\"category-item\">\n" +
                "                <a class=\"js-href\" href=\"/view/productInfo?" + json.data.shootLocList[1].page.modelList[i].shootId  + "\" target=\"_blank\">\n" +
                "                    <img src=\"" + json.data.shootLocList[1].page.modelList[i].img1Path + "\">\n" +
                "                    <a class=\"address-days\">" + json.data.shootLocList[1].page.modelList[i].shootLoc + " | 1天</a>\n" +
                "                   <div class=\"msg\">\n" +
                "                        <p class=\"msg-tittle\">"+ json.data.shootLocList[1].page.modelList[i].shootDesc + "</p>\n" +
                "                        <div class=\"msg-price\">\n" +
                "                            ¥\n" +
                "                            <span>" + json.data.shootLocList[1].page.modelList[i].shootPrice +"</span>\n" +
                "                            元起\n" +
                "                        </div>\n" +
                "                    </div>" +
                "                </a>\n" +
                "            </li>";
        }

        var pagearea = document.getElementById("next-page-sz");
        pagearea.innerHTML = "";

        if (json.data.shootLocList[1].page.currentPageCode!=json.data.shootLocList[1].page.totalPages){
            var url_next_page = url_getShootByLoc + "/page/" + (json.data.shootLocList[1].page.currentPageCode+1);
            var href = 'javascript:refreshShootByLoc1("'+url_next_page+'")';
            var nextPageEle = "<a href='"+ href + "'>加载更多</a>";
            pagearea.innerHTML += nextPageEle;
        }
    }
}

var xhr8 = null;
/**
 * 获得所有套餐根据地点分类并发送请求
 * @param url 含当前页码的url
 */
function refreshShootByLoc2(url) {
    if (xhr8==null){
        url = url_getShootByLoc;
    }
    if (window.XMLHttpRequest){
        xhr8 = new XMLHttpRequest();
    } else {
        xhr8 = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr8.open("GET",url,true);
    xhr8.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr8.onreadystatechange = loadShootByLoc2;
    xhr8.send();
}

/**
 * 加载所有套餐
 */
function loadShootByLoc2() {
    if (xhr8.readyState==4&&xhr8.status==200){
        var json = JSON.parse(xhr8.responseText);

        var category = document.getElementById("category-ul-cd");

        for (var i in json.data.shootLocList[2].page.modelList){
            category.innerHTML += "<li class=\"category-item\">\n" +
                "                <a class=\"js-href\" href=\"/view/productInfo?" + json.data.shootLocList[2].page.modelList[i].shootId  + "\" target=\"_blank\">\n" +
                "                    <img src=\"" + json.data.shootLocList[2].page.modelList[i].img1Path + "\">\n" +
                "                    <a class=\"address-days\">" + json.data.shootLocList[2].page.modelList[i].shootLoc + " | 1天</a>\n" +
                "                   <div class=\"msg\">\n" +
                "                        <p class=\"msg-tittle\">"+ json.data.shootLocList[2].page.modelList[i].shootDesc + "</p>\n" +
                "                        <div class=\"msg-price\">\n" +
                "                            ¥\n" +
                "                            <span>" + json.data.shootLocList[2].page.modelList[i].shootPrice +"</span>\n" +
                "                            元起\n" +
                "                        </div>\n" +
                "                    </div>" +
                "                </a>\n" +
                "            </li>";
        }

        var pagearea = document.getElementById("next-page-cd");
        pagearea.innerHTML = "";

        if (json.data.shootLocList[2].page.currentPageCode!=json.data.shootLocList[2].page.totalPages){
            var url_next_page = url_getShootByLoc + "/page/" + (json.data.shootLocList[2].page.currentPageCode+1);
            var href = 'javascript:refreshShootByLoc2("'+url_next_page+'")';
            var nextPageEle = "<a href='"+ href + "'>加载更多</a>";
            pagearea.innerHTML += nextPageEle;
        }
    }
}

var xhr9 = null;

/**
 * 获得所有套餐根据地点分类并发送请求
 * @param url
 */
function refreshShootByLoc3(url) {
    if (xhr9==null){
        url = url_getShootByLoc;
    }
    if (window.XMLHttpRequest){
        xhr9 = new XMLHttpRequest();
    } else {
        xhr9 = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr9.open("GET",url,true);
    xhr9.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr9.onreadystatechange = loadShootByLoc3;
    xhr9.send();
}

/**
 * 加载所有套餐
 */
function loadShootByLoc3() {
    if (xhr9.readyState==4&&xhr9.status==200){
        var json = JSON.parse(xhr9.responseText);

        var category = document.getElementById("category-ul-yn");

        for (var i in json.data.shootLocList[3].page.modelList){
            category.innerHTML += "<li class=\"category-item\">\n" +
                "                <a class=\"js-href\" href=\"/view/productInfo?" + json.data.shootLocList[3].page.modelList[i].shootId  + "\" target=\"_blank\">\n" +
                "                    <img src=\"" + json.data.shootLocList[3].page.modelList[i].img1Path + "\">\n" +
                "                    <a class=\"address-days\">" + json.data.shootLocList[3].page.modelList[i].shootLoc + " | 1天</a>\n" +
                "                   <div class=\"msg\">\n" +
                "                        <p class=\"msg-tittle\">"+ json.data.shootLocList[3].page.modelList[i].shootDesc + "</p>\n" +
                "                        <div class=\"msg-price\">\n" +
                "                            ¥\n" +
                "                            <span>" + json.data.shootLocList[3].page.modelList[i].shootPrice +"</span>\n" +
                "                            元起\n" +
                "                        </div>\n" +
                "                    </div>" +
                "                </a>\n" +
                "            </li>";
        }

        var pagearea = document.getElementById("next-page-yn");
        pagearea.innerHTML = "";

        if (json.data.shootLocList[3].page.currentPageCode!=json.data.shootLocList[3].page.totalPages){
            var url_next_page = url_getShootByLoc + "/page/" + (json.data.shootLocList[3].page.currentPageCode+1);
            var href = 'javascript:refreshShootByLoc3("'+url_next_page+'")';
            var nextPageEle = "<a href='"+ href + "'>加载更多</a>";
            pagearea.innerHTML += nextPageEle;
        }
    }
}



