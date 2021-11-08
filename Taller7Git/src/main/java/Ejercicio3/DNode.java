/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

public class DNode {

  DNode next, prev;
  Object val;

  public DNode() {

    this.next = null;
    this.prev = null;
    this.val = null;
  }

  public DNode(Object val, DNode first, DNode last) {

    this.next = first;
    this.prev = last;
    this.val = val;
  }

  public DNode getNext() {
    return next;
  }

  public void setNext(DNode next) {
    this.next = next;
  }

  public DNode getPrev() {
    return prev;
  }

  public void setPrev(DNode prev) {
    this.prev = prev;
  }

  public Object getVal() {
    return val;
  }

  public void setVal(Object val) {
    this.val = val;
  }

}
	  
 class DLDqueue implements Dqueue {
  DNode head, tail;
  int size;

  public DLDqueue() {
    head = new DNode();
    tail = new DNode();
    head.setNext(tail);
    tail.setPrev(head);
    size = 0;
  }

  public void insertFirst(Object obj) {
    DNode h = head;
    DNode node = new DNode();
    node.setVal(obj);
    node.setNext(h);
    h.setPrev(node);
    head = node;
    if (size == 0)
      tail = node;
    size++;

  }

  public void insertLast(Object obj) {
    DNode t = tail;
    DNode node = new DNode();
    node.setVal(obj);
    node.setPrev(t);
    t.setNext(node);
    tail = node;
    if (size == 0)
      head = node;
    size++;
  }

  public Object removeFirst() {
    if (head == null)
      return null;
    Object val = head.getVal();
    head = head.getNext();
    size--;
    return val;
  }

  public Object removeLast() {
    if (tail == null)
      return null;
    Object val = tail.getVal();
    tail = tail.getPrev();
    size--;
    return val;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String s = "head [";
    DNode aux = head;
    for (int i = 0; i < size; i++) {
      s += aux.getVal();
      if (aux == tail) {
        break;
      }
      s += "-";
      aux = aux.getNext();
    }
    return s + "] tail";
  }

}