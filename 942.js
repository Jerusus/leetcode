/**
 * @param {string} S
 * @return {number[]}
 */
var diStringMatch = function(S) {
    var res = [];
    var temp = [0];
    for (var i = 1; i <= S.length; i++) {
        if (S.charAt(i-1) === 'I') {
            res = res.concat(temp);
            temp = [];
            temp.push(i);
        } else {
            temp.unshift(i);
        }
    }

    res = res.concat(temp);

    return res;
};