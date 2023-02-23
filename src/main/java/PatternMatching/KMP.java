package PatternMatching;

public class KMP {

    public int[] getValueArray(String pattern){
        int lengthOfPattern = pattern.length();
        int[] values = new int[lengthOfPattern];
        int leftPointer = 0;
        int rightPointer = 1;
        values[0] = 0;

        while (leftPointer < lengthOfPattern && rightPointer < lengthOfPattern){
            char leftChar = pattern.charAt(leftPointer);
            char rightChar = pattern.charAt(rightPointer);
            if (leftChar == rightChar) {
                values[rightPointer] = leftPointer + 1;
                leftPointer++;
            }else if (leftPointer == 0){
                values[rightPointer] = 0;
            }else{
                leftPointer = values[leftPointer - 1];
                continue;
            }
            rightPointer++;
        }

        return values;
    }
}
