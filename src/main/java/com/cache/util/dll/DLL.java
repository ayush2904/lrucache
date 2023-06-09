package com.cache.util.dll;

public class DLL<E> {
    DLLNODE<E> head = null;
    DLLNODE<E> tail = null;

    public DLLNODE addNodeToFront(E e) {
        DLLNODE<E> newNode = new DLLNODE<E>(e,head,null);

        if(head != null) {
            head.prev=newNode;
        }
        head = newNode;
        if(tail==null) {
            tail = newNode;
        }
        return newNode;
    }

    public DLLNODE addNodeToLast(E e) {
        DLLNODE<E> newNode = new DLLNODE<E>(e,null,tail);

        if(tail != null) {
            tail.next=newNode;
        }
        tail = newNode;
        if(head == null) {
            head = newNode;
        }
        return newNode;
    }

    public void detachNode(DLLNODE<E> node) {
       /// System.out.println("Detach node called : "+ node.getElement());
        if(node!=null) {
            DLLNODE<E> prev = node.prev;
            DLLNODE<E> next = node.next;
            // prev->node->next
            if(prev!=null)
            prev.next = next;
            if(next!=null)
            next.prev = prev;
            if(node == head) {
                head = next;
            }
        }
       // System.out.println(" tail is " + tail.getElement());
       // System.out.println("After Detach node called new head is: "+ head.getElement());
    }

    public DLLNODE<E> getFirst() {
        return head;
    }

    public DLLNODE<E> getTail() {
        return tail;
    }

}
