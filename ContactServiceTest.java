package com.weeksix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    @Test
    public void testAddAndRetrieveContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("123"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        service.deleteContact("123");
        assertNull(service.getContact("123"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        service.updateContact("123", "Jane", "Smith", "0987654321", "456 Oak St");
        Contact updatedContact = service.getContact("123");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak St", updatedContact.getAddress());
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(new Contact("123", "Jane", "Doe", "0987654321", "456 Oak St")));
    }

    @Test
    public void testUpdateNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("999", "Jane", "Doe", "0987654321", "456 Oak St"));
    }
}

