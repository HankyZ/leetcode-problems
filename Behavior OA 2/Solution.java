import java.util.*;

class CharObject {

    char character;
    int num;

    public CharObject(char character, int num) {
        this.character = character;
        this.num = num;
    }

}

class Solution {

    public String solution(int A, int B, int C) {

        Queue<CharObject> queue = new PriorityQueue<>(new Comparator<CharObject>() {
            @Override
            public int compare(CharObject o1, CharObject o2) {
                if (o1.num < o2.num)
                    return 1;
                else if (o1.num > o2.num)
                    return -1;
                return 0;
            }
        });
        queue.add(new CharObject('a', A));
        queue.add(new CharObject('b', B));
        queue.add(new CharObject('c', C));

        StringBuilder s = new StringBuilder();
        int timesInARow = 1;
        while (queue.peek().num != 0) {

            if (timesInARow <= 2) {

                CharObject charObject = queue.poll();

                s.append(charObject.character);
                charObject.num--;

                if (s.charAt(s.length() - 1) == charObject.character)
                    timesInARow++;
                else
                    timesInARow = 1;

                queue.offer(charObject);
            } else {
                CharObject charObject = queue.poll();

                if (charObject.character == s.charAt(s.length() - 1)) {
                    CharObject tmp = charObject;
                    charObject = queue.poll();
                    if (charObject.num <= 0)
                        break;
                    queue.offer(tmp);
                }

                s.append(charObject.character);
                charObject.num--;
                timesInARow = 1;
                queue.offer(charObject);
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(99, 60, 1));
    }
}
