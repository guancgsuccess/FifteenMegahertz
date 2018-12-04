let putExtra = {
    fname: "", //原文件名
    params: {}, //自定义变量
    mimeType: ["image/png", "image/jpeg", "image/gif", "image/jpg"]
};
let config = {
    useCdnDomain: false,
    region: qiniu.region.z0,
};
let token = '';

function getUpToken(key) {
    let url = '/community/get/token/' + key;
    ajax('get', url, false, function (data) {
        token = data.token;
    })
}

/**
 * 用于生成唯一key
 * @returns {string}
 */
function getKey() {
    let x = "0123456789qwertyuioplkjhgfdsazxcvbnm";
    let tmp = "";
    let timestamp = new Date().getTime();
    for (let i = 0; i < 2; i++) {
        tmp += x.charAt(Math.ceil(Math.random() * 100000000) % x.length);
    }
    return timestamp.toString(16) + tmp;
}