{

    /**
     * 社区公告信息详情展示
     */
    $cbContent = $('.community-bulletin-content');

    $cbContent.append('<div class="community-nav-loading-div">' +
                        '<img src="/images/community/loading.gif">' +
                      '</div>');
    setTimeout(function () {
        ajax('get','/community/get/bulletinInfo',true,function (data) {
            if (data.status != 1){
                location.href = '/500.html';
            }
            let success = `<div class="community-bulletin-content-title">
                            ${data.bulletinInfo.bullTitle}
                        </div>
                        <p class="community-bulletin-content-content">
                            ${data.bulletinInfo.bullContent}
                        </p>
                        <div class="community-bulletin-content-tip">
                            <span data-cust-id="${data.bulletinInfo.custId}"
                            class="community-bulletin-content-tip-one">${data.bulletinInfo.custNick}</span>
                            <span class="community-bulletin-content-tip-two">${data.bulletinInfo.bullCreateTime}</span>
                        </div>`;

            $cbContent.empty();
            $cbContent.append(success);

            $('.community-bulletin-content-tip-one').on('click',function (e) {
                e.stopPropagation();
                let custId = $('.community-bulletin-content-tip-one').data().custId;
                goPersonalCenter(custId);
            });
        });
    },300);
}