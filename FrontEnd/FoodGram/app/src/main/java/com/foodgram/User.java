package com.foodgram;

public class User {

    private long idUser;
    private String userName;
    private String fullName;
    private String userBio;
    private String userEmail;
    private String userPassword;
    private String userAccountType;
    private String userLocationCity;
    private String userLocationState;
    private String userPhoneNum;
    private String userProfile;

public void userId(long user_id){
    idUser = user_id;
}

public void name(String username, String full_name){
    userName = username;
    fullName = full_name;

}

public void userInfo(String bio, String email, String password, String account_type){
        userBio = bio;
        userEmail = email;
        userPassword = password;
        userAccountType = account_type;
}

public void userHabitat(String location_city, String location_state, String phone_no){
        userLocationCity = location_city;
        userLocationState = location_state;
        userPhoneNum = phone_no;
}

public void profile(String profile_pic){
    userProfile = profile_pic;
}

}
