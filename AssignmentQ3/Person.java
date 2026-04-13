package AssignmentQ3;

class Person {
    protected int id;
    protected String name, mobile, email;

    private static int counter = 1;

    // Constructor (Auto ID generation)
    public Person(String name, String mobile, String email) {
        this.id = counter++;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Mobile: " + mobile + ", Email: " + email);
    }

    public int getId() {
        return id;
    }
}