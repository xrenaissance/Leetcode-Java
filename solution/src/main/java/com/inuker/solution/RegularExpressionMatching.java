package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/20.
 */
/**
 * 这道题最重要的是no bug，而不是性能
 * 面试中要给所有cases cover到
 * 下面的写法足够简单和直观了
 * DP也可，但是不推荐
 */

/**
 * TestCases
 * ".*"是可以匹配任意字符串的，因为".*"表示0个或多个"."，而"."是可以匹配任意字符的
 */
public class RegularExpressionMatching {

    // 耗时153ms
    public boolean isMatch(String s, String p) {
        // 如果p是空串，那么s必须也是空串
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // 如果p只有一个字符，那么s必须也是1个字符，而且两者要匹配，注意p不会是单独的*，因为*要跟在某个字符后面
        if (p.length() == 1) {
            return s.length() == 1 && isMatch(s, 0, p);
        }

        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            }

            return isMatch(s, 0, p) && isMatch(s.substring(1), p.substring(1));
        } else {
            // 这里要注意判断s是否为空
            if (s.length() > 0 && isMatch(s, 0, p)) {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }

    private boolean isMatch(String s, int i, String p) {
        return s.charAt(i) == p.charAt(0) || p.charAt(0) == '.';
    }
}
