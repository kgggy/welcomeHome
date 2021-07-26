//js/variable3.js
const students = [];
//학생이름(name), 국어(kor), 수학(mat), 영어(eng)를 담는 student 오브젝트 선언.
const student1 = {
    name: '권가영',
    kor: 95,
    mat: 90,
    eng: 100
}
const student2 = {
    name: '오혜지',
    kor: 100,
    mat: 90,
    eng: 95
}
const student3 = {
    name: '박주현',
    kor: 90,
    mat: 95,
    eng: 100
}
students.push(student1);
students.push(student2);
students.push(student3);
const fields = {
    name: '학생명',
    kor: '국어',
    mat: '수학',
    eng: '영어'
}
document.write('<table border = "1">')
document.write('<thead><tr>')
for (field in student1) {
    document.write('<th>' + fields[field] + '</th>')
    //document.write('<td>' + field + '</td>')
}
document.write('</tr></thead>')
document.write('<tbody>')
for (let i = 0; i < students.length; i++) {
    document.write('<tr>')
    for (field in students[i]) {
        document.write('<td align = center>' + students[i][field] + '</td>')
    }
    document.write('</tr>')
}
document.write('</tbody>')
document.write('</table>')