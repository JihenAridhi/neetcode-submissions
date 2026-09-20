class Solution {
    public int evalRPN(String[] tokens) {
        int res=Integer.parseInt(tokens[0]);
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");

        Stack<String> equation = new Stack<>();

        for(String s:tokens){
            if(operators.contains(s)){
                int x=Integer.parseInt(equation.pop()); 
                int y=Integer.parseInt(equation.pop()); 
                switch(s){
                    case "+": res=y+x; break;
                    case "-": res=y-x; break;
                    case "*": res=y*x; break;
                    case "/": res=y/x; break;
                }
                equation.push(res+"");
            }
            else
                equation.push(s);
        }
        return res;
    }
}
