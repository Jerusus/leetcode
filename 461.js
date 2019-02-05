/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    var val = x ^ y;
    var s = val.toString(2);
    var res = 0;
    for (var i = 0; i < s.length; i++) {
        if (s.charAt(i) === '1') {
            res++;
        }
    }
    return res;
};