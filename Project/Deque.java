import java.util.NoSuchElementException;
import java.util.Iterator;

class Node<Item>{
    Item data;
    Node<Item> next;
    Node<Item> prev;
    Node(Item data1){
        this.data=data1;
        next = null;
        prev = null;
    }
}


public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;
    // construct an empty deque
    public Deque() {
        head=null;
        tail=null;
        size=0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size==0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> newNode = new Node<Item>(item);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> newNode = new Node<Item>(item);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> temp = head;
        head = head.next;
        if(head!= null){
            head.prev = null;
        } 
        else {
            tail = null;
        }
        size--;
        return temp.data;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> temp = tail;
        tail = tail.prev;
        if(tail!= null){
            tail.next = null;
        } 
        else {
            head = null;
        }
        size--;
        return temp.data;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(head);
    }



    // unit testing (required)
    public static void main(String[] args){

    }

}