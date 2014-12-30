# GENERICS

1. Generics, introduced in Java 5, provide stronger type safety.
2. Generics allow types to be passed as parameters to class, interface, and method declarations.
For example:
	List<Employee> emps = new ArrayList<Employee>();The <Employee> in this example is a type parameter. 

3. With the type parameter, the compiler ensures that we use the collection with objects of a compatible type only.
4. Another benefit is that we won't need to cast the objects we get from the collection:
	
	Employee e = emps.get(0);

Object type errors are now detected at compile time, rather than throwing casting exceptions at runtime.

### Generics and Polymorphism

* What can be confusing about generics when you start to use them is that collections of a type are not polymorphic on the type.
* That is, you can not assign a List<String> to a reference variable of type List<Object> (and by extension, pass a List<String> as an argument to a method whose parameter is type List<Object>); it results in a compiler error.
* Why? If allowed, we could then add objects of an incompatible type to the collection through the more ?generic? typed reference variable.
* So if you define a printCollection() to accept a parameter typed List<Person>, you can pass only List<Person> collections as arguments.
Even if Employee is a subclass of Person, a List<Employee> can?t be assigned to a List<Person>.
* Here's an illustration of how type parameters are not polymorphic for collections:

Example:

	public class GenericsTypeError {
    	public static void main( String[] args) {
        	// Create a List of Dog objects
        	List<Dog> kennel = new ArrayList<Dog>();

	        // Adding a Dog is no problem
    	    kennel.add( new Dog() );
	
    	    // The following line results in a compiler error
        	List<Object> objs = kennel;

	        // Because if it were allowed, we could do this
    	    objs.add( new Cat() );

        	// And now we've got a Cat in our List of Dogs
    	}
	}
	
https://thenewcircle.com/static/bookshelf/java_fundamentals_tutorial/generics_collections.html