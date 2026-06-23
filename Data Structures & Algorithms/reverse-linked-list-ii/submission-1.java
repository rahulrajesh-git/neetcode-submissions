class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPrev = dummy;
        ListNode cur = head;

        for (int i = 0; i < left - 1; i++) {
            leftPrev = cur;
            cur = cur.next;
        }

        ListNode subHead = cur;
        ListNode prev = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode tempNxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNxt;
        }

        leftPrev.next = prev;
        subHead.next = cur;

        return dummy.next;
    }
}