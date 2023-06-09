package com.cache.util.dll;

public class DLLNODE<E> {
    DLLNODE<E> next;
    DLLNODE<E> prev;
    E element;

    public DLLNODE<E> getNext() {
        return next;
    }

    public DLLNODE<E> getPrev() {
        return prev;
    }

    public E getElement() {
        return element;
    }

    public DLLNODE(E e, DLLNODE next, DLLNODE prev) {
        this.element = e;
        this.next = next;
        this.prev = prev;
    }
}
