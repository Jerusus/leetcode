function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var partition = function(head, x) {
    if (head === null) {
        return null;
    }
    var dummy = new ListNode(null);
    dummy.next = head;
    var lowerPartHead = dummy;
    while (lowerPartHead !== null && (lowerPartHead.val === null || lowerPartHead.val < x)) {
        var upperPartHead = lowerPartHead.next;
        var swap = false;
        if (upperPartHead !== null && upperPartHead.val >= x) {
            swap = true;
            var upperPartTail = upperPartHead;
            while (upperPartTail.next !== null && upperPartTail.next.val >= x) {
                upperPartTail = upperPartTail.next;
            }
            if (swap && upperPartTail.next) {
                var lowerPartTail = upperPartTail.next;
                upperPartTail.next = lowerPartTail.next;
                lowerPartHead.next = lowerPartTail;
                lowerPartTail.next = upperPartHead;
            }
        }
        lowerPartHead = lowerPartHead.next;
    }
    return dummy.next;
};

// var head = new ListNode(1);
// var x = new ListNode(4);
// var xx = new ListNode(3);
// var xxx = new ListNode(2);
// var xxxx = new ListNode(5);
// head.next = x;
// x.next = xx;
// xx.next = xxx;
// xxx.next = xxxx;
// var a = partition(head, 3);
// console.log(a);
