const keys1 = ["abc", 3, 'yo']
const vals1 = [42, 'wassup', true]

const keys2 = []
const vals2 = []

const keys3 = ["abc", 3, true]
const vals3 = [42, 'wassup', 'yo', 'wow']

const keys4 = ['yo', 'abc', 3,  'something']
const vals4 = [42, 'wassup', true]

function createDict(key, value){
    var answer = {}
    if (key.length < value.length){
        return false
    }
    for (var i=0; i<key.length; i++)
        answer[key[i]] = value[i]
        
    return answer
}

console.log(createDict(keys1, vals1))
console.log(createDict(keys2, vals2))
console.log(createDict(keys3, vals3))
console.log(createDict(keys4, vals4))



// Inverted hash


const two_obj1 = { name: "Zaphod", charm: "high", morals: "dicey" };
const two_expected1 = { Zaphod: "name", high: "charm", dicey: "morals" };

const two_obj2 = { name: "Zaphod", charm: "high", morals: "dicey", something:1 };
const two_expected2 = { Zaphod: "name", high: "charm", dicey: "morals", 1:"something" };

const two_obj3 = { name: "Zaphod", charm: "high", morals: "dicey", something:"dicey" , why:"dicey"};
const two_expected3 = { Zaphod: "name", high: "charm", dicey: ["morals", "something"] };

function invertedHash(obj){
    oldKeys = Object.keys(obj)
    oldVals = Object.values(obj)
    answer = {}
    for (var i=0; i<oldVals.length; i++){
        if (answer[oldVals[i]]!= undefined){
            if (Array.isArray(answer[oldVals[i]])){
                answer[oldVals[i]].push(oldKeys[i])          
                continue
            }
            var repeat = []
            repeat.push(answer[oldVals[i]])
            repeat.push(oldKeys[i])
            answer[oldVals[i]] = repeat
            continue
        }
        answer[oldVals[i]] = oldKeys[i]
    }
    return answer
}

console.log(invertedHash(two_obj1))
console.log(invertedHash(two_obj2))
console.log(invertedHash(two_obj3))