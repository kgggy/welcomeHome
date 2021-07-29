function makeRow(obj) {
    //<tr><td>id</td><td>first_name</td>....</td></tr>
    let tr = document.createElement('tr');

    //
    tr.addEventListener('mouseover', mover, true); //addEventListener => 매개값 두개!
    tr.addEventListener('mouseout', mout, true); //true => 상위(부모)요소에서 하위요소로 이벤트 전파.
    tr.addEventListener('click', trClick, false); //default값은 false(가장 하위요소 이벤트 실행.)
    //preventdefault => 기본 원래의 기능을 막음.

    //필드의 갯수만큼 반복할 때 for..in 반복문 사용.
    for (let field in obj) { //obj필드만큼 반복.
        let td = document.createElement('td');
        let text = document.createTextNode(obj[field]);
        //console.log('필드: ' + field + '값: ' + obj[field]);
        console.log(`필드: ${field}, 값: ${obj[field]}`); //string형식으로 가져옴. ``
        td.appendChild(text);
        tr.appendChild(td);
    }

    //삭제버튼 생성.
    let td = document.createElement('td');
    let btn = document.createElement('input');
    btn.type = 'button'; //btn,setAttribute('type', 'button')과 같음.
    btn.value = '삭제';
    btn.addEventListener('click', deleteRow); //이벤트 발생시 실행되어야해서 ()없이 이름만 적어줌.(콜백함수)
    td.appendChild(btn);
    tr.appendChild(td);

    return tr;
}


let deleteRow = (arg) => { //이렇게 쓰는 경우 this쓰면 window를 가르키므로 arg.target을 써줌)
    arg.stopPropagation(); //이벤트의 하위/상위로의 전파를 차단.(tr 상위의 이벤트가 진행되지 않음.)
    arg.target.parentElement.parentElement.remove();
}
// let deleteRow = function (arg) {
//     console.log(this.parentNode.parentNode.childNodes[2].innerText); //innerText => 태그없이 값만 가져옴.
//     //console.log(arg.target.parentNode.parentNode.childNodes[2].nextSibling); //nextSibling => 그 다음 요소를 가져옴.(previousSibling(그 전 요소를 가져옴.))
//     //target => 자기자신.(arg.target = this)
// }

let mover = function (arg) { //tr태그에 이벤트 걸었으므로  arg.target = tr
    //arrow function일 경우에는 this 키워드는 window 오브젝트.
    this.style.backgroundColor = 'yellow';
    // console.log(arg.target)
}
let mout = function (arg) {
    //function일 경우에는 this 키워드는 event 대상.
    //console.log(this);
    this.style.backgroundColor = '';
}
let trClick = function (arg) {
    window.alert(this.children[0].innerHTML); //this = tr
}