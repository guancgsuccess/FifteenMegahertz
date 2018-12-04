{
    /**
     * 全部社区分页
     */
    {
        $ccAll = $('#community-community-all');

        let pageCode = 1;
        let url = '/community/get/allComm/' + pageCode;
        loadAllCommunity(url, false);

        function loadAllCommunity(url, isAsy) {
            ajax('get', url, isAsy, function (data) {
                if (data.status == 1) {
                    renderingCommunity($ccAll, data);

                    appendPage($ccAll, data);

                    $('.page-btn').on('click', function (e) {
                        e.stopPropagation();
                        let ev = e || window.event;
                        let target = ev.target || ev.srcElement;
                        if (target.nodeName.toLowerCase() == 'a') {
                            let v = target.dataset.pageTip;
                            let url = '/community/get/allComm/';
                            if (v < 100000) {
                                pageCode = v;
                                url += pageCode;
                            } else {
                                if (v == 100001) {
                                    pageCode = 1;
                                    url += pageCode;
                                } else if (v == 100002) {
                                    url += --pageCode;
                                } else if (v == 100003) {
                                    url += ++pageCode;
                                } else {
                                    pageCode = data.totalPages;
                                    url += pageCode;
                                }
                            }

                            let top = $('.community-search-content-center-one-community').offset().top - 200;
                            goTop(top);
                            loadAllCommunity(url, true);
                        }
                    });
                }
            });
        }


    }
}