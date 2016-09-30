package io.bna.allUniques;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by brandon on 3/23/16.
 */
public class UniqueChecker {

    public Boolean check(String s) {

        try {
            return bitVectorApproach(s);
        } catch(IllegalArgumentException e) {
            return false;
        }
    }

    private Boolean bitVectorApproach(String s) throws IllegalArgumentException {
        Integer alphaBits = 0x0,
                charBit = 0x0;
        Character lowerChar;
        char[] sArray = s.toCharArray();
        for(Character c : sArray) {
            lowerChar = Character.toLowerCase(c);
            if(lowerChar > 'z')
                throw new IllegalArgumentException("The string must contain only alpha chars.");
            charBit = 1 << (lowerChar - 'a');
            if((alphaBits & charBit) > 0)
                return false;
            else alphaBits |= charBit;
        }
        return true;
    }

    private Boolean linkedListApproach(String s) {
        char[] sArray = s.toCharArray();
        List<Character> chars = new LinkedList();
        for(Character c : sArray) {
            if(chars.contains(c))
                return false;
            chars.add(c);
        }
        return true;
    }
}
