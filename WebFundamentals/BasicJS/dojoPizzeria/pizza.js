function pizzaOven (crustType, sauceType, cheeses, toppings) {
    var pizza = {};
    pizza.crustType = crustType;
    pizza.sauceType = sauceType;
    pizza.cheeses = cheeses;
    pizza.toppings=toppings;
    return pizza;
}



var pizza1 = pizzaOven("deep dish", "traditional", ["mozzeralla"], ["pepperoni", "sausage"])
var pizza2 = pizzaOven("hand tossed", "marinara", ["mozzeralla", "feta"], ["mushrooms", "olives", "onions"])
var pizza3 = pizzaOven("thin crust", "pesto",["four cheese"], ["chicken", "saussage"] )
var pizza4 = pizzaOven("cheesy crust", "alfredo", ["mozzeralla"], ["ham", "pineapple"])

console.log(pizza1)
console.log(pizza2)
console.log(pizza3)
console.log(pizza4)

var crustTypeList = ["deep dish", "hand tossed", "thin crust", "cheesy crust"]
var sauceTypeList = ["traditional", "marinara", "pesto", "alfredo"]
var cheesesList = ["mozzeralla", "four cheese", "feta"]
var toppingsList = ["pepperoni", "sausage", "mushrooms", "olives", "onions", "chicken", "ham", "pineapple"]

function getRandomInt(max){
    min = 0;
    max = Math.floor(max);
    return Math.floor(Math.random() * (max-min) + min)
}

function randomPizzaOven(){
    var pizza = {}
    pizza.crustType = crustTypeList[getRandomInt(crustTypeList.length)]
    pizza.sauceType = sauceTypeList[getRandomInt(sauceTypeList.length)]
    var cheeses = Array(getRandomInt(cheesesList.length)+1).fill(0)
    for (var i = 0; i<cheeses.length;i++){
        cheeses[i] = cheesesList[getRandomInt(cheesesList.length)];
    }
    pizza.cheeses = cheeses;
    var toppings = Array(getRandomInt(toppingsList.length)+1).fill(0)
    for (var i = 0; i<toppings.length;i++){
        toppings[i] = toppingsList[getRandomInt(toppingsList.length)];
    }
    pizza.toppings = toppings;
    return pizza
}

var x = randomPizzaOven()
console.log(x)

//NEXT TO DO: refactor to ensure there are no repeats 







// var trial = Array(getRandomInt(cheesesList.length) + 1).fill(cheesesList[getRandomInt(cheesesList.length)])
// console.log(trial)


// var cheeses = Array(getRandomInt(cheesesList.length)+1).fill(0)
// console.log(newTrial)

// for (var i = 0; i<newTrial.length;i++){
//     newTrial[i] = cheesesList[getRandomInt(cheesesList.length)];
// }

// console.log(newTrial)
// "(cheesesList[getRandomInt(cheesesList.length)])"
// var arrTrial = Array.from(xy.repeat(getRandomInt(cheesesList.length) + 1));
// console.log(arrTrial)

// y = getRandomInt(8);
// console.log(y);
// x = cheesesList.length;
// console.log(x)

// console.log(toppingsList[y])
