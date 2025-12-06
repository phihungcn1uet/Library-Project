package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JOptionPane;

public class FunctionTest {

    @Test
    public void testConvertToHex() {
        byte[] bytes = {0x12, 0x34, 0x56, 0x78};
        String expectedHex = "12345678";
        String result = Function.convertToHex(bytes);
        assertEquals(expectedHex, result, "The hex string should be '12345678'");

        // Test with null input
        assertNull(Function.convertToHex(null), "The result should be null for null input");
    }

    @Test
    public void testLoadUserImage() {
        byte[] validBytes = new byte[]{0x01, 0x02}; // Dummy byte array for valid image
        byte[] emptyBytes = null;

        // Test with valid byte array (this is a placeholder check)
        assertNotNull(Function.loadUserImage(100, 100, validBytes));

        // Test with null/empty byte array (should load default image)
        assertNotNull(Function.loadUserImage(100, 100, emptyBytes));
    }

    @Test
    public void testLoadBookImage() {
        byte[] validBytes = new byte[]{0x01, 0x02}; // Dummy byte array for valid image
        byte[] emptyBytes = null;

        // Test with valid byte array (this is a placeholder check)
        assertNotNull(Function.loadBookImage(100, 100, validBytes));

        // Test with null/empty byte array (should load default image)
        assertNotNull(Function.loadBookImage(100, 100, emptyBytes));
    }

    @Test
    public void testCheckDateValid() {
        // Test with valid date
        assertTrue(Function.checkDate("15/08/2023"), "The date should be valid");

        // Test with valid date but edge cases
        assertTrue(Function.checkDate("01/01/1000"), "The date should be valid with year 1000");
        assertTrue(Function.checkDate("31/12/9999"), "The date should be valid with year 9999");
    }

    @Test
    public void testCheckDateInvalid() {
        // Test with invalid format
        assertFalse(Function.checkDate("2023/08/15"), "The date format should be invalid");

        // Test with invalid day
        assertFalse(Function.checkDate("32/08/2023"), "The day should be invalid");

        // Test with invalid month
        assertFalse(Function.checkDate("15/13/2023"), "The month should be invalid");

        // Test with invalid year
        assertFalse(Function.checkDate("15/08/202"), "The year should have 4 digits");

        // Test with non-numeric input
        assertFalse(Function.checkDate("AB/CD/EFGH"), "The date should contain only digits");
    }

    @Test
    public void testCheckPhoneNumberValid() {
        // Test with valid phone number
        assertTrue(Function.checkPhoneNumber("0123456789"), "The phone number should be valid");
    }

    @Test
    public void testCheckPhoneNumberInvalid() {
        // Test with alphabetic characters
        assertFalse(Function.checkPhoneNumber("01234AB678"), "The phone number should not contain letters");

        // Test with incorrect length
        assertFalse(Function.checkPhoneNumber("123456789"), "The phone number should have exactly 10 digits");
        assertFalse(Function.checkPhoneNumber("01234567890"), "The phone number should have exactly 10 digits");
    }
}
