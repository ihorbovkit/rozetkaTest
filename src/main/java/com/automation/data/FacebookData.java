package com.automation.data;

import org.testng.annotations.DataProvider;

/**
 * Created by kolodiy on 7/14/16.
 */
public class FacebookData {
    @DataProvider(name = "com/automation/pages")

    public static Object[][] pages() {
        return new Object[][]{
                {"https://www.facebook.com/", "Facebook - Log In or Sign Up"}
        };
    }

    @DataProvider(name = "login")
    public static Object[][] login() {
        return new Object[][]{
                {"axtzvpn_schrocksen_1468497450@tfbnw.net", "6vje1ai5tro", null},
                {"", "6vje1ai5tro", "Log into Facebook"},
/*                {"axtzvpn_schrocksen_1468497450@tfbnw.net", "12345678", "invalid pw" },
                {"axtzvpn__1468497450@tfbnw.net", "6vje15tro", "invalid email and pw"},
                {"", "6vje1ai5tro", "blank email and pw"},
                {"axtzvpn_schrocksen_1468497450@tfbnw.net", "", "email and black pw"},*/

        };

    }

    @DataProvider(name = "singup")
    public static Object[][] singup() {
        return new Object[][]{
                {"Roman", "Kolodiy", "validEmail@facebook.com"},
                {"@#$%@#", "@#!#@$T%%%", "validEmail@facebook.com"},
                {"12341", "5234523", "validEmail@facebook.com"},
        };
    };
}