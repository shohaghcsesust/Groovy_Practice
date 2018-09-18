package json

import groovy.json.JsonSlurper
import groovy.json.JsonOutput

class Example {
   static void main(String[] args) {
      def jsonSlurper = new JsonSlurper()
      def object = jsonSlurper.parseText('{ "name": "John", "ID" : "1", "List": [2, 3, 4, 5]}')		
      println(object.name);
      println(object.ID);
	  println(object.List)
	  object.List.each{
		  println it
	  }
	  
	  def obj = jsonSlurper.parseText ''' {"Integer": 12, "fraction": 12.55, "double": 12e13}'''		
      println(obj.Integer);
      println(obj.fraction);
      println(obj.double);
	  
	  //it's serializing groovy object to json string
	  def output = JsonOutput.toJson(object)
	  println(output);
	  
	  def output2 = JsonOutput.toJson([ new Student(name: 'John',ID:1), new Student(name: 'Mark',ID:2)])
	  println(output2);
   }
}

class Student {
	String name
	int ID;
 }