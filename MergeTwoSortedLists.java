public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root;
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else if (list1.val > list2.val) {
            root = list1;
        }else root = list2;
        merge(list1, list2);
        return root;

    }

    public static void merge(ListNode list1,ListNode list2){
        ListNode small;
        ListNode big;
        if (list1.val >= list2.val){
            small = list2;
            big = list1;
        } else {
            small = list1;
            big = list2;
        }

        if (small.next == null) {
            small.next = big;
            return;
        }
        else if (small.next.val > big.val){
            ListNode temp = small.next;
            small.next = big;
            small = temp;
            temp = null;
        } else small = small.next;

        list1 = null;
        list2 = null;
        merge(big, small);
    }

    public static void main(String[] args){

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        mergeTwoLists(list1, list2);
        System.out.print("[" + list1.val);
        ListNode current = list1;
        while (current != null){
            System.out.print(", " + current.val);
            current = current.next;
        }

    }
}
