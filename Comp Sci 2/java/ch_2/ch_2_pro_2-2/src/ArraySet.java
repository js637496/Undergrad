
public class ArraySet<T> implements SetInterface<T> {

	private ResizableArrayBag arrayBag;
	private static final int DEFUALT_CAP = 25;
	
	public ArraySet(){
		this(DEFUALT_CAP);
	}
	
	public ArraySet(int capacity){
		arrayBag = new ResizableArrayBag(capacity);
	}
	
	public int getCurrentsize() {
		return arrayBag.getCurrentSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return arrayBag.isEmpty();
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return arrayBag.add(newEntry);
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return arrayBag.remove(anEntry);
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return (T) arrayBag.remove();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		arrayBag.clear();
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return arrayBag.contains(anEntry);
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return (T[]) arrayBag.toArray();
	}

	
	
}
