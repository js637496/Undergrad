
public class LinkedSet<T> implements SetInterface<T> {

	private LinkedBag1 linkedBag;
	private static final int DEFUALT_CAP = 25;
	
	public LinkedSet(){
		linkedBag = new LinkedBag1();
	}
	
	public LinkedSet(int capacity){
		linkedBag = new LinkedBag1();
	}
	
	public int getCurrentsize() {
		return linkedBag.getCurrentSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return linkedBag.isEmpty();
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return linkedBag.add(newEntry);
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return linkedBag.remove(anEntry);
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return (T) linkedBag.remove();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		linkedBag.clear();
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return linkedBag.contains(anEntry);
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return (T[]) linkedBag.toArray();
	}

}
