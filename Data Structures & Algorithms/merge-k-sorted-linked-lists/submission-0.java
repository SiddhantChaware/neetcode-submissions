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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        List<Integer> lst = new ArrayList<>();
        for(int i = 0;i < lists.length;i++){
            ListNode temp = lists[i];
            while(temp != null){
                lst.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(lst);
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(int i = 0;i < lst.size();i++){
            temp.next = new ListNode(lst.get(i));
            temp = temp.next;
        }
        return dummy.next;
    }
}
