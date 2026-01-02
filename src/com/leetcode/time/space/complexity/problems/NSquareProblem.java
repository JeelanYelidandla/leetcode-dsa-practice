import com.leetcode.time.space.complexity.problems.Student;
    // Space: O(1) - no additional storage used
    private static  boolean hasSameGPA(List<Student> students) {
        for (Student s1 : students) {
            for (Student s2 : students) {
                if (s1 != s2 && s1.getGpa() == s2.getGpa()) return true;
            }
        }
        return false;
    }
    //Time: O(n)
    //Space: O(n)
    private static boolean hasSameGPAWithSetExample(List<Student> students) {
        Set<Double> seen = new HashSet<>();
        for (Student s : students) {
            if (!seen.add(s.getGpa())) return true; // Duplicate GPA found
        }
        return false;
    }


    public static void main(String[] args) {
        var studentsList  = List.of(
            new Student("Alice", 20, 3.5),
            new Student("Bob", 22, 3.7),
            new Student("Charlie", 21, 3.5)
        );

        System.out.println( hasSameGPA(studentsList));
    }
