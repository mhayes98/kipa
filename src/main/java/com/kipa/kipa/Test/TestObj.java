package com.kipa.kipa.Test;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class TestObj {

    private int testID;
    private String testName;
    private int testPrice;


    public TestObj() {}

    public TestObj(int testID, String testName, int testPrice) {
        this.testID = testID;
        this.testName = testName;
        this.testPrice = testPrice;
    }

    // Getters for all values are required for data to be retrieved
    public int getTestID() {
        return testID;
    }
    public String getTestName() {
        return testName;
    }
    public int getTestPrice() {
        return testPrice;
    }

    @Override
    public String toString() {
    return "TestObj{" +
            "testID=" + testID +
            ", testName='" + testName + '\'' +
            ", testPrice=" + testPrice +
            '}';
    }
}
