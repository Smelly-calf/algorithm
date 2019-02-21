package cn.sy.main;


import cn.sy.datastruct.ListNode;
import cn.sy.solution.TwoLinkedSum;

public class TestMain {
    public static void main(String[] args) {
        TwoLinkedSum twoLinkedSum = new TwoLinkedSum();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        int[] arr1={9};
        int[] arr2={1,9,9,9,9,9,9,9,9,9};
        for (int i = 0; i < arr1.length; i++) {
            twoLinkedSum.insert(l1,arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            twoLinkedSum.insert(l2,arr2[i]);
        }
        int numFromLinked = twoLinkedSum.getNumFromLinked(l1.next);
        System.out.println(numFromLinked);
        ListNode l = twoLinkedSum.addTwoNumbers2(l1.next, l2.next);

        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }

}
