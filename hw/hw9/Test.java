/** @Author:  Yixing Chen (CIS 351 Student) **/

class Test{
	public static void main(String[] args){
		HashTable<String, String> aTable = new HashTable<>();
		aTable.put("A", "B");
		System.out.println(aTable.size());
		System.out.println(aTable.get("A"));
		aTable.put("A","C");
		System.out.println(aTable.size());
		System.out.println(aTable.get("A"));


		HashTable<String, Integer> sTable;
    	for (int j = 1; j < 100; j++) {
      		sTable = new HashTable<>();
      		for (int i = 0; i < HashTable.INITIAL_CAPACITY / 2; i++) {
        		sTable.put(new String("The  string: " + i * j), i + 100);
			}
        		System.out.println(sTable.size());
				//System.out.println(" ");
      		for (int i = 0; i < HashTable.INITIAL_CAPACITY / 2; i++) {
        		System.out.println(sTable.get(new String("The  string: " + i * j)));
			}
		}
		HashTable<Integer, Integer> mTable = new HashTable<>();
		for(int i=0; i<HashTable.INITIAL_CAPACITY+1; i++){
			mTable.put(i,i+100);
			System.out.println(mTable.size());
		}
		System.out.println(mTable.table.length);
		for(int i=0; i<HashTable.INITIAL_CAPACITY+1; i++){
		System.out.println(mTable.get(i));
		}

	  }
}
