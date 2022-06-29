var connectionRequests = 2
var connections = 432

function editName(){
    element = document.querySelector("#profileName");
    element.innerText = "Madhav Asok"
}

function removeRequest(arg){
    element = document.querySelector(arg)
    element.remove();
}

function requestNum(arg){
    element = document.querySelector("#requestTally");
    connectionRequests--
    element.innerText = connectionRequests 
    removeRequest(arg)
    

}

function connectNum(arg){
    connection = document.querySelector("#connectTally");
    connections++
    connection.innerText = connections;
    requestNum(arg)
}