package quicktest;

import sort.Utils;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by xiaogui on 2021/12/25.
 */
public class IsValidTest {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c =='{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }else{
                    Character pop = stack.pop();
                    if (c!=map.get(pop)){
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }

    public void test() {
        String text1 = "{[{]}";
        Utils.printNum(this, text1);
        boolean result = isValid(text1);
        Utils.printNum(this, result);

    }
}
