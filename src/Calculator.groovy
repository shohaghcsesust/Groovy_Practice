
class Calculator {
	private String name;
	private String model;
	public Calculator(){
		name = "Default";
		model = "Default";
	}
	public Calculator(String name, String model){
		this.name = name;
		this.model = model;
	}
	int getAdditionResult(int a,int b){
		return a+b;
	}
	int getMultiplicationResult(int a,int b){
		return a*b;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setModel(String model){
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public String getModel() {
		return model;
	}
}
