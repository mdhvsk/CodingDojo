function odds() {
    for (var i=1; i<21; i++){
        if (i%2==1){
            console.log(i);
        }
    }
}

function threeDivsible(){
    for (var i = 100; i>-1; i--){
        if (i%3==0){
            console.log(i)
        }
    }
}

function deSequencing(){
    var start = 4;
    for (var i=0; i<6;i++){
        console.log(start)
        start -= 1.5;
    }
}

function sigma(){
    sum = 0;
    for (var i=1;i<101;i++){
        sum+=i
    }
    console.log(sum);
}

function factorial(){
    product = 1;
    for (var i=1;i<13;i++){
        product*=i
    }
    console.log(product);
}

//answers
odds()
threeDivsible()
deSequencing()
sigma()
factorial()

