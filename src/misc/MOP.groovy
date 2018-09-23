package misc

class Example {
	static void main(String[] args) {
		Student mst = new Student();
		mst.Name = "Joe";
		mst.ID = 1;

		println(mst.Name);
		println(mst.ID);
		mst.addID(12);
	}
}

class Student implements GroovyInterceptable {
	protected dynamicProps=[:]

	void setProperty(String pName,val) {
		dynamicProps[pName] = val
	}

	def getProperty(String pName) {
		dynamicProps[pName]
	}
	def invokeMethod(String name, Object args) {
		return "called invokeMethod $name $args"
	}
}
