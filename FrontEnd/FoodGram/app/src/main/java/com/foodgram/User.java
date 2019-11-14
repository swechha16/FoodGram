package com.foodgram;

public class User {
    private long user_id;
    private String username;
    private String full_name; //can be null
    private String bio; //can be null
    private String email;
    private String password;
    private String account_type;
    private String location_city;
    private String location_state;
    private String phone_no;

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    private String profile_pic;

    public User(){

    }

    public User(long user_id, String username, String email, String account_type, String password){
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.account_type = account_type;
        this.password = password;
    }


    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getLocation_state() {
        return location_state;
    }

    public void setLocation_state(String location_state) {
        this.location_state = location_state;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
