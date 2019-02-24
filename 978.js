/**
 * @param {number[]} A
 * @return {number}
 */
var maxTurbulenceSize = function(A) {
  if (A.length === 1 || A.length === 2) {
    return A.length;
  }

  var max = 2;
  for (var i = 0; i < A.length - 1; i++) {
    var cur = 2;
    var diff = A[i + 1] - A[i];
    while (i < A.length - 1) {
      var newDiff = A[i + 2] - A[i + 1];
      if (diff * newDiff >= 0 || i + 2 === A.length) {
        max = Math.max(max, cur);
        break;
      }
      diff = newDiff;
      cur++;
      i++;
    }
  }
  return max;
};

console.log(maxTurbulenceSize([4, -1, 1, -1, -1, 1, 0, 1, 0, 1]));
