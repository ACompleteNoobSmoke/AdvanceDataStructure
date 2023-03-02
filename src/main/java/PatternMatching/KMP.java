package PatternMatching;

public class KMP {

    public int[] getSubstringValues(String pattern) {
        int lengthOfPattern = pattern.length();
        int[] values = new int[lengthOfPattern];
        int leftPointer = 0, rightPointer = 1;
        values[leftPointer] = leftPointer;

        while (rightPointer < lengthOfPattern) {
            char leftCharacter = pattern.charAt(leftPointer);
            char rightCharacter = pattern.charAt(rightPointer);
            if (leftCharacter == rightCharacter) values[rightPointer] = leftPointer++ + 1;
            else if (leftPointer == 0) values[rightPointer] = 0;
            else {
                leftPointer = values[leftPointer - 1];
                continue;
            }
            rightPointer++;
        }

        return values;
    }

    public boolean searchPattern(String pattern, String text) {
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();
        if (lengthOfPattern > lengthOfText) return false;
        int[] values = getSubstringValues(pattern);
        int patternPointer = 0, textPointer = 0, counter = 0;

        while (textPointer < lengthOfText) {
            char patternCharacter = pattern.charAt(patternPointer++);
            char textCharacter = text.charAt(textPointer++);
            if (patternCharacter != textCharacter) {
                patternPointer = (patternPointer - 1 <= 0) ? 0 : values[patternPointer - 2];
                counter = patternPointer;
            } else counter++;
            if (counter == lengthOfPattern) return true;
        }

        return false;
    }
}
