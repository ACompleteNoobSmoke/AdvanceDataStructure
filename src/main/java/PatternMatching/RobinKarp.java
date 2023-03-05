package PatternMatching;

public class RobinKarp {
    //TODO - Create Hash Function -- DONE
    //TODO - Get Hash Value For Pattern -- DONE
    //TODO - Get Hash Value For Text
    //TODO - Perform Rolling Hash Function/Comparison
    //TODO - If Hash Values Are The Same Compare Characters
    //TODO - If Hash Values Are Different Continue With Another Substring


    public int powerOf(int base, int exp){
        int values = 1;
        for (int i = 0; i < exp; i++) values *= base;
        return values;
    }

    public int getHashValue(String pattern, int base){
        int len = pattern.length();
        int exp = len;
        int hashValues = 0;

        for (int i = 0; i < len; i++){
            char currentChar = pattern.charAt(i);
            char compareChar = (Character.isUpperCase(currentChar)) ? 'A' : 'a';
            int characterValue = currentChar - compareChar + 1;
            hashValues += characterValue * powerOf(base, --exp);
        }

        return hashValues;
    }

    public boolean searchPattern(String text, String pattern){
        int textLen = text.length();
        int patternLen = pattern.length();
        if (patternLen > textLen) return false;
        if (patternLen == textLen) return text.equals(pattern);
        int base = 10;
        int patternValues = getHashValue(pattern, base);
        int textPointer = 0;

        while (textPointer <= textLen - patternLen){
            String currSub = text.substring(textPointer, textPointer + patternLen);
            int hashValues = getHashValue(pattern, base);
            if (hashValues == patternValues){
                if (pattern.equals(currSub)) return true;
            }
            textPointer++;
        }
        return false;
    }
}
