package ex;

/**
 * Created by tommy on 2016/09/24.
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last) {
        lastName = last;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
