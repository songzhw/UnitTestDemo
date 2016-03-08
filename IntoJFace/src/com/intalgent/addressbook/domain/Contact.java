package com.intalgent.addressbook.domain;

public class Contact {
    private String givenName;
    private String familyName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String businessPhone;
    private String homePhone;
    private String emailAddress;

    public Contact() {
        this.givenName = "";
        this.familyName = "";
        this.addressLine1 = "";
        this.addressLine2 = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
        this.businessPhone = "";
        this.homePhone = "";
        this.emailAddress = "";
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setFamilyName(String string) {
        familyName = string;
    }

    public void setGivenName(String string) {
        givenName = string;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setAddressLine1(String string) {
        addressLine1 = string;
    }

    public void setAddressLine2(String string) {
        addressLine2 = string;
    }

    public void setCity(String string) {
        city = string;
    }

    public void setState(String string) {
        state = string;
    }

    public void setZipCode(String string) {
        zipCode = string;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setBusinessPhone(String string) {
        businessPhone = string;
    }

    public void setHomePhone(String string) {
        homePhone = string;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String string) {
        emailAddress = string;
    }
}
