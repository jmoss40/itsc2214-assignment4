import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is part of Lab 4 for ITSC 2214: Data Structures and Algorithms.
 * This class reads in an input text file and parses the contents into HashObject objects. It then uses linear
 * probing algorithm to add the objects to a HashMap. Then it reads in another input file of HashObjects to search for
 * in the hash map, uses the linear probing algorithm to search for each item, and prints whether it was found or not.
 * @author Jordan Moss
 */
public class Main {
	public static void main(String[] args) {
		HashMap<Integer, HashObject> hashmap = new HashMap<Integer, HashObject>(100, 0.75f);
		int x; String y;
		int count = 0;
		try {
			Scanner scanner = new Scanner(new File("Lab4InputFile1.txt"));
			while(scanner.hasNext()) {
				x = scanner.nextInt();
				y = scanner.next();
				HashObject object = new HashObject(x, y);
				count++; // keep track of the number of items in input file 1
				
				//hashing algorithm - linear probing
				Integer index = x / 10;
				if(hashmap.containsKey(index)) {
					do {
						index++;
						index %= 100; // ensure the index never goes above 99
						hashmap.putIfAbsent(index, object);
					}while(!hashmap.containsValue(object));
				}else {
					hashmap.put(index , object);
				}
			}
			scanner.close();
		}catch(FileNotFoundException ex) {
			System.err.println("Error: Input file 1 not found.");
		}
		
		//print hash table
		System.out.println("Element count: " + count); //number of elements in input file
		System.out.println("Hash table size: " + hashmap.size()); //number of key-value pairs in hash map - should be equal to count
		System.out.println("\nKey\tValue");
		for(Integer i = 0; i < 100; i++) {
			System.out.println(i + ":\t" + hashmap.get(i));
		}
		
		
		System.out.println("\n\nSearch items:");
		try {
			Scanner scanner = new Scanner(new File("Lab4InputFile2.txt"));
			while(scanner.hasNext()) {
				x = scanner.nextInt();
				y = scanner.next();
				HashObject object = new HashObject(x, y);
				
				//use hashing algorithm from before to search for the search items
				boolean found = false;
				Integer index = x / 10;
				int i = 0;
				do {
					HashObject result = hashmap.get(index);
					if(result != null && object.compareTo(result) == 0)
						found = true;
					i++;
				}while(i < 5 && !found); //if not found on the first check, check 4 more times. If not found by then, assume it's not in the hash map
				System.out.println("------------------------");
				System.out.println("{" + object.toString() + "}, Found: " + (found? "Yes": "No"));
			}
			System.out.println("------------------------");
			scanner.close();
			
		}catch(FileNotFoundException ex) {
			System.err.println("Error: Input file 2 not found.");
		}
	}
}
