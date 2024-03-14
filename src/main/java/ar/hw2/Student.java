package ar.hw2;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;
    private String groupName;
    private static long idIncrement = 0;

    public Student(String name, String groupName) {
        this.id = idIncrement++;
        this.name = name;
        this.groupName = groupName;
    }
}
