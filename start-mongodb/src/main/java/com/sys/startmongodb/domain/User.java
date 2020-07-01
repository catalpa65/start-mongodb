package com.sys.startmongodb.domain;

public class User {
    private int _id;
    private String name;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
