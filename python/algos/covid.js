/* 
Given an array of ints representing a line of people where the space between
indexes is 1 foot, with 0 meaning no one is there and 1 meaning someone is in
that space,
return whether or not there is at least 6 feet separating every person.
Bonus: O(n) linear time (avoid nested loops that cause re-visiting indexes).
*/

const queue1 = [0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1];
const expected1 = false;

const queue2 = [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1];
const expected2 = true;

const queue3 = [1, 0, 0, 0, 0, 0, 0, 0, 1];
const expected3 = true;

const queue4 = [];
const expected4 = true;

/**
 * Determines whether each occupied space in the line of people is separated by
 * 6 empty spaces.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Array<0|1>} queue
 * @returns {Boolean}
 */
function socialDistancingEnforcer(queue) {
  counterOn = false
  counter = 0;
  
  for (var i=0; i < queue.length; i++){
    if (counterOn){
      counter++
    }
    if (queue[i] == 1) {
      if (counterOn == true && counter < 6){
        return false
      }
      counterOn = true
      counter = 0
      }
  }
  return true
}

// console.log(socialDistancingEnforcer(queue1))
// console.log(socialDistancingEnforcer(queue2))
// console.log(socialDistancingEnforcer(queue3))
// console.log(socialDistancingEnforcer(queue4))


// *****************************************************************

/* 
  Balance Index
  Here, a balance point is ON an index, not between indices.
  Return the balance index where sums are equal on either side
  (exclude its own value).
  
  Return -1 if none exist.
  
*/

// [-2, 3, 10, 10, 13]
// [3,3,10, 15, 13]

const two_nums1 = [-2, 5, 7, 0, 3];
const two_expected1 = 2;

const two_nums2 = [9, 9];
const two_expected2 = -1;

// [10, 12, 17, 22, 27, 28, 29]
//[1,2,7,12,17, 19, 29]

const two_nums3 = [10, 2, 5, 5, 5, 1, 1]
const two_expected3 = 2;

const two_nums4 = [10, 2, 5, 5, 5, 1, 1, 3]
const two_expected4 = -1;

const two_nums5 = [2,0,1,1]
const two_expected5 = 1

const two_nums6 = [5,8,9, -5, 1,4,3, 14]

const two_nums7 = [1, 1, 1, 4]


/**
 * Finds the balance index in the given array where the sum to the left of the
 *    index is equal to the sum to the right of the index.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Array<number>} nums
 * @returns {number} The balance index or -1 if there is none.
 */
function balanceIndex(nums) {
  if (nums.length < 3){
    return -1
  }

  forward = []
  sumForward = 0
  for(var i = 0; i < nums.length; i++){
    sumForward += nums[i]
    forward.push(sumForward)
  }

  backward = []
  sumBack = 0
  for (var i = nums.length -1; i > -1; i--){
    sumBack += nums[i]
    backward.push(sumBack)
  }

  for (var i = 1; i < nums.length; i++){
    left = forward[i-1]
    right = backward[backward.length-2-i]
    if (left == right){
      return i
    }
  }
  return -1

}

console.log(balanceIndex(two_nums1))
console.log(balanceIndex(two_nums2))
console.log(balanceIndex(two_nums3))
console.log(balanceIndex(two_nums4))
// console.log(balanceIndex(two_nums5))
// console.log(balanceIndex(two_nums6))
// console.log(balanceIndex(two_nums7))


