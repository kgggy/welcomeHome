  //사용자 입력값을 활용해 tr 완성.
  function createTr(num, title, writer, regDate) {

      let trTag = document.createElement('tr');
      //   trTag.setAttribute('class', 'altRow');
      
      //   let tdTag1 = document.createElement('td');
      //   let numText = document.createTextNode(num);
      //   tdTag1.appendChild(numText)
      
      //   let tdTag2 = document.createElement('td');
      //   let titleText = document.createTextNode(title);
      //   tdTag2.appendChild(titleText)
      
      //   let tdTag3 = document.createElement('td');
      //   let writerText = document.createTextNode(writer);
      //   tdTag3.appendChild(writerText)
      
      //   let tdTag4 = document.createElement('td');
      //   let regDateText = document.createTextNode(regDate);
      //   tdTag4.appendChild(regDateText)
      
      //   trTag.append(tdTag1, tdTag2, tdTag3, tdTag4);
      
      trTag.setAttribute('id', num);
      
      for (let i = 0; i < arguments.length; i++) {
          let tdTag = document.createElement('td');
          tdTag.setAttribute('class', 'td' + (i + 1));
          let text = document.createTextNode(arguments[i]);
          //   let chb = document.createElement('td');
          //   chb.setAttribute('input', 'checkbox');
          //   tdTag.appendChild(chb);
          let tbody = document.createElement('tbody');
          tbody.appendChild(trTag);
          tdTag.appendChild(text); //<td>namd</td>
          trTag.appendChild(tdTag); //<tr><td>..</td></tr>        
      }

      let td = document.createElement('td');
      let checkbox = document.createElement('input')
      checkbox.setAttribute('type', 'checkbox');
      td.appendChild(checkbox); //<td>namd</td>
      trTag.appendChild(td);

      return trTag;
  }

//기존생성되어있는 tr에 이벤트등록.
function addTrEvent() {
  let trs = document.querySelectorAll('#list > tbody > tr') //관계를 통해 요소 생성.
  console.log(trs);
  for (let i = 0; i < trs.length; i++) {
      trs[i].addEventListener('click', function () { //addEventListener(event이름, function(실행할기능))
          console.log(this.children[0].innerHTML); //td태그 첫번째(번호)의 html

          //form 화면의 각 요소의 값에 this.children[0].innerHTML
          document.getElementById('num').value = this.children[0].innerHTML;
          document.getElementById('title').value = this.children[1].innerHTML;
          document.getElementById('writer').value = this.children[2].innerHTML;
          document.getElementById('regDate').value = this.children[3].innerHTML;
      });
  }
}

  // function childCnt() {
  //     let table = document.getElementById('list');

  //     if (table.row.length % 2 == 1) {
  //         table.style.backgroundColor = '#e0f0b5';

  //     } else {
  //         table.style.backgroundColor = 'white';
  //     }
  // }



  function submitFnc(e) {
      e.preventDefault(); //submit의 기본 기능을 차단. => 페이지 안넘어가도록함.
      if (document.frm.num.value == '') {
          alert('번호를 입력하세요!')
          document.frm.num.focus();
          return;
      }
      if (document.frm.title.value == '') { //값을 안넣었을 경우.
          alert('제목을 입력하세요!')
          document.frm.title.focus();
          return; //function을 종료한다는 의미.
      }
      if (document.frm.writer.value == '') {
          alert('이름을 입력하세요!')
          document.frm.writer.focus();
          return;
      }
      if (document.frm.regDate.value == '') {
          alert('날짜를 입력하세요!')
          document.frm.regDate.focus();
          return;
      }


      let num = document.frm.num.value;
      let title = document.frm.title.value;
      let writer = document.frm.writer.value;
      let regDate = document.frm.regDate.value;

      let uList = document.querySelector('#list>tbody')

      // let childCnt = uList.children.length; //tbody 하위의 td 갯수가 몇개인가.
      // console.log(childCnt);

      //0, null, '' => false
      //1, 'value' => true
      // if (uList.childNodes.length) {
      //     uList.appendChild(createTr(num, title, writer, regDate));
      //     document.frm.num.value = '';
      //     document.frm.title.value = ''; //사용자 입력 후 입력값을 지움.
      //     document.frm.writer.value = '';
      //     document.frm.regDate.value = '';
      //     document.frm.num.focus() //첫번째 입력값의 위치에 초점을 둠.
      // }

      let childCnt = list.children.length + 1;
      if (childCnt % 2 == 0) {
          let liTag = createTr(num, title, writer, regDate);
          liTag.setAttribute('class', 'altRow');
          // liTag.className='altRow'
          list.appendChild(liTag);
      } else {
          list.appendChild(createTr(num, title, writer, regDate))
      }
      document.frm.num.value = childCnt + 1;
      addTrEvent();
  }

  //수정 버튼을 클릭하면 실행될 eventHandler(실행코드)
  let updateBtn = document.querySelector('#inputForm > form > input[type="button"]');
  console.log(updateBtn);
  updateBtn.addEventListener('click', function () {
      //form태그 안에 사용자가 수정한 값을 테이블에서 찾아와서(tr태그의 id기준으로) 하위요소 값 변경.
      let numInput = document.getElementById('num');
      let titInput = document.getElementById('title');
      let wriInput = document.getElementById('writer').value;
      let regInput = document.getElementById('regDate');

      console.log(numInput.value); //수정하고자 하는 게시판의 글번호.
      let searchId = numInput.value;
      let findTr = document.getElementById(searchId);
      console.log(findTr);
      //제목 수정
      findTr.children[1].innerHTML = titInput.value;
      //이름 수정
      findTr.children[2].innerHTML = wriInput;
      //날짜 수정
      findTr.children[3].innerHTML = regInput.value;
  });

  //선택삭제 버튼 클릭하면 선택값만 삭제처리.
  document.getElementById('delBin');
  delBtn.addEventListener('click', function () {
      //체크박스가 선택된 요소를 가져와야함.
      let checkedBox = document.querySelectorAll('#list > tbody > tr > td > input[type="checkbox"]:checked')
      console.log(checkedBox);
      for (let i = 0; i < checkedBox.length; i++) {
          checkedBox[i].parentNode.parentNode.remove();
      }

      //남은 데이터의 tr건수만큼 가져와서 class속성을 altRow로
      let remainTr = document.querySelectorAll('#list > tbody > tr');
      for (let i = 0; i < remainTr.length; i++) {
          if (i % 2 == 1) {
              remainTr[i].className = 'altRow';
          } else {
              remainTr[i].className = '';
          }
      }

  })