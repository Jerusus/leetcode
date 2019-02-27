function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var rotateRight = function (head, k) {
    if (head === null) {
        return null;
    } else if (k === 0) {
        return head;
    }
    // create the loop
    var p1 = head;
    var p2 = head;
    var size = 1;
    while (p1.next !== null) {
        size++;
        p1 = p1.next;
    }
    p1.next = head;

    // rotate
    var timesToShift = 2 * size - (k % size) - 1; // this is so dumb
    for (var i = 0; i < timesToShift; i++) {
        p2 = p2.next;
    }
    head = p2.next;
    p2.next = null;
    return head;
};

// var head = new ListNode(0);
// var a = new ListNode(1);
// var b = new ListNode(2);
// var c = new ListNode(4);
// var d = new ListNode(5);
// head.next = a;
// a.next = b;
// b.next = c;
// c.next = d;
// var x = rotateRight(head, 2);
// console.log(x);
