package org.cw6_2.entity;

public class Writer {
    private int id;
    private String firstName;
    private String lastName;
    private int [] novelsId;

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

    public int[] getNovelsId() {
        return novelsId;
    }

    public void setNovelsId(int[] novelsId) {
        this.novelsId = novelsId;
    }
}
