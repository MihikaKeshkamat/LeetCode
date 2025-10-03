class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                n = n * 10 + (c - '0');
            }else if(c == '['){
                num.push(n);
                stk.push(sb);
                sb = new StringBuilder();
                n = 0;
            }else if(c == ']'){
                int k = num.pop();
                StringBuilder temp = sb;
                sb = stk.pop();
                while(k-- > 0){
                    sb.append(temp);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}