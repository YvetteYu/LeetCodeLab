import java.util.List;
public class GoodSet {

    static void noPrefix(List<String> words) {
        boolean isGoodSet = true;
        String target = "";
        for(int i = 0; i<words.size(); i++) {
            target = words.get(i);
            for(int j = 0; j<words.size(); j++) {
                if(i == j) continue;
                if(target.contains(words.get(j))) {
                    isGoodSet = false;
                    break;
                }
            }
            if(!isGoodSet) {
                break;
            }
        }
        if(isGoodSet) {
            System.out.println("GOOD SET");
        } else {
            System.out.println("BAD SET");
            System.out.println(target);
        }
    }
}
