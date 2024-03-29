package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "221270936";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Seth";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailEmptyUsernameAndInvalidPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "invalid");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailEmptyUsernameAndValidPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailInvalidUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("invalidUser", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailInvalidUsernameAndInvalidPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("invalidUser", "invalid");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailInvalidUsernameAndValidPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("invalidUser", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailValidUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailValidUsernameAndInvalidPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "invalid");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testSuccessValidUsernameAndValidPasswordAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }

    @Test
    public void testFailValidUsernameAndValidPasswordAndWrongValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());

        Assert.assertFalse(LoginForm.validateCode("wrongCode"));
    }
}
