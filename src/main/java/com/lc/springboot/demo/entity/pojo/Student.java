package com.lc.springboot.demo.entity.pojo;

import com.lc.springboot.demo.common.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("student")
public class Student extends BaseEntity {

    private String name;
    private Integer age;
    private String gender;
    private String address;

    private List<Course> courses;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", courses=" + courses +
                '}';
    }
}
