var i = 0;
var infinite;

$(function () {

    var width = (window.screen.width - 17);
    $(" body").css("min-width", width);
    $("#top").css("min-width", width);
    $(".images").css("min-width", width);
    $("#tab").css("min-width", width);
    $("#nav").css("min-width", width);
    $("#introduce").css("min-width", width);
    $("#content").css("min-width", width);
    $("#other").css("min-width", width);
    $(" footer").css("min-width", width);

    $img = $(".essence-image");

    var w = $img.width();
    $(".car-like").css("width", w);
    $(".head-name").css("width", w);

    $unit = $(".essence-images-unit");
    $headname = $(".head-name");
    var colh = [0.000000001, 0.0000000001, 0.000000000001];
    var gap = width * 0.97 * 0.01;
    var len = $img.length;
    for (var x = 0; x < len; x++) {
        var h = $img.eq(x).height();
        var minh = getArrMin(colh);
        var mini = getArrIndex(colh, minh);
        var a = (mini + 1) % 3;
        if (a == 0)
            a = 3;
        $unit.eq(x).css({"height": h, "top": minh, "left": w * mini + a * gap});
        $headname.eq(x).css("margin-top", h - 45);
        colh[mini] += (h + 15);
    }

    var maxh = getArrMax(colh);
    $("#essence").css("height", maxh);
    $(".images:eq(0)").show().siblings().hide();

    showTime(800, 800);

    $("#tab li").hover(function () {
        clearInterval(infinite);
        i = $(this).index();
        show(10, 10);
    }, function () {
        showTime(800, 800);
    });

    $(".car-like").hide();
    $("#essence-img-set").hide();
    $("#img").click(function () {
        $("#img span").addClass("choice-color");
        $("#set span").removeClass("choice-color");
        $("#essence-images").show();
        $("#essence-img-set").hide();
        $("#essence").css("height", maxh);
    });

    $("#set").click(function () {
        $("#set span").addClass("choice-color");
        $("#img span").removeClass("choice-color");
        $("#essence-images").hide();
        $("#essence-img-set").show();
        $("#essence").css("height", "auto");
    });

    var e;
    $(".essence-images-unit").hover(function () {
        e = $(this).index();
        $(".car-like").eq(e).show();
        $(".head-name").eq(e).show();
    }, function () {
        $(".car-like").eq(e).hide();
        $(".head-name").eq(e).hide();
    });
});


function showTime(x, y) {
    infinite = setInterval(function () {
        if (++i == $(".images").length)
            i = 0;
        show(x, y);
    }, 6000);
}

function show(x, y) {
    $(".images:eq(" + i + ")").fadeIn(x).siblings().fadeOut(y);
    $("#tab li:eq(" + i + ")").addClass("tab-bg").siblings().removeClass("tab-bg");
}

function getArrMax(arr) {
    var max = arr[0];
    for (var x = 1; x < arr.length; x++) {
        if (max < arr[x]) {
            max = arr[x];
        }
    }
    return max;
}

function getArrMin(arr) {
    var min = arr[0];
    for (var x = 1; x < arr.length; x++) {
        if (min > arr[x]) {
            min = arr[x];
        }
    }
    return min;
}

function getArrIndex(arr, y) {
    for (var x = 0; x < arr.length; x++) {
        if (y == arr[x]) {
            return x;
        }
    }
    return -1;
}
