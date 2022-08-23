
public class Calculator {
	
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double results;
	

	public void performOperation() {
		if(this.operation == "+") {
			this.results = this.operandOne + this.operandTwo;
		}
		else if (this.operation == "-") {
			this.results = this.operandOne - this.operandTwo;
		}
		else {
			this.results = 0;
		}
	}
	
	public double getResults() {
		return this.results;
	}
	



	public double getoperandOne() {
		return operandOne;
	}



	public void setOperandOne(double setOperandOne) {
		this.operandOne = setOperandOne;
	}



	public String getOperation() {
		return operation;
	}



	public void setOperation(String setOperation) {
		this.operation = setOperation;
	}



	public double getOperandTwo() {
		return operandTwo;
	}



	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

}
