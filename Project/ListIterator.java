import java.util.NoSuchElementException;
import java.util.Iterator;
class ListIterator<Item> implements Iterator<Item>{
	Node<Item> newNode;

	public ListIterator(Node<Item> first)
	{
		newNode=first;
	}

	public boolean hasNext(){
		return newNode!=null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public Item next(){
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		Item item = newNode.data;
		newNode = newNode.next;
		return item;
	}
}