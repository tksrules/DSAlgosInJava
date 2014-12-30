# The Collection Interface

* Collections represent a group of object.
* Primitive types (e.g., int) must be boxed (e.g., Integer) for inclusion in a collection.
* Commonly used methods:
  - Adding objects add(E), addAll(Collection)
  - Testing size and membership: size(), isEmpty(), contains(E), containsAll(Collection)
  - Iterating over members: iterator()
  - Removing members: remove(E), removeAll(Collection), clear(), retainAll(Collection)
  - Generating array representations: toArray(), toArray(T[])
  
###  1. The List Interface
* Common methods provided by List include:
  - add(int index, E element) Insert an element at a specific location (without an index argument, new elements are appended to the end)
  - get(int index) Return an element at the specified location
  - remove(int index) Remove an element at the specified location
  - set(int index, E element) Replace the element at the specified location
 
 * ArrayList and LinkedList implement the List interface
   - java.util.ArrayList is usually your best bet for a List if the values remain fairly static once you've created the list. It's more efficient than a LinkedList for random access.  
   - java.util.LinkedList has better performance than an ArrayList if you are frequently inserting and deleting elements, especially from the middle of the collection. But it's slower than an ArrayList for random-access.
  
  
 ps: https://thenewcircle.com/static/bookshelf/java_fundamentals_tutorial/generics_collections.html
  