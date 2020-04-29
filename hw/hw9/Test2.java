/** @Author:  Yixing Chen (CIS 351 Student) **/

class Test2{
	public static void testAddAndRemoveWithNoRehashing() {
	HashTable<Integer,Integer> table = new HashTable<>();
   		for (int i = 0; i < HashTable.INITIAL_CAPACITY / 2; i++) {
    		 	 table.put(i, i + 100);
     		 	 System.out.println(table.size());
    	}

   		int correctSize = table.size();

    // remove first half
    for (int i = 0; i < HashTable.INITIAL_CAPACITY / 4; i++) {
      table.remove(i);
      correctSize--;
      System.out.println(table.get(i));
	  System.out.println(correctSize);
      System.out.println(table.size());
    }

    // make sure the rest remain
    for (int i = HashTable.INITIAL_CAPACITY / 4; i < HashTable.INITIAL_CAPACITY / 2; i++) {
      System.out.println(table.get(i));
    }

    // remove the rest
    for (int i = HashTable.INITIAL_CAPACITY / 4; i < HashTable.INITIAL_CAPACITY / 2; i++) {
      table.remove(i);
      correctSize--;
      System.out.println(table.get(i));
	  System.out.println(correctSize);
      System.out.println(table.size());
    }
	}

	public static void main(String[] args){
		testAddAndRemoveWithNoRehashing();
    	testAddAndRemoveWithNoRehashing();
    	testAddAndRemoveWithNoRehashing();
	}
}
