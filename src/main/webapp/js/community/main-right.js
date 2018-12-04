{

    /**
     * 社区右边个人信息展示
     */
    {
        //个人信息容器
        $crPersonal = $('#community-right-personal');

        //定义一个元素节点
        let success = `<div class="community-content-two-personal-profile">
                        <img src="${customer.custProfile}">
                    </div>
                    <div class="community-content-two-personal-message-some">
                        <span data-cust-id="${customer.custId}" class="community-content-two-personal-nick">
                            ${customer.custNick}</span>
                        <span class="community-content-two-personal-level">Lv${customer.custLevel}</span>
                    </div>
                    <div class="community-content-two-personal-intro">
                        ${customer.custIntro}
                    </div>`;

        //清空
        $crPersonal.empty();
        //添加数据
        $crPersonal.append(success);

        //添加点击事件
        $('.community-content-two-personal-nick').on('click', function (e) {
            e.stopPropagation();
            goPersonalCenter(customer.custId);
        });
    }

    /**
     * 社区右边已经加入社区展示
     */
    {
        //已加入的社区展示容器
        $crCustComms = $('#community-right-customer-community');
        let url = '/community/get/cc/' + customer.custId;

        ajax('get', url, false, function (data) {
            if (data.status == 1) {
                //加入用户对象中
                customer.communityList = data.communityList;
            }
        });

        //定义元素节点
        let success = ``;
        //判断用户内的是否为字符串类型
        if ((typeof customer.communityList) === "string") {

            success = `${customer.communityList}`;
        } else {

            let len = customer.communityList.length;
            for (let i = 0; i < len; i++) {
                success += `<div data-comm-id="${customer.communityList[i].commId}"
                                title="${customer.communityList[i].commName}"
                                class="community-content-two-personal-community-unit">
                                ${customer.communityList[i].commName}
                           </div>`;
            }
        }

        //清除数据
        $crCustComms.empty();
        // 追加数据
        $crCustComms.append(success);

        //添加点击事件
        $('.community-content-two-personal-community-unit').on('click', function (e) {
            e.stopPropagation();
            location.href = '/view/info?commId=' +
                $('.community-content-two-personal-community-unit').eq($(this).index()).data().commId
                + '&r=' + new Date().getTime();
        });
    }

    /**
     * 快速入口点击事件
     */
    {
        //全部社区
        $cCommunity = $('#community-community');
        //消息
        $cCenterMessage = $('#community-center-message');
        //申请社区
        $cCommunityAdd = $('#community-community-add');
        //发布公告
        $cBulletinAdd = $('#community-bulletin-add');
        //设置
        $cCenterSetting = $('#community-center-setting');

        $cCommunity.click(function (e) {
            location.href = '/view/allComm';
        });
        $cCenterMessage.click(function (e) {
        });
        $cCommunityAdd.click(function (e) {
            location.href = '/view/center';
        });
        $cBulletinAdd.click(function (e) {
        });
        $cCenterSetting.click(function (e) {
            location.href = '/view/center';
        });
    }

    /**
     * 社区右边推荐社区展示
     */
    let crNewComm = null;
    {

        //推荐社区容器
        $crNewComm = $('#community-right-community');

        //临时变量
        let crNewComm = null;

        /**********************************************************出错地方看不懂**********/
        ajax('get', '/community/get/nComm', false, function (data) {
            if (data.status == 1) {
                //加入用户对象中
                crNewComm = data.communityList;
            }
        });

        //定义元素节点
        let success = ``;
        let len = crNewComm.length;
        for (let i = 0; i < len; i++) {
            success += `<li data-comm-id="${crNewComm[i].commId}">
                            <div class="community-content-two-recommend-content-name">
                                ${crNewComm[i].commName}
                            </div>
                            <div class="community-content-two-recommend-content-label">
                            ${crNewComm[i].commLabel}
                            </div>
                        </li>`;
        }

        //清除数据
        $crNewComm.empty();
        // 追加数据
        $crNewComm.append(success);

        //添加点击事件
        $('#community-right-community > li').on('click', function (e) {
            e.stopPropagation();
            location.href = '/view/info?commId=' +
                $('#community-right-community > li').eq($(this).index()).data().commId
                + '&r=' + new Date().getTime();
        });
    }

    /**
     * 社区右边寻找社区展示
     */
    {
        //寻找社区容器
        $crClassify = $('#community-right-classify');

        var crClassify = '类别分类';

        ajax('get', '/image/category/get/list', false, function (data) {
            // if (data.status == 1) {
            //加入用户对象中
            crClassify = data;
            // }
        });

        //定义元素节点
        let success = ``;
        let len = crClassify.data.categoryInfo.length;
        for (let i = 0; i < len; i++) {
            success += `<div data-category-id="${crClassify.data.categoryInfo[i].categoryId}" 
                             class="community-content-two-classify-content-classify-unit">
                            ${crClassify.data.categoryInfo[i].categoryName}</div>`;
        }

        //清除数据
        $crClassify.empty();
        // 追加数据
        $crClassify.append(success);

        //添加点击事件
        $('.community-content-two-classify-content-classify-unit').on('click', function (e) {
            e.stopPropagation();
            location.href = '/view/search?categoryId=' +
                $('.community-content-two-classify-content-classify-unit').eq($(this).index()).data().categoryId
                + '&r=' + new Date().getTime();
        });
    }
}