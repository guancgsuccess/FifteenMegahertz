

$(function () {
   $(window).scroll(function () {
        var height = $(window).scrollTop();
        if (height >= 500 && height < 600){
            $("#nav").css("position","fixed").addClass("nav-bg-1").removeClass("nav-bg-2");
            $(".nav-button").addClass("nav-button-bottom");
            $("#nav-register").css("color","black");
        }else if(height >= 600){
            $("#nav").css("position","fixed").addClass("nav-bg-2").removeClass("nav-bg-1");
            $(".nav-button").addClass("nav-button-bottom");
            $("#nav-register").css("color","black");
        }else{
            $("#nav").css("position","absolute").removeClass("nav-bg-1").removeClass("nav-bg-2");
            $(".nav-button").removeClass("nav-button-bottom");
            $("#nav-register").css("color","white");
       }
   });
});