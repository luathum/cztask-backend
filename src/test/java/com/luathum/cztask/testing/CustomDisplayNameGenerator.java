package com.luathum.cztask.testing;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGenerator;

public class CustomDisplayNameGenerator extends DisplayNameGenerator.Standard {
  @Override
  public String generateDisplayNameForClass(Class<?> testClass) {
    return replaceCamelCase(super.generateDisplayNameForClass(testClass));
  }

  @Override
  public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
    return super.generateDisplayNameForNestedClass(nestedClass) + "...";
  }

  @Override
  public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
    return this.replaceCamelCase(testMethod.getName());
  }

  private String replaceCamelCase(String camelCase) {
    String result = "" + camelCase.toUpperCase().charAt(0);
    for (char letter : camelCase.substring(1).toCharArray()) {
      result += Character.isUpperCase(letter) ? (" " + letter).toLowerCase() : letter;
    }
    return result + ".";
  }

}
