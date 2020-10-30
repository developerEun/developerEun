

$().ready(function(){
	
	getMainNotice();

    var slides = $('.swiper-slide');
    var mySwiper = new Swiper('.swiper-container', {
        spaceBetween: 0,
        centeredSlides: true,
        pagination: {
            el: '.swiper-pagination_main',
            clickable: true,
        },
        on: {
            init: function(){
                swiperAnimateCache(this);
                swiperAnimate(this);
                $(".swiper-slide-prev, .swiper-slide-next").removeClass("animate");
                $(".swiper-slide-active").addClass("animate");
            },
            slideChangeTransitionEnd: function(){ 
            swiperAnimate(this);
            $(".swiper-slide-prev, .swiper-slide-next").removeClass("animate");
            $(".swiper-slide-active").addClass("animate");
            }
        } 
    }); 
       

    $(".mainNoticeBtn li").click(function(){
        var idx = $(this).index();
        $(".mainNoticeBtn li").removeClass("active");
        $(this).addClass("active");
        $(".mainNoticeInfo").removeClass("active");
        $(".mainNoticeInfo").eq(idx).addClass("active");
    });

    $(window).scroll(function(){ 
        var height = $(document).scrollTop();
        if(height > 100){ 
          $('nav').addClass('fix'); 
        }else if(height == 0){ 
          $('nav').removeClass('fix'); 
        } 
      });
    
});