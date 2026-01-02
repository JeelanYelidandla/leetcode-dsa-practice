package com.leetcode.linkedlist;

public class LinkedListAlgoImplPR1Ex {
    NodeForLL head;
    private void add(int value){
        NodeForLL node =  new NodeForLL();
        node.data=value;
        node.next= null;

        if(head== null){
            head = node;
        }else{
            NodeForLL n = head;
            while(n.next!=null){
                n = n.next;
            }
            n.next= node;
        }
    }
    public void show(){
        NodeForLL node = head;
        while (node!=null){
            System.out.println(node.data);
            node= node.next;
        }
    }
    public static void main(String[] args) {
        LinkedListAlgoImplPR1Ex ex= new LinkedListAlgoImplPR1Ex();
        ex.add(10);
        ex.add(20);
        ex.add(30);
        ex.show();
    }
}
