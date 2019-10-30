import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Random;


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

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;
    // construct an empty randomized queue
    public RandomizedQueue() {
        head = null;
        tail = null;
        size=0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size==0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if(item  == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> newNode = new Node<Item>(item);
        if(head == null && tail == null) {
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> temp = head;
        Random random = new Random();
        int index = random.nextInt(size);

        for(int i =0; i<index;i++){
            temp = temp.next;
        }
        if(tail == temp && temp == head) {
            head = null;
            tail = null;
        }
        else if(temp == head) {
            head = temp.next;
        }
        else if(temp == tail) {
            tail = tail.prev;
            tail.next= null;
        }

        if(temp.next!=null) {
            temp.next.prev = temp.prev;
        }

        if(temp.prev != null){
            temp.prev.next = temp.next;
        }
        size--;
        return temp.data;

    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Random random = new Random();
        int index = random.nextInt(size);
        Node<Item> temp = head;
        int i = 0;
        while(i < index){
            temp = temp.next;
            i++;
        }
        return temp.data;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(head);
    }

    // unit testing (required)
    public static void main(String[] args){

    }

}