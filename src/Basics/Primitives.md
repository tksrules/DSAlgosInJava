* floats can be defined with F, and doubles with D. 
* Implicit upcasting to wider types 
    
    int value = Integer.MAX_VALUE;
    long biggerValue = value + 1;
  
  With the exception of chars, the compiler can automatically use a wider type for a variable, because it is not possible to lose any precision, for instance, when stepping up from an int to a long, or a float to a double. The reverse is not true. When trying to assign a long value to an int, you must cast that value. This tells the compiler this is actually what you intend, and you are happy to lose precision, as shown next.

* Explicit downcasting to narrower types 
    
    long veryLargeNumber = Long.MAX_VALUE;
    int fromLargeNumber = (int) veryLargeNumber;
