package ru.stonefist.lesson4;

/**
 * Created by Наиль on 01.06.2016.
 */
public class contact {
    String number;
    int contactIcon;
    String contactName;
    String contact;

    public contact(String number, int contactIcon, String contactName, String contact) {
        this.number = number;
        this.contactIcon = contactIcon;
        this.contactName = contactName;
        this.contact = contact;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getContactIcon() {
        return contactIcon;
    }

    public void setContactIcon(int contactIcon) {
        this.contactIcon = contactIcon;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
