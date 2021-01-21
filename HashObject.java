/**
 * This class is part of Lab 4 for ITSC 2214: Data Structures and Algorithms.
 * This class describes an object that will be stored in the hash map in the Main class.
 * I was instructed to make the first number in the input file an integer, and the
 * second a string.
 * @author Jordan Moss
 */
public class HashObject implements Comparable<HashObject>{
	private int x;
	private String y;
	
	/**
	 * A constructor for the HashObject class that sets the attributes to the parameters.
	 * @param x
	 * @param y
	 */
	public HashObject(int x, String y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns a string representation of this object.
	 * @return formatted string containing x and y attributes.
	 */
	@Override
	public String toString() {
		return this.x + " " + this.y;
	}

	/**
	 * Compares this HashObject to another HashObject based on their x attributes.
	 * @return a number >0 if this item is greater, <0 if less than, 0 if both are equal.
	 */
	@Override
	public int compareTo(HashObject other) {
		return Integer.compare(this.x, other.x);
	}
}
