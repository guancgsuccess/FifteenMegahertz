//引入Plupload 、qiniu.js后
var  uploader2 = Qiniu.uploader({
    runtimes: 'html5,flash,html4',    //上传模式,依次退化
    browse_button: 'uploadImage',       //上传选择的点选按钮，**必需**
    uptoken_url: '/upload/getToken', //Ajax请求upToken的Url，**强烈建议设置**（服务端提供）
    unique_names: true, // 默认 false，key为文件名。若开启该选项，SDK为自动生成上传成功后的key（文件名）。
    save_key: true,   // 默认 false。若在服务端生成uptoken的上传策略中指定了 `sava_key`，则开启，SDK会忽略对key的处理
    domain: 'http://img.gcc666.top/',   //bucket 域名，下载资源时用到，**必需**
    get_new_uptoken: true,  //设置上传文件的时候是否每次都重新获取新的token
    multi_selection: true,  //限制单张添加到队列
    container: 'container',           //上传区域DOM ID，默认是browser_button的父元素，
    max_file_size: '100mb',           //最大文件体积限制
    max_retries: 3,                   //上传失败最大重试次数
    dragdrop: true,                   //开启可拖曳上传
    drop_element: 'container',        //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                //分块上传时，每片的体积
    auto_start: false,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传
    filters: {  //对上传文件类型进行限制
        mime_types : [
            { title : "Image files", extensions : "jpg,jpeg,png"}
        ],
        prevent_duplicates: false
    },
    init: {
        'FilesAdded': function(up, files) {
            var imgs=document.getElementsByClassName("simg")[0].children;
            if(imgs.length>0){
                $.message({
                    message:"暂只支持单张上传!",
                    type:"info"
                });
                uploader2.removeFile(files[0].id);
            }else{
                plupload.each(files, function(file) {
                    showPreview (file);
                });

            }
        },
        'BeforeUpload': function(up, file) {
            // 每个文件上传前,处理相关的事情
        },
        'UploadProgress': function(up, file) {
            document.getElementsByClassName("progress-bar")[0].style.width=file.percent+"%";
        },
        'FileUploaded': function(up, file, info) {
            var domain = up.getOption("domain");
            var res = JSON.parse(info);
            var sourceLink = domain + res.key;
            console.log("获取上传成功后的文件的Url:"+sourceLink);
            //发送ajax添加图片数据
            let ajax=null;
            if(window.XMLHttpRequest){
                ajax=new XMLHttpRequest();
            }else{
                ajax = new ActiveXObject('Microsoft.XMLHTTP');
            }
            let imageName=document.getElementsByClassName("imageName")[0].value;
            let imageKeyword=document.getElementsByClassName("keyword")[0].value;
            let cateIndex=document.getElementsByClassName("category-select")[0].selectedIndex;
            let categoryId=document.getElementsByClassName("category-select")[0].options[cateIndex].value;
            let imageIsFree=$('input:radio:checked').val();
            let imagePrice=document.getElementsByClassName("imagePrice")[0].value;
            let cameraBrand=document.getElementsByClassName("imageBrand")[0].value;
            let cameraModel=document.getElementsByClassName("imageModel")[0].value;
            let cameraFocalLenth=document.getElementsByClassName("imageFocalLength")[0].value;
            let cameraAperture=document.getElementsByClassName("imageFocus")[0].value;
            let cameraIso=document.getElementsByClassName("imageISO")[0].value;
            let cameraExposureTime=document.getElementsByClassName("imageExposureTime")[0].value;
            let imageBrightness=document.getElementsByClassName("imageBrightness")[0].value;
            let formData="imageName="+imageName+"&imageKeyword="+imageKeyword+"&categoryId="+categoryId+"&imageIsFree="+imageIsFree+
                "&imagePrice="+imagePrice+"&cameraBrand="+cameraBrand+"&cameraModel="+cameraModel+"&cameraFocalLenth="+cameraFocalLenth+
                "&cameraAperture="+cameraAperture+"&cameraIso="+cameraIso+"&cameraExposureTime="+cameraExposureTime+"&imageBrightness="+imageBrightness+
                "&nocomprePath="+sourceLink;
            ajax.open("POST","/image/save",false);
            ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
            ajax.onreadystatechange=function () {
                if(ajax.readyState===4&&ajax.status===200){
                    let jsText=JSON.parse(ajax.responseText);
                    if(jsText.status===1){
                        $.message({
                            message:"作品上传成功,请前往个人中心查看!",
                            type:"success"
                        });
                    }else {
                        $.message({
                            message:jsText.msg,
                            type:"error"
                        });
                    }
                }
            };
            ajax.send(formData);


        },
        'Error': function(up, err, errTip) {
            $.message({
                message:"上传失败,请稍后再试!",
                type:"error"
            });
            console.log(errTip);
        },
        'UploadComplete': function() {
            document.getElementsByClassName("progress-bar")[0].style.width="0%";
            document.getElementsByClassName("simg")[0].innerHTML="";
        },
        'Key': function(up, file) {
            // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
            // 该配置必须要在 unique_names: false , save_key: false 时才生效
            /*var key = generateKey()+file.name.substr(file.name.lastIndexOf("."), file.name.length);*/
            var key="";
            // do something with key here
            return key;
        }
    }
});
/**
 * 图片预览
 */
