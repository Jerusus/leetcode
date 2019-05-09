import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    class Course {
        int id;
        List<Integer> prerequisites;
        Course(int id) {
            this.id = id;
            prerequisites = new ArrayList<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            Course c = new Course(i);
            courses.add(c);
        }
        for (int[] prerequisite : prerequisites) {
            Course c = courses.get(prerequisite[0]);
            c.prerequisites.add(prerequisite[1]);
        }
        Stack<Course> stack = new Stack<>();
        for (Course course : courses) {
            boolean[] visited = new boolean[numCourses];
            addToStack(course, stack, courses, visited);
        }
        if (stack.size() != numCourses) return new int[]{};
        int[] res = new int[numCourses];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop().id;
        }
        return res;
    }

    public boolean addToStack(Course course, Stack<Course> stack, List<Course> courses, boolean[] visited) {
        if (visited[course.id]) return false;
        visited[course.id] = true;
        if (course.prerequisites.isEmpty() && !stack.contains(course)) {
            return stack.add(course);
        }
        for (int prerequisite : course.prerequisites) {
            if (stack.contains(courses.get(prerequisite))) continue;
            if (!addToStack(courses.get(prerequisite), stack, courses, visited)) {
                return false;
            }
        }
        if (!stack.contains(course)) return stack.add(course);
        return true;
    }
}