var count = [9, 12, 9];

function add1(element) {
    if (element=='first'){
        var countElement = document.querySelector("#first");
        count[0]++;
        countElement.innerText = count[0]
    }
    if (element=='second'){
        var countElement = document.querySelector("#second");
        count[1]++;
        countElement.innerText = count[1]
    }
    if (element=='third'){
        var countElement = document.querySelector("#third");
        count[2]++;
        countElement.innerText = count[2]
    }
}