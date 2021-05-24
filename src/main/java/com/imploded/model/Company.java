package com.imploded.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Company extends BaseEntity{

    private int cid;
    private String lables;
    private String industryName;
    private String symbol;
    private String zipCode;
    private String website;
    private String businessScope;
    private String officeAddress;
    private String establishDate;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getLables() {
        return lables;
    }

    public void setLables(String lables) {
        this.lables = lables;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getRegisterCaptial() {
        return registerCaptial;
    }

    public void setRegisterCaptial(String registerCaptial) {
        this.registerCaptial = registerCaptial;
    }

    public String getSigChange() {
        return sigChange;
    }

    public void setSigChange(String sigChange) {
        this.sigChange = sigChange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    private String registerAddress;
    private String registerCaptial;
    private String sigChange;
    private String name;
    private String shortName;

}
