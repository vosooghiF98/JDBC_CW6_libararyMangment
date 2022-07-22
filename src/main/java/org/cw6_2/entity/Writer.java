package org.cw6_2.entity;

import java.util.ArrayList;

public class Writer {
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Novel> novels = new ArrayList<>();

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

    public ArrayList<Novel> getNovels() {
        return novels;
    }

    public void setNovels(ArrayList<Novel> novels) {
        this.novels = novels;
    }

    public void addNovel(Novel novel){
        this.novels.add(novel);
    }
    public void removeNovel(Novel novel){
        this.novels.remove(novel);
    }
}
