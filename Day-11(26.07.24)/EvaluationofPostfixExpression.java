class EvaluationofPostfixExpression
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();

        // Traverse the given expression.
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // If the current character is a digit, push it onto the stack.
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } 
            // If the current character is an operator, pop two elements from the stack,
            // perform the operation and push the result back to the stack.
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        
        // The result will be the only element left in the stack.
        return stack.pop();
    }
}