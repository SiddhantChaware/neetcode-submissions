/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while(true){
            ListNode kth = groupPrev;
            for(int i = 0;i < k;i++){
                kth = kth.next;
                if(kth == null){
                    break;
                }
            }
            if(kth == null){
                break;
            }

            ListNode groupNext = kth.next;
            ListNode groupStart = groupPrev.next;

            kth.next = null;
            reverse(groupStart);

            groupPrev.next = kth;
            groupStart.next = groupNext;

            groupPrev = groupStart;
        }    
        return dummy.next;
    }
}
