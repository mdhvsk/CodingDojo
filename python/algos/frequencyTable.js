const arr1 = ["a", "a", "a"]
const expected1 = {"a": 3}

const arr2 = ["a", "b", "a", "c", "B", "c", "c", "d"];
const expected2 = {
  a: 2,
  b: 1,
  c: 3,
  B: 1,
  d: 1,
};

const arr3 = [];
const expected3 = {};


function makeFrequencyTable(arr){
    var countDict = {}
    for (var i = 0; i< arr.length; i++ ) {
        if (countDict[arr[i]]) {
            countDict[arr[i]] += 1
            continue
        }
        countDict[arr[i]] = 1
    }
    return countDict
}

console.log(makeFrequencyTable(arr3))



