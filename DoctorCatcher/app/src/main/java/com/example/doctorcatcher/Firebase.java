package com.example.doctorcatcher;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {

    String Username, Password;
    String FullName, NRIC, DOB, Phone, Email, Address;
    String PolicyName, PolicyPhone, PolicyRelation;

    public Firebase() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getNRIC() {
        return NRIC;
    }

    public void setNRIC(String NRIC) {
        this.NRIC = NRIC;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPolicyName() {
        return PolicyName;
    }

    public void setPolicyName(String policyName) {
        PolicyName = policyName;
    }

    public String getPolicyPhone() {
        return PolicyPhone;
    }

    public void setPolicyPhone(String policyPhone) {
        PolicyPhone = policyPhone;
    }

    public String getPolicyRelation() {
        return PolicyRelation;
    }

    public void setPolicyRelation(String policyRelation) {
        PolicyRelation = policyRelation;
    }


}
