package com.example.healthmonitoring;

import android.os.Parcel;
import android.os.Parcelable;

public class Patient implements Parcelable {
    String surname;
    String name;
    String feature;
    int age;

    public Patient(String surname, String name, String feature, int age) {
        this.surname = surname;
        this.name = name;
        this.feature = feature;
        this.age = age;
    }

    public Patient(Parcel in) {
        surname = in.readString();
        name = in.readString();
        feature = in.readString();
        age = in.readInt();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFeature() {
        return feature;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(surname);
        dest.writeString(name);
        dest.writeString(feature);
        dest.writeInt(age);
    }
}
