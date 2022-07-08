const str1 = "aaaabbcdddaa";

const str2 = ""

const str3 = "aa"

const str4 = "bbss"


function encode(str) {
    var currLetter = str[0];
    var currTally = 1;
    var tally = ""
    if (str.length == 1) {
        return str
    }
    for (var i = 0; i < str.length; i++) {
        if (str[i + 1] != undefined) {
            if (str[i + 1] == currLetter) {
                currTally += 1
            }
            else {
                tally += currLetter;
                tally += String(currTally);
                currLetter = str[i + 1];
                currTally = 1;
            }
        }
        else {
            tally += currLetter
            tally += String(currTally)
        }
    }
    if (tally.length <= str.length) {
        return str
    }
    else {
        return tally
    }
}




console.log(encode(str3))


function decodeStr(str) {
    const numList = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"]
    var currLetter = str[0]
    var currTally = ""
    var tally = ""

    for (var i = 0; i < str.length; i++) {

        if (str[i + 1] == undefined) {
            currTally = parseInt(currTally)
            tally += currLetter.repeat(currTally)
            continue
        }

        if (numList.includes(str[i + 1])) {
            currTally += str[i + 1]
        }
        else {
            currTally = parseInt(currTally)
            tally += currLetter.repeat(currTally)
            currLetter = str[i + 1]
            currTally = ""
        }
    }

    return tally

}

var two_str1 = "a3b2c1d3"
const two_str2 = "a3b2c12d10";
const two_expected2 = "aaabbccccccccccccdddddddddd";

console.log(decodeStr(two_str2))



