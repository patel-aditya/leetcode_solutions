/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        while(headA != null && headB != null){
            if(set.contains(headA)) return headA;
            set.add(headA);
            if(set.contains(headB)) return headB;
            set.add(headB);
            headA = headA.next;
            headB = headB.next;
        }

        // while(headB != null){
        //     if(set.contains(headB)) return headB;
        //     headB = headB.next;
        // }

        while(headA != null){
            if(set.contains(headA)) return headA;
            headA = headA.next;
        }

        while(headB != null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}