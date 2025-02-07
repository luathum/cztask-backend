package com.luathum.cztask.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.luathum.cztask.testing.CustomDisplayNameGenerator;

@DisplayNameGeneration(CustomDisplayNameGenerator.class)
public class UserTest {

  private User user;

  @BeforeEach
  void setUp() {
    user = new User();
  }

  @Nested
  class emailIsValid {

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @ValueSource(strings = "jhon.doe@email.com")
    public void shouldReturnTrueForValidEmails (String email) {
      user.setEmail(email);

      assertEquals(email, user.getEmail(), "email not set to User.email");
      assertTrue(user.emailIsValid(), "this email is invalid");
    }

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @NullAndEmptySource
    @ValueSource(strings = {"example.com", "@example", "example@.com"})
    public void shouldReturnFalseForInvalidEmails(String email) {
      user.setEmail(email);

      assertEquals(email, user.getEmail(), "email not set to User.email");
      assertFalse(user.emailIsValid(), "this email is incorrectly marked as valid");
    }

  }

  @Nested
  class passwordIsValid {

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @ValueSource(strings = "Password123!")
    public void shouldReturnTrueForValidPasswords (String password) {
      user.setPassword(password);

      assertEquals(password, user.getPassword(), "password not set to User.password");
      assertTrue(user.passwordIsValid(), "this password is invalid");
    }

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @NullAndEmptySource
    @ValueSource(strings = {"Pd123", "noupercase1!", "NOLOWERCASE1!", "NoSpecialChar1", "NoNumber!"})
    public void shouldReturnFalseForInvalidPasswords(String password) {
      user.setPassword(password);

      assertEquals(password, user.getPassword(), "password not set to User.password");
      assertFalse(user.passwordIsValid(), "this password is incorrectly marked as valid");
    }
  }

  @Nested
  class nameIsValid {

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @ValueSource(strings = {"John Doe", "Jhon"})
    public void shouldReturnTrueForValidNames (String name) {
      user.setName(name);

      assertEquals(name, user.getName(), "name not set to User.name");
      assertTrue(user.nameIsValid(), "this name is invalid");
    }

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @NullAndEmptySource
    @ValueSource(strings = {" Jhon", "Jhon ", "Jhon  Doe", "John1", "John!", "john", "john doe",
      "JOHN", "JOHN DOE", "JoHn", "Jhon DoE"})
    public void shouldReturnFalseForInvalidNames(String name) {
      user.setName(name);

      assertEquals(name, user.getName(), "name not set to User.name");
      assertFalse(user.nameIsValid(), "this name is incorrectly marked as valid");
    }
  }

  @Nested
  class lastnameIsValid {

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @ValueSource(strings = {"John Doe", "Doe"})
    public void shouldReturnTrueForValidLastnames (String lastname) {
      user.setLastname(lastname);

      assertEquals(lastname, user.getLastname(), "lastname not set to User.lastname");
      assertTrue(user.lastnameIsValid(), "this lastname is invalid");
    }

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @NullAndEmptySource
    @ValueSource(strings = {" Jhon", "Jhon ", "Jhon  Doe", "John1", "John!", "john", "john doe",
      "JOHN", "JOHN DOE", "JoHn", "Jhon DoE"})
    public void shouldReturnFalseForInvalidLastnames(String lastname) {
      user.setLastname(lastname);

      assertEquals(lastname, user.getLastname(), "lastname not set to User.lastname");
      assertFalse(user.lastnameIsValid(), "this lastname is incorrectly marked as valid");
    }
  }

  @Nested
  class phoneNumberIsValid {

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @ValueSource(strings = {"+1234567", "+12345678901234"})
    public void shouldReturnTrueForValidPhoneNumbers (String phoneNumber) {
      user.setPhoneNumber(phoneNumber);

      assertEquals(phoneNumber, user.getPhoneNumber(), "phoneNumber not set to User.phoneNumber");
      assertTrue(user.phoneNumberIsValid());
    }

    @ParameterizedTest(name = "Testing with \"{0}\".")
    @NullAndEmptySource
    @ValueSource(strings = {"+12345", "+1234567890123456", "+12 345 678 90", "+12-345-678-90",
      "+12.345.678.90", "1234567890", "123abc7890"})
    public void shouldReturnFalseForInvalidPhoneNumbers(String phoneNumber) {
      user.setPhoneNumber(phoneNumber);

      assertEquals(phoneNumber, user.getPhoneNumber(), "phoneNumber not set to User.phoneNumber");
      assertFalse(user.phoneNumberIsValid(), "phoneNumber is incorrectly marked as valid");
    }
  }

}
