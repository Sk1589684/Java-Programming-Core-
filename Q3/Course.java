package Q3;

abstract class Course {
    int courseId;
    String courseName;
    int duration;
    double fees;
    String status; // Active / Inactive

    public Course(int id, String name, int duration, double fees, String status) {
        this.courseId = id;
        this.courseName = name;
        this.duration = duration;
        this.fees = fees;
        this.status = status;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getDuration() { return duration; }
    public double getFees() { return fees; }

    public void setFees(double fees) { this.fees = fees; }
    public void setStatus(String status) { this.status = status; }

    public abstract void display();
}

