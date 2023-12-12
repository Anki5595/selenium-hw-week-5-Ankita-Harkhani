package resources.testdata;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestData {
    @DataProvider(name = "getTestData")
    public Object[][] getData(Method method) {
        Object[][] dataForProduct1 = {
                {"HTC Touch HD", "1", "Success: You have added HTC Touch HD to your shopping cart!", "HTC Touch HD", "Product 1", "£74.73"}
        };
        Object[][] dataForProduct2 = {
                {"iPhone", "2", "Success: You have added iPhone to your shopping cart!", "iPhone", "product 11", "£150.92"}
        };
        Object[][] dataForProduct3 = {
                {"Palm Treo Pro", "3", "Success: You have added Palm Treo Pro to your shopping cart!", "Palm Treo Pro", "Product 2", "£1,242.11"}
        };
        String methodName = method.getName();
        if (methodName.equals("verifyProduct1AddedToShoppingCartSuccessFully")) {
            return dataForProduct1;
        } else if (methodName.equals("verifyProduct2AddedToShoppingCartSuccessFully")) {
            return dataForProduct2;
        } else if (methodName.equals("verifyProduct3AddedToShoppingCartSuccessFully")) {
            return dataForProduct3;
        } else {
            return new Object[][]{{"No Test Data Present"}, {"No Test Data Present"}};
        }

    }
}