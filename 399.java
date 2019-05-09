import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

class Solution399 {
    public static void main(String[] args) {
        Solution399 s = new Solution399();
        String[][] equations = new String[][]{{"a","b"},{"b","c"}};
        double[] values = new double[]{2.0,3.0};
        String[][] queries = new String[][]{{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
        System.out.println(s.calcEquation(equations, values, queries));
    }
    class Node {
        String name;
        Map<String,Double> ratios;
        Node(String name) {
            this.name = name;
            ratios = new HashMap<>();
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String,Node> variables = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            Node a;
            if (variables.containsKey(eq[0])) {
                a = variables.get(eq[0]);
            } else {
                a = new Node(eq[0]);
                variables.put(eq[0],a);
            }
            a.ratios.put(eq[1],values[i]);
            Node b;
            if (variables.containsKey(eq[1])) {
                b = variables.get(eq[1]);
            } else {
                b = new Node(eq[1]);
                variables.put(eq[1],b);
            }
            b.ratios.put(eq[0],1/values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = calc(queries[i], variables);
        }
        return res;
    }

    private double calc(String[] query, Map<String, Node> variables) {
        String num = query[0];
        String denom = query[1];
        Set<String> visited = new TreeSet<>();
        if (!variables.containsKey(num)) return -1;
        List<Node> path = new ArrayList<>();
        if (canPath(variables.get(num), visited, variables, path, denom)) {
            path.add(variables.get(num));
            double res = 1;
            for (int i = path.size() - 1; i > 0; i--) {
                Node a = path.get(i);
                Node b = path.get(i-1);
                res *= a.ratios.get(b.name);
            }
            return res;
        }
        return -1;
    }

    private boolean canPath(Node cur, Set<String> visited, Map<String, Node> variables, List<Node> path, String target) {
        if (visited.contains(cur.name)) return false;
        visited.add(cur.name);
        if (cur.name.equals(target)) return true;
        for (String ratio : cur.ratios.keySet()) {
            if (canPath(variables.get(ratio), visited, variables, path, target)) {
                path.add(variables.get(ratio));
                return true;
            }
        }
        return false;
    }
}