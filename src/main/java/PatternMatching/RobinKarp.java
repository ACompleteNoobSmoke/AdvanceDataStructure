package PatternMatching;

public class RobinKarp {
    //TODO - Create Hash Function -- DONE
    //TODO - Get Hash Value For Pattern -- DONE
    //TODO - Get Hash Value For Text -- DONE
    //TODO - Perform Rolling Hash Function/Comparison -- DONE
    //TODO - If Hash Values Are The Same Compare Characters -- DONE
    //TODO - If Hash Values Are Different Continue With Another Substring -- DONE


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
        int base = 127;
        int patternValues = getHashValue(pattern, base);

        for (int textPointer = 0; textPointer <= textLen - patternLen; textPointer++) {
            String currSub = text.substring(textPointer, textPointer + patternLen);
            int hashValues = getHashValue(currSub, base);
            if (hashValues == patternValues && pattern.equals(currSub)) return true;
        }
        return false;
    }



    //**Cleaner Version Below**

    public boolean search(String text, String pattern){
        int textLen = text.length();
        int patternLen = pattern.length();
        if (patternLen > textLen) return false;
        int patternHash = pattern.hashCode();

        for (int textIndex = 0; textIndex <= textLen - patternLen; textIndex++){
            String currentSub = text.substring(textIndex, textIndex + patternLen);
            int currentHash = currentSub.hashCode();
            if(currentHash == patternHash && pattern.equals(currentSub)) return true;
        }

        return false;
    }
}
