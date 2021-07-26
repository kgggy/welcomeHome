 //js/variable2.js
 // const object = new Object();
 // object.name = 'Kim'; //key=value 형식
 // object.age = 30;
 const obj = {
     name: 'Hong', //key: value 형식
     age: 20,
     hobby: ['sleeping', 'dancing', 'eating']
 };
 console.log('이름: ' + obj.name);
 console.log('나이: ' + obj['age']);
 console.log('취미: ' + obj.hobby[0]);
 console.log('취미: ' + obj['hobby'][1]);
 let hob = 'hobby';
 console.log('취미: ' + obj[hob][2]);

 const mem1 = {
     id: 'user1',
     name: '홍길동',
     passwd: '1234'
 }
 const mem2 = {
     id: 'user2',
     name: '권가영',
     passwd: '1111'
 }
 const mem3 = {
     id: 'user3',
     name: '오혜지',
     passwd: '2222'
 }
 //for in => 필드의 갯수 만큼 반복.
 for (field in mem3) { //mem3의 필드를 가져옴 
     console.log(field + ', ' + mem3[field]); // mem3[field] => 필드값을 가져옴.
 }
 const members = [mem1, mem2, mem3];
 for (let i = 0; i < members.length; i++) {
     // console.log('아이디: ' + members[i].id);
     // console.log('이름: ' + members[i]['name']);
     // console.log('패스워드: ' + members[i]['passwd']);
     for (field in members[i]) {
         console.log(field + ', ' + members[i][field]);
     }
     console.log('----------------------');
 }