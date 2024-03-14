package ar.hw2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private final List<Student> studentList;

    public StudentRepository() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Алексей", "1"));
        studentList.add(new Student("Ирина", "1"));
        studentList.add(new Student("Степан", "2"));
        studentList.add(new Student("Николай", "3"));
        studentList.add(new Student("Александр", "2"));
        studentList.add(new Student("Виктория", "1"));
        studentList.add(new Student("Дмитрий", "3"));
        studentList.add(new Student("Дарья", "1"));
        studentList.add(new Student("Виктор", "3"));
    }

    /**
     * Получение студента по ID
     * @param id номер ID
     * @return Student
     */
    public Student getById(long id){
        return studentList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Получение всего списка студентов
     * @return список студентов List<Student>
     */
    public List<Student> getAll(){
        return List.copyOf(studentList);
    }

    /**
     * Получение (поиск) студентов по имени, содержащим строку-запрос
     * @param name строка-запрос
     * @return список студентов List<Student>
     */
    public List getByName(String name){
        return studentList.stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    /**
     * Получение (поиск) студентов по имени группы
     * @param groupName имя группы
     * @return список студентов List<Student>
     */
    public List getByGroupName(String groupName) {
        return studentList.stream()
                .filter(e -> e.getGroupName().equals(groupName))
                .toList();
    }
}
