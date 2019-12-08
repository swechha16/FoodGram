package com.foodgram;

public class Photo {

  private  User user;
   private String pic;
   private String caption, food_tag, cost_tag, restaurant, time_stamp;
    private int pic_id;


    public Photo(User user, String pic, String caption, String food_tag, String cost_tag, String restaurant, String time_stamp, int pic_id) {
        this.user = user;
        this.pic = pic;
        this.caption = caption;
        this.food_tag = food_tag;
        this.cost_tag = cost_tag;
        this.restaurant = restaurant;
        this.time_stamp = time_stamp;
        this.pic_id = pic_id;
    }

    public User getUser() {
        return user;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFood_tag() {
        return food_tag;
    }

    public void setFood_tag(String food_tag) {
        this.food_tag = food_tag;
    }

    public String getCost_tag() {
        return cost_tag;
    }

    public void setCost_tag(String cost_tag) {
        this.cost_tag = cost_tag;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }
}
