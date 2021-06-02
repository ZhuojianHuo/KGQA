package com.imploded.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Person extends BaseEntity{

    private Long pid;
    private String lables;
    private String resume;
    private String profession;
    private String stkcd;
    private String tmtp;
    private String gender;
    private String sharEnd;
    private String university;
    private String degree;
    private String ctb;
    private String isSupervisor;
    private String nationality;
    private String major;
    private String totalSalary;
    private String name;
    private String personID;
    private int age;


    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getLables() {
        return lables;
    }

    public void setLables(String lables) {
        this.lables = lables;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStkcd() {
        return stkcd;
    }

    public void setStkcd(String stkcd) {
        this.stkcd = stkcd;
    }

    public String getTmtp() {
        return tmtp;
    }

    public void setTmtp(String tmtp) {
        this.tmtp = tmtp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSharEnd() {
        return sharEnd;
    }

    public void setSharEnd(String sharEnd) {
        this.sharEnd = sharEnd;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCtb() {
        return ctb;
    }

    public void setCtb(String ctb) {
        this.ctb = ctb;
    }

    public String getIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(String isSupervisor) {
        this.isSupervisor = isSupervisor;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(String totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
