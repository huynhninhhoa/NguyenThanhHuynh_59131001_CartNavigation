package vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Model;

public class CustomsModel {

    String name;
    String dateOfBirth;
    String phoneNumber;
    String address;

    public CustomsModel() {
    }

    public CustomsModel(String name, String dateOfBirth, String phoneNumber, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
