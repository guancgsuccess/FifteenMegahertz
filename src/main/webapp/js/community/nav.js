{

    /**
     * 类别块
     */
    {
        //类别触发元素
        $cnCategory = $('#community-nav-classify');
        //类别隐藏部分
        $cnCategoryHide = $('#community-nav-classify-hide');
        //类别置空容器
        $cnCategoryContainer = $('#community-nav-classify-container');

        //出来隐藏容器消失
        $cnCategoryHide.hover(function (e) {
        }, function (e) {
            $cnCategoryHide.fadeOut(300);
        });
    }

    /**
     * 个人信息块
     */
    {
        $cnCustomer = $('#community-nav-customer');
        $cnCustomerHide = $('#community-nav-customer-hide');

        $cnCustomerHide.hover(function (e) {
        }, function (e) {
            $cnCustomerHide.fadeOut(300);
        });

        //个人信息
        $cPersonal = $('#customer-personal');
        //消息
        $cCenterNews = $('#community-center-news');
        //社区中心
        $cCenter = $('#community-center');
        //订单中心
        $cOrder = $('#customer-order');
        //收藏
        $cCollection = $('#customer-collection');
        //关注
        $cFollow = $('#customer-follow');
        //设置
        $cSetting = $('#customer-setting');
        //退出登录
        $cLogout = $('#customer-logout');

        $cPersonal.click(function (e) {
            goPersonalCenter(customer.custId);
        });
        $cCenterNews.click(function (e) {

        });
        $cCenter.click(function (e) {
            location.href = '/view/center';
        });
        $cOrder.click(function (e) {
            //订单路径
            goPersonalCenter(customer.custId);
        });
        $cCollection.click(function (e) {
            //收藏路径
            goPersonalCenter(customer.custId);
        });
        $cFollow.click(function (e) {
            //关注
            goPersonalCenter(customer.custId);
        });
        $cSetting.click(function (e) {
            //设置
            goPersonalCenter(customer.custId);
        });
        $cLogout.click(function (e) {
            signOut();
        });
    }

    /**
     * 判断是否已经登录
     */
    {
        //未登录显示
        $login = $('.community-nav-btn-div-special');
        //已经登录显示
        $logout = $('.community-nav-logout');
        //用户昵称
        $customer = $('#community-nav-customer');

        if (customer.custId != 0) {
            $login.addClass('community-nav-hide');
            $logout.removeClass('community-nav-hide');

            let customerShow = `<span>${customer.custNick}</span>`;
            $customer.append(customerShow);
        }
    }

    /**
     * 查询联动
     */
    {
        //查询输入框
        $cnSearch = $('#community-nav-search');
        //查询图片按钮
        $$cnSearchImg = $('#community-nav-search-img');
        //实时联动记录容器
        $cnSearchHide = $('#community-nav-search-hide');

        //添加内容变动监听事件
        $cnSearch.bind('input', function () {
            //获得内容值
            let v = $cnSearch.val();
            //判断内容值是否为空
            if (v != null && v.trim() != '') {
                //发送ajax请求
                let url = '/community/get/navContext/' + v;
                ajax('get', url, true, function (data) {
                    if (data.status == 1) {

                        let success = `<ul>`;
                        let len = data.searchList.length;

                        if (len > 6)
                            len = 6;

                        for (let i = 0; i < len; i++) {
                            if (data.searchList[i].commId != null) {
                                success += `<li data-comm-id="${data.searchList[i].commId}">
                                            <span>${data.searchList[i].commName}</span></li>`;
                            } else {
                                let context = data.searchList[i].commMessContext;
                                if (context.indexOf('img') == -1){
                                    if (context.length > 20){
                                        context = context.substring(0,20) + '...';
                                    }
                                }
                                success += `<li data-comm-mess-id="${data.searchList[i].commMessId}">
                                            <span>${context}</span></li>`;
                            }
                        }
                        success += `</ul>`;

                        //删除内元素
                        $cnSearchHide.empty();
                        //追加节点
                        $cnSearchHide.append(success);
                        //控件显示
                        $cnSearchHide.show();
                        //为新生成元素添加事件
                        $('#community-nav-search-hide > ul > li').on("click", function (e) {
                            e.stopPropagation();
                            let index = $(this).index();
                            let commId = $('#community-nav-search-hide > ul > li').eq(index).data().commId;
                            let commMessId = $('#community-nav-search-hide > ul > li').eq(index).data().commMessId;
                            location.href = '/view/info?commId=' + commId + '&commMessId=' +
                                commMessId + '&r=' + new Date().getTime();
                        });

                    } else {
                        $cnSearchHide.hide();
                    }
                });
            } else {
                //反之隐藏
                $cnSearchHide.hide();
            }
        });

        let value = '';

        //失去焦点清空文本框
        $cnSearch.blur(function (e) {
            value = $cnSearch.val();
            $cnSearch.val('');
        });

        $cnSearch.keydown(function (e) {
            if (e.keyCode == 13) {
                location.href = '/view/search?context=' + $cnSearch.val();
            }
        });

        $$cnSearchImg.click(function (e) {
            location.href = '/view/search?context=' + value;
        });
    }

    /**
     * 类别个人公共
     */
    {
        let cbTop = $cnCategory.offset().top - 10;
        let cbLeft = $cnCategory.offset().left - 20;
        let cbBottom = cbTop + $cnCategory.height() + 20;
        let cbRight = cbLeft + $cnCategory.width() + 20;

        let ccTop = $cnCustomer.offset().top - 10;
        let ccLeft = $cnCustomer.offset().left - 24;
        let ccBottom = ccTop + $cnCustomer.height() + 20;
        let ccRight = ccLeft + $cnCustomer.width() + 34;

        $(window).resize(function (e) {
            cbTop = $cnCategory.offset().top - 10;
            cbLeft = $cnCategory.offset().left - 20;
            cbBottom = cbTop + $cnCategory.height() + 20;
            cbRight = cbLeft + $cnCategory.width() + 20;

            ccTop = $cnCustomer.offset().top - 10;
            ccLeft = $cnCustomer.offset().left - 24;
            ccBottom = ccTop + $cnCustomer.height() + 20;
            ccRight = ccLeft + $cnCustomer.width() + 34;
        });

        $(document).mousemove(function (e) {

            let x = e.pageX;
            let y = e.pageY;

            if (x < cbLeft || x > cbRight) {
                if ($cnCategoryHide.css('display') != 'none')
                    $cnCategoryHide.fadeOut(200);
            } else if (y < cbTop) {
                if ($cnCategoryHide.css('display') != 'none')
                    $cnCategoryHide.fadeOut(200);
            } else if (y < cbBottom) {

                if ($cnCategoryHide.css('display') == 'none') {
                    //清空容器内容
                    $cnCategoryContainer.empty();
                    //获取数据url
                    let url = '/image/category/get/list';
                    //正在加载容器
                    let loadingOne = `<div id="loadingOne" class="community-nav-loading-div">
                                      <img src="/images/community/loading.gif">
                                 </div>`;
                    $cnCategoryContainer.append(loadingOne);

                    $cnCategoryHide.show();

                    /**
                     * 获取数据方法
                     */
                    ajax('get', url, true, function (data) {
                        if (data.status == 1) {

                            let success = '<ul id="community-category-ul" class="community-nav-loading-ul">';
                            let len = data.data.categoryInfo.length;
                            for (let i = 0; i < len; i++) {
                                success += '<li data-category-id="' + data.data.categoryInfo[i].categoryId
                                    + '">' + data.data.categoryInfo[i].categoryName + '</li>'
                            }
                            success += '</ul>';
                            //清除正在加载
                            $cnCategoryContainer.empty();
                            //添加数据
                            $cnCategoryContainer.append(success);

                            //添加点击事件
                            $('#community-category-ul > li').on('click', function (e) {
                                e.stopPropagation();
                                location.href = '/view/search?categoryId=' +
                                    $('#community-category-ul > li').eq($(this).index()).data().categoryId
                                    + '&r=' + new Date().getTime();
                            });
                        }

                    });
                }
            }

            if (x < ccLeft || x > ccRight) {
                if ($cnCustomerHide.css('display') != 'none')
                    $cnCustomerHide.fadeOut(200);
            } else if (y < ccTop) {
                if ($cnCustomerHide.css('display') != 'none')
                    $cnCustomerHide.fadeOut(200);
            } else if (y < ccBottom) {
                if ($cnCustomerHide.css('display') == 'none')
                    $cnCustomerHide.fadeIn(200);
            }
        });
    }


    $('body').click(function (e) {
        if ($cnSearchHide.css('display') != 'none') {
            $cnSearchHide.hide();
        }
    });
}
