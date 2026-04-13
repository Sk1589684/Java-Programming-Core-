package AssignmentQ3;

class Member extends Person {
    private String membershipType;
    private double amountPaid;

    public Member(String name, String mobile, String email,
                  String type, double amount) {
        super(name, mobile, email);
        this.membershipType = type;
        this.amountPaid = amount;
    }

    public void display() {
        super.display();
        System.out.println("Membership: " + membershipType +
                ", Amount Paid: " + amountPaid);
    }
}