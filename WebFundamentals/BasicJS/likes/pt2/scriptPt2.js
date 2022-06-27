var count = [9, 12, 9];
var countElement = document.querySelector("#likeTally")

console.log(countElement)

function add1(element) {
    count++;
    console.log(count)
    countElement.innerText = count + " likes(s)"
}