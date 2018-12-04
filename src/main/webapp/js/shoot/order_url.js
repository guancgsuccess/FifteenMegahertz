var url_getOrder = "/shoot/all";
var url_addOrder = "/shoot/orderAdd";
var url_deleteOrder = "/shoot/orderDelete"

window.onload = function () {
    refreshOrder();
}

var xhr = null;

/**
 * 获得所有订单并发送请求
 */
function refreshOrder() {
    if (window.XMLHttpRequest){
        xhr = new XMLHttpRequest();
    }else {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xhr.open("GET",url_getOrder,true);
    xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr.onreadystatechange = loadOrder;
    xhr.send();
}

/**
 * 加载所有订单
 */
function loadOrder() {
    if (xhr.readyState==4&&xhr.status==200){
        var json = JSON.parse(xhr.responseText);
        var block = document.getElementById("has-gutter-table");
        block.innerHTML =  "<tr>\n" +
            "                                <td class=\"shoot-th\">下单时间</td>\n" +
            "                                <td>订单 ID</td>\n" +
            "                                <td>订单内容</td>\n" +
            "                                <td>拍摄时间</td>\n" +
            "                                <td>价格</td>\n" +
            "                                <td >地址</td>\n" +
            "                                <td>联系方式</td>\n" +
            "                                <td></td>\n" +
            "                                <td></td>\n" +
            "                            </tr>";
        if (json.data !== null){
            // document.getElementsByClassName("table-empty-text")[0].style.display = "none";
            for (var i in json.data.orderList){
                var orderCreateTime = getMyDate(json.data.orderList[i].orderCreateTime);
                var shootTime = getMyDate(json.data.orderList[i].shootTime);
                var href = "javascript:deleteOrder("+json.data.orderList[i].orderId+")";
                if (json.data.orderList[i].orderPay==0){
                    block.innerHTML += "<tr>\n" +
                        "                                       <td class=\"shoot-th\">" + orderCreateTime + "</td>\n" +
                        "                                        <td >"+ json.data.orderList[i].orderId +"</td>\n" +
                        "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                        "                                        <td >" + shootTime + "</td>\n" +
                        "                                        <td >" + json.data.orderList[i].shootPrice + "</td>\n" +
                        "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                        "                                        <td >" + json.data.orderList[i].orderPhone + "</td>\n" +
                        "                                        <td >\n" +
                        "                                            <a href=\"/pay/go2shootPay/"+ json.data.orderList[i].shootPrice +"/"+ json.data.orderList[i].orderId + "\" target='_blank'>支付</a>\n" +
                        "                                        </td>\n" +
                        "                                        <td>\n" +
                        "                                            <a href=\""+ href + "\">取消</a>\n" +
                        "                                        </td>\n" +
                        "                                       </tr>";
                } else{
                    block.innerHTML += "<tr>\n" +
                        "                                       <td>" + orderCreateTime + "</td>\n" +
                        "                                        <td>"+ json.data.orderList[i].orderId +"</td>\n" +
                        "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                        "                                        <td >" + shootTime + "</td>\n" +
                        "                                        <td >" + json.data.orderList[i].shootPrice + "</td>\n" +
                        "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                        "                                        <td>" + json.data.orderList[i].orderPhone + "</td>\n" +
                        "                                        <td></td>\n" +
                        "                                        <td>已支付</td>\n" +
                        "                                       </tr>";
                }

            }
        }

        var block1 = document.getElementById("has-gutter-table1");
        block1.innerHTML = "<tr>\n" +
            "                                <td class=\"shoot-th\">下单时间</td>\n" +
            "                                <td>订单 ID</td>\n" +
            "                                <td>订单内容</td>\n" +
            "                                <td>拍摄时间</td>\n" +
            "                                <td>价格</td>\n" +
            "                                <td>地址</td>\n" +
            "                                <td>联系方式</td>\n" +
            "                                <td></td>\n" +
            "                                <td></td>\n" +
            "                            </tr>";
        for (var i in json.data.orderList) {
            if (json.data.orderList[i].orderPay==0){
                // document.getElementsByClassName("table-empty-text1")[0].style.display = "none";
                var orderCreateTime1 = getMyDate(json.data.orderList[i].orderCreateTime);
                var shootTime1 = getMyDate(json.data.orderList[i].shootTime);
                var href = "javascript:deleteOrder(" +json.data.orderList[i].orderId+ ")";
                block1.innerHTML += "<tr>\n" +
                    "                                   <td class=\"shoot-th\">" + orderCreateTime1 + "</td>\n" +
                    "                                        <td>"+ json.data.orderList[i].orderId +"</td>\n" +
                    "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                    "                                        <td>" + shootTime1 + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootPrice + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].orderPhone + "</td>\n" +
                    "                                        <td>\n" +
                    "                                            <a href=\"/pay/go2shootPay/"+ json.data.orderList[i].shootPrice +"/"+ json.data.orderList[i].orderId +"\" target='_blank'>支付</a>\n" +
                    "                                        </td>\n" +
                    "                                        <td>\n" +
                    "                                            <a href=\""+ href + "\">取消</a>\n" +
                    "                                        </td>\n" +
                    "                                    </tr>";
            }

        }

        var block2 = document.getElementById("has-gutter-table2");
        block2.innerHTML = "<tr>\n" +
            "                                <td class=\"shoot-th\">下单时间</td>\n" +
            "                                <td>订单 ID</td>\n" +
            "                                <td>订单内容</td>\n" +
            "                                <td>拍摄时间</td>\n" +
            "                                <td>价格</td>\n" +
            "                                <td>地址</td>\n" +
            "                                <td>联系方式</td>\n" +
            "                                <td></td>\n" +
            "                                <td></td>\n" +
            "                            </tr>";
        for (var i in json.data.orderList) {
            if (json.data.orderList[i].orderPay==1){
                // document.getElementsByClassName("table-empty-text2")[0].style.display = "none";
                var orderCreateTime2 = getMyDate(json.data.orderList[i].orderCreateTime);
                var shootTime2 = getMyDate(json.data.orderList[i].shootTime);
                block2.innerHTML += "<tr>\n" +
                    "                                       <td class=\"shoot-th\">" + orderCreateTime2 + "</td>\n" +
                    "                                        <td>"+ json.data.orderList[i].orderId +"</td>\n" +
                    "                                        <td class=\"cell-div\" onclick=\"window.open('/view/productInfo?" + json.data.orderList[i].shootId + "')\" title=\""+ json.data.orderList[i].shootDesc + "\">" + json.data.orderList[i].shootDesc + "</td>\n" +
                    "                                        <td >" + shootTime2 + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootPrice + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].shootLoc + "</td>\n" +
                    "                                        <td>" + json.data.orderList[i].orderPhone + "</td>\n" +
                    "                                        <td></td>\n" +
                    "                                        <td>已支付</td>\n" +
                    "                                     </tr>";
            }

        }


    }
}

