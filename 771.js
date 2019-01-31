/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    var map = {};
    var res = 0;
    for (var i = 0; i < J.length; i++) {
        map[J.charAt(i)] = true;
    }
    for (var i = 0; i < S.length; i++) {
        if (map[S.charAt(i)]) {
            res++;
        }
    }
    return res;
};