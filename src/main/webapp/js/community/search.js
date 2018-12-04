{

    //搜索所得内容
    let searchContext = {
        //状态
        flag: 0,
        //关键字
        context: null,
        //社区列表
        communityList: null,
        //社区信息列表
        messageList: null
    };

    $csCondition = $('.community-search-content-top-two > div');
    $csSearchCommunity = $('.community-search-content-center-one-community');
    $csSearchMessage = $('.community-search-content-center-one-message');
    $csSearchLoading = $('.community-search-content-center-one-loading');
    $csSearchTip = $('.community-search-content-center-one-tip');

    $csCommunity = $('.community-search-content-center-one-community-content');
    $csMessage = $('.community-content-one-two-message');

    let flag = 0;
    $csCondition.click(function (e) {
        e.stopPropagation();
        $csSearchTip.hide();
        $csSearchCommunity.hide();
        $csSearchMessage.hide();
        flag = $(this).index();
        $csCondition.eq(flag).addClass('community-search-content-top-two-special')
            .siblings().removeClass('community-search-content-top-two-special');
        switch (flag) {
            case 0:
                if (searchContext.communityList == null && searchContext.messageList == null) {
                    $csSearchTip.show();
                } else {
                    if (searchContext.communityList != null) {
                        $csSearchCommunity.show();
                    }
                    if (searchContext.messageList != null) {
                        $csSearchMessage.show();
                    }
                }
                break;
            case 1:
                if (searchContext.communityList != null) {
                    $csSearchCommunity.show();
                } else {
                    $csSearchTip.show();
                }
                break;
            case 2:
                if (searchContext.messageList != null) {
                    $csSearchMessage.show();
                } else {
                    $csSearchTip.show();
                }
                break;
        }
    });


    let url = '/community/get/context';
    //首次加载
    getSearchContext(url, false);

    function getSearchContext(url, isAsy) {
        $csCommunity.empty();
        $csMessage.empty();
        $csSearchLoading.show();
        $csSearchTip.hide();
        $csSearchCommunity.hide();
        $csSearchMessage.hide();
        ajax('get', url, isAsy, function (data) {
            if (data.status == 1) {
                searchContext.flag = data.flag;
                searchContext.context = data.context;
                searchContext.communityList = data.communityList;
                searchContext.messageList = data.messageList;
                if (data.communityList == null && data.messageList == null) {
                    $csSearchTip.show();
                } else {
                    if (data.communityList != null && flag != 2) {
                        $csSearchCommunity.show();
                    }
                    if (data.messageList != null && flag != 1) {
                        $csSearchMessage.show();
                    }
                }
                if (data.communityList != null) {
                    renderingCommunity($csCommunity, searchContext);
                }
                if (data.messageList != null) {
                    renderingMessage($csMessage, searchContext);
                }
                $csSearchLoading.hide();
            } else {
                $csSearchLoading.hide();
                $csSearchTip.show();
            }
        });
    }

    /**
     * 搜索主输入框
     */
    {
        //搜索输入框
        $csSearchInput = $('.community-search-content-top-one-two-one > input');
        //搜索按钮
        $csSearchBtn = $('.community-search-content-top-one-three > a');
        //历史记录
        $crHistory = $('.community-search-content-top-one-two-two');
        //历史记录数据展示部分
        $crHistoryShow = $('#community-search-history');

        if (searchContext.flag != 0) {
            $csSearchInput.val(searchContext.context);
        }
        $csSearchInput.keydown(function (e) {
            if (e.keyCode == 13) {
                search();
            }
        });
        $csSearchInput.focus(function (e) {
            loadingHistory();
        });
        $csSearchInput.click(function (e) {
            e.stopPropagation();
        });


        function loadingHistory() {
            let cookies = getCookie();
            let len = cookies.length;
            let show = ``;
            if (len != 0) {
                for (let i = 0; i < len; i++) {
                    show += `<li data-history="${cookies[i]}" class="community-search-history-li">
                                <img src="/images/community/history.png"/>
                                <span>${cookies[i]}</span>
                                <i><img class="community-search-history-li-i-img"
                                 src="/images/community/delete.png"></i>
                            </li>`;
                }

                $crHistoryShow.empty();

                if ($crHistory.css('display') == 'none')
                    $crHistory.show();

                $crHistoryShow.append(show);

                $('.community-search-history-li').on('click', function (e) {
                    e.stopPropagation();
                    let v = $('.community-search-history-li').eq($(this).index()).data().history;
                    $csSearchInput.val(v);
                    $crHistory.hide();
                });

                $('.community-search-history-li-i-img').on('click', function (e) {
                    e.stopPropagation();
                    let v = $('.community-search-history-li').eq($(this).index()).data().history;
                    deCookie(v);
                    loadingHistory();
                });
            }else{
                $crHistory.hide();
            }
        }

        $csSearchBtn.click(function (e) {
            search();
        });

        function search() {
            let url = '';
            let value = $csSearchInput.val();
            if (value == null || value.trim() == '') {
                url = '/community/get/context';
            } else {
                url = '/community/get/context/' + value;
                addCookie(true, value, 7);
            }
            getSearchContext(url, true);
        }

        function addCookie(flag, context, day) {
            if (flag) {
                if (isExistence(context)) {
                    let data = new Date();
                    data.setTime(data.getTime() + day * 24 * 60 * 60 * 1000);
                    document.cookie = context + "=search;expires=" + data.toGMTString();
                }
            } else {
                let data = new Date();
                data.setTime(data.getTime() + day * 24 * 60 * 60 * 1000);
                document.cookie = context + "=search;expires=" + data.toGMTString();
            }

        }

        function getCookie() {
            let cookies = document.cookie.split('; ');
            let len = cookies.length;
            let cookieValues = new Array();
            let n = 0;
            if (len == 0)
                return null;
            for (let i = len - 1; i >= 0; i--) {
                let cookie = cookies[i].split('=');
                if ('search' == cookie[1]) {
                    cookieValues[n++] = cookie[0];
                    if (n > 5)
                        return cookieValues;
                }
            }
            return cookieValues;
        }

        function deCookie(context) {
            addCookie(false, context, -1);
        }

        function isExistence(context) {
            let cookies = document.cookie.split('; ');
            let len = cookies.length;
            if (len == 0)
                return true;
            for (let i = 0; i < len; i++) {
                let cookie = cookies[i].split('=');
                if (context == cookie[0])
                    return false;
            }
            return true;
        }
    }

    $('body').click(function (e) {
        if ($crHistory.css('display') != 'none') {
            $crHistory.hide();
        }
    });
}