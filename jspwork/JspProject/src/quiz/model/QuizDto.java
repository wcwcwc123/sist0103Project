package quiz.model;

import java.sql.Timestamp;

public class QuizDto {
    private String name;
    private String age;
    private String phone;
    private String hasDriver;
    private Timestamp date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHasDriver() {
        return hasDriver;
    }

    public void setHasDriver(String hasDriver) {
        this.hasDriver = hasDriver;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
