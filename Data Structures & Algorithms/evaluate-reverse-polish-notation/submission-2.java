class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < tokens.length;i++){
            String tmp = tokens[i];
            if(!tmp.equals("+") && !tmp.equals("-") && !tmp.equals("/")
             && !tmp.equals("*")){
                int num = Integer.parseInt(tmp);
                st.push(num);
            }
            else{
                int n1 = st.pop();
                int n2 = st.pop();
                if(tmp.equals("+")){
                    int sum = n1+n2;
                    st.push(sum);
                }
                else if(tmp.equals("*")){
                    int mul = n1*n2;
                    st.push(mul);
                }
                else if(tmp.equals("-")){
                    int sub = n2 - n1;
                    st.push(sub);
                }
                else{
                    int div = n2/n1;
                    st.push(div);
                }
            }
        }
        return st.peek();
    }
}
