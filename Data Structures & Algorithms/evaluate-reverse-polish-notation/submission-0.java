class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String c : tokens){
            if(c.equals("+")){
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i1+i2);
            }else if(c.equals("-")){
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2-i1);
            }else if(c.equals("*")){
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i1*i2);
            }else if(c.equals("/")){
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2/i1);
            }else {
                stack.push(Integer.parseInt(c));
            }

        }
        return stack.pop();
    }
}
