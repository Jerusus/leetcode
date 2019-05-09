import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    class Operation implements Comparable<Operation> {
        int index;
        String source;
        String target;
        public Operation(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }

        @Override
        public int compareTo(Operation o) {
            return this.index > o.index ? 1 : this.index < o.index ? -1 : 0;
        }
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            Operation operation = new Operation(indexes[i], sources[i], targets[i]);
            operations.add(operation);
        }
        Collections.sort(operations);
        String result = "";
        int pointer = 0;
        while (!operations.isEmpty()) {
            Operation operation = operations.remove(0);
            int index = operation.index;
            while (pointer < index) {
                result += S.charAt(pointer);
                pointer++;
            }
            if (S.indexOf(operation.source, pointer) == index) {
                result += operation.target;
                pointer += operation.source.length();
            }
        }
        while (pointer < S.length()) {
            result += S.charAt(pointer);
            pointer++;
        }
        return result;
    }
}