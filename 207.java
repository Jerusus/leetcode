import java.util.ArrayList;
import java.util.List;

class Solution {
    class Node {
        int val;
        List<Node> prereqs;
        public Node(int val) {
            this.val = val;
            this.prereqs = new ArrayList<>();
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // set up
        Node[] courses = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Node(i);
        }
        for (int[] prereq : prerequisites) {
            // link prereqs
            courses[prereq[0]].prereqs.add(courses[prereq[1]]);
        }
        for (Node course : courses) {
            boolean[] visited = new boolean[numCourses];
            if (!noLoop(course, visited)) return false;
        }
        return true;
    }

    private boolean noLoop(Node i, boolean[] visited) {
        if (visited[i.val]) return false;
        visited[i.val] = true;
        // recurse
        for (Node prereq: i.prereqs) {
            if (!noLoop(prereq, visited)) return false;
        }
        visited[i.val] = false;
        return true;
    }
}