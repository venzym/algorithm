package easy;

public class Merge_Two_Sorted_Lists {
    /**
     * 릿코드 21. Merge Two Sorted Lists (https://leetcode.com/problems/merge-two-sorted-lists/)
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            // ListNode nextNode = l1;
            // while(true){
            //     System.out.print(nextNode.val);
            //     if (nextNode.next != null){
            //         nextNode = nextNode.next;
            //     }else{
            //         break;
            //     }
            // }


            ListNode temp = new ListNode();
            ListNode node = temp;

            while (l1 != null && l2 != null) {

                //작은값을 넣어준다.
                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }

                node = node.next;

            }//while

            if (l1 != null) {
                node.next = l1;
                l1 = l1.next;
            }

            if (l2 != null) {
                node.next = l2;
                l2 = l2.next;
            }

            return temp.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
