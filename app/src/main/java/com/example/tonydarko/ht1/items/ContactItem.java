package com.example.tonydarko.ht1.items;

public class ContactItem {

    String name, email;
    String phone, adress;
    int image;

    public ContactItem(String name, String email, String phone, String adress, int image) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
