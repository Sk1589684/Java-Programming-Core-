package Q3;

import java.util.*;

public class CourseApp {
    static LinkedList<Course> list = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Update Fees 4.Change Status");
            System.out.println("5.Enroll 6.Display All 7.By Type 8.Fees Filter");
            System.out.println("9.Sort by Duration 10.Search 11.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addCourse(); break;
                case 2: removeCourse(); break;
                case 3: updateFees(); break;
                case 4: changeStatus(); break;
                case 5: enrollCourse(); break;
                case 6: displayAll(); break;
                case 7: displayByType(); break;
                case 8: filterByFees(); break;
                case 9: sortByDuration(); break;
                case 10: searchByName(); break;
                case 11: System.exit(0);
            }
        }
    }

    static void addCourse() {
        System.out.println("1.Online 2.Offline");
        int type = sc.nextInt();

        System.out.print("Enter ID, Name, Duration, Fees: ");
        int id = sc.nextInt();
        String name = sc.next();
        int duration = sc.nextInt();
        double fees = sc.nextDouble();

        if (type == 1) {
            System.out.print("Platform & Instructor: ");
            String p = sc.next();
            String i = sc.next();
            list.add(new OnlineCourse(id, name, duration, fees, "Active", p, i));
        } else {
            System.out.print("Classroom No & Location: ");
            int c = sc.nextInt();
            String loc = sc.next();
            list.add(new OfflineCourse(id, name, duration, fees, "Active", c, loc));
        }
    }

    static void removeCourse() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        list.removeIf(c -> c.getCourseId() == id);
    }

    static void updateFees() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Course c : list) {
            if (c.getCourseId() == id) {
                System.out.print("New Fees: ");
                c.setFees(sc.nextDouble());
            }
        }
    }

    static void changeStatus() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Course c : list) {
            if (c.getCourseId() == id) {
                c.setStatus(c.status.equals("Active") ? "Inactive" : "Active");
            }
        }
    }

    static void enrollCourse() {
        System.out.print("Enter type (1.Online 2.Offline) and max duration: ");
        int type = sc.nextInt();
        int maxDur = sc.nextInt();

        for (Course c : list) {
            if (c.getDuration() <= maxDur) {
                if (type == 1 && c instanceof OnlineCourse)
                    c.display();
                else if (type == 2 && c instanceof OfflineCourse)
                    c.display();
            }
        }
    }

    static void displayAll() {
        for (Course c : list)
            c.display();
    }

    static void displayByType() {
        System.out.println("1.Online 2.Offline");
        int type = sc.nextInt();

        for (Course c : list) {
            if (type == 1 && c instanceof OnlineCourse)
                c.display();
            else if (type == 2 && c instanceof OfflineCourse)
                c.display();
        }
    }

    static void filterByFees() {
        System.out.print("Enter max fees: ");
        double max = sc.nextDouble();

        for (Course c : list) {
            if (c.getFees() < max)
                c.display();
        }
    }

    static void sortByDuration() {
        list.sort(Comparator.comparingInt(Course::getDuration));

        for (Course c : list)
            c.display();
    }

    static void searchByName() {
        System.out.print("Enter name: ");
        String name = sc.next();

        for (Course c : list) {
            if (c.getCourseName().equalsIgnoreCase(name))
                c.display();
        }
    }
}