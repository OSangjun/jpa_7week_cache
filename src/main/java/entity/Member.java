package entity;

import javax.persistence.*;

@Cacheable
@Table(name="MEMBER")
@Entity
public class Member {
    @Id
    @Column(name="NAME")
    private String name;

    @Column(name="AGE")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
