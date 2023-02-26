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

    private void precompute(int lengthOfPattern){
        for (int i = 0; i < lengthOfPattern; i++){
            char currentChar = pattern.charAt(i);
            int maxShift = Math.max(1, lengthOfPattern - i - 1);
            mismatchShiftTable.put(currentChar, maxShift);
        }
    }

    public boolean searchPattern(){
        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();
        precompute(lengthOfPattern);
        int numberOfSkips;

        for (int i = 0; i < lengthOfText - lengthOfPattern; i += numberOfSkips){
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

    private HashMap<Character, Integer> getShiftTable(String localPattern, int lengthOfPattern){
        HashMap<Character, Integer> shiftTable = new HashMap<>();
        for (int i = 0; i < lengthOfPattern; i++){
            char currentChar = localPattern.charAt(i);
            int maxShift = Math.max(1, lengthOfPattern - i - 1);
            shiftTable.put(currentChar, maxShift);
        }
        return shiftTable;
    }

    public boolean searchPatternPractice(String localPattern, String localText){
        int lengthOfText = localText.length();
        int lengthOfPattern = localPattern.length();
        HashMap<Character, Integer> shiftTable = getShiftTable(localPattern, lengthOfPattern);
        int numberOfSkips;

        for (int i = 0; i < lengthOfText - lengthOfPattern; i += numberOfSkips){
            numberOfSkips = 0;
            for (int j = lengthOfPattern - 1; j >= 0; j--){
                char patternChar = localPattern.charAt(j);
                char textChar = localText.charAt(i + j);
                if (patternChar != textChar){
                    Integer maxShift = shiftTable.get(textChar);
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
