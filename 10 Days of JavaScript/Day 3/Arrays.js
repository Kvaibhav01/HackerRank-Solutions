// Link to the problem: https://www.hackerrank.com/challenges/js10-arrays/problem

/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/

function getSecondLargest(nums) {
    // Complete the function
    var sort_array = nums.sort(
        function (a, b) {
            return a - b;
        }
    );
    var new_array = sort_array.filter(
            function(e, index, arr) {
                return index === arr.indexOf(e);
            }
        
        );
    return new_array[new_array.length - 2];    
}
