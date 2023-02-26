package PatternMatching;

public class KMP {

    public int[] getSubstringValues(String pattern){
        int lengthOfPattern = pattern.length();
        int leftPointer = 0, rightPointer = 1;
        int[] values = new int[lengthOfPattern];
        values[leftPointer] = leftPointer;

        while (rightPointer < lengthOfPattern){
            char leftChar = pattern.charAt(leftPointer);
            char rightChar = pattern.charAt(rightPointer);
            if (leftChar == rightChar){ values[rightPointer] = leftPointer++ + 1; }
            else if(leftPointer == 0) values[rightPointer] = 0;
            else { leftPointer = values[leftPointer - 1]; rightPointer--;}
            ++rightPointer;
        }

        return values;
    }
}
