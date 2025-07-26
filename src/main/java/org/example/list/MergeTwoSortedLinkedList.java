package org.example.list;
import org.example.model.ListNode;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8};

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        ListNode head = mergeTwoList(list1,list2);

        System.out.println("Head : "+head.val);
    }

    private static ListNode createList(int[] arr) {
        if (arr.length==0)return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i =1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1!=null && list2!=null){

            if(list1.val<=list2.val){
                current.next=list1;
                list1 = list1.next;
            }else {
                current.next=list2;
                list2 = list2.next;
            }

            current=current.next;
        }

        if(list1!=null){
            current.next = list1;
        } else if (list2!=null) {
            current.next= list2;
        }
        return dummy.next;
    }
}
