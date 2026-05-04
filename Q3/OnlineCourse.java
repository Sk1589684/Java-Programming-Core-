package Q3;

class OnlineCourse extends Course {
    String platformName;
    String instructorName;

    public OnlineCourse(int id, String name, int duration, double fees, String status,
                        String platformName, String instructorName) {
        super(id, name, duration, fees, status);
        this.platformName = platformName;
        this.instructorName = instructorName;
    }

    public void display() {
        System.out.println("Online Course -> ID: " + courseId +
                ", Name: " + courseName +
                ", Duration: " + duration +
                ", Fees: " + fees +
                ", Status: " + status +
                ", Platform: " + platformName +
                ", Instructor: " + instructorName);
    }
}