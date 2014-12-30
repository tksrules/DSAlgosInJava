In Java an iterator is an object that allows a programmer to traverse all the elements of a collection.

1. Most importanthe point of using an iterator is to allow the the client to iterate over the collection of objects, without exposing implementation details. 
This gives you the benefit to change what collection the Iterator iterates over and how each element is served, without making any change the client's code.
2. Invoking the iterator() method on a collection returns an iterator object that implements Iterator and knows how to step through the objects in the underlying collection.

For e.g we could have a BookCollection implemented using an ArrayList or HashSet or whatever, We don't want client to have this knowledge.

Example:

	private static void print(Collection c) {
    	for (Iterator i = c.iterator(); i.hasNext(); ) {
        	System.out.println(i.next());
    	}
	}
	
And in Java 5, the Iterator can be used implicitly thanks to for-each:

	private static void print(Collection c) {
    	for (Object o : c) {
        	System.out.println(o);
    	}
	}