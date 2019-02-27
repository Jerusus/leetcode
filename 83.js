function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if (head === null) {
        return null;
    }
    var unique = head;
    var cur = head;
    while(cur !== null) {
        if (unique.val !== cur.val) {
            unique.next = cur;
            unique = cur;
        }
        cur = cur.next;
    }
    unique.next = null;
    return head;
};

// var head = new ListNode(1);
// var a = new ListNode(1);
// var b = new ListNode(2);
// var c = new ListNode(2);
// var d = new ListNode(3);
// head.next = a;
// a.next = b;
// b.next = c;
// c.next = d;
// var x = deleteDuplicates(head);
// console.log(x);
