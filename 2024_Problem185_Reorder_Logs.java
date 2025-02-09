//937. Reorder Data in Log Files - https://leetcode.com/problems/reorder-data-in-log-files/description/
//Time Complexity: O(nl*log(nl))
//Space Complexity: O(1) ~ no extra space

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //sort array
        Arrays.sort(logs, (a,b)->{
            //separate identifier and content
            String[] splitArr1 = a.split(" ", 2);
            String[] splitArr2 = b.split(" ", 2);
            //check if 1st character isDigit
            boolean isDigit1 = Character.isDigit(splitArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitArr2[1].charAt(0));

            if(!isDigit1 && !isDigit2){ //both are characters
                int cmp = splitArr1[1].compareTo(splitArr2[1]);
                if(cmp == 0){
                    //compare identifier as content is same
                    return splitArr1[0].compareTo(splitArr2[0]);
                }
                return cmp; //+1 or -1
            } else if(!isDigit1 && isDigit2){ //1digit-1char
                return -1; //return as is
            } else if(isDigit1 && !isDigit2){ //1char-1digit
                return 1; //swap them
            } else{ //both digits
                //Arrays.sort(a,b) -> a-b
                //-ve: sorted order [1,2]
                //+ve: descending order [4,3]
                //0: maintain order [4,4]
                return 0;
            }
        });
        return logs;
    }
}