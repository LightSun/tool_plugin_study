package com.heaven7.plugin.idea.data_mediator.test;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void test(TestItem item){

    }
    public static void test2(TestItem item){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public Student() {
    }

    protected Student(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
