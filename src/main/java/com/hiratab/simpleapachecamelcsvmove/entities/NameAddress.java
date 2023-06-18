package com.hiratab.simpleapachecamelcsvmove.entities;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class NameAddress {

    @DataField(pos = 1)
    private String name;
    @DataField(pos = 2)
    private String houseNumber;
    @DataField(pos = 3)
    private String city;
    @DataField(pos = 4)
    private String province;
    @DataField(pos = 5)
    private String postalCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "NameAddress{" +
            "name='" + name + '\'' +
            ", houseNumber='" + houseNumber + '\'' +
            ", city='" + city + '\'' +
            ", province='" + province + '\'' +
            ", postalCode='" + postalCode + '\'' +
            '}';
    }
}
