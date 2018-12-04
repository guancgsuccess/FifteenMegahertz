{
    /**
     * 社区主页公告部分
     */
    {
        //公告容器
        $cmBulletin = $('#community-main-bulletin');
        //加载跟多公告按钮
        $cmBulletinLoadMore = $('#load-more-bulletin');

        let loadingTwo = `<div id="loadingTwo" class="community-nav-loading-div">
                              <img src="/images/community/loading.gif">
                         </div>`;
        $cmBulletin.append(loadingTwo);

        //设置初始页面为1
        let bulletinPage = 1;
        //默认路径
        let url = '/community/get/allBulletin/' + bulletinPage;
        //执行一次方法
        loadBulletin(url, false);

        //加载更多公告
        $cmBulletinLoadMore.click(function (e) {
            if ($cmBulletinLoadMore.attr('disabled') != 'disabled') {
                url = '/community/get/allBulletin/' + ++bulletinPage;
                loadBulletin(url, true);
            }
        });

        function loadBulletin(url, isAsy) {
            ajax('get', url, isAsy, function (data) {
                if (data.status == 1) {
                    let success = '';
                    let len = data.bulletinList.length;
                    for (let i = 0; i < len; i++) {
                        success += '<li data-bulletin-id="' + data.bulletinList[i].bulletinId + '" ' +
                            'class="community-content-one-content-unit">' +
                            '<span class="community-content-one-content-unit-title">' +
                            data.bulletinList[i].bulletinTitle + '</span>' +
                            '<span class="community-content-one-content-unit-time">' +
                            data.bulletinList[i].bulletinTime + '</span></li>';
                    }
                    //添加数据
                    $('#loadingTwo').remove();
                    $cmBulletin.append(success);

                    //当是最后一页时候
                    if (data.isLastPage == 1) {
                        $cmBulletinLoadMore.attr("disabled", true);
                    }

                    //添加点击事件
                    $('#community-main-bulletin > li').on('click', function (e) {
                        e.stopPropagation();
                        location.href = '/view/bulletin?bulletinId=' +
                            $('#community-main-bulletin > li').eq($(this).index()).data().bulletinId
                            + '&r=' + new Date().getTime();
                    });
                }
            });
        }

    }

    /**
     * 社区主页推荐留言活动部分
     */
    {
        //推荐留言按钮
        $ccBtn = $('.community-content-one-two-top > a');
        //正在进行按钮
        $ccBtnSpanA = $('.community-content-one-two-top > span > a');
        //留言容器
        $ccMessage = $('.community-content-one-two-message');
        //活动容器
        $ccActivity = $('.community-content-one-two-activity');
        //查看更多按钮
        $cmMessageOrActivityLoadMore = $('.community-content-one-two-more');

        //活动页数
        let activityPage = 1;
        //获取活动数据路径
        let activityUrl = '/community/get/allActivity/0/' + activityPage;
        //活动正在加载元素节点
        let loadingFour = `<div id="loadingFour" class="community-nav-loading-div">
                                <img src="/images/community/loading.gif">
                            </div>`;
        //追加到容器中
        $ccActivity.append(loadingFour);

        //推荐留言按钮点击事件
        $ccBtn.click(function (e) {
            //获取点击的索引
            let index = $(this).index();
            //根据索引修改样式
            $ccBtn.eq(index).addClass('community-content-one-two-top-selected')
                .siblings().removeClass('community-content-one-two-top-selected');

            //索引为0点击为推荐
            if (index == 0) {
                //活动隐藏
                $ccActivity.hide();
                $ccBtnSpanA.hide();
                //留言展示
                $ccMessage.show();
                //最下方查看更多按钮href改变
                $cmMessageOrActivityLoadMore.attr('href', '/view/community');
            } else {
                //活动展示
                $ccActivity.css('display', 'flex');
                $ccBtnSpanA.show();
                //留言隐藏
                $ccMessage.hide();
                //最下方查看更多按钮href改变
                $cmMessageOrActivityLoadMore.attr('href', 'javascript:loadMoreActivity("' + activityUrl + '")');
            }
        });

        //是否激活状态0为未激活
        let underway = 0;
        //正在进行按钮点击事件
        $ccBtnSpanA.click(function (e) {
            //判断是否激活真正真正进行按钮
            if ($ccBtnSpanA.css('color') != 'rgb(255, 115, 0)') {
                //激活状态
                $ccBtnSpanA.addClass('community-content-one-two-top-selected');
                underway = 1;
                $ccActivity.empty();
                $ccActivity.append(loadingFour);
                let url = '/community/get/underwayActivity';
                loadActivity(url, true);
            } else {
                //未激活
                $ccBtnSpanA.removeClass('community-content-one-two-top-selected');
                underway = 0;
                $ccActivity.empty();
                $ccActivity.append(loadingFour);
                let url = '/community/get/activity';
                loadActivity(url, true);
            }
        });

        /**
         * 留言部分
         */
        {
            //正在加载元素节点
            let loadingThree = `<div id="loadingThree" class="community-nav-loading-div">
                                <img src="/images/community/loading.gif">
                            </div>`;
            //容器最佳正在加载元素节点
            $ccMessage.append(loadingThree);

            //获得数据路径
            let url = '/community/get/nMess';
            //第一次加载数据
            loadMessage(url, false);

            //加载数据方法
            function loadMessage(url, isAsy) {
                ajax('get', url, isAsy, function (data) {
                    //查看返回中的数据状态
                    if (data.status == 1) {
                        renderingMessage($ccMessage, data);
                    }
                });
            }
        }

        /**
         * 活动部分
         */
        {
            //第一次加载数据
            loadActivity(activityUrl, false);

            //加载更多数据
            function loadMoreActivity(activityUrl) {
                //判断是否为最后一页
                if ($cmMessageOrActivityLoadMore.attr('disabled') != 'disabled') {
                    //判断是否激活正在进行
                    //url改变根据页数获得数据
                    activityUrl = '/community/get/allActivity/' + underway + '/' + ++activityPage;
                    //加载数据
                    loadActivity(activityUrl, true);
                }
            }

            window.onload = function (e) {
                ajax('delete', '/community/d/temporaryActivity', false, function (data) {

                });
            };
        }

        //活动加载数据方法
        function loadActivity(activityUrl, isAsy) {
            ajax('get', activityUrl, isAsy, function (data) {
                //查看返回中的数据状态
                if (data.status == 1) {
                    //定义一个元素节点
                    let success = ``;
                    //获得数据中真正数据的数组长度
                    let len = data.activityList.length;

                    let src = '/images/community/test-activity-img.jpg';

                    //循环添加数据
                    for (let i = 0; i < len; i++) {
                        success += `<div data-activity-id="${data.activityList[i].activityId}" 
                                            class="community-content-one-two-activity-unit">
                                            <div class="community-content-one-two-activity-img">
                                                <img src="${src}"/></div>
                                            <div class="community-content-one-two-activity-text">
                                                <div class="community-content-one-two-activity-name">
                                                    ${data.activityList[i].activityName}
                                                </div>
                                                <div class="community-content-one-two-activity-tip">
                                                    <span>${data.activityList[i].activityPart}</span>`;
                        if (data.activityList[i].activityDeadline == -1) {
                            success += `<span class="community-content-one-two-activity-tip-end-day">暂未开始</span>`;
                        } else if (data.activityList[i].activityDeadline == 0) {
                            success += `<span class="community-content-one-two-activity-tip-end-day">已结束</span>`;
                        } else {
                            success += `<span class="community-content-one-two-activity-tip-end-day">
                                            ${data.activityList[i].activityDeadline}天后结束</span>`;
                        }
                        success += `</div>
                                            </div>
                                        </div>`;
                    }

                    //清除正在加载
                    $('#loadingFour').remove();
                    //添加数据
                    $ccActivity.append(success);

                    //当是最后一页时候
                    if (data.isLastPage == 1) {
                        $cmMessageOrActivityLoadMore.attr("disabled", true);
                    }

                    //添加点击事件
                    $('.community-content-one-two-activity-unit').on('click', function (e) {
                        e.stopPropagation();
                        location.href = '/view/activity?activityId=' +
                            $('.community-content-one-two-activity-unit').eq($(this).index()).data().activityId;
                    });
                }
            });
        }
    }

}