
public class TestCalculator {
	
	public static void main(String [] args) {
		Calculator myCalc = new Calculator();
		myCalc.setOperandOne(10.5);
		myCalc.setOperation("+");
		myCalc.setOperandTwo(5.2);
		myCalc.performOperation();
		System.out.println(myCalc.getResults());
		
	}

}
