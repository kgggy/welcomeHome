//js/variable.js

let var1 = 'Hello'; //let => 변수선언.
var1='world'; //String
var1 = 100; 
var1 = true; //값이 할당될 때 타입이 정해짐. => 여러 타입을 담을 수 있음.
console.log(typeof var1); //해당 변수의 타입을 출력해줌.
console.log(var1); //변수 출력.

const con1 = 'Good'; //const => 상수선언. --- 값이 한번 할당되면 바꿀 수 없음.
//con1 = 'Morning';

console.log(1+1);
let num1 = 1;
let num2 = 1;
console.log(num1+num2);

document.write('<h1>Hello</h1>'); //콘솔영역이 아닌 다큐먼트 영역에 보여줌.
document.write('<ul>');
document.write('  <li>Apple</li>');
document.write('  <li>Banana</li>');
document.write('</ul>');

let str = '<ul>';
str += '      <li>Orange</li>';
str += '      <li>Mango</li>';
str += '   </ul>';
document.write(str);

let fruits = ['수박', '딸기', '복숭아'];
fruits = new Array();
fruits.push('블루베리') //배열에 값 추가.
fruits.push('망고')
fruits[2] = '자두';
fruits[fruits.length] = '사과';
fruits[fruits.length] = '포도';
fruits.push('aa');
fruits.pop(); //마지막 위치 삭제.
fruits.unshift('옥수수'); //첫번째에 추가.
fruits.shift(); //첫번째 위치 삭제.


console.log(typeof fruits);

document.write('<ul>');
for(let i=0; i<fruits.length; i++){
    document.write('<li>' + fruits[i] + '</li>');
}
document.write('</ul>');

