package com.leetcode.linkedlist;;

public class LinkedListAlgoImplEx {

    public NodeForLL head;//head always pointing to first element of linked list.

    public void add(int value){
        NodeForLL node = new NodeForLL(); //create new node for every new element
        node.data = value; //assign data
        node.next= null; //assing null for next node. if null means its last element of linked list.
        if(head ==null){ //first elment head is always null. so head = node for first elemnt. else execute from second elemet.
            head = node;
        }else {
            NodeForLL n = head; //take the first head elemnt.. travel till head has null elemnet. then assing current node for null address.
            while (n.next != null) {
                n = n.next;
            }
            n.next=node; // assing current nod to last elemnt of the linked list which has null.
        }

    }

    public void show(){
        NodeForLL n = head;
        while(n!=null){
         System.out.println(n.data);
         n = n.next;
        }
    }
    public static void main(String[] args) {
        LinkedListAlgoImplEx linkedListAlgoImplEx= new LinkedListAlgoImplEx();
        linkedListAlgoImplEx.add(10);
        linkedListAlgoImplEx.add(20);
        linkedListAlgoImplEx.add(30);

        linkedListAlgoImplEx.show();

    }


}
