//js/variable1.js
const numbers = [23, 44, 18, 35, 50];
numbers.push(42);
let sum = 0;
document.write('&nbsp&nbsp&nbsp' + numbers[0]);
for (let i = 1; i < numbers.length; i++) {
    console.log(numbers[i]);
    document.write('<br>' + "+ " + numbers[i])
    sum += numbers[i];
}
sum = sum + numbers[0];
numbers.pop(numbers[1]);
document.write('<br>')
document.write('---------');
document.write('<br>' + "합계 " + sum)
console.log(sum);