package cn.sy.solution;


import cn.sy.datastruct.ListNode;

import java.util.List;

public class TwoLinkedSum {
    //方法1：这种方法在位数>10位的时候相加会超出 整型范围，返回非预期值。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1=getNumFromLinked(l1);
        int num2=getNumFromLinked(l2);
        int sum=num1+num2;
        ListNode s=new ListNode(sum%10);
        while(sum/10!=0){
            sum=sum/10;
            insert(s,sum%10);
        }
        return s;
    }

    //方法2：注意最后 carry如果>0，需要在链表后再增加一个节点存放carry的值。
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode s=new ListNode(0);
        ListNode p=l1, q=l2, pn=s;
        int carry=0;
        while (p!=null || q!=null){
           int x= (p!=null)?p.val:0;
           int y= (q!=null)?q.val:0;
           int sum=x+y+carry;
           pn.next=new ListNode(sum%10);
           carry=sum/10;
           pn=pn.next;
           p=(p!=null)?p.next:null;
           q=(q!=null)?q.next:null;
        }
        if (carry > 0) {
            pn.next = new ListNode(carry);
        }
        return s.next;
    }

    public void insert(ListNode l, int data){
        //找到最后一个节点
        ListNode pn = l;
        while (pn.next != null)
        {
            pn = pn.next;
        }
        //插入元素
        pn.next = new ListNode(data);
    }

    public int getNumFromLinked(ListNode l){
        int dig=1;
        int num=0;
        while(l!=null){
            num+=l.val*dig;
            l=l.next;
            dig*=10;
        }
        return num;
    }


    public ListNode reverse(ListNode l){
        ListNode prev=null;
        ListNode next=l.next;
        while(l.next!=null){
            l.next=prev;
            prev=l;
            l=next;
            next=l.next;
        }
        return prev;
    }

}
