/* 
  Recursively reverse a string
  helpful methods:
  str.slice(beginIndex[, endIndex])
  returns a new string from beginIndex to endIndex exclusive
*/

const str1 = "abc";
const expected1 = "cba";

const str2 = "";
const expected2 = "";

const str3 = "Hello World";
const expected3 = "dlroW olleH";

/**
 * Recursively reverses a string.
 * - Time: O(?).
 * - Space: O(?).
 * @param {string} str
 * @returns {string} The given str reversed.
 */
function reverseStr(str, newStr = "") {
    strLength = str.length
    if (strLength == 0) return ""

    newStr += str.slice(strLength-1)
    if (strLength == 1) return newStr
    return reverseStr(str.substring(0, strLength-1), newStr)
}

console.log(reverseStr(str1))
console.log(reverseStr(str2))
console.log(reverseStr(str3))


/*****************************************************************************/


/*
  Recursive Binary Search
  Input: SORTED array of ints, int value
  Output: bool representing if value is found
  Recursively search to find if the value exists, do not loop over every element.
  Approach:
  Take the middle item and compare it to the given value.
  Based on that comparison, narrow your search to a particular section of the array
*/

const two_nums1 = [1, 3, 5, 6];
const two_searchNum1 = 4;
const two_expected1 = false;

const two_nums2 = [4, 5, 6, 8, 12];
const two_searchNum2 = 5;
const two_expected2 = true;

const two_nums3 = [3, 4, 6, 8, 12];
const two_searchNum3 = 3;
const two_expected3 = true;

/**
 * Add params if needed for recursion
 * Recursively performs a binary search (divide and conquer) to determine if
 * the given sorted nums array contains the given number to search for.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Array<number>} sortedNums
 * @param {number} searchNum
 * @returns {boolean} Whether the searchNum was found in the sortedNums array.
 */
function binarySearch(sortedNums, searchNum) {
    var low = 0 
    var mid = Math.floor(sortedNums.length / 2)
    var high = sortedNums.length

    if (searchNum == sortedNums[mid]) return true
    if (low == high && sortedNums[mid] != searchNum) return false

    if (searchNum < sortedNums[mid])return binarySearch(sortedNums.slice(0,mid), searchNum)
    else if (searchNum > sortedNums[mid]) return binarySearch(sortedNums.slice(mid+1,high), searchNum)
}

console.log(binarySearch(two_nums1, two_searchNum1))
console.log(binarySearch(two_nums2, two_searchNum2))
console.log(binarySearch(two_nums3, two_searchNum3))