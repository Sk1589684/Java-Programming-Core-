package Q3;

class OfflineCourse extends Course {
    int classroomNumber;
    String location;

    public OfflineCourse(int id, String name, int duration, double fees, String status,
                         int classroomNumber, String location) {
        super(id, name, duration, fees, status);
        this.classroomNumber = classroomNumber;
        this.location = location;
    }

    public void display() {
        System.out.println("Offline Course -> ID: " + courseId +
                ", Name: " + courseName +
                ", Duration: " + duration +
                ", Fees: " + fees +
                ", Status: " + status +
                ", Classroom: " + classroomNumber +
                ", Location: " + location);
    }
}