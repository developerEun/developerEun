function readJSON(file, callback) {
    var rawFile = new XMLHttpRequest();
    rawFile.overrideMimeType("application/json");
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function() {
        if (rawFile.readyState === 4 && rawFile.status == "200") {
            callback(rawFile.responseText);
        }
    }
    rawFile.send(null);
}

//함수 사용법
readJSON("https://developereun.github.io/mbti/data.json", function(text){
    var data = JSON.parse(text);
    var target = document.querySelector("button");
    var clickCnt = -1;
    var allScore = 0;

    target.addEventListener('click', function(){
        document.querySelector(".start").style.display = "none";
        nextQna(clickCnt, data, allScore, 0, countMBTI, typeMBTI);        
    });
});

var countMBTI = 0;
var typeMBTI = "";
var nickname = "";

function nextQna(clickCnt, data, allScore, score){
    if(clickCnt == -1){
        clickCnt = 0;
        nickname = inputString = prompt('니 이름이 뭐고?~~~~');
    }else{
        allScore += score;
        if(clickCnt != Object.keys(data).length){
            if(data[clickCnt].category != data[clickCnt-1].category){
                countMBTI++;
                if(countMBTI == 1){
                    if(allScore < 5){
                        typeMBTI = "I";
                    }else{
                        typeMBTI = "E";
                    }
                }else if(countMBTI == 2){
                    if(allScore < 5){
                        typeMBTI = typeMBTI + "S";
                    }else{
                        typeMBTI = typeMBTI + "N";
                    }                
                }else if(countMBTI == 3){
                    if(allScore < 5){
                        typeMBTI = typeMBTI + "F";
                    }else{
                        typeMBTI = typeMBTI + "T";
                    }                       
                }
                allScore = 0;
            }
        }else{
            countMBTI++;
            if(countMBTI == 4){
                if(allScore < 5){
                    typeMBTI = typeMBTI + "J";
                }else{
                    typeMBTI = typeMBTI + "P";
                }                       
            }
            document.body.innerHTML = "";
            var mbtiTxt = document.createElement("p");
            mbtiTxt.append("끝났다리~~~~~~~~~");
            document.body.append(mbtiTxt);
            alert(name + "! 너의 MBTI는 '" + typeMBTI + "' 라능 ㅇㅅㅇ~~");
        }
    }
    
    if(clickCnt < Object.keys(data).length){
        var qnaBox = document.createElement("div");
        var qna = document.createElement("p");
        var answerY = document.createElement("button");
        answerY.onclick=function(){nextQna(clickCnt, data, allScore, 1)};
        var answerN = document.createElement("button");
        answerN.onclick=function(){nextQna(clickCnt, data, allScore, 2)};

    
        qna.append(data[clickCnt].qna);
        answerY.append(data[clickCnt].answerY);
        answerN.append(data[clickCnt].answerN);

        qnaBox.append(qna, answerY, answerN);
        document.body.innerHTML = "";
        document.body.append(qnaBox);

        if(clickCnt >= 0){
            clickCnt++;
        }
    }

}