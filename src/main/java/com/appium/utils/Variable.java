package com.appium.utils;

public class Variable {
    public static String getOverriddenStringValue(String key) {
        return getValueFromEnvOrProperty(key);
    }

    public static String getOverriddenStringValue(String key, String defaultValue) {
        return (isKeyProvidedInEnvOrProperty(key))
                ? defaultValue
                : getValueFromEnvOrProperty(key);
    }

    public static int getOverriddenIntValue(String key) {
        return Integer.parseInt(getValueFromEnvOrProperty(key));
    }

    public static int getOverriddenIntValue(String key, int defaultValue) {
        return isKeyProvidedInEnvOrProperty(key)
                ? defaultValue
                : Integer.parseInt(getValueFromEnvOrProperty(key));
    }

    public static boolean getOverriddenBooleanValue(String key) {
        return Boolean.parseBoolean(getValueFromEnvOrProperty(key));
    }

    public static boolean getOverriddenBooleanValue(String key, boolean defaultValue) {
        return isKeyProvidedInEnvOrProperty(key)
                ? defaultValue
                : Boolean.parseBoolean(getValueFromEnvOrProperty(key));
    }

    private static boolean isKeyProvidedInEnvOrProperty(String key) {
        return null == System.getenv(key) && null == System.getProperty(key);
    }

    private static String getValueFromEnvOrProperty(String key) {
        return (null == System.getenv(key)) ? System.getProperty(key) : System.getenv(key);
    }
}