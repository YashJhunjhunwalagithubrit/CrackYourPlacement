class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
         if (head == null) return null; // handle case with empty list
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // skip the duplicate node
            } else {
                current = current.next; // move to the next distinct node
            }
        }
        
        return head;
    }
}