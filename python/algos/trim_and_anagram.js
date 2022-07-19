/* 
  Given a string that may have extra spaces at the start and the end,
  return a new string that has the extra spaces at the start and the end trimmed (removed)
  do not remove any other spaces.
*/

const str1 = "   hello world     ";
const expected1 = "hello world";

const str2 = "   hello     world     ";
const expected2 = "hello     world";

/**
 * Trims any leading or trailing white space from the given str.
 * - Time: O(?).
 * - Space: O(?).
 * @param {string} str
 * @returns {string} The given string with any leading or trailing white space
 *    stripped.
 */
// function trim(str) {
//     var wordStarted = false
//     var newWord = ""
//     var potentialEnd = ""
//     var potentialEndBool = false
//     for (var i = 0; i < str.length; i++){
//         if (wordStarted == true) {
//             newWord += str[i]
//             console.log(str[i])
            
//         }
//         else if (str[i] != " "){
//             wordStarted = true
//             newWord += str[i]
//             console.log(str[i])
//         }
//     }
//     console.log(newWord.length)
//     console.log(newWord)

//     wordStarted = false
//     var finalWord = ""
//     for (var j = newWord.length-1; j > -1; j--) {
//         if (wordStarted == true) {
//             finalWord += str[j]
//             console.log(str[j])
            
//         }
//         else if (str[j] != " "){
//             wordStarted = true
//             finalWord += str[j]
//             console.log(str[j])
//         }
//     }

//     console.log(finalWord.length)
//     return finalWord
// }

function trim(str) {
    for (var i = 0; i < str.length; i++) {
        if (str[i] != " "){
            var first = i
            break
        }
    }

    for (var i = str.length; i > -1; i--) {
        if (str[i] != " "){
            var last = i 
            break
        }
    }

    const newString = str.slice(first, last+1)
    console.log(newString.length)
    return newString
}

console.log(trim(str1))

/*****************************************************************************/

/* 
  An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
  typically using all the original letters exactly once.
  Is there a quick way to determine if they aren't an anagram before spending more time?
  Given two strings
  return whether or not they are anagrams
*/

const two_strA1 = "yes";
const two_strB1 = "eys";
const two_expected1 = true;

const two_strA2 = "yes";
const two_strB2 = "eYs";
const two_expected2 = true;

const two_strA3 = "no";
const two_strB3 = "noo";
const two_expected3 = false;

const two_strA4 = "silent";
const two_strB4 = "listen";
const two_expected4 = true;

/**
 * Determines whether s1 and s2 are anagrams of each other.
 * Anagrams have all the same letters but in different orders.
 * - Time: O(?).
 * - Space: O(?).
 * @param {string} s1
 * @param {string} s2
 * @returns {boolean} Whether s1 and s2 are anagrams.
 */
function isAnagram(s1, s2) {
    if (s1.length != s2.length) {
        return false
    }
    s1 = s1.toLowerCase()
    s2 = s2.toLowerCase()

    myDict1 = {}
    myDict2 = {}

    for (var i = 0; i < s1.length; i++){
        if (myDict1[s1[i]] != undefined) {
            myDict1[s1[i]] += 1
            continue
        }
        myDict1[s1[i]] = 1
    }

    for (var i = 0; i < s2.length; i++){
        if (myDict2[s2[i]] != undefined) {
            myDict2[s2[i]] += 1
            continue
        }
        myDict2[s2[i]] = 1
    }
    
    console.log(myDict1)
    console.log(myDict2)
    
    console.log (myDict1 == myDict2)
}

console.log(isAnagram(two_strA1, two_strB1))