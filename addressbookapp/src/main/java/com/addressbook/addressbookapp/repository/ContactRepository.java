package com.addressbook.addressbookapp.repository;

import com.addressbook.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
