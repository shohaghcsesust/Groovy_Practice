package io

class ExceptionTest {
	static main(args) {
		FileReadWrite io = new FileReadWrite()
		try{
			io.readFile("E:\\personal\\works\\Groovy_Practice\\test\\Input2.txt")
		} catch(FileNotFoundException e){
			e.printStackTrace()
		}
	}
	def readFile(String filePath){
		File input = new File(filePath)
		println input.text
	}
}
