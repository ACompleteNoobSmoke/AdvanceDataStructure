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

    private void precomputeShift(){
        int lengthOfPattern = this.pattern.length();
        for (int i = 0; i < lengthOfPattern; i++){
            char currentCharacter = this.pattern.charAt(i);
            int maxShift = Math.max(1, lengthOfPattern - i - 1);
            this.mismatchShiftTable.put(currentCharacter, maxShift);
        }
    }

    public boolean searchPattern(){
        precomputeShift();
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();
        int numberOfSkips;

        for (int i = 0; i <= lengthOfText - lengthOfPattern; i += numberOfSkips){
            numberOfSkips = 0;
            for (int j = lengthOfPattern - 1; j >= 0; j--){
                char currentTextChar = text.charAt(i + j);
                char currentPatternChar = pattern.charAt(j);
                if (currentPatternChar != currentTextChar){
                    numberOfSkips = (mismatchShiftTable.get(currentTextChar) != null) ?
                            mismatchShiftTable.get(currentTextChar) : lengthOfPattern;
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
