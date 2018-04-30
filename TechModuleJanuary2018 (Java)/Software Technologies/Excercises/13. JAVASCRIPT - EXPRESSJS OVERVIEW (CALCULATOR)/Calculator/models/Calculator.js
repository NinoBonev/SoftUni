class Calculator {
    constructor(leftOperand, operator, rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;

        this.CalculateResult = function () {
            let result = 0;
            switch (this.operator) {
                case "+":
                    result = this.leftOperand + this.rightOperand;
                    break;
                case "-":
                    result = this.leftOperand - this.rightOperand;
                    break;
                case "*":
                    result = this.leftOperand * this.rightOperand;
                    break;
                case "/":
                    result = this.leftOperand / this.rightOperand;
                    break;
            }

            return result;

        }
    }
}

module.exports = Calculator;