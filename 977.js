/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortedSquares = function(A) {
  var front = 0;
  var end = A.length - 1;
  var res = [];
  while (front <= end) {
    if (Math.abs(A[front]) > Math.abs(A[end])) {
      res.unshift(Math.pow(A[front], 2));
      front++;
    } else {
      res.unshift(Math.pow(A[end], 2));
      end--;
    }
  }
  return res;
};

console.log(sortedSquares([-7, -3, 2, 3, 11]));
