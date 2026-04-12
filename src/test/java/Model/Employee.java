package Model;

public class Employee {
    private String name;
    private String age;
    private String salary;
    private String durationWorked;
    private String email;

    public Employee(String name, String age, String salary, String durationWorked, String email) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.durationWorked = durationWorked;
        this.email = email;
    }

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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDurationWorked() {
        return durationWorked;
    }

    public void setDurationWorked(String durationWorked) {
        this.durationWorked = durationWorked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
