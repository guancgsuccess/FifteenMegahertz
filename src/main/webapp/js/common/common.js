/**
 * Created by guochangji on 2018/10/5.
 */

Vue.component('mynav',{
    template:`<nav id="nav">
                <ul id="nav-ul">
                    <li id="nav-first"><img src="/images/home/logo.png" id="nav-logo"></li>
                    <li id="nav-first-button"><a href="/index.html" class="nav-button">首页</a></li>
                    <li><a href="/view/all_image" class="nav-button">图库</a></li>
                    <li><a href="/view/active" class="nav-button">活动</a></li>
                    <li><a href="/view/comm" class="nav-button">社区</a></li>
                    <li><a href="/view/all" class="nav-button">定制</a></li>
                    <li id="nav-search-img"><img src="http://7mx.com/static/img/searchIcon.83cfcde.svg" id="search-img" onclick="search()"></li>
                    <li id="nav-search-input">
                        <input style="background-color:rgba(0,0,0,0.2)" type="text" placeholder="搜索关键词或名称" id="search-input" onkeyup="tipKeyword()">
                        <div id="search-suggest">
                            <ul id="search-ul">
                                
                            </ul>
                        </div>
                    </li>
                    
                    <li><a href="/view/sign" id="signing" class="nav-button">签约</a></li>
                    <li><a href="javascript:void(0)" id="upload" class="nav-button" onclick="showUpload()">上传</a></li>
                    <li><a href="/register.html" id="regist" class="nav-button">注册</a></li>
                    <li><a href="/login.html" id="nav-login" class="nav-button">登录</a></li>                    
                </ul>
              </nav>
    `
});
Vue.component('myupload',{
    template:`<div class="modal fade" id="upload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
            </div>
            <div class="modal-body container" >
                <div class="row">
                    <div class="left col-lg-6" id="container">
                        <div id="uploadImage" class="col-lg-4">➕选择文件</div>
                        <div class="simg col-lg-8">
                        </div>
                    </div>
                    <div class="right col-lg-5">
                        <input type="text" class="imageName form-control col-lg-12" placeholder="作品名称(必填)">
                        <textarea rows="3" class="keyword col-lg-12" placeholder="尽量填写多的关键词,有利于搜索(选填,每个关键词以#开头)"></textarea>
                        <select class="category-select form-control" >
                            <option value="14">请选择类别(默认为 其他)</option>
                        </select>
                        <div class="price form-inline col-xs-12">
                            <label class="radio-inline">
                                <input type="radio" class="form-inline radio-price" name="isFree" value="1" onclick="changePriceStatus(this)" checked>免费
                            </label>
                            <label class="radio-inline">
                                <input type="radio" class="form-inline radio-price" name="isFree" value="2" onclick="changePriceStatus(this)">收费
                            </label>
                        </div>
                        <input type="text" class="imagePrice form-control col-xs-12" value="0" placeholder="价格" readonly>
                        <span class="col-xs-12" style="font-size: 12px;color: red;text-align: right">*单位:积分,用户下载之后返回50%的积分给作者</span>
                        <input type="text" class="imageBrand form-control col-xs-12" placeholder="品牌(选填)">
                        <input type="text" class="imageModel form-control col-xs-12" placeholder="型号(选填)">
                        <input type="text" class="imageFocalLength form-control col-xs-12"  placeholder="焦距(选填)">
                        <input type="text" class="imageFocus form-control col-xs-12" placeholder="光圈(选填)">
                        <input type="text" class="imageISO form-control col-xs-12" placeholder="ISO(选填)">
                        <input type="text" class="imageExposureTime form-control col-xs-12" placeholder="曝光补偿(选填)">
                        <input type="text" class="imageBrightness form-control col-xs-12" placeholder="亮度(选填)">
                    </div>
                    <div class="show-process progress">
                        <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width:0%">
                        </div>
                    </div>
                    <button class="upload btn btn-success" onclick="upload()">发布作品</button>
                </div>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>`
});
Vue.component('myfooter',{
   template:`<footer>
    <div id="footer-left"></div>
    <div class="footer-bottom">
        <ul class="footer-ul">
            <li class="first-li"><h3>社区</h3></li>
            <li><a href="" class="footer-btn">热门</a></li>
            <li><a href="" class="footer-btn">交友</a></li>
            <li><a href="" class="footer-btn">隐私条款</a></li>
            <li><a href="" class="footer-btn">帮助</a></li>
        </ul>
    </div>
    <div class="footer-bottom">
        <ul class="footer-ul">
            <li class="first-li"><h3>商业</h3></li>
            <li><a href="" class="footer-btn">签约合作</a></li>
            <li><a href="" class="footer-btn">创作分成</a></li>
            <li><a href="" class="footer-btn">定制商业摄影</a></li>
            <li><a href="" class="footer-btn">活动发起</a></li>
        </ul>
    </div>
    <div class="footer-bottom">
        <ul class="footer-ul">
            <li class="first-li"><h3>联系我们</h3></li>
            <li><a href="" class="footer-btn">888-8888-8888</a></li>
            <li><a href="" class="footer-btn">yftpaper@15m.com</a></li>
        </ul>
    </div>
    <div class="footer-bottom">
        <ul class="footer-ul">
            <li class="first-li"><h3>关于</h3></li>
            <li><a href="" class="footer-btn">关于15M</a></li>
            <li><a href="" class="footer-btn">15M工作</a></li>
            <li><a href="" class="footer-btn">意见反馈</a></li>
        </ul>
    </div>
    <div id="copyright">
        <span>© 2018 Copyright 苏州十五兆科技摄影责任有限公司 苏ICP备14057276号-4</span>
    </div>
</footer>`
});

new Vue({
     el:'#big-container'
});

/*选中赋值*/
function selectValue(ele) {
    document.getElementById("search-input").value=ele.innerText;
    search();

}
/*搜索提示*/
function tipKeyword() {
    let ajax=null;
    if(window.XMLHttpRequest){
        ajax=new XMLHttpRequest();
    }else{
        ajax=new ActiveXObject("Microsoft.XMLHTTP");
    }
    let serchInput=document.getElementById("search-input");
    if(serchInput.value!=""){
        document.getElementById("search-suggest").style.display="block";
        ajax.open("GET","/image/search/"+serchInput.value,true);
        ajax.onreadystatechange=function () {
            if(ajax.readyState===4&&ajax.status===200){
                let jsText=JSON.parse(ajax.responseText);
                if(jsText.data.keys.length!=0){
                    document.getElementById("search-ul").innerHTML="";
                    for(let i in jsText.data.keys){
                        document.getElementById("search-ul").innerHTML+="<li class=\"key-item\" onclick='selectValue(this)'>"+jsText.data.keys[i]+"</li>";
                    }
                }else {
                    document.getElementById("search-ul").innerHTML="<li style='display: inline-block;width: 100%;margin-top: 100px;text-align: center' >没有找到相关的提示哦!</li>";
                }
            }
        };
        ajax.send(null);
    }else{
        document.getElementById("search-suggest").style.display="none";
    }


}
/*搜索*/
function search() {
    let keyword=document.getElementById("search-input").value;
    let st=window.sessionStorage;
    st.setItem("keyword",keyword);
    window.location.href="/view/all_image";
}

//跳转到个人中心
function goPersonalCenter(custId) {
    let storage=window.sessionStorage;
    storage.setItem("custId",custId)
    window.open('/view/personal');
    event.stopPropagation();
}
//加载登录状态
$(function(){
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
});

