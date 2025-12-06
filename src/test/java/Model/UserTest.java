package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testSetAndGetIdUser() {
        user.setIdUser("U001");
        assertEquals("U001", user.getIdUser());
    }

    @Test
    void testSetAndGetUserName() {
        user.setUserName("John Doe");
        assertEquals("John Doe", user.getUserName());
    }

    @Test
    void testSetAndGetBirthday() {
        user.setBirthday("2000-01-01");
        assertEquals("2000-01-01", user.getBirthday());
    }

    @Test
    void testSetAndGetAddress() {
        user.setAddress("123 Main St");
        assertEquals("123 Main St", user.getAddress());
    }

    @Test
    void testSetAndGetPhoneNumber() {
        user.setPhoneNumber("123456789");
        assertEquals("123456789", user.getPhoneNumber());
    }

    @Test
    void testSetAndGetIdentityNumber() {
        user.setIdentityNumber("ID123456");
        assertEquals("ID123456", user.getIdentityNumber());
    }

    @Test
    void testSetAndGetSex() {
        user.setSex("Male");
        assertEquals("Male", user.getSex());
    }

    @Test
    void testSetAndGetAccountName() {
        user.setAccountName("john_doe");
        assertEquals("john_doe", user.getAccountName());
    }

    @Test
    void testSetAndGetPassword() {
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    void testSetAndGetRole() {
        user.setRole(1);
        assertEquals(1, user.getRole());
    }

    @Test
    void testSetAndGetUyTin() {
        user.setPrestige(5);
        assertEquals(5, user.getPrestige());
    }

    @Test
    void testSetAndGetImage() {
        byte[] image = {1, 2, 3};
        user.setImage(image);
        assertArrayEquals(image, user.getImage());
    }

    @Test
    void testConstructorWithPartialData() {
        byte[] image = {1, 2, 3};
        User user = new User("U002", "Jane Doe", "1995-05-15", "456 Elm St", "987654321", "ID654321", "Female", image);
        assertEquals("U002", user.getIdUser());
        assertEquals("Jane Doe", user.getUserName());
        assertEquals("1995-05-15", user.getBirthday());
        assertEquals("456 Elm St", user.getAddress());
        assertEquals("987654321", user.getPhoneNumber());
        assertEquals("ID654321", user.getIdentityNumber());
        assertEquals("Female", user.getSex());
        assertArrayEquals(image, user.getImage());
    }
}
