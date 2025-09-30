class Solution {
    static String removeSpace(String str){
        StringBuilder res = new StringBuilder();
        int n = str.length();
        for(char c : str.toCharArray()){
            if(c != '#'){
                res.append(c);
            }else if(res.length() > 0){
                res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        s = removeSpace(s);
        t = removeSpace(t);
        return s.equals(t);
    }
}