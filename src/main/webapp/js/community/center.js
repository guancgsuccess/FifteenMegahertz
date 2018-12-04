{
    //新建社区拟态框
    let cnCommunity = document.getElementById('center-new-community');
    //图片剪辑拟态框
    let imgCrop = document.getElementById('img-crop');

    /**
     * 新建社区拟态框
     */
    {
        //新建按钮
        let cnCommunityBtn = document.getElementById('center-new-community-btn');
        //新建拟态内容部分
        let cnCommunityContent = document.getElementById('center-new-community-content');
        //社区名
        let cnCommunityName = document.getElementById('center-new-community-name');
        //选择类别
        let cnCommunitySelect = document.getElementById('center-new-community-select');
        //类别隐藏部分渲染而出
        let cnCommunitySelectHide = document.getElementById('center-new-community-select-hide');
        //社区简介
        let cnCommunityLabel = document.getElementById('center-new-community-label');
        //验证码
        let cnCommunityVCode = document.getElementById('v-code');
        //确认新建社区按钮
        let cnConfirmCommunityBtn = document.getElementById('community-new-community-btn');
        //取消新建社区按钮
        let cnClearCommunityBtn = document.getElementById('community-clear-community-btn');
        //头像部分
        //选择图片按钮
        let sPortrait = document.getElementById('select-portrait');
        //再次选择图片按钮
        let sPortraitAgain = document.getElementById('select-portrait-again');
        //显示图片控件
        $image = $('#image');
        //显示图片控件
        let image = document.getElementById('image');
        //获得剪裁过后头像按钮
        let getImgBtn = document.getElementById('get-new-image');
        //剪裁过后展示框
        let imgShow = document.getElementById('img-show');
        //特殊提示span
        let specialV = document.getElementById('select-portrait-v');

        cnCommunitySelect.onclick = function (ev) {
            ev.stopPropagation();
            ajax('get', '/image/category/get/list', true, function (data) {
                let success = ``;
                for (let i = 0; i < data.data.categoryInfo.length; i++) {
                    if (i != data.length - 1) {
                        success += `<div data-category-id="${data.data.categoryInfo[i].categoryId}"
                                    class="center-new-community-category">${data.data.categoryInfo[i].categoryName}</div>`;
                    } else {
                        success += `<div data-category-id="${data.data.categoryInfo[i].categoryId}"
                                    class="center-new-community-category 
                                    center-new-community-content-two-one-two-two-hide-last">
                                    ${data.data.categoryInfo[i].categoryName}</div>`;
                    }
                }

                cnCommunitySelectHide.innerHTML = '';
                cnCommunitySelectHide.innerHTML = success;
                cnCommunitySelectHide.style.display = 'block';

                $('.center-new-community-category').on('click', function (e) {
                    let ev = e || window.event;
                    let t = ev.target || ev.srcElement;
                    cnCommunitySelect.setAttribute('data-category-id', t.dataset.categoryId);
                    cnCommunitySelectHide.style.display = 'none';
                    cnCommunitySelect.innerText = t.innerText;
                });
            });
        };
        cnCommunityContent.onclick = function (ev) {
            ev.stopPropagation();
            if (window.getComputedStyle(cnCommunitySelectHide).display == 'block') {
                cnCommunitySelectHide.style.display = 'none';
            }
        };
        cnCommunity.onclick = function (ev) {
            ev.stopPropagation();
            if (window.getComputedStyle(imgCrop).display == 'block') {
                imgCrop.style.display = 'none';
            } else {
                cnCommunity.style.display = 'none';
            }
        };
        cnCommunityBtn.onclick = function (ev) {
            ev.stopPropagation();
            cnCommunity.style.position = 'absolute';
            cnCommunity.style.display = 'block';
        };

        /**
         * 生成验证码
         */
        let verifyCode = new GVerify("v-code-container");

        /**
         * 在线图片剪辑
         */
        {
            getImgBtn.onclick = function (ev) {
                ev.stopPropagation();
                let canvas = $image.cropper('getCroppedCanvas');
                let file = canvas.toDataURL('image/jpeg');
                imgCrop.style.display = 'none';
                imgShow.firstElementChild.innerHTML = `<img src="${file}" width="100%">`;
            };
            sPortrait.onchange = function (ev) {
                let filePath = sPortrait.files[0];
                sPortrait.value = '';
                image.src = window.URL.createObjectURL(filePath);
                imgCrop.style.display = 'block';
                $image.cropper('replace', window.URL.createObjectURL(filePath), false);
            };
            sPortraitAgain.onchange = function (ev) {
                let filePath = sPortraitAgain.files[0];
                image.src = window.URL.createObjectURL(filePath);
                $image.cropper('replace', window.URL.createObjectURL(filePath), false);
            };
            $image.cropper({
                aspectRatio: 1 / 1,//默认比例
                preview: '.preview-one',//预览视图
                viewMode: 1,  //不允许移动
                autoCropArea: 0.8,  //0-1之间的数值，定义自动剪裁区域的大小，默认0.8
                dragCrop: false,  //是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域
                resizable: true,  //是否允许改变裁剪框的大小
                zoomable: false,  //是否允许缩放图片大小
                mouseWheelZoom: false,  //是否允许通过鼠标滚轮来缩放图片
                touchDragZoom: false,  //是否允许通过触摸移动来缩放图片
                rotatable: false,  //是否允许旋转图片
                crop: function (e) {
                    // 输出结果数据裁剪图像。
                }
            });

            function convertBase64UrlToBlob(urlData) {

                let bytes = window.atob(urlData.split(',')[1]);        //去掉url的头，并转换为byte
                let ab = new ArrayBuffer(bytes.length);
                let ia = new Uint8Array(ab);
                for (let i = 0; i < bytes.length; i++) {
                    ia[i] = bytes.charCodeAt(i);
                }
                return new Blob([ab], {type: 'image/jpeg'});
            }
        }

        /**
         * 验证表单
         */
        {
            cnCommunityName.onchange = function (ev) {
                vCommunityName();
            };
            cnCommunityLabel.onblur = function (ev) {
                vCommunityLabel();
            };
            cnCommunityVCode.onchange = function (ev) {
                vCommunityVCode();
            };

            function vCommunityName() {
                if (cnCommunityName.value == null || cnCommunityName.value == '') {
                    cnCommunityName.nextElementSibling.style.display = 'inline';
                    return false;
                } else {
                    let url = '/community/get/presence/' + cnCommunityName.value;
                    let flag = false;
                    ajax('get', url, false, function (data) {
                        if (data.status == 1) {
                            cnCommunityName.nextElementSibling.style.display = 'inline';
                            flag = false;
                        } else {
                            cnCommunityName.nextElementSibling.style.display = 'none';
                            flag = true;
                        }
                    });
                    return flag;
                }
            }

            function vCommunitySelect() {
                if (cnCommunitySelect.innerText == null || cnCommunitySelect.innerText == '选择') {
                    cnCommunitySelect.nextElementSibling.nextElementSibling.style.display = 'inline';
                    return false;
                } else {
                    cnCommunitySelect.nextElementSibling.nextElementSibling.style.display = 'none';
                    return true;
                }
            }

            function vPortrait() {
                if (imgShow.firstElementChild.firstElementChild == null) {
                    specialV.style.display = 'inline';
                    return false;
                } else {
                    specialV.style.display = 'none';
                    return true;
                }
            }

            function vCommunityLabel() {
                if (cnCommunityLabel.innerText == null || cnCommunityLabel.innerText == '') {
                    cnCommunityLabel.nextElementSibling.style.display = 'inline';
                    return false;
                } else {
                    cnCommunityLabel.nextElementSibling.style.display = 'none';
                    return true;
                }
            }

            function vCommunityVCode() {
                if (verifyCode.validate(cnCommunityVCode.value)) {
                    cnCommunityVCode.nextElementSibling.style.display = 'none';
                    return true;
                } else {
                    cnCommunityVCode.nextElementSibling.style.display = 'inline';
                    return false;
                }
            }
        }

        //确认提交
        cnConfirmCommunityBtn.onclick = function (ev) {
            if (vCommunityName() && vCommunitySelect() && vPortrait() && vCommunityLabel() && vCommunityVCode()) {
                let canvas = $image.cropper('getCroppedCanvas');
                let fileBase64 = canvas.toDataURL('image/jpeg');
                let file = convertBase64UrlToBlob(fileBase64);
                let key = getKey();
                getUpToken(key);
                let observable = qiniu.upload(file, key, token, putExtra, config);
                let subscription = observable.subscribe(function (res) {
                }, function (err) {
                }, function (res) {
                    let formData = JSON.stringify({
                        "communityName": cnCommunityName.value,
                        "categoryId": cnCommunitySelect.dataset.categoryId,
                        "communityLabel": cnCommunityLabel.innerText,
                        "communityPhoto": 'http://img.gcc666.top/' + res.key,
                    });
                    ajaxPost('post', '/community/add/comm', false, function (data) {
                        if (data.status == 1) {
                            clear();
                            let url = '/community/get/myComm/1';
                            loadMyCommunity(url);
                        }
                    }, formData);
                });
            }
        };
        //取消提交
        cnClearCommunityBtn.onclick = function (ev) {
            clear();
        };

        function clear() {
            cnCommunityName.nextElementSibling.style.display = 'none';
            cnCommunitySelect.nextElementSibling.nextElementSibling.style.display = 'none';
            specialV.style.display = 'none';
            cnCommunityLabel.nextElementSibling.style.display = 'none';
            cnCommunityVCode.nextElementSibling.style.display = 'none';
            cnCommunityName.value = '';
            cnCommunitySelect.innerText = '选择';
            imgShow.firstElementChild.innerHTML = '';
            cnCommunityLabel.innerText = '';
            sPortrait.value = '';
            cnCommunityVCode.value = '';
            cnCommunity.style.display = 'none';
        }
    }

    /**
     * 左边导航
     */
    {
        let ccJoin = document.getElementById('community-center-join');
        let ccMessage = document.getElementById('community-center-message');
        let ccActivity = document.getElementById('community-center-activity');
        let ccSetting = document.getElementById('community-center-setting');
        let ccMyCommunity = document.getElementById('community-center-my-community');
        let ccMyBulletin = document.getElementById('community-center-my-bulletin');
        let ccMyActivity = document.getElementById('community-center-my-activity');

        let ccJoinInfo = document.getElementById('community-center-join-info');
        let ccMessageInfo = document.getElementById('community-center-message-info');
        let ccActivityInfo = document.getElementById('community-center-activity-info');
        let ccSettingInfo = document.getElementById('community-center-join-setting');
        let ccMyCommunityInfo = document.getElementById('community-center-my-community-info');
        let ccMyBulletinInfo = document.getElementById('community-center-my-bulletin-info');
        let ccMyActivityInfo = document.getElementById('community-center-my-activity-info');

        ccJoin.onclick = function (ev) {
            goTop(ccJoinInfo.offsetTop - 20);
        };
        ccMessage.onclick = function (ev) {
            goTop(ccMessageInfo.offsetTop - 20);
        };
        ccActivity.onclick = function (ev) {
            goTop(ccActivityInfo.offsetTop - 20);
        };
        ccSetting.onclick = function (ev) {
            goTop(ccSettingInfo.offsetTop - 20);
        };
        ccMyCommunity.onclick = function (ev) {
            goTop(ccMyCommunityInfo.offsetTop - 20);
        };
        ccMyBulletin.onclick = function (ev) {
            goTop(ccMyBulletinInfo.offsetTop - 20);
        };
        ccMyActivity.onclick = function (ev) {
            goTop(ccMyActivityInfo.offsetTop - 20);
        };

        let ccLeft = document.getElementById('community-center-one');
        let eTop = ccLeft.offsetTop;
        let ccWidth = ccLeft.offsetWidth;
        window.addEventListener("scroll", function (e) {
            let top = document.documentElement.scrollTop || document.body.scrollTop;
            cnCommunity.style.top = top + 'px';
            if (top > eTop) {
                ccLeft.className = 'community-center-one-fixed';
                ccLeft.style.width = ccWidth + 'px';
            } else {
                ccLeft.className = '';
            }
        });
    }

    /**
     * 数据渲染
     */
    {
        /**
         * 我的留言
         */
        {
            let cMyMessage = document.getElementById('center-my-message');
            let cMyMessagePage = document.getElementById('center-my-message-page');

            let url = '/community/get/myMess/1';
            loadMyMessage(url);

            function loadMyMessage(url) {
                ajax('get', url, true, function (data) {
                    if (data.status == 1) {
                        let success = ` <table id="center-my-message" class="table">
                                    <tr>
                                        <th class="community-center-table-two-one">社区</th>
                                        <th class="community-center-table-two-two">留言</th>
                                        <th class="community-center-table-one-three">时间</th>
                                        <th class="community-center-table-two-three">状态</th>
                                        <th class="community-center-table-one-four">查看</th>
                                    </tr>`;
                        for (let i = 0; i < data.messageList.length; i++) {
                            let r = new Date().getTime() - 1000000000;
                            success += `<tr>
                                        <td>${data.messageList[i].commName}</td>
                                        <td>${data.messageList[i].messContent}</td>
                                        <td>${data.messageList[i].messCreateTime}</td>`;
                            if (data.messageList[i].messStatus == 1) {
                                success += `<td>正常</td>`;
                            } else {
                                success += `<td>已删除</td>`;
                            }
                            success += `<td><a href="/view/info?commId=${data.messageList[i].commId}&r=${r}">查看</a></td>
                                    </tr>`;
                        }

                        success += `</table>`;

                        cMyMessage.innerHTML = '';
                        cMyMessage.innerHTML = success;

                        let className = 'my-message-page-btn';
                        appendCenterPage(cMyMessagePage, className, data);

                        let url = '/community/get/myMess/';
                        pageBtnAddEvent(className, url, data, function (url) {
                            loadMyMessage(url);
                        });
                    }
                });
            }
        }

        /**
         * 我的社区
         */
        {
            let cMyCommunity = document.getElementById('accordion');

            let url = '/community/get/myComm/1';
            loadMyCommunity(url);

            function loadMyCommunity(url) {
                ajax('get', url, true, function (data) {
                    if (data.status == 1) {
                        let success = ``;

                        for (let i = 0; i < data.communityList.length; i++) {
                            success += `<div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">
                                                    <a data-id="${i}" data-comm-id="${data.communityList[i].commId}"
                                                      class="center-community-btn" data-toggle="collapse"
                                                       data-parent="#accordion" href="#center${i}">
                                                        ${data.communityList[i].commName}
                                                    </a>
                                                    <a data-comm-id="${data.communityList[i].commId}" 
                                                    class="community-center-two-content-community-delete" 
                                                    href="javascript:void(0)">删除</a>
                                                </h4>
                                            </div>
                                            <div id="center${i}" class="panel-collapse collapse">
                                                <div class="panel-body">
                                                    <table class="table center-community-members-table
                                                     community-center-two-content-community-table">
                                                    </table>
                                                    <div class="center-community-members-page
                                                     community-info-content-content-unit-comment-page-two">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>`;
                        }

                        cMyCommunity.innerHTML = '';
                        cMyCommunity.innerHTML = success;

                        $('.center-community-btn').on('click', function (e) {
                            let ev = e || window.event;
                            let t = ev.target || ev.srcElement;
                            let url = '/community/get/commCust/' + t.dataset.commId + '/1';
                            let ccMembers = document.getElementsByClassName('center-community-members-table');
                            let ccMembersPage = document.getElementsByClassName('center-community-members-page');
                            loadCommunityMembers(t.dataset.id, ccMembers[t.dataset.id], ccMembersPage[t.dataset.id], url);
                        });

                        $('.community-center-two-content-community-delete').on('click', function (e) {
                            let ev = e || window.event;
                            let t = ev.target || ev.srcElement;
                            if (window.confirm('确认删除该社区？')) {
                                let url = '/community/del/myComm/' + t.dataset.commId;
                                ajax('get', url, true, function (data) {
                                    if (data.status == 1) {
                                        loadMyCommunity('/community/get/myComm/1');
                                    }
                                });
                            }
                        });
                    }
                });
            }

            function loadCommunityMembers(flag, e, pageE, url) {
                ajax('get', url, true, function (data) {
                    if (data.status == 1) {
                        let success = `<tr>
                                            <th class="community-center-table-four-one">昵称</th>
                                            <th class="community-center-table-four-two">简介</th>
                                            <th class="community-center-table-four-three">操作</th>
                                        </tr>`;
                        for (let i = 0; i < data.membersList.length; i++) {
                            success += `<tr>
                                            <td>${data.membersList[i].custNick}</td>
                                            <td>${data.membersList[i].custIntro}</td>`;
                            if (data.membersList[i].custStatus == 1) {
                                success += `<td><a class="center-update-status"
                                                data-comm-id="${data.membersList[i].commId}"
                                                data-cust-id="${data.membersList[i].custId}" 
                                                data-tip="0"
                                                href="javascript:void(0)">拉黑</a></td>`;
                            } else {
                                success += `<td><a class="center-update-status" 
                                                data-comm-id="${data.membersList[i].commId}"
                                                data-cust-id="${data.membersList[i].custId}" 
                                                data-tip="1"
                                                href="javascript:void(0)">解除</a></td>`;
                            }
                            success += `</tr>`;
                        }

                        e.innerHTML = '';
                        e.innerHTML = success;

                        let currentPage = data.currentPage;
                        $('.center-update-status').on('click', function (event) {
                            event.stopPropagation();
                            let ev = event || window.event;
                            let t = ev.target || ev.srcElement;

                            let url = '/community/upd/custStatus/' + t.dataset.commId + '/' + t.dataset.custId + '/' + t.dataset.tip;
                            ajax('get', url, true, function (data) {
                                if (data.status == 1) {
                                    let url = '/community/get/commCust/' + t.dataset.commId + '/' + currentPage;
                                    loadCommunityMembers(flag, e, pageE, url);
                                }
                            });
                        });

                        let className = 'my-community-page-btn' + flag;
                        appendCenterPage(pageE, className, data);

                        let url = '/community/get/commCust/' + data.membersList[0].commId + '/';
                        pageBtnAddEvent(className, url, data, function (url) {
                            loadCommunityMembers(flag, e, pageE, url);
                        });
                    }
                });
            }
        }

        function pageBtnAddEvent(className, url, data, refresh) {
            $('.' + className).on('click', function (e) {
                e.stopPropagation();
                let ev = e || window.event;
                let t = ev.target || ev.srcElement;
                if (t.tagName == 'IMG')
                    t = t.parentElement;

                let v = t.dataset.pageTip;
                if (v < 100000) {
                    url += v;
                } else {
                    if (v == 100001) {
                        url += 1;
                    } else if (v == 100002) {
                        url += data.currentPage - 1;
                    } else if (v == 100003) {
                        url += data.currentPage + 1;
                    } else {
                        url += data.totalPages;
                    }
                }
                refresh(url);
            });
        }

        function appendCenterPage(e, className, data) {
            let page = ``;

            if (data.isFirstPage == 1) {
                page += `<span><img src="/images/community/first-1.png"></span>
                                <span><img src="/images/community/left-1.png"></span>`;

            } else {
                page += `<a data-page-tip="100001" class="${className}"
                         href="javascript:void(0)"><img src="/images/community/first-1.png"></a>
                         <a data-page-tip="100002" class="${className}"
                          href="javascript:void(0)"><img src="/images/community/left-1.png"></a>`;
            }

            if (data.totalPages <= 5) {
                for (let i = 1; i <= data.totalPages; i++) {
                    if (i == data.currentPage) {
                        page += `<span class="center-current-page">${i}</span>`;
                    } else {
                        page += `<a data-page-tip="${i}" class="${className}"
                                href="javascript:void(0)">${i}</a>`;
                    }
                }
            } else {
                if (data.currentPage < 5) {//当前页小于5，加载1-5页
                    for (let i = 1; i <= 5; i++) {
                        if (i == data.currentPage) {
                            page += `<span class="center-current-page">${i}</span>`;
                        } else {
                            page += `<a data-page-tip="${i}" class="${className}"
                                     href="javascript:void(0)">${i}</a>`;
                        }
                    }
                    if (data.currentPage <= data.totalPages - 2) {//最后一页追加“...”代表省略的页
                        page += `<span>...</span>`;
                    }
                } else if (data.currentPage >= 5) {//当前页大于5页
                    for (let i = 1; i <= 2; i++) {//1,2页码始终显示
                        page += `<a data-page-tip="${i}" class="${className}"
                                    href="javascript:void(0)">${i}</a>`;
                    }
                    page += `<span>...</span>`;//2页码后面用...代替部分未显示的页码
                    if (data.currentPage + 1 == data.totalPages) {//当前页+1等于总页码
                        //“...”后面跟三个页码当前页居中显示
                        for (let i = data.currentPage - 1; i <= data.totalPages; i++) {
                            if (i == data.currentPage) {
                                page += `<span class="center-current-page">${i}</span>`;
                            } else {
                                page += `<a data-page-tip="${i}" class="${className}"
                                            href="javascript:void(0)">${i}</a>`;
                            }
                        }
                        //当前页数等于总页数则是最后一页页码显示在最后
                    } else if (data.currentPage == data.totalPages) {
                        //...后面跟三个页码当前页居中显示
                        for (let i = data.currentPage - 2; i <= data.totalPages; i++) {
                            if (i == data.currentPage) {
                                page += `<span class="center-current-page">${i}</span>`;
                            } else {
                                page += `<a data-page-tip="${i}" class="${className}"
                                            href="javascript:void(0)">${i}</a>`;
                            }
                        }
                    } else {//当前页小于总页数，则最后一页后面跟...
                        for (let i = data.currentPage - 1; i <= data.currentPage + 1; i++) {//dqPage+1页后面...
                            if (i == data.currentPage) {
                                page += `<span class="center-current-page">${i}</span>`;
                            } else {
                                page += `<a data-page-tip="${i}" class="${className}"
                                href="javascript:void(0)">${i}</a>`;
                            }
                        }
                        page += `<span>...</span>`;
                    }
                }
            }

            if (data.isLastPage == 1) {
                page += `<span><img src="/images/community/right-1.png"></span>
                                <span><img src="/images/community/last-1.png"></span>`;
            } else {
                page += `<a data-page-tip="100003" class="${className}" href="javascript:void(0)">
                                <img src="/images/community/right-1.png"></a>
                                <a data-page-tip="100004" class="${className}" href="javascript:void(0)">
                                <img src="/images/community/last-1.png"></a>`;
            }

            page += `<span>共${data.totalPages}页</span>`;

            e.innerHTML = '';
            e.innerHTML = page;
        }
    }
}