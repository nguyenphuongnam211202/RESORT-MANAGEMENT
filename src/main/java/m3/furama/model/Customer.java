package m3.furama.model;

import m3.furama.util.annotation.Extra;
import m3.furama.util.annotation.IsAssociate;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String fullname;
    private LocalDate birthday;
    private Boolean gender;
    private String identifyNumber;
    private String phone;
    private String email;
    private String address;
    @IsAssociate(table = "customer_type")
    private int customerTypeId;
    @Extra
    private String customerTypeName;

    public Customer(int id, String fullname, LocalDate birthday, Boolean gender, String identifyNumber, String phone, String email, String address, int customerTypeId, String customerTypeName) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.identifyNumber = identifyNumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerType() {
        return customerTypeName;
    }

    public void setCustomerType(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
