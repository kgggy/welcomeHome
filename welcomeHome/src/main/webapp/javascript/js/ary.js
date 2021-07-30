const numbers = [23, 43, 77, 88, 65];
for (let i = 0; i < numbers.length; i++) {
    console.log(numbers[i]);
}
for (let num of numbers) { //numbers에 든 갯수만큼 반복.
    console.log(num);
}

let sum = 0;
// numbers.forEach(function(val, idx) { //forEach(function(매개변수)) => 배열 가져오는 메소드.
//     //console.log(val, idx); //(배열에 들어있는 값, 인덱스.)
//     sum += val;
// });

let fData = numbers.filter(function (val, idx) { //조건에 만족하는 값만 배열타입으로 리턴됨.
    // if(idx < 3) {
    //     return val;
    // }
    return val > 40;
});
console.log(`fData: ${fData}`); //``=> string값 출력.

mData = fData.map(function (val, idx) { //요소 하나를 받아와 추가적 작업을 하고 리턴해줌. 배열타입으로 리턴됨.
    return val * 2;
});
console.log(`mData: ${mData}`);

mData.forEach(sumCallBack);

//  numbers.forEach(sumCallBack);

function sumCallBack(v, i) {
    // if (v < 50) {
    //     sum += v;
    // }
    sum += v;
}
console.log(`합계 : ${sum}`);

console.log('---------------------');

numbers.filter(function (val, idx) {
        return val > 40;
    })
    .map(function (val, idx) {
        return val * 2;
    })
    .forEach(function (val, idx) {
        console.log(`val: ${val}, idx: ${idx}`);
    });