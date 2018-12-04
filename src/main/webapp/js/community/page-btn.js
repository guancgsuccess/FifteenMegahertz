/**
 * 分页渲染方法
 * @param e 容器
 * @param data 数据
 */
function appendPage(e, data) {
    let page = `<div class="community-info-content-content-page community-community-page">`;

    if (data.isFirstPage == 1) {
        page += `<span class="not-click-btn">首页</span>
                                 <span class="not-click-btn">上一页</span>`;
    } else {
        page += `<a data-page-tip="100001" class="page-btn" href="javascript:void(0)">首页</a>
                                 <a data-page-tip="100002" class="page-btn" href="javascript:void(0)">上一页</a>`;
    }

    if (data.totalPages <= 5) {
        for (let i = 1; i <= data.totalPages; i++) {
            if (i == data.currentPage) {
                page += `<span class="not-click-btn current-page">${i}</span>`;
            } else {
                page += `<a data-page-tip="${i}" class="page-btn" href="javascript:void(0)">${i}</a>`;
            }
        }
    } else {
        if (data.currentPage < 5) {//当前页小于5，加载1-5页
            for (let i = 1; i <= 5; i++) {
                if (i == data.currentPage) {
                    page += `<span class="not-click-btn current-page">${i}</span>`;
                } else {
                    page += `<a data-page-tip="${i}" class="page-btn" href="javascript:void(0)">${i}</a>`;
                }
            }
            if (data.currentPage <= data.totalPages - 2) {//最后一页追加“...”代表省略的页
                page += `<span>...</span>`;
            }
        } else if (data.currentPage >= 5) {//当前页大于5页
            for (let i = 1; i <= 2; i++) {//1,2页码始终显示
                page += `<a data-page-tip="${i}" class="page-btn" href="javascript:void(0)">${i}</a>`;
            }
            page += `<span>...</span>`;//2页码后面用...代替部分未显示的页码
            if (data.currentPage + 1 == data.totalPages) {//当前页+1等于总页码
                for (let i = data.currentPage - 1; i <= data.totalPages; i++) {//“...”后面跟三个页码当前页居中显示
                    if (i == data.currentPage) {
                        page += `<span class="not-click-btn current-page">${i}</span>`;
                    } else {
                        page += `<a data-page-tip="${i}" class="page-btn" href="javascript:void(0)">${i}</a>`;
                    }
                }
            } else if (data.currentPage == data.totalPages) {//当前页数等于总页数则是最后一页页码显示在最后
                for (let i = data.currentPage - 2; i <= data.totalPages; i++) {//...后面跟三个页码当前页居中显示
                    if (i == data.currentPage) {
                        page += `<span class="not-click-btn current-page">${i}</span>`;
                    } else {
                        page += `<a data-page-tip="${i}" class="page-btn" href="javascript:void(0)">${i}</a>`;
                    }
                }
            } else {//当前页小于总页数，则最后一页后面跟...
                for (i = data.currentPage - 1; i <= data.currentPage + 1; i++) {//dqPage+1页后面...
                    if (i == data.currentPage) {
                        page += `<span class="not-click-btn current-page">${i}</span>`;
                    } else {
                        page += `<a data-page-tip="${i}" class="page-btn" href="javascript:void(0)">${i}</a>`;
                    }
                }
                page += `<span>...</span>`;
            }
        }
    }

    if (data.isLastPage == 1) {
        page += `<span class="not-click-btn">下一页</span>
                                 <span class="not-click-btn">尾页</span>`;
    } else {
        page += `<a data-page-tip="100003" class="page-btn" href="javascript:void(0)">下一页</a>
                                 <a data-page-tip="100004" class="page-btn" href="javascript:void(0)">尾页</a>`;
    }

    page += `<span>共${data.totalPages}页</span>
                            </div>`;

    e.append(page);
}

