//js/function.js

    function cal() {
        let num1 = document.getElementById('num1');
        let num2 = document.getElementById('num2');
        console.log(Number(num1.value) + Number(num2.value));
        let result = document.getElementById('result');
        // result.value = sum(Number(num1.value), Number(num2.value));
        result.value = fnc(Number(num1.value), Number(num2.value));
    }

    console.log('function정의 전: ' + sum(10, 20));
    //console.log('function정의 전: ' + fnc(10, 20)); //변수는 정의->실행의 순서 지켜줘야함.

    let fnc = function (a, b) {
        return a + b;
    }
    console.log(fnc(10, 20));

    function sum(num1, num2) { //function => 위로 끌어올려져 가장 처음 읽어줌. => 선언 전에 호출해도 상관없음.
        //hoisting: function정의문을 끌어올림.
        return num1 + num2;
    }
    let result = sum(10, 20);
    console.log(result);
    result = sum('Hello', 'World');
    console.log(result);