var xhr1 = null;

/**
 * 添加订单并发送请求
 * @param url 含订单Id和状态的url
 */
function addOrder(url) {
    if (window.XMLHttpRequest){
        xhr1 = new XMLHttpRequest();
    } else {
        xhr1 = new ActiveXObject("Microsoft.XMLHTTP");
    }

    var shootId = url.split('?')[0];
    var orderPay = url.split('?')[1];
    var shootLoc = document.getElementsByClassName("modal-body-location-input")[0].value;
    var orderPhone = document.getElementsByClassName("modal-body-phone-input")[0].value;
    var startDate = document.getElementsByClassName("form-control")[0].value;
    startDate = startDate.replace(new RegExp("-","gm"),"/");
    var shootTime = (new Date(startDate)).getTime();

    var data = {"shootId":shootId,"orderPhone":orderPhone,"shootLoc":shootLoc,"shootTime":shootTime,"orderPay":orderPay};
    var jsonstr = JSON.stringify(data);

    xhr1.open("POST",url_addOrder);
    xhr1.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr1.onreadystatechange = refreshOrder;
    xhr1.send(jsonstr);
}

var xhr3 = null;

/**
 * 接收验证码并发送请求
 * @param url 含套餐价格、订单Id和订单状态的url
 */
function receiveCode(url) {
    if (window.XMLHttpRequest){
        xhr3 = new XMLHttpRequest();
    } else {
        xhr3 = new ActiveXObject("Microsoft.XMLHTTP");
    }

    var getCode = document.getElementsByClassName("modal-code-input")[0].value;
    var url_code = "/shoot/receiveCode?getCode=" + getCode;

    xhr3.open("POST",url_code);
    xhr3.setRequestHeader("Content-Type","application/json;charset=utf-8");
    xhr3.onreadystatechange = function(){confirmCode(url)};
    xhr3.send();
}

/**
 * 确认验证结果并跳转
 * @param url 含套餐价格、套餐Id和订单状态的url
 */
function confirmCode(url) {
    if (xhr3.readyState==4&&xhr3.status==200){
        var json = JSON.parse(xhr3.responseText);
        if (json.msg == "success"){
            var price = url.split('?')[0] + "";
            var url_order = url.split('?')[1] + "?" + url.split('?')[2];
            var custId = url.split('?')[3];
            addOrder(url_order);
            const btn2 = document.getElementById("pay-button1");
            btn2.click();
            document.getElementsByClassName("modal-body-a")[0].href = "javascript:goPersonalCenter('"+ custId +"')";
        }else{
            $.message({
                message: "验证码有误",
                type: 'warning'
            });
        }
    }
}

