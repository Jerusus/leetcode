/**
 * @param {string[]} emails
 * @return {number}
 */
var numUniqueEmails = function(emails) {
    var map = {};
    for (var i = 0; i < emails.length; i++) {
        var email = emails[i].split("@");
        var local = email[0];
        local = local.split("+")[0];
        local = local.replace(new RegExp("\\.", "g"),"");
        var domain = email[1];
        map[local+domain] = true;
    }
    return Object.keys(map).length;
};