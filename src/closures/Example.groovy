package closures

class Example { 
   def static Display(clo) {
      // This time the $param parameter gets replaced by the string "Inner"         
      clo.call("Inner");
   } 
	
   static void main(String[] args) {
      def str1 = "Hello";
      def clos = { param -> println "${str1} ${param}" }
      clos.call("World");
		
      // We are now changing the value of the String str1 which is referenced in the closure
      str1 = "Welcome";
      clos.call("World");
		
      // Passing our closure to a method
      Example.Display(clos);
	  
	  def lst = [11, 12, 13, 14];
	  lst.each {println it}
	  
	  def mp = ["TopicName" : "Maps", "TopicDescription" : "Methods in Maps"]
	  mp.each {println it}
	  mp.each {println "${it.key} maps to: ${it.value}"}
	  
	  def value = lst.find{element -> element > 12}
	  value.each {println it}
	  
	  value = lst.findAll{element -> element > 12}
	  value.each {println it}
	  
	  // Is there any value above 12
	  value = lst.any{element -> element > 12}
	  println(value);
		
	  // Is there any value above 14
	  value = lst.any{element -> element > 14}
	  println(value);
	  
	  def newlst = lst.collect {element -> return element * element}
	  println(newlst);
   }
}