function showPreview (file) {
    let preloader = new mOxie.Image();
    preloader.onload = function() {
        preloader.downsize(300,350);
        let img=document.createElement("img");
        img.src= preloader.getAsDataURL();
        img.style.borderRadius="0.5em";
        img.id=file.id;
        document.getElementsByClassName("simg")[0].appendChild(img);
    };
    preloader.load(file.getSource());
}
/**
 * 移除队列
 */
$(document).on("click",".simg",function(ele){
    delImg(ele.target.id);
});
function delImg(id){
    uploader2.removeFile(id);
    document.getElementsByClassName("simg")[0].removeChild(document.getElementById(id));
}

/**
 * 弹出上传模态框并加载类别信息到模态框中
 */
function showUpload() {
    let ajax=null;
    if(window.XMLHttpRequest){
        ajax=new XMLHttpRequest();
    }else{
        ajax = new ActiveXObject('Microsoft.XMLHTTP');
    }
    ajax.open("GET","/image/category/get/list",false);
    ajax.onreadystatechange=function () {
        if(ajax.readyState===4&&ajax.status===200){
            let cate=document.getElementsByClassName("category-select")[0];
            cate.innerHTML="";
            let option =document.createElement("option");
            option.value="14";
            option.text="请选择类别(默认为 其他)";
            cate.appendChild(option);
            let jsText=JSON.parse(ajax.responseText);
            for(let i in jsText.data.categoryInfo){
                let option =document.createElement("option");
                option.value=jsText.data.categoryInfo[i].categoryId;
                option.text=jsText.data.categoryInfo[i].categoryName;
                cate.appendChild(option);
            }
        }
    };
    ajax.send(null);
    $("#upload").modal();

}

/**
 * 切换价格输入框readOnly属性
 */
function changePriceStatus(ele) {
    if(ele.value==="1"){
        document.getElementsByClassName("imagePrice")[0].readOnly=true;
        document.getElementsByClassName("imagePrice")[0].value=0;
    }else{
        document.getElementsByClassName("imagePrice")[0].readOnly=false;
    }
}

/**
 * 判断是否符合要求并上传
 */
function upload(){
    let name=document.getElementsByClassName("imageName")[0];
    let imagePrice=document.getElementsByClassName("imagePrice")[0].value;
    if(uploader2.files.length===0){
        $.message({
            message:"请选择图片!",
            type:"error"
        });
    }else if(name.value===""){
        $.message({
            message:"图片名称不能为空!",
            type:"error"
        });
    }else if(!/^\d+$/.test(imagePrice)){
        $.message({
            message:"价格只能是0或者正整数!",
            type:"error"
        });
    }else {
        let ajax=null;
        if(window.XMLHttpRequest){
            ajax=new XMLHttpRequest();
        }else{
            ajax = new ActiveXObject('Microsoft.XMLHTTP');
        }
        ajax.open("GET","/customer/isLogin",true);
        ajax.onreadystatechange=function(){
            if(ajax.readyState===4&&ajax.status===200){
                let jsText=JSON.parse(ajax.responseText);
                if(jsText.status===4){
                    $.message({
                        message:'请登录!',
                        type:"error"
                    });
                }else {
                    uploader2.start();
                }
            }
        };
        ajax.send(null);
    }
}

