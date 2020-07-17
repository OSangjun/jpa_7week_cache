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

    @Column(name="TEAM_NAME")
    String teamName;

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

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


    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
