    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    
        //Creating three nodes previous, current and forward
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode forward = null;

        while(curr!=null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        head = prev;
        return head;
    }
