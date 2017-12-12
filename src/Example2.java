
public class Example2 {
	public static void main(String[] args) {
		Calculator calculator = new Calculator("Scientific", "MS-512");
		System.out.println("Sum: 5+6="+calculator.getAdditionResult(5, 6));
		System.out.println("Multiplication: 2*5="+calculator.getMultiplicationResult(2, 5));
	}
}
