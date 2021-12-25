package quicktest;

import sort.Utils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xiaogui on 2021/12/21.
 */
public class Test001 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans=0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int start=0,end =0;end<n;end++){
            Character c = s.charAt(end);
            if (map.containsKey(c)){
                start =  Math.max(map.get(c),start);
            }
            ans = Math.max(ans,end - start +1);
            map.put(c,end+1);
        }
        return ans;
    }
    public void test() {
        String text1 = "abcabcbb";
        Utils.printNum(this, text1);
        int result = lengthOfLongestSubstring(text1);
        Utils.printNum(this, result);

    }



}
