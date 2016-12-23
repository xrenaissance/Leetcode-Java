package com.inuker.solution;

import com.inuker.solution.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>(Arrays.asList(
                        "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar",
                "ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or",
                "rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh",
                "co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an",
                "me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
//                "hot","dot","dog","lot","log"
        ));
        List<List<String>> ladders = new WordLadderII().findLadders("qa", "sq", dict);
//        List<List<String>> ladders = new WordLadderII().findLadders("hit", "cog", dict);
        for (List<String> list : ladders) {
            for (String word : list) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
