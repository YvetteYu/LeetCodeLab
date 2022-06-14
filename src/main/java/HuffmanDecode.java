public class HuffmanDecode {

    class Node implements Comparable<Node> {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
        public Node(int freq) {
            frequency = freq;
        }

        // compares on the frequency
        public int compareTo(Node tree) {
            return frequency - tree.frequency;
        }
    }

    void decode(String S ,Node root) {
        if (root == null) {
            return;
        }
        char[] arr = S.toCharArray();
        int index = 0;
        String rst = "";
        while (index < arr.length) {
            Node node = root;
            while (node != null) {
                if (node.left == null && node.right == null) {
                    rst += node.data;
                    break;//break inner while
                } else {
                    char c = arr[index];
                    if (c == '0') {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                    index++;
                }
            }
        }
        System.out.println(rst);
    }
}
