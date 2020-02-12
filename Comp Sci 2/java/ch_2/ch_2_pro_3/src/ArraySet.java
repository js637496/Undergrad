import java.util.Arrays;

public class ArraySet<T> implements SetInterface<T> {

	
        private T[] set; // Cannot be final due to doubling
        private int numberOfEntries;
        private boolean initialized = false;
        private static final int DEFAULT_CAPACITY = 25; // Initial capacity of set
        private static final int MAX_CAPACITY = 10000;

        /** Creates an empty set whose initial capacity is 25. */
        public ArraySet() 
        {
                this(DEFAULT_CAPACITY);
        } // end default constructor

        /** Creates an empty set having a given initial capacity.
            @param initialCapacity  The integer capacity desired. */
        public ArraySet(int initialCapacity)
        {
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempset = (T[])new Object[initialCapacity]; // Unchecked cast
      set = tempset;
      numberOfEntries = 0;
      initialized = true;
        } // end constructor

        /** Creates a set containing given entries.
            @param contents  An array of objects. */
   public ArraySet(T[] contents) 
   {
      checkCapacity(contents.length);
      set = Arrays.copyOf(contents, contents.length);
      numberOfEntries = contents.length;
      initialized = true;
   } // end constructor
       
        /** Adds a new entry to this set.
       @param newEntry  The object to be added as a new entry.
       @return  True. */
        public boolean add(T newEntry)
        {
                checkInitialization();
      if (isArrayFull())
      {
         doubleCapacity();
      } // end if
      
      set[numberOfEntries] = newEntry;
      numberOfEntries++;
      
      return true;
        } // end add

        /** Retrieves all entries that are in this set.
       @return  A newly allocated array of all the entries in this set. */
        public T[] toArray() 
        {
                checkInitialization();
      
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = set[index];
      } // end for
      
      return result;
        } // end toArray
   
        /** Sees whether this set is empty.
       @return  True if this set is empty, or false if not. */
        public boolean isEmpty()
        {
        	return numberOfEntries == 0;
        } // end isEmpty
   
        /** Gets the current number of entries in this set.
       @return  The integer number of entries currently in this set. */
        public int getCurrentSize()
        {
        	return numberOfEntries;
        } // end getCurrentSize
   
        /** Counts the number of times a given entry appears in this set.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in this ba. */
        public int getFrequencyOf(T anEntry)
        {
                checkInitialization();
      int counter = 0;
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(set[index]))
         {
            counter++;
         } // end if
      } // end for
      
      return counter;
        } // end getFrequencyOf
   
        /** Tests whether this set contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this set contains anEntry, or false otherwise. */
   public boolean contains(T anEntry)
        {
                checkInitialization();
      return getIndexOf(anEntry) > -1; // or >= 0
        } // end contains
   
        /** Removes all entries from this set. */
        public void clear()
        {
      while (!isEmpty())
         remove();
        } // end clear
        
        /** Removes one unspecified entry from this set, if possible.
       @return  Either the removed entry, if the removal
       was successful, or null. */
        public T remove()
        {
                checkInitialization();
      T result = removeEntry(numberOfEntries - 1);
      return result;
        } // end remove
        
        /** Removes one occurrence of a given entry from this set.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
        public boolean remove(T anEntry)
        {
                checkInitialization();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
        } // end remove
   
         // Locates a given entry within the array set.
        // Returns the index of the entry, if located,
        // or -1 otherwise.
   // Precondition: checkInitialization has been called.
        private int getIndexOf(T anEntry)
        {
                int where = -1;
                boolean found = false;
                int index = 0;
      
      while (!found && (index < numberOfEntries))
                {
                        if (anEntry.equals(set[index]))
                        {
                                found = true;
                                where = index;
                        } // end if
         index++;
                } // end while
      
      // Assertion: If where > -1, anEntry is in the array set, and it
      // equals set[where]; otherwise, anEntry is not in the array.
      
                return where;
        } // end getIndexOf
   
   // Removes and returns the entry at a given index within the array.
   // If no such entry exists, returns null.
   // Precondition: 0 <= givenIndex < numberOfEntries.
   // Precondition: checkInitialization has been called.
        private T removeEntry(int givenIndex)
        {
                T result = null;
      
                if (!isEmpty() && (givenIndex >= 0))
                {
         result = set[givenIndex];          // Entry to remove
         int lastIndex = numberOfEntries - 1;
         set[givenIndex] = set[lastIndex];  // Replace entry to remove with last entry
         set[lastIndex] = null;             // Remove reference to last entry
         numberOfEntries--;
                } // end if
      
      return result;
        } // end removeEntry
   
   // Returns true if the array set is full, or false if not.
        private boolean isArrayFull()
        {
                return numberOfEntries >= set.length;
        } // end isArrayFull
   
   // Doubles the size of the array set.
   // Precondition: checkInitialization has been called.
        private void doubleCapacity()
        {
      int newLength = 2 * set.length;
      checkCapacity(newLength);
      set = Arrays.copyOf(set, newLength);
        } // end doubleCapacity
   
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a set whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   } // end checkCapacity
   
   // Throws an exception if receiving object is not initialized.
   private void checkInitialization()
   {
      if (!initialized)
         throw new SecurityException ("Uninitialized object used " +
                                      "to call an Arrayset method.");
   } // end checkInitialization

@Override
public int getCurrentsize() {
	return numberOfEntries;
}
} // end ArraySet