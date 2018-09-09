package com.almundo.callcenter.model;

public class ListNodes<T> {

    private Node<T> start;
    private Node<T> end;
    private int size;

    public ListNodes() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null && start == end;
    }

    public int getSize() {
      return size;
    }

    public void addNode(T node) {
        Node<T> newNode = new Node<>(node);
        size++;
        if (this.isEmpty()) {
            start = newNode;
            end = newNode;
        } else {
            end.setNext(newNode);
            end = newNode;
        }
    }

    public T getNode() {
        T result = null;
        Node<T> aux = start;
        if (!this.isEmpty()) {
            start = aux.getNext();
            result = aux.getValue();
            aux.setNext(null);
            size--;
        }
        return result;
    }
}
