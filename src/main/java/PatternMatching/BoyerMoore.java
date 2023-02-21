package PatternMatching;

import java.util.HashMap;

public class BoyerMoore {

    private String pattern;
    private String text;
    private HashMap<Character, Integer> mismatchShiftTable;

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
        int lengthOfPattern = this.pattern.length();
        int lengthOfText = this.text.length();
        int numberOfSkips = 0;

        for (int i = 0; i <= lengthOfText - lengthOfPattern; i += numberOfSkips){
            for (int j = lengthOfPattern - 1; j >= 0; j--){
                if(pattern.charAt(j) != text.charAt(i + j)){
                    if (this.mismatchShiftTable.get(text.charAt(i + j)) != null){
                        numberOfSkips = this.mismatchShiftTable.get(text.charAt(i + j));
                    }else{
                        numberOfSkips = lengthOfPattern;
                    }
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
