$(document).ready(function(){

    var swiper = new Swiper('.swiper-container', {
        slidesPerView: '2',
        spaceBetween: 0,
        mousewheel: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
    });

    //페이지 오픈 시 포트폴리오 애니메이션
    $('.slide-wrap').addClass('on');

    // 포트폴리오 black bg
    $('.swiper-slide').each(function(){
        $(this).hover(function(){
            $(this).find('.mouseover').stop().animate({'left':'0'});
        },function(){
            $(this).find('.mouseover').stop().animate({'left':'-100%'});
        });
    });

    // 메뉴(아이콘) 클릭시    
    $('.gnb').click(function(){
        $('.gnb').toggleClass('on');
        $('.gnb-box').fadeToggle('on');
    });  

    // 메뉴(2depth) 클릭시    
    $('.nav>li>a').each(function(){
        $(this).click(function(){
            var i = $(this).parent('li').index();
            $('.gnb').toggleClass('on');
            $('.gnb-box').fadeToggle('on');        
            $('#wrap>div').hide();    
            $('#wrap>div').eq(i).fadeIn();   
            if($(this).parent('li').hasClass('depth-02')){
                $('.swiper-slide').show();
            };
        });
    });      

    // 메뉴(2depth) 클릭시    
    $('.depth-02 ul li').each(function(){
        $(this).click(function(){
            var group = $(this).attr('class');
            var i = $(this).index();        
            $('.gnb').toggleClass('on');
            $('.gnb-box').fadeToggle('on');        
            $('#wrap>div').hide();    
            $('#wrap>div').eq(1).fadeIn();                 
            if(i===0){
                $('.swiper-slide').show();
            }else{
                $('.swiper-slide').hide();
                $('.swiper-slide[data-group='+group+']').show();
            }        
        });
    });  

    // 메뉴(logo) 클릭시
    $('#logo').click(function(){
        $('.gnb').removeClass('on');
        $('.gnb-box').hide();
        $('#wrap>div').hide();
        $('.swiper-slide').show();
        $('.portfolio').fadeIn();
    });

});