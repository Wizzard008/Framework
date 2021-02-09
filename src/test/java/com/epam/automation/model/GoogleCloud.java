package com.epam.automation.model;

import org.openqa.selenium.By;

import java.util.Objects;

public class GoogleCloud {


    private String numberOfInstances;
    private String vmClass;
    private String instanceType;
    private String localSSD;
    private String dataCenterLocation;
    private String committedUsage;

    public String getNumberOfInstancesLocator() {
        return numberOfInstances;
    }

    public By getVmClassLocator() {
        switch (vmClass){
            case "VM class: regular":return By.id("select_option_78");
            case "VM class: preemptible":return By.id("select_option_79");
            default: return By.id("select_option_78");
        }
    }

    public By getInstanceTypeLocator() {
        switch (instanceType){
            case "Instance type: n1-standard-1":return By.id("select_option_357");
            case "Instance type: n1-standard-2":return By.id("select_option_358");
            case "Instance type: n1-standard-4":return By.id("select_option_359");
            case "Instance type: n1-standard-8":return By.id("select_option_360");
            default: return By.id("select_option_360");
        }

    }

    public By getLocalSSDLocator() {
        switch (localSSD){
            case "Total available local SSD space 1x375 GiB":return By.id("select_option_380");
            case "Total available local SSD space 2x375 GiB":return By.id("select_option_381");
            case "Total available local SSD space 3x375 GiB":return By.id("select_option_382");
            default: return By.id("select_option_381");
        }
    }

    public By getDataCenterLocationLocator() {
        switch (dataCenterLocation){
            case "Region: Los Angeles":return By.id("select_option_200");
            case "Region: Las Vegas":return By.id("select_option_202");
            case "Region: London":return By.id("select_option_204");
            case "Region: Frankfurt":return By.id("select_option_205");
            default: return By.id("select_option_205");
        }
    }

    public By getCommittedUsageLocator() {
        switch (committedUsage){
            case "Commitment term: 1 Year":return By.id("select_option_97");
            case "Commitment term: 3 Years":return By.id("select_option_98");
            default: return By.id("select_option_97");
        }
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getVmClass() {
        return vmClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public GoogleCloud(String numberOfInstances, String vmClass, String instanceType, String localSSD, String dataCenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.vmClass = vmClass;
        this.instanceType = instanceType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "GoogleCloud{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoogleCloud that = (GoogleCloud) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(vmClass, that.vmClass) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(dataCenterLocation, that.dataCenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, vmClass, instanceType, localSSD, dataCenterLocation, committedUsage);
    }
}
