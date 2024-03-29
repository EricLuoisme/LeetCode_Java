package Ex1_300.Ex121_to_150.Ex140_WordBreak2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (null == s || s.length() == 0) {
            return res;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (wordDict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0, i), wordDict);
                if (temp.size() != 0) {
                    for (int j = 0; j < temp.size(); j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
