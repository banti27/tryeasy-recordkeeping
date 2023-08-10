package in.tryeasy.recordkeeping.model;

import in.tryeasy.recordkeeping.constant.Gender;

import java.util.StringJoiner;

public class EmployeeCreationRequest {
    private String firstName;
    private String lastName;
    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EmployeeCreationRequest.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("gender=" + gender)
                .toString();
    }
}

