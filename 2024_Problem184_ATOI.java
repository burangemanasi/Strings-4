//8. String to Integer - https://leetcode.com/problems/string-to-integer-atoi/description/
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int myAtoi(String s) {
        s.trim(); //trim white spaces
        if(s.length() == 0) return 0; //no String

        char c = s.charAt(0);
        if(!Character.isDigit(c) && c != '+' && c != '-') return 0; //invalid integer

        boolean isNegative = false;
        if(c == '-') isNegative = true; //to return negative integer

        int result = 0;
        int limit = Integer.MAX_VALUE/10;
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(Character.isDigit(c)){
                if(result > limit){
                    if(isNegative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                } else if(result == limit){
                    if(isNegative){
                        if(c - '0' >= 8) return Integer.MIN_VALUE;
                    }else {
                        if(c - '0' >= 7) return Integer.MAX_VALUE;
                    }
                }
                result = result * 10 + c - '0';
            }else{
                if(i != 0)
                    break;
            }
        }
        if(isNegative) return -result;
        return result;
    }
}