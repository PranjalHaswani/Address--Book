package com.addressbook.addressbookapp.service;


import com.addressbook.addressbookapp.model.AddressBookModel;
import com.addressbook.addressbookapp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Section-02(UC-1)
@Service
public class AddressBookService {

    private final AddressBookRepository addressBookRepository;

    public AddressBookService(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    public Optional<AddressBookModel> findById(Long id) {
        return addressBookRepository.findById(id);
    }
}

