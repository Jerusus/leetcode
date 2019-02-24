/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  var dict = {};
  for (var i = 0; i < s.length; i++) {
    if (dict[s[i]]) {
      dict[s[i]] = 2;
    } else {
      dict[s[i]] = 1;
    }
  }
  for (var i = 0; i < s.length; i++) {
    if (dict[s[i]] == 1) {
      return i;
    }
  }
  return -1;
};
