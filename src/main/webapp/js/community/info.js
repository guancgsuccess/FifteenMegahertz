{
    let commInfo = {
        isJoin: 0,
        commId: 0,
        commCustId: 0
    };

    let messPageCode = 1;
    /**
     * 获得社区详情信息
     */
    {
        $ciShow = $('.community-info-top-div');

        ajax('get', '/community/get/commInfo', false, function (data) {
            if (data.status == 1) {
                loadCommInfo($ciShow, data);
            }
        });

        function join() {
            let url = '/community/join/comm/' + commInfo.commId + '/' + customer.custId;
            ajax('get', url, true, function (data) {
                if (data.status == 1) {
                    loadCommInfo($ciShow, data);
                }
            });
        }

        function exit() {
            let url = '/community/exit/comm/' + commInfo.commId + '/' + customer.custId;
            ajax('get', url, true, function (data) {
                if (data.status == 1) {
                    loadCommInfo($ciShow, data);
                }
            });
        }

        function loadCommInfo(e, data) {
            commInfo.isJoin = data.commInfo.isJoin;
            commInfo.commId = data.commInfo.commId;
            commInfo.commCustId = data.commInfo.custId;

            document.title = data.commInfo.commName;

            let success = `<div class="community-info-top-div-img">
                                    <img src="${data.commInfo.commPhoto}"/></div>
                                <div class="community-info-top-div-text">
                                    <div class="community-info-top-div-text-one">
                                        <div class="community-info-top-div-text-one-one">
                                            <span>${data.commInfo.commName}</span>`;
            if (data.commInfo.isJoin == 1) {
                success += `<a id="join-or-exit" href="javascript:void(0)">退出社区</a>`;
            } else if (data.commInfo.isJoin == 0) {
                success += `<a id="join-or-exit" href="javascript:void(0)">加入社区</a>`;
            } else {
                success += `<a id="join-or-exit" disabled="disabled" href="javascript:void(0)">无法加入</a>`;
            }

            let r = new Date().getTime() + 12213456456;

            success += `</div>
                                        <div class="community-info-top-div-text-one-two">
                                            ${data.commInfo.commLabel}
                                        </div>
                                    </div>
                                    <div class="community-info-top-div-text-two">
                                        <div>
                                            <a href="/view/search?categoryId=${data.commInfo.categoryId}&r=${r}">
                                                <img src="/images/community/community-selected.png">
                                                <span>${data.commInfo.categoryName}</span>
                                            </a>
                                        </div>
                                        <div>
                                            <a href="javascript:goPersonalCenter(${data.commInfo.custId})">
                                                <img src="/images/community/community-customer.png">
                                                <span>${data.commInfo.custNick}</span>
                                            </a>
                                        </div>
                                        <div>
                                            <img src="/images/community/community-customer-count.png">
                                            <span>${data.commInfo.commPeopleCount}</span></div>
                                        <div>
                                            <img src="/images/community/community-message-count.png">
                                            <span>${data.commInfo.commMessageCount}</span></div>
                                    </div>
                                </div>`;

            e.empty();
            e.append(success);

            let joinOrExit = document.getElementById('join-or-exit');
            joinOrExit.addEventListener('click', function (e) {
                if (joinOrExit.getAttribute('disabled') != 'disabled') {
                    if (commInfo.isJoin == 1) {
                        exit();
                    } else {
                        join();
                    }
                }
            });
        }
    }

    /**
     * 添加信息
     */
    {
        //上传文件按钮
        let uploadFileImg = document.getElementById('upload-file-img');
        //上传文件按钮展示
        let uploadFileImgShow = document.getElementById('upload-file-img-show');
        //文本编辑框
        $cnMessage = $('#community-new-message');
        let cnMessage = document.getElementById('community-new-message');
        //文本按钮
        let caMessage = document.getElementById('community-add-message');

        uploadFileImg.onchange = function (ev) {
            let filePath = uploadFileImg.files[0];
            uploadFileImgShow.parentElement.style.display = 'block';
            uploadFileImgShow.style.background =
                'url(' + window.URL.createObjectURL(filePath) + ') no-repeat center center / 100%';
        };
        uploadFileImgShow.firstElementChild.onclick = function (e) {
            uploadFileImg.value = '';
            uploadFileImgShow.parentElement.style.display = 'none';
            uploadFileImgShow.style.background = '';
        };

        $cnMessage.emoji({
            button: "#add-emoji-btn",
            showTab: false,
            animation: 'slide',
            icons: [{
                name: "贴吧表情",
                path: "/images/community/tieba/",
                maxNum: 50,
                file: ".jpg"
            }]
        });

        caMessage.onclick = function (ev) {
            let v = cnMessage.innerHTML;
            if (!(v == null || v == '')) {
                if (uploadFileImg.value == '') {
                    let formData = JSON.stringify({
                        "communityId": commInfo.commId,
                        "messContent": v
                    });
                    addMessage(formData);
                } else {
                    let file = uploadFileImg.files[0];
                    let key = getKey();
                    getUpToken(key);
                    let observable = qiniu.upload(file, key, token, putExtra, config);
                    let subscription = observable.subscribe(function (res) {
                    }, function (err) {
                    }, function (res) {
                        let formData = JSON.stringify({
                            "imagePath": 'http://img.gcc666.top/' + res.key,
                            "communityId": commInfo.commId,
                            "messContent": v
                        });
                        addMessage(formData);
                    });
                }
            }
        };

        function addMessage(formData) {
            ajaxPost('post', '/community/add/mess', false, function (data) {
                if (data.status == 1) {
                    uploadFileImg.value = '';
                    cnMessage.innerHTML = '';
                    uploadFileImgShow.parentElement.style.display = 'none';
                    let url = '/community/get/allMess/' + commInfo.commId + '/' + messPageCode;
                    loadCommMessById(url, true);
                }
            }, formData);
        }
    }

    /**
     * 分页获取留言信息
     */
    {

        $ciAllMess = $('#community-info-all-mess');
        let commentPageCode = 1;

        let url = '/community/get/allMess/' + commInfo.commId + '/' + messPageCode;
        loadCommMessById(url, false);

        function loadCommMessById(url, isAsy) {

            ajax('get', url, isAsy, function (data) {
                if (data.status == 1) {
                    loadCommMess($ciAllMess, data);
                    loadMessComment();
                    appendPage($ciAllMess, data);

                    $('.page-btn').on('click', function (e) {
                        e.stopPropagation();
                        let ev = e || window.event;
                        let target = ev.target || ev.srcElement;
                        if (target.nodeName.toLowerCase() == 'a') {
                            let v = target.dataset.pageTip;
                            let url = '/community/get/allMess/' + commInfo.commId + '/';
                            if (v < 100000) {
                                messPageCode = v;
                                url += messPageCode;
                            } else {
                                if (v == 100001) {
                                    messPageCode = 1;
                                    url += messPageCode;
                                } else if (v == 100002) {
                                    url += --messPageCode;
                                } else if (v == 100003) {
                                    url += ++messPageCode;
                                } else {
                                    messPageCode = data.totalPages;
                                    url += messPageCode;
                                }
                            }

                            let top = $('.community-info-content-edit').offset().top - 120;
                            goTop(top);
                            loadCommMessById(url, true);
                        }
                    });

                    let messImages = document.getElementsByClassName('community-info-content-content-unit-img');
                    for (let i = 0; i < messImages.length; i++) {
                        messImages[i].addEventListener('click', function (e) {
                            e.stopPropagation();
                            let ev = e || window.event;
                            let t = ev.target || ev.srcElement;
                            if (t.parentElement.dataset.click == 0) {
                                t.parentElement.setAttribute('data-click', '1');
                                t.parentElement.style.width = '88%';
                            } else {
                                t.parentElement.setAttribute('data-click', '0');
                                t.parentElement.style.width = '28%';
                            }
                        });
                    }

                    let messCusts = document.getElementsByClassName
                    ('community-info-content-content-unit-message-a');
                    for (let i = 0; i < messCusts.length; i++) {
                        messCusts[i].addEventListener('click', function (e) {
                            e.stopPropagation();
                            let ev = e || window.event;
                            let t = ev.target || ev.srcElement;
                            goPersonalCenter(t.dataset.custId);
                        });
                    }

                    let totalPage = data.totalPages;
                    let size = data.messageList.length;
                    let delMess = document.getElementsByClassName
                    ('community-info-content-content-unit-message-del');
                    for (let i = 0; i < delMess.length; i++) {
                        delMess[i].addEventListener('click', function (e) {
                            e.stopPropagation();
                            let ev = e || window.event;
                            let t = ev.target || ev.srcElement;
                            if (window.confirm('确认删除留言信息？')) {
                                let formData = JSON.stringify({"messId": t.dataset.messId});
                                ajaxPost('delete', '/community/del/mess', true, function (data) {
                                    if (data.status == 1) {
                                        let url = '';
                                        if (messPageCode == totalPage && size == 1) {
                                            url = '/community/get/allMess/' + commInfo.commId + '/'
                                                + --messPageCode;
                                        } else {
                                            url = '/community/get/allMess/' + commInfo.commId + '/'
                                                + messPageCode;
                                        }
                                        loadCommMessById(url, true);
                                    }
                                }, formData);
                            }
                        });
                    }

                    let messCommentBtn = document.getElementsByClassName
                    ('community-info-content-content-unit-message-comment-btn');
                    for (let i = 0; i < messCommentBtn.length; i++) {
                        messCommentBtn[i].addEventListener('click', function (e) {
                            e.stopPropagation();
                            let ev = e || window.event;
                            let t = ev.target || ev.srcElement;
                            if (t.innerText.length == 2) {
                                let commentEdit = document.getElementsByClassName
                                ('community-info-content-content-unit-comment-hide');
                                if (window.getComputedStyle(commentEdit[t.dataset.id]).display == 'none') {
                                    commentEdit[t.dataset.id].style.display = 'block';
                                    t.nextElementSibling.setAttribute('src', '/images/community/show.png');
                                } else {
                                    commentEdit[t.dataset.id].style.display = 'none';
                                    t.nextElementSibling.setAttribute('src', '/images/community/hide.png');
                                }
                            } else {
                                let comment = document.getElementsByClassName('community-message-all-comment');
                                if (window.getComputedStyle(comment[t.dataset.id]).display == 'none') {
                                    comment[t.dataset.id].style.display = 'block';
                                    t.nextElementSibling.setAttribute('src', '/images/community/show.png');
                                } else {
                                    comment[t.dataset.id].style.display = 'none';
                                    t.nextElementSibling.setAttribute('src', '/images/community/hide.png');
                                }
                                let commentEdit = document.getElementsByClassName
                                ('community-info-content-content-unit-comment-hide');
                                if (window.getComputedStyle(commentEdit[t.dataset.id]).display == 'block') {
                                    commentEdit[t.dataset.id].style.display = 'none';
                                    t.nextElementSibling.setAttribute('src', '/images/community/hide.png');
                                }
                            }
                        });
                    }

                    let commentInputBtn = document.getElementsByClassName
                    ('community-info-content-content-unit-comment-edit-two');
                    for (let i = 0; i < commentInputBtn.length; i++) {
                        commentInputBtn[i].addEventListener('click', function (e) {
                            e.stopPropagation();
                            let ev = e || window.event;
                            let t = ev.target || ev.srcElement;
                            let commentInput = document.getElementsByClassName
                            ('community-info-content-content-unit-comment-edit-one');

                            let v = commentInput[t.dataset.id].value;
                            if (v == null || v == '') {
                                commentInput[t.dataset.id].setAttribute('placeholder', '请输入内容再次尝试~');
                            } else {
                                let formData = JSON.stringify({
                                    "messageId": commentInput[t.dataset.id].dataset.messId,
                                    "superCommentId": commentInput[t.dataset.id].dataset.superCommentId,
                                    "commentContent": v,
                                    "custId": customer.custId
                                });

                                ajaxPost('post', '/community/add/reply', true, function (data) {
                                    if (data.status == 1) {
                                        let allComment = document.getElementsByClassName
                                        ('community-message-all-comment');
                                        let url = '/community/get/allComment/' +
                                            allComment[t.dataset.id].dataset.messId + '/' + commentPageCode;
                                        loadCommMessPage(t.dataset.id, allComment[t.dataset.id], url);
                                        let commentEdit = document.getElementsByClassName
                                        ('community-info-content-content-unit-comment-hide');
                                        commentEdit[t.dataset.id].style.display = 'none';
                                        let commentEditInput = document.getElementsByClassName
                                        ('community-info-content-content-unit-comment-edit-one');
                                        commentEditInput[t.dataset.id].value = '';
                                    }
                                }, formData);
                            }
                        });
                    }

                } else {
                    let error = `<p>暂无留言信息来发布一条新的留言信息吧~~</p>`;
                    $ciAllMess.empty();
                    $ciAllMess.append(error);
                }
            });
        }

        function loadCommMess(e, data) {

            let success = ``;
            let len = data.messageList.length;
            for (let i = 0; i < len; i++) {
                success += `<div class="community-info-content-content-unit">`;
                if (data.messageList[i].messImagePath != null) {
                    success += `<div data-click="0" class="community-info-content-content-unit-img">
                                    <img src="${data.messageList[i].messImagePath}"></div>`;
                }
                success += `<div class="community-info-content-content-unit-text">
                                   ${data.messageList[i].messContent}
                                </div>
                                <div class="community-info-content-content-unit-message">
                                    <img src="${data.messageList[i].custProfile}">
                                    <a data-cust-id="${data.messageList[i].custId}" 
                                    class="community-info-content-content-unit-message-a" 
                                    href="javascript:void(0)">${data.messageList[i].custNick}</a>
                                    <span>${data.messageList[i].messCreateTime}</span>
                                    <div>`;
                if (data.messageList[i].isOperation != 0) {
                    success += `<a class="community-info-content-content-unit-message-del"
                                data-mess-id="${data.messageList[i].messId}" href="javascript:void(0)">删除</a>`;
                }

                success += `<a href="javascript:void(0)">
                            <img src="/images/community/comment.png">`;
                if (data.messageList[i].messCommentCount != 0) {
                    success += `<span data-id="${i}" class="community-info-content-content-unit-message-comment-btn">
                                ${data.messageList[i].messCommentCount}条评论</span>
                                <img class="community-info-content-content-unit-message-special" src="/images/community/show.png">`;
                } else {
                    success += `<span data-id="${i}" class="community-info-content-content-unit-message-comment-btn">评论</span>
                                <img class="community-info-content-content-unit-message-special" src="/images/community/hide.png">`;
                }

                success += `</a>
                                    </div>
                                </div>
                                <div class="community-info-content-content-unit-comment">
                                    <div data-mess-id="${data.messageList[i].messId}" class="community-message-all-comment">`;

                success += `</div>
                                    <div class="community-info-content-content-unit-comment-hide">
                                        <div class="community-info-content-content-unit-comment-level"></div>
                                        <div class="community-info-content-content-unit-comment-edit">
                                            <input type="text" data-mess-id="${data.messageList[i].messId}"
                                             class="community-info-content-content-unit-comment-edit-one"
                                              contenteditable="true">
                                            <div class="community-info-content-content-unit-comment-edit-two">
                                            <a data-id="${i}" href="javascript:void(0)">确认</a></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="community-info-content-content-unit-level"></div>
                            </div>`;

                e.empty();
                e.append(success);
            }
        }

        function loadMessComment() {
            let allComment = document.getElementsByClassName('community-message-all-comment');

            for (let i = 0; i < allComment.length; i++) {
                getMessComment(i, allComment[i], allComment[i].dataset.messId);
            }
        }

        function getMessComment(flag, e, messId) {

            let url = '/community/get/allComment/' + messId + '/' + 1;
            loadCommMessPage(flag, e, url);
        }

        function loadCommMessPage(flag, e, url) {
            ajax('get', url, true, function (data) {
                    if (data.status == 1) {

                        let success = ``;
                        let len = data.commentList.length;
                        for (let i = 0; i < len; i++) {
                            success += `<div class="community-info-content-content-unit-comment-unit">
                                        <div class="community-info-content-content-unit-comment-unit-one">
                                            <i>
                                                <img src="${data.commentList[i].custProfile}">
                                                <a class="comment-message-customer" 
                                                data-cust-id="${data.commentList[i].custId}" 
                                                href="javascript:void(0)">${data.commentList[i].custNick}</a>`;
                            if (data.commentList[i].superCustId != null) {
                                success += `<em>回复</em>
                                            <a class="comment-message-super-customer" 
                                            data-super-cust-id="${data.commentList[i].superCustId}"
                                             href="javascript:void(0)">${data.commentList[i].superCustNick}
                                             </a>`;
                            }

                            success += `</i>
                                            <span>
                                            ${data.commentList[i].commentContent}
                                        </span>
                                        </div>
                                        <div class="community-info-content-content-unit-comment-unit-two">
                                            <span>${data.commentList[i].commentContentCreateTime}</span>
                                            <a class="community-info-content-content-unit-comment-unit-two-reply"
                                            data-comment-id="${data.commentList[i].commentId}" data-id="${flag}" 
                                            data-cust-nick="${data.commentList[i].custNick}" 
                                            href="javascript:void(0)">回复</a>
                                        </div>
                                    </div>`;
                        }

                        success += `<div class="community-info-content-content-unit-comment-page">
                                        <div class="community-info-content-content-unit-comment-page-one">
                                            <a class="community-info-content-content-unit-comment-page-comment-btn"
                                             data-id="${flag}" href="javascript:void(0)">评论</a>
                                        </div>`;
                        if (!(data.isFirstPage == 1 && data.isLastPage == 1)) {
                            success += `<div class="community-info-content-content-unit-comment-page-two">`;

                            if (data.isFirstPage == 1) {
                                success += `<span><img src="/images/community/first-1.png"></span>
                                <span><img src="/images/community/left-1.png"></span>`;

                            } else {
                                success += `<a data-page-tip="100001" data-id="${flag}" class="comment-page-btn" 
                                href="javascript:void(0)"><img src="/images/community/first-1.png"></a>
                                 <a data-page-tip="100002" data-id="${flag}" class="comment-page-btn" 
                                 href="javascript:void(0)"><img src="/images/community/left-1.png"></a>`;
                            }

                            if (data.totalPages <= 5) {
                                for (let i = 1; i <= data.totalPages; i++) {
                                    if (i == data.currentPage) {
                                        success += `<span class="comment-current-page">${i}</span>`;
                                    } else {
                                        success += `<a data-page-tip="${i}" data-id="${flag}" 
                                        class="comment-page-btn" href="javascript:void(0)">${i}</a>`;
                                    }
                                }
                            } else {
                                if (data.currentPage < 5) {//当前页小于5，加载1-5页
                                    for (let i = 1; i <= 5; i++) {
                                        if (i == data.currentPage) {
                                            success += `<span class="comment-current-page">${i}</span>`;
                                        } else {
                                            success += `<a data-page-tip="${i}" data-id="${flag}" 
                                            class="comment-page-btn" href="javascript:void(0)">${i}</a>`;
                                        }
                                    }
                                    if (data.currentPage <= data.totalPages - 2) {//最后一页追加“...”代表省略的页
                                        success += `<span>...</span>`;
                                    }
                                } else if (data.currentPage >= 5) {//当前页大于5页
                                    for (let i = 1; i <= 2; i++) {//1,2页码始终显示
                                        success += `<a data-page-tip="${i}" data-id="${flag}" 
                                        class="comment-page-btn" href="javascript:void(0)">${i}</a>`;
                                    }
                                    success += `<span>...</span>`;//2页码后面用...代替部分未显示的页码
                                    if (data.currentPage + 1 == data.totalPages) {//当前页+1等于总页码
                                        for (let i = data.currentPage - 1; i <= data.totalPages; i++) {//“...”后面跟三个页码当前页居中显示
                                            if (i == data.currentPage) {
                                                success += `<span class="comment-current-page">${i}</span>`;
                                            } else {
                                                success += `<a data-page-tip="${i}" data-id="${flag}" 
                                                class="comment-page-btn" href="javascript:void(0)">${i}</a>`;
                                            }
                                        }
                                    } else if (data.currentPage == data.totalPages) {//当前页数等于总页数则是最后一页页码显示在最后
                                        for (let i = data.currentPage - 2; i <= data.totalPages; i++) {//...后面跟三个页码当前页居中显示
                                            if (i == data.currentPage) {
                                                success += `<span class="comment-current-page">${i}</span>`;
                                            } else {
                                                success += `<a data-page-tip="${i}" data-id="${flag}" 
                                                class="comment-page-btn" href="javascript:void(0)">${i}</a>`;
                                            }
                                        }
                                    } else {//当前页小于总页数，则最后一页后面跟...
                                        for (i = data.currentPage - 1; i <= data.currentPage + 1; i++) {//dqPage+1页后面...
                                            if (i == data.currentPage) {
                                                success += `<span class="comment-current-page">${i}</span>`;
                                            } else {
                                                success += `<a data-page-tip="${i}" data-id="${flag}" 
                                                class="comment-page-btn" href="javascript:void(0)">${i}</a>`;
                                            }
                                        }
                                        success += `<span>...</span>`;
                                    }
                                }
                            }

                            if (data.isLastPage == 1) {
                                success += `<span><img src="/images/community/right-1.png"></span>
                                <span><img src="/images/community/last-1.png"></span>`;
                            } else {
                                success += `<a data-page-tip="100003" data-id="${flag}" class="comment-page-btn" 
                                href="javascript:void(0)"><img src="/images/community/right-1.png"></a>
                                <a data-page-tip="100004" data-id="${flag}" class="comment-page-btn" 
                                href="javascript:void(0)"><img src="/images/community/last-1.png"></a>`;
                            }

                            success += `<span>共${data.totalPages}页</span>
                            </div>`;
                        }
                        success += `</div>`;

                        e.innerHTML = '';
                        e.innerHTML = success;

                        let customer = document.getElementsByClassName('comment-message-customer');
                        for (let i = 0; i < customer.length; i++) {
                            customer[i].addEventListener('click', function (e) {
                                e.stopPropagation();
                                let ev = e || window.event;
                                let t = ev.target || ev.srcElement;
                                goPersonalCenter(t.dataset.custId);
                            });
                        }

                        let superCustomer = document.getElementsByClassName('comment-message-super-customer');
                        for (let i = 0; i < superCustomer.length; i++) {
                            superCustomer[i].addEventListener('click', function (e) {
                                e.stopPropagation();
                                let ev = e || window.event;
                                let t = ev.target || ev.srcElement;
                                goPersonalCenter(t.dataset.superCustId);
                            });
                        }

                        let reply = document.getElementsByClassName
                        ('community-info-content-content-unit-comment-unit-two-reply');
                        for (let i = 0; i < reply.length; i++) {
                            reply[i].addEventListener('click', function (e) {
                                e.stopPropagation();
                                let ev = e || window.event;
                                let t = ev.target || ev.srcElement;
                                let commentEdit = document.getElementsByClassName
                                ('community-info-content-content-unit-comment-hide');
                                let commentEditInput = document.getElementsByClassName
                                ('community-info-content-content-unit-comment-edit-one');
                                commentEdit[t.dataset.id].style.display = 'block';
                                commentEditInput[t.dataset.id].setAttribute
                                ('data-super-comment-id', t.dataset.commentId);
                                commentEditInput[t.dataset.id].setAttribute
                                ('placeholder', '回复：' + t.dataset.custNick);
                            });
                        }

                        let comment = document.getElementsByClassName
                        ('community-info-content-content-unit-comment-page-comment-btn');
                        for (let i = 0; i < comment.length; i++) {
                            comment[i].removeEventListener('click', function (e) {

                            });
                            comment[i].addEventListener('click', function (e) {
                                e.stopPropagation();
                                let ev = e || window.event;
                                let t = ev.target || ev.srcElement;
                                let commentEdit = document.getElementsByClassName
                                ('community-info-content-content-unit-comment-hide');
                                let commentEditInput = document.getElementsByClassName
                                ('community-info-content-content-unit-comment-edit-one');
                                commentEdit[t.dataset.id].style.display = 'block';
                                commentEditInput[t.dataset.id].setAttribute
                                ('data-super-comment-id', '');
                                commentEditInput[t.dataset.id].setAttribute
                                ('placeholder', '');

                            });
                        }

                        let commentPageBtn = document.getElementsByClassName('comment-page-btn');
                        for (let i = 0; i < commentPageBtn.length; i++) {
                            commentPageBtn[i].addEventListener('click', function (e) {
                                e.stopPropagation();
                                let ev = e || window.event;
                                let t = ev.target || ev.srcElement;
                                if (t.tagName == 'IMG')
                                    t = t.parentElement;
                                let allComment = document.getElementsByClassName
                                ('community-message-all-comment');

                                let v = t.dataset.pageTip;
                                let url = '/community/get/allComment/' +
                                    allComment[t.dataset.id].dataset.messId + '/';
                                if (v < 100000) {
                                    commentPageCode = v;
                                    url += commentPageCode;
                                } else {
                                    if (v == 100001) {
                                        commentPageCode = 1;
                                        url += commentPageCode;
                                    } else if (v == 100002) {
                                        commentPageCode = data.currentPage - 1;
                                        url += commentPageCode;
                                    } else if (v == 100003) {
                                        commentPageCode = data.currentPage + 1;
                                        url += commentPageCode;
                                    } else {
                                        commentPageCode = data.totalPages;
                                        url += commentPageCode;
                                    }
                                }

                                loadCommMessPage(t.dataset.id, allComment[t.dataset.id], url);
                            });
                        }
                    }
                }
            );
        }
    }
}