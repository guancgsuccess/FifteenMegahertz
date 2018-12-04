/**
 * 封装ajax方法
 * @param method 传输方式
 * @param url 虚拟路径
 * @param isAsy 是否同步
 * @param loadData 加载数据
 */
function ajax(method, url, isAsy, loadData) {
    let xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open(method, url, isAsy);
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            loadData(data);
        }
    };
    xhr.send();
}

function ajaxPost(method, url, isAsy, loadData, formData) {

    let xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    xhr.open(method, url, isAsy);
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            loadData(data);
        }
    };
    xhr.send(formData);
}

const customer = {
    //用户id
    custId: 0,
    //用户头像路径
    custProfile: '/images/community/test-profile.jpg',
    //用户昵称
    custNick: '暂未登录',
    //用户等级
    custLevel: 1,
    //用户简介
    custIntro: '这个人很懒没留下简介~~~~',
    //已经加入社区列表
    communityList: '暂未加入任何社区~~~'
};

ajax('get', '/customer/isLogin', false, function (data) {
    if (data.status == 3) {

        console.log(data);

        customer.custId = data.data.custId;
        if (data.data.custProfile != null){
            customer.custProfile = data.data.custProfile;
        }
        customer.custNick = data.data.custNick;
        customer.custLevel = data.data.rangeLevel;
        if (data.data.custIntro != null && data.data.custIntro != ''){
            customer.custIntro = data.data.custIntro;
        }
    }
});

function goTop(top) {
    $('html , body').animate({scrollTop: top}, 'slow');
}