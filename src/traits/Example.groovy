package traits

class Example {
	static main(args) {
		Student st = new Student()
		st.StudentID = 1
		st.Marks1 = 10

		st.DisplayMarks()
		st.DisplayTotal()
		st.DisplayMarksAndTotal()
	}
}

interface Total {
	void DisplayTotal()
}

trait Marks implements Total {
	void DisplayMarks() {
		println("Display Marks")
	}

	void DisplayTotal() {
		println("Display Total")
	}
	
	abstract void DisplayMarksAndTotal()
}

class Student implements Marks {
	int StudentID
	int Marks1
	
	@Override
	void DisplayMarks(){
		println 'Implemented displayMarks method'
	}

	@Override
	public void DisplayMarksAndTotal() {
		println 'Implemented DisplayMarksAndTotal method'
	}
}