document.addEventListener('DOMContentLoaded', function () {
    ajax('dataset2.xml', 1);
    //ajax = Asynchronous(비동기방식 => 시간이 소요되는 부분은 요청해놓고 결과가 나타나면 그때 화면에 보여줌.순차적x) Javascript And XML
    //string: 102Hong8020 102Hong8020 102Hong8020 102Hong8020 102Hong8020 102Hong8020
    //xml: <id>102</id><name>Hong</name><score>80</score><age>20</age>
    let btns = document.querySelectorAll('.pagination > button');
    for (let i = 0; i < btns.length; i++) {
        btns[i].addEventListener('click', function () {
            //클릭이벤트 시 button의 클래스를 초기화해줌.
            for (let i = 0; i < btns.length; i++) {
                btns[i].className='';
            }
            let page = this.innerHTML;
            this.className = 'active'; 
            ajax('dataset2.xml', page); //1page 호출

        });
    }
})

function ajax(url, page) {
    let xhtp = new XMLHttpRequest(); //new Object(); (최상위 오브젝트인 object를 상속받음.)
    xhtp.open('get', url); //('페이지를 요청하는 방식', '요청하는 페이지')
    xhtp.send(); //페이지 요청 작업 시작.
    
    xhtp.onreadystatechange = function () {
        if (xhtp.readyState == 4 && xhtp.status == 200) { //정상적으로 데이터 가져왔을 경우.
            // console.log(xhtp.response);
            // console.log(JSON.parse(xhtp.response)); //MOCK_DATA.json
            console.log(xhtp.responseXML); //dataset.xml
            //console.log(xhtp.responseText); //js/variable.js
            //document.getElementById('show').innerHTML = xhtp.responseText
            // document.getElementById('show').innerHTML = makePage(xhtp.responseXML);
            makePage(xhtp.responseXML, page);
        }
    }
}

function makePage(data, page) {
    //기존에 있던 데이터를 화면에서 삭제해준 후...
    let divShow = document.querySelector('#show');
    let cnt = divShow.children.length;
    for (let i = 0; i < cnt; i++) {
        divShow.removeChild(divShow.children[0]);
    }

    //데이터 10개를 한페이지씩 화면에 보여줌
    let records = data.getElementsByTagName('record');
    let startCnt, endCnt;
    startCnt = (page - 1) * 10; //0 //10개 단위로 페이지 나눔.
    endCnt = page * 10 - 1; //9
    endCnt = endCnt > records.length - 1 ? records.length - 1 : endCnt; //마지막 페이지에는 레코드 갯수만큼만 가져와서 그려줌.
    console.log(records)
    for (let i = startCnt; i <= endCnt; i++) {
        let div = document.createElement('div');
        div.className = 'row';
        let span = document.createElement('span');
        span.innerText = records[i].children[0].innerHTML

        let strong = document.createElement('strong');
        strong.innerText = records[i].children[1].innerHTML
        let strong1 = document.createElement('strong');
        strong1.className = 'lastname';
        
        strong1.innerText = records[i].children[2].innerHTML
        let strong2 = document.createElement('strong');
        strong2.innerText = records[i].children[3].innerHTML

        div.appendChild(span);
        div.append(strong, strong1, strong2);

        document.getElementById('show').appendChild(div);
    }
}