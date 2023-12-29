package entity;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String address;

    // Default constructor
    public Customer() {
    }

    // Overloaded constructor with Account attributes
    public Customer(int customerId, String firstName, String lastName, String email, long phoneNumber, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        setEmail(email); // Validate email in the constructor
        setPhoneNumber(phoneNumber); // Validate phone number in the constructor
        this.address = address;
    }

    // Getter methods
    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        // Validate email without regex
        if (email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email address");
        }
    }

    public void setPhoneNumber(long phoneNumber) {
        // Validate 10-digit phone number without regex
        if (String.valueOf(phoneNumber).length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to print all information
    public void printInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email Address: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }

    
}
