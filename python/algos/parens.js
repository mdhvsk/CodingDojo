/* 
Parens Valid
Given an str that has parenthesis in it
return whether the parenthesis are valid
*/

const str1 = "Y(3(p)p(3)r)s";
const expected1 = true;

const str2 = "N(0(p)3";
const expected2 = false;
// Explanation: not every parenthesis is closed.

const str3 = "N(0)t ) 0(k";
const expected3 = false;
// Explanation: because the second ")" is premature: there is nothing open for it to close.

const str4 = "a(b))(c";
const expected4 = false;
// Explanation: same number of opens and closes but the 2nd closing closes nothing.

const str5 = ")"
/**
 * Determines whether the parenthesis in the given string are valid.
 * Each opening parenthesis must have exactly one closing parenthesis.
 * - Time: O(?).
 * - Space: O(?).
 * @param {string} str
 * @returns {boolean} Whether the parenthesis are valid.
 */
function parensValid(str) {
    var tracker = []

    for (var i = 0; i < str.length; i++){
        if (str[i] == ")" && tracker.length == 0 ){
            return false
        }
        else if (str[i] == '('){
            tracker.push(str[i]);
        }

        else if (str[i] == ")"){
            tracker.pop();
        }
        else {
            continue 
        }
    }

    if (tracker.length == 0){
        return true
    }
    else {
        return false
    }
    
}

// console.log(parensValid(str1))
// console.log(parensValid(str2))
// console.log(parensValid(str3))
// console.log(parensValid(str4))
// console.log(parensValid(str5))




/*****************************************************************************/

/* 
Braces Valid
Given a string sequence of parentheses, braces and brackets, determine whether it is valid. 
*/

const two_str1 = "W(a{t}s[o(n{ c}o)m]e )h[e{r}e]!";
const two_expected1 = true;

const two_str2 = "D(i{a}l[ t]o)n{e";
const two_expected2 = false;

const two_str3 = "A(1)s[O (n]0{t) 0}k";
const two_expected3 = false;

/**
 * Determines whether the string's braces, brackets, and parenthesis are valid
 * based on the order and amount of opening and closing pairs.
 * - Time: O(?).
 * - Space: O(?).
 * @param {string} str
 * @returns {boolean} Whether the given strings braces are valid.
 */
function bracesValid(str) {
    var tracker = []
    const open = ['{', '(', '[']
    const close = ['}', ')', ']']
    for (var i = 0; i < str.length; i++) {
        if (tracker.length == 0 && close.includes(str[i])) {
            return false
        }
        

        if (open.includes(str[i])) {
            tracker.push(str[i])
        }
        else if (close.includes(str[i])){
            var curr = close.indexOf(str[i])
            if (tracker[tracker.length-1] == open[curr]){
                tracker.pop()
            }
            else {
                return false
            }
        }
        else {
            continue
        }   
    }


    if (tracker.length == 0){
        return true
    }
    else {
        return false
    }

}

console.log(bracesValid(two_str1))
console.log(bracesValid(two_str2))
console.log(bracesValid(two_str3))
console.log(bracesValid('[(0)}'))