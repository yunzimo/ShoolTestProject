package com.offcn.Bean;

import java.util.Date;

public class Register {
/*
    +---------------+--------------+------+-----+---------+-------+
            | Field         | Type         | Null | Key | Default | Extra |
            +---------------+--------------+------+-----+---------+-------+
            | rid           | varchar(10)  | NO   | PRI | NULL    |       |
            | name          | varchar(30)  | YES  |     | NULL    |       |
            | idCard        | varchar(20)  | YES  |     | NULL    |       |
            | siNumber      | varchar(18)  | YES  |     | NULL    |       |
            | registerMoney | double       | YES  |     | NULL    |       |
            | phone         | varchar(30)  | YES  |     | NULL    |       |
            | isPay         | int(11)      | YES  |     | NULL    |       |
            | sex           | int(11)      | YES  |     | NULL    |       |
            | age           | int(11)      | YES  |     | NULL    |       |
            | consultation  | int(11)      | YES  |     | NULL    |       |
            | department    | int(11)      | YES  |     | NULL    |       |
            | did           | int(11)      | YES  |     | NULL    |       |
            | status        | int(11)      | YES  |     | NULL    |       |
            | registerDate  | datetime     | YES  |     | NULL    |       |
            | remark        | varchar(500) | YES  |     | NULL    |       |
            +---------------+--------------+------+-----+---------+-------+
*/
    private String rid;
    private String name;
    private String idCard;
    private String siNumber;
    private double registerMoney;
    private String phone;
    private int isPay;
    private int sex;
    private int age;
    private int consultation;
    private int department;
    private int did;
    private int status;
    private Date registerDate;
    private String remark;
    private Doctor doctor;

    public Register() {
    }

    public Register(String rid, String name, String idCard, String siNumber, double registerMoney, String phone, int isPay, int sex, int age, int consultation, int department, int did, int status, Date registerDate, String remark) {
        this.rid = rid;
        this.name = name;
        this.idCard = idCard;
        this.siNumber = siNumber;
        this.registerMoney = registerMoney;
        this.phone = phone;
        this.isPay = isPay;
        this.sex = sex;
        this.age = age;
        this.consultation = consultation;
        this.department = department;
        this.did = did;
        this.status = status;
        this.registerDate = registerDate;
        this.remark = remark;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSiNumber() {
        return siNumber;
    }

    public void setSiNumber(String siNumber) {
        this.siNumber = siNumber;
    }

    public double getRegisterMoney() {
        return registerMoney;
    }

    public void setRegisterMoney(double registerMoney) {
        this.registerMoney = registerMoney;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getConsultation() {
        return consultation;
    }

    public void setConsultation(int consultation) {
        this.consultation = consultation;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Register{" +
                "rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", siNumber='" + siNumber + '\'' +
                ", registerMoney=" + registerMoney +
                ", phone='" + phone + '\'' +
                ", isPay=" + isPay +
                ", sex=" + sex +
                ", age=" + age +
                ", consultation=" + consultation +
                ", department=" + department +
                ", did=" + did +
                ", status=" + status +
                ", registerDate=" + registerDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
