/**
 * 渲染信息容器方法
 * @param data
 */
function renderingMessage(e, data) {
    //定义一个元素节点
    let success = ``;
    //获得正在数据长度
    let len = data.messageList.length;
    //循环添加元素节点
    for (let i = 0; i < len; i++) {
        
        let context = data.messageList[i].messContent;
        if (context.indexOf('img') == -1){
            if (context.length > 20){
                context = context.substring(0,20) + '...';
            }
        }
        
        success += `<div class="community-content-one-two-message-unit">
                                        <div class="community-content-one-two-message-unit-text">
                                                <div data-mess-id="${data.messageList[i].messId}" 
                                                class="community-content-one-two-message-unit-content">
                                                ${context}
                                            </div>
                                            <div class="community-content-one-two-message-unit-tip">
                                            <span data-comm-id="${data.messageList[i].commId}"
                                            class="community-content-one-two-message-unit-tip-comm">
                                                <img src="${data.messageList[i].commPhotoPath}">
                                                ${data.messageList[i].commName}
                                            </span>
                                            <span data-cust-id="${data.messageList[i].custId}"
                                            class="community-content-one-two-message-unit-tip-cust">
                                                ${data.messageList[i].custNick}
                                                </span>
                                            <span class="community-content-one-two-message-unit-tip-time">
                                                ${data.messageList[i].messTime}
                                            </span>
                                        </div>
                                        </div>`;
        if (data.messageList[i].messImagePath != null) {
            success += `<div class="community-content-one-two-message-unit-img">
                                            <img src="${data.messageList[i].messImagePath}">
                                        </div>`;
        }
        success += `</div>`;
    }

    //清除正在加载
    $('#loadingThree').remove();
    //添加数据
    e.append(success);

    let ccMess = document.getElementsByClassName('community-content-one-two-message-unit-content');
    for (let i = 0; i < ccMess.length; i++) {
        ccMess[i].addEventListener('click', function (e) {
            let ev = e || window.event;
            let t = ev.target || ev.srcElement;
            if (t.className == 'community-content-one-two-message-unit-content') {
                location.href = '/view/info?messId=' + t.dataset.messId
                    + '&r=' + new Date().getTime();
                ;
            }
        });
    }

    let ccComm = document.getElementsByClassName('community-content-one-two-message-unit-tip-comm');
    for (let i = 0; i < ccComm.length; i++) {
        ccComm[i].addEventListener('click', function (e) {
            let ev = e || window.event;
            let t = ev.target || ev.srcElement;
            if (t.className == 'community-content-one-two-message-unit-tip-comm') {
                location.href = '/view/info?commId=' + t.dataset.commId
                    + '&r=' + new Date().getTime();
            }
        });
    }

    let ccCust = document.getElementsByClassName('community-content-one-two-message-unit-tip-cust');
    for (let i = 0; i < ccCust.length; i++) {
        ccCust[i].addEventListener('click', function (e) {
            let ev = e || window.event;
            let t = ev.target || ev.srcElement;
            if (t.className == 'community-content-one-two-message-unit-tip-cust') {
                goPersonalCenter(t.dataset.custId);
            }
        });
    }
}

function renderingCommunity(e, data) {
    //定义一个元素节点
    let success = ``;
    //获得正在数据长度
    let len = data.communityList.length;
    //循环添加元素节点
    for (let i = 0; i < len; i++) {
        success += `<div class="community-search-content-center-one-community-content-unit">
                                <div class="community-search-content-center-one-community-content-img">
                                    <img src="${data.communityList[i].commPhoto}"/>
                                </div>
                                <div class="community-search-content-center-one-community-content-text">
                                    <div class="community-search-content-center-one-community-content-text-one">
                                        <span data-comm-id="${data.communityList[i].commId}" 
                                        class="community-search-content-center-one-community-content-text-one-one">
                                        ${data.communityList[i].commName}
                                        </span>
                                        <span data-cust-id="${data.communityList[i].custId}" 
                                        class="community-search-content-center-one-community-content-text-one-two">
                                            <img src="${data.communityList[i].custProfile}">
                                            ${data.communityList[i].custNick}
                                        </span>
                                    </div>
                                    <div class="community-search-content-center-one-community-content-text-two">
                                        ${data.communityList[i].commLabel}
                                    </div>
                                    <div class="community-search-content-center-one-community-content-text-three">
                                        <span class="community-search-content-center-one-community-content-text-three-one">
                                            <img src="/images/community/select.png">
                                            <span data-category-id="${data.communityList[i].categoryId}">
                                            ${data.communityList[i].categoryName}</span></span>
                                        <span class="community-search-content-center-one-community-content-text-three-two">
                                            <img src="/images/community/nav-personal.png">
                                            <span>${data.communityList[i].commPeopleCount}</span></span>
                                    </div>
                                </div>
                            </div>`;
    }

    //清除正在加载
    e.empty();
    //添加数据
    e.append(success);

    let csComm = document.getElementsByClassName
    ('community-search-content-center-one-community-content-text-one-one');
    for (let i = 0; i < csComm.length; i++) {
        csComm[i].addEventListener('click', function (e) {
            let ev = e || window.event;
            let t = ev.target || ev.srcElement;
            if (t.className == 'community-search-content-center-one-community-content-text-one-one') {
                location.href = '/view/info?commId=' + t.dataset.commId
                    + '&r=' + new Date().getTime();
            }
        });
    }

    let csCust = document.getElementsByClassName('community-search-content-center-one-community-content-text-one-two');
    for (let i = 0; i < csCust.length; i++) {
        csCust[i].addEventListener('click', function (e) {
            let ev = e || window.event;
            let t = ev.target || ev.srcElement;
            if (t.className == 'community-search-content-center-one-community-content-text-one-two') {
                goPersonalCenter(t.dataset.custId);
            }
        });
    }

    let csCategory = document.getElementsByClassName('community-search-content-center-one-community-content-text-three-one');
    for (let i = 0; i < csCategory.length; i++) {
        csCategory[i].addEventListener('click', function (e) {
            let ev = e || window.event;
            let t = ev.target || ev.srcElement;
            location.href = '/view/search?categoryId=' + t.dataset.categoryId
                + '&r=' + new Date().getTime();
        });
    }
}