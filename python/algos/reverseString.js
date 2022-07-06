const str1 = "- "


function reverseString(word) {
    var reverseString = ""
    for (var i = (word.length) - 1; i > -1; i--) {
        reverseString += word[i];
    }
    return reverseString
}

console.log(reverseString(str1))




// console.log(str2)


const twoStr1 = " dog bird cat    "

function acronymize(str){
    var two_expected = ""
    if (str[0] != " ") {
        two_expected += str[0]
    }
    for (var i = 0; i < str.length; i++) {
        if (str[i] == " " && str[i + 1] != " " && str[i+1] != undefined) {
            two_expected = two_expected + twoStr1[i + 1]
        }
    }
    two_expected = two_expected.toUpperCase()
    return two_expected
    
}



// var two_expected = two_expected.toUpperCase()
// console.log(two_expected)

console.log(acronymize(twoStr1))