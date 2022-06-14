import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    static LinkedList<Integer> que = new LinkedList<>();

    static void enqueue(Integer n) {
        que.add(n);
    }

    static Integer dequeue() {
        return que.poll();
    }

    static void printElement() {
        System.out.println(que.peek());
    }

    static void chooseJob(int job, int input) {
        switch (job) {
            case 1:
                enqueue(input);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                printElement();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int firstNum = Integer.parseInt(br.readLine().split("\\s+")[1]);
        enqueue(firstNum);
        String line;
        while ((line = br.readLine()) != null) {
            String[] input = line.trim().split("\\s+");
            int operator = Integer.valueOf(input[0]);
            if (operator == 1) {
                chooseJob(operator, Integer.valueOf(input[1]));
            } else {
                chooseJob(operator, 0);
            }
        }
        br.close();
    }
}
