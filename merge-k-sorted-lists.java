//https://leetcode.com/problems/merge-k-sorted-lists/
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
class merge-k-sorted-lists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = lists[0];
        for(int i = 1; i<lists.length; i++){
            result = mergeList(result, lists[i]);
        }
        return result;
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        ListNode current = result;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val<l2.val){
                    current.val = l1.val;
                }else{
                    current.val = l2.val;
                }
            }else if(l1 != null){
                current.val = l1.val;
            }else if(l2 != null){
                current.val = l2.val;
            }
            current.next = new ListNode();
            current = current.next;
        }
        return result;
    }
}