var count = 3;
var countElement = document.querySelector("#likeTally")

console.log(countElement)

function add1() {
    count++;
    console.log(count)
    countElement.innerText = count + " likes(s)"
}