
public class NodleService {

    private AVLTree timeTree;

    public NodleService() {
        timeTree = new AVLTree();
    }

    public void addStudent(int startTime, int id, int startDistance, int rate) {
        Student student = new Student(startTime, id, startDistance, rate);

        // Calculate all time points until the student arrives
        int currentTime = startTime;
        int currentDistance = startDistance;

        while (currentDistance >= 0) {
            timeTree.insert(currentTime, student);
            currentTime++;
            currentDistance = student.getDistanceAtTime(currentTime);
        }
    }

    public int answer(int time) {
        Student nextStudent = timeTree.findNextStudent(time);
        return (nextStudent != null) ? nextStudent.getId() : -1;
    }

    public static void main(String[] args) {
        NodleService service = new NodleService();

        // Test case 1
        service.addStudent(2, 31, 6, 3);
        System.out.println(service.answer(1)); // Should print 31
        System.out.println(service.answer(5)); // Should print -1

        // Test case 2
        service.addStudent(1, 16, 6, 1);
        service.addStudent(1, 50, 1, 1);
        System.out.println(service.answer(1)); // Should print 50
        System.out.println(service.answer(4)); // Should print 31
        System.out.println(service.answer(5)); // Should print 16
    }
}
