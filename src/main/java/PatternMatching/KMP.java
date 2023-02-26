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

    public boolean searchPattern(String pattern, String text){
        int[] subStringValues = getSubstringValues(pattern);
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();
        int textPointer = 0, patternPointer = 0;
        int counter = 0;

        while (textPointer < lengthOfText && patternPointer < lengthOfPattern){
            char patternChar = pattern.charAt(patternPointer++);
            char textChar = text.charAt(textPointer++);
            if (patternChar != textChar) {
                patternPointer = (patternPointer - 1 <= 0) ? 0 : subStringValues[patternPointer - 2];
                counter = patternPointer;
            } else counter++;

            if (counter == lengthOfPattern) return true;
        }
        return false;
    }
}
