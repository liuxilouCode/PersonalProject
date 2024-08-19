package Problems;

import java.util.*;

/**
 * @Author Yi Liu
 * @Date 8/4/22
 * @SpecificTime 9:41 PM
 *
 * Given a string array words, return an array of all characters that show up in all strings within
 * the words (including duplicates)
 *
 * For example if words = ["bella", "label","roller"]
 * result should be ["e","l","l"]
 */
public class FindCommonCharacters {
    public List<String> findCommon(String[] words){
        List<String> result = new ArrayList();

        int[] helperFrequency = new int[26];
        Arrays.fill(helperFrequency,Integer.MAX_VALUE);
        for (String word:words){
            int[] charFrequency = new int[26];
            for (char c:word.toCharArray()){
                charFrequency[c-'a']++;
            }

            for (int i = 0; i < 26; i++){
                helperFrequency[i] = Math.min(helperFrequency[i],charFrequency[i]);
            }
        }

        for (int i = 0; i<26; i++){
            while(helperFrequency[i] >0){
                result.add(""+(char)(i+'a'));
                helperFrequency[i]--;
            }
        }
        return result;
    }
}
