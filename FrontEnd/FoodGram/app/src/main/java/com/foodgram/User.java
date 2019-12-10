package com.foodgram;

import org.parceler.Parcel;

/**
 * A user for FoodGram
 * @author SKarn
 * @author Vtorres - Javadoc
 */

@Parcel
public class User {
    /**
     * User identification
     */
    public long user_id;
    /**
     * User name
     */
    public String username;
    /**
     * The full name of a user
     */
    public String full_name; //can be null
    /**
     * The bio of a user
     */
    public String bio; //can be null
    /**
     * the email for a user
     */
    public String email;
    /**
     * the password for a user
     */
    public String password;
    /**
     * Whether a user is a restaurant or a person
     */
    public String account_type;
    /**
     * The location in city of the user
     */
    public String location_city;
    /**
     * The location in state of a user
     */
    public String location_state;
    /**
     * The phone number of a user
     */
    public String phone_no;
    /**
     * the profile picture of a user
     */
    public String profile_pic;

    public User(){

    }


    /**
     * Constructs a user given its parameters
     * @param user_id - The user id which has been generated in the backend
     * @param username - The username chosen by the user which will be used to login
     * @param email - The email for the given user
     * @param account_type - Restaurant or Person
     * @param password - The password which will be used to login
     */
    public User(long user_id, String username, String email, String account_type, String password){
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.account_type = account_type;
        this.password = password;
    }
    /**
     * Gets the profile picture of a user
     * @return the profile picture of a user
     */
    public String getProfile_pic() {
        return profile_pic;
    }

    /**
     * Sets the profile pic of the user
     * @param profile_pic
     */
    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    /**
     * Gets the phone number of a user
     * @return the phone number of a user
     */
    public String getPhone_no() {
        return phone_no;
    }

    /**
     * Sets the phone number of a user
     * @param phone_no - the new phone number to set
     */
    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    /**
     * Gets the location in state of a user
     * @return - the location state of a user
     */
    public String getLocation_state() {
        return location_state;
    }

    /**
     * Sets the new location state of a user
     * @param location_state - the new location state of a user
     */
    public void setLocation_state(String location_state) {
        this.location_state = location_state;
    }

    /**
     * Gets the location in city of a user
     * @return the location city of a user
     */
    public String getLocation_city() {
        return location_city;
    }

    /**
     * Sets the location city of a user
     * @param location_city - the new location city of a user
     */
    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }
/**
 * Gets the account type of a user
 * @return the account type of a user
 */
    public String getAccount_type() {
        return account_type;
    }

    /**
     * Sets the account type of a user.
     * !!! Should probably not have a method to change a person to a restaurant !!!
     * @param account_type - the new account type of a user
     */
    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    /**
     * Gets the password of the user
     * @return the password for the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password for the user
     * @param password - the new password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email for the user
     * @return - the email for the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a new email for the user
     * @param email - the new email for the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the bio for the user
     * @return - the bio for the user
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets the bio for the user
     * @param bio - the new bio for the user
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Gets the full name of the user
     * @return full name of the user
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * Sets the full name of a user
     * @param full_name - the new full name of the user
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * Gets the username for the user
     * @return username for user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the user
     * @param username - The new username for the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user id for the user
     * @return user id for the user
     */
    public long getUser_id() {
        return user_id;
    }

    /**
     * Sets the user id for the user
     * @param user_id new user id for the user
     */
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
