package com.addressbook.addressbookapp.controller;

import com.addressbook.addressbookapp.model.Contact;
import com.addressbook.addressbookapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//Section-01(UC1)
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.getContactById(id);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact createdContact = contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Optional<Contact> existingContact = contactService.getContactById(id);
        if (existingContact.isPresent()) {
            Contact updatedContact = contactService.updateContact(id, contact);
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
