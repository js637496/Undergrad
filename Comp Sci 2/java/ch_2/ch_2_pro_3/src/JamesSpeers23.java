
public class JamesSpeers23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetInterface<String> aSet = new ArraySet();
		System.out.println("Is the set empty? " + aSet.isEmpty());
		aSet.add("Hello");
		aSet.add("World");
		aSet.add("TESTARRAY");
		System.out.println("Is the set still empty? " + aSet.isEmpty());
		System.out.println("How many items does it contain? " + aSet.getCurrentsize() + " Strings");
		aSet.remove("Hello");
		System.out.println("Removed Hello");
		System.out.println("How many items does it contain? " + aSet.getCurrentsize() + " Strings");
		System.out.println("Removing 1 more String");
		aSet.remove();
		System.out.println("How many items does it contain? " + aSet.getCurrentsize() + " Strings");
		System.out.println("Removing 1 more String");
		aSet.remove();
		System.out.println("How many items does it contain? " + aSet.getCurrentsize() + " Strings");
		System.out.println("Is the set empty? " + aSet.isEmpty());
		System.out.println("Adding items");
		aSet.add("Jim");
		aSet.add("D");
		aSet.add("Speers");
		System.out.println("Does it contain Jim? " + aSet.contains("Jim"));
		System.out.println("To Array");
		Object testArray[] = aSet.toArray();
		for(int i = 0; i < testArray.length; i++){
			System.out.print(testArray[i] + " ");
		}
		System.out.println("");
		System.out.println("Clearing Set");
		aSet.clear();
		System.out.println("Is the set empty? " + aSet.isEmpty());
		System.out.println(aSet.getCurrentsize());
		for(int i = 0; i < 27; i++){
			aSet.add("Test" + i);
		}
		System.out.println("Check capacity");
		System.out.println(aSet.getCurrentsize());
		
	}

}
