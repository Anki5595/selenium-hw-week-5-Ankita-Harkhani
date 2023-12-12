package resources.testdata;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestData {
    @DataProvider(name = "credentials")
    public Object[][] getData(Method method) {
        Object[][] errorMessage = {
                {" ", " ", "Required"},
                {"test123@gmail.com", " ", "Required"},
                {" ", "test123", "Required"}
        };
        Object[][] invalidInputMessage = {
                {"test123@gmail.com", "test123", "Invalid credentials"}
        };
        String methodName = method.getName();
        if (methodName.equals("verifyErrorMessageWithInvalidCredentials")) {
            return errorMessage;
        } else if (methodName.equals("verifyInvalidInputMessageWithInvalidCredentials")) {
            return invalidInputMessage;
        } else {
            return new Object[][]{{"No Test Data Present"}, {"No Test Data Present"}};
        }

    }

    @DataProvider(name = "DataSet")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Admin", "Admin", "Paul Collings", "Enable"},
                {"Cassidy.Hope", "ESS", "Cassidy Hope", "Enable"},
                {"Nina.Patel", "ESS", "Nina Patel", "Enable"},
                {"Odis.Adalwin", "Admin", "Odis Adalwin", "Enable"}
        };
        return data;
    }

}

