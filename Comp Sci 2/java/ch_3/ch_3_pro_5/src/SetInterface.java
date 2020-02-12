

public interface SetInterface<T> {
	public int getCurrentsize();
	public boolean isEmpty();
	
	public boolean add(T newEntry);
	
	public boolean remove(T anEntry);
	
	public T remove();
	public void clear();
	public boolean contains(T anEntry);
	public T[] toArray();
}
