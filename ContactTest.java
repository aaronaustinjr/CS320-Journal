package com.weeksix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testValidContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "123", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "123456789", "123 Elm St"));
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "1234567890", "This address is way too long for the given constraints"));
    }
}

