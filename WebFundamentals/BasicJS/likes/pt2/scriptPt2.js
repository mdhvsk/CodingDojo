function add1(element) {
    var countElement = document.getElementById(element);
    newNum = Number(countElement.innerText)
    newNum++
    countElement.innerText = newNum 
}