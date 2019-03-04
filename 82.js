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
    var dummy = new ListNode(null);
    dummy.next = head;
    var slow = dummy;
    var fast = dummy.next;
    while(fast !== null) {
        var faster = fast;
        var dupes = false;
        while(faster.next !== null) {
            if (faster.next.val === faster.val) {
                dupes = true;
                faster = faster.next;
            } else {
                break;
            }
        }
        if (dupes) {
            fast = faster.next;
            slow.next = fast;
        } else {
            slow = fast;
            fast = fast.next;
        }
    }
    return dummy.next;
};

// var head = new ListNode(1);
// var x = new ListNode(1);
// var xx = new ListNode(2);
// var xxx = new ListNode(3);
// var xxxx = new ListNode(4);
// head.next = x;
// x.next = xx;
// xx.next = xxx;
// xxx.next = xxxx;
// var a = deleteDuplicates(head);
// console.log(a);
