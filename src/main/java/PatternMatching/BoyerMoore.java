package PatternMatching;

import java.util.HashMap;

public class BoyerMoore {

    private String pattern;
    private String text;
    private HashMap<Character, Integer> mismatchShiftTable;

    public void setPattern(String pattern){
        this.pattern = pattern;
    }

    public void setText(String text){
        this.text = text;
    }

    public BoyerMoore(){
        this("", "");
    }

    public BoyerMoore(String pattern, String text){
        this.pattern = pattern;
        this.text = text;
        mismatchShiftTable = new HashMap<>();
    }

    private void precomputeShift(int lengthOfPattern){
        for (int index = 0; index < lengthOfPattern; index++){
            char currentChar = pattern.charAt(index);
            int maxShift = Math.max(1, lengthOfPattern - index - 1);
            mismatchShiftTable.put(currentChar, maxShift);
        }
    }

    public boolean searchPattern(){
        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();
        precomputeShift(lengthOfPattern);
        int numberOfSkips;

        for (int i = 0; i <= lengthOfText - lengthOfPattern; i += numberOfSkips){
            numberOfSkips = 0;
            for (int j = lengthOfPattern - 1; j >= 0; j--){
                char patternChar = pattern.charAt(j);
                char textChar = text.charAt(i + j);
                if (patternChar != textChar){
                    Integer maxShift = mismatchShiftTable.get(textChar);
                    numberOfSkips = (maxShift != null) ? maxShift : lengthOfPattern;
                    break;
                }
            }
            if (numberOfSkips == 0) return true;
        }
        return false;
    }
    public void printText(){
        System.out.println("Text: " + text);
    }

    public void printPattern(){
        System.out.println("Pattern: " + pattern);
    }

    public void printMismatchTable(){
        if(mismatchShiftTable == null || mismatchShiftTable.isEmpty())
            return;
        mismatchShiftTable.forEach((c, m) -> System.out.println("Character: " + c +
                " Max Shift: " + m));
    }
}
