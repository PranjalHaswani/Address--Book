package com.addressbook.addressbookapp.service;

import com.addressbook.addressbookapp.model.Contact;
import com.addressbook.addressbookapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Section-01(UC1)
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
