package com.epam.automation.service;

import com.epam.automation.model.GoogleCloud;

public class CloudCreator {
    private static final String numberOfInstances = "testdata.number.of.instances";
    private static final String vmClass = "testdata.vm.class";
    private static final String instanceType = "testdata.instance.type";
    private static final String localSSD = "testdata.local.ssd";
    private static final String dataCenterLocation = "testdata.data.center.location";
    private static final String committedUsage = "testdata.committed.usage";

    public static GoogleCloud generateCloudWithProperties() {
        return new GoogleCloud(
                TestDataReader.getTestData(numberOfInstances),
                TestDataReader.getTestData(vmClass),
                TestDataReader.getTestData(instanceType),
                TestDataReader.getTestData(localSSD),
                TestDataReader.getTestData(dataCenterLocation),
                TestDataReader.getTestData(committedUsage)
        );
    }
}
