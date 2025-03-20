package org.example.inventorymanagersystemspring.models;

public class ClubMember {
    private int id;
    private static int idIncrement = 1;
    private String firstName;
    private String lastName;
    private String email;

    public ClubMember(String firstName, String lastName, String email) {
        id = idIncrement++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
