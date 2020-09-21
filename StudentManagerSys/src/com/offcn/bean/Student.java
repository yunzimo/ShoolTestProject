package com.offcn.bean;

public class Student {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String birthday;
    private String degree;
    private String hobby;
    private String pic;
    private String mark;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Student(String name, int age, String sex, String birthday, String degree, String hobby, String pic, String mark) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday=birthday;
        this.degree = degree;
        this.hobby = hobby;
        this.pic = pic;
        this.mark = mark;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", degree='" + degree + '\'' +
                ", hobby='" + hobby + '\'' +
                ", pic='" + pic + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
