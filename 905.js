/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
    var l = A.length;
    for (var i = 0; i < l; i++) {
        if (A[i] % 2 != 0) {
            var x = A[i];
            A.splice(i, 1);
            A.push(x);
            i--;
            l--;
        }
    }
    return A;
};