package xml

import groovy.xml.MarkupBuilder

class XMLImportExport {
	static main(args) {
		XMLImportExport xmlImportExportTest = new XMLImportExport()
//		String inputPath = "E:\\personal\\works\\Groovy_Practice\\test\\input_test.xml"
		String inputPath = "E:\\personal\\works\\Groovy_Practice\\test\\Movie.xml"
		xmlImportExportTest.importXML(inputPath);
		
//		String outputPath = "E:\\personal\\works\\Groovy_Practice\\test\\output_test2.xml"
		String outputPath = "E:\\personal\\works\\Groovy_Practice\\test\\Output_Movie.xml"
		xmlImportExportTest.exportXML(outputPath)
		
	}
	
	def importXML(String inputPath){
		def parser = new XmlParser()
		def doc = parser.parse(inputPath)
		doc.movie.each{
			attr->
			print "Movie Name:"
			println "${attr['@title']}"
			
			print "Movie Type:"
			println "${attr.type[0].text()}"
			
			print "Movie Format:"
			println "${attr.format[0].text()}"
			
			print("Movie year:")
			println "${attr.year[0].text()}"
			   
			print("Movie rating:")
			println "${attr.rating[0].text()}"
			   
			print("Movie stars:")
			println "${attr.stars[0].text()}"
			   
			print("Movie description:")
			println "${attr.description[0].text()}"
			println("*******************************")
		}
	}
	
	def exportXML(String responseFileName){
		String header = '''<?xml version="1.0" encoding="ISO-8859-1"?>
 <report action="" BusRule="">
   <object-tree>
  </object-tree>
</report>''' 
		def response = new XmlSlurper(false, false).parseText(header);
		String item_code = "VAL1010"
		String item_ver = "00"
		def newObj = '''<obj type="SCREW" flag="Success">
                <attr name="name">''' + item_code + '''</attr>
                <attr name="revision">''' + item_ver + '''</attr>
                </obj>'''

        def newReponseObj = new XmlSlurper(false, false).parseText(newObj)
        response."object-tree".appendNode(newReponseObj)
		def fileWriter = new FileWriter(responseFileName)
		groovy.xml.XmlUtil.serialize(response, fileWriter)
		fileWriter.close()
		
		FileWriter w = new FileWriter(responseFileName.substring(0, responseFileName.length()-4)+"1.xml")
		def out = new MarkupBuilder(w);
		// Compose the builder
		out.collection(shelf : 'New Arrivals') {
			movie(title : 'Enemy Behind')
			type('War, Thriller')
			format('DVD')
			year('2003')
			rating('PG')
			stars(10)
			description('Talk about a US-Japan war')
		}
		
		w.close()
	}
}
