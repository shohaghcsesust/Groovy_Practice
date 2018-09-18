package gui

String records = '''
   <library>
	
      <Student>
         <StudentName division = 'A'>Joe</StudentName>
         <StudentID>1</StudentID>
      </Student>
	  
      <Student>
         <StudentName division = 'B'>John</StudentName>
         <StudentID>2</StudentID>
      </Student>
	  
      <Student>
         <StudentName division = 'C'>Mark</StudentName>
         <StudentID>3</StudentID>
      </Student>
		
   </library>'''

def rd = new StringReader(records)
def doc = groovy.xml.DOMBuilder.parse(rd)
println doc

def builder = new groovy.json.JsonBuilder()
def root = builder.students {
	student {
		studentname 'Joe'
		studentid '1'

		Marks(
				Subject1: 10,
				Subject2: 20,
				Subject3: 30,
			  )
	}
}
println(builder.toString());

class Student {
	String name
}
def studentlist = [
	new Student (name: "Joe"),
	new Student (name: "Mark"),
	new Student (name: "John")
]

builder studentlist, { Student student ->name student.name}
println(builder)

def nodeBuilder = new NodeBuilder()
studentlist = nodeBuilder.userlist {
   user(id: '1', studentname: 'John', Subject: 'Chemistry')
   user(id: '2', studentname: 'Joe', Subject: 'Maths')
   user(id: '3', studentname: 'Mark', Subject: 'Physics')
}
println(studentlist)

tmpDir = File.createTempDir()
def fileTreeBuilder = new FileTreeBuilder(tmpDir)
fileTreeBuilder.dir('main') {
   dir('submain') {
	  dir('Tutorial') {
		file('Sample.txt', 'println "Hello World"')
	  }
   }
}