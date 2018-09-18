package traits

class Example {
	static main(args) {
		Student st = new Student()
		st.StudentID = 1
		st.Marks1 = 10

		st.DisplayTotal()
		st.DisplayMarks()
		st.DisplayMarksAndTotal()
		println st.Marks1
	}
}

interface Total {
	int inBonus = 10
	void DisplayTotal()
}

trait Marks implements Total {
	int bonus = 5
	void DisplayMarks() {
		println("Display Marks")
	}

	void DisplayTotal() {
		bonus += inBonus
		println("Display Total")
	}
	
	abstract void DisplayMarksAndTotal()
}

class Student implements Marks {
	int StudentID
	int Marks1
	
	@Override
	void DisplayMarks(){
		this.Marks1 += bonus
		println 'Implemented displayMarks method'
	}

	@Override
	public void DisplayMarksAndTotal() {
		println 'Implemented DisplayMarksAndTotal method'
	}
}