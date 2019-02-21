package cn.sy.solution;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

public class TwoLinkedSum {
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

    private void insert(ListNode l,int data){
        //找到最后一个节点
        ListNode pn = l;
        while (pn.next != null)
        {
            pn = pn.next;
        }
        //插入元素
        pn.next = new ListNode(data);
    }

    private int getNumFromLinked(ListNode l){
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
