package tsooanapartone;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
  
    @Test
public void testCheckUserName() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

assertTrue(login.checkUserName());
}
    @Test
public void testInvalidUserName() {
    login login = new login("kyl123", "MyPassword1!", "+27838968976");

    assertFalse(login.checkUserName());
}
@Test
public void testCheckPasswordComplexity() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

    assertTrue(login.checkPasswordComplexity());
}
@Test
public void testInvalidPassword() {
    login login = new login("kyl_1", "MyPassword!", "+27838968976");

    assertFalse(login.checkPasswordComplexity());
}
@Test
public void testCheckCellPhoneNumber() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

    assertTrue(login.checkCellPhoneNumber());
}
@Test
public void testInvalidCellPhoneNumber() {
    login login = new login("kyl_1", "MyPassword1!", "0838986976");

    assertFalse(login.checkCellPhoneNumber());
}
@Test
public void testRegisterUser() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

    assertEquals("Registration successful.", login.registerUser());
}
@Test
public void testInvalidRegisterUser() {
    login login = new login("kyl123", "MyPassword1!", "+27838968976");

    assertEquals("Username is incorrectly formatted.", login.registerUser());
}
@Test
public void testLoginUser() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

    assertTrue(login.loginUser("kyl_1", "MyPassword1!"));
}
@Test
public void testInvalidLoginUser() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

    assertFalse(login.loginUser("wrongUser", "wrongPassword"));
}
@Test
public void testReturnLoginStatusSuccess() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

    assertEquals(
        "Welcome back! It is great to see you again.",
        login.returnLoginStatus(true)
    );
}
@Test
public void testReturnLoginStatusFailed() {
    login login = new login("kyl_1", "MyPassword1!", "+27838968976");

    assertEquals(
        "Username or password incorrect, please try again.",
        login.returnLoginStatus(false)
    );
}
}

