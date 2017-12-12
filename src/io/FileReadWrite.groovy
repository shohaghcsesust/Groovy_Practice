package io

class FileReadWrite {
	static void main(String[] args){
		FileReadWrite io = new FileReadWrite()
		io.readFile("E:\\personal\\works\\Groovy_Practice\\test\\Input.txt")
		io.writeFile("E:\\personal\\works\\Groovy_Practice\\test\\Output.txt")
	}
	
	def readFile(String filePath){
		File input = new File(filePath)
		println input.text
	}
	
	def writeFile(String filePath){
		File output = new File(filePath)
		output.write("Happy file writing from Groovy....")
	}
}
