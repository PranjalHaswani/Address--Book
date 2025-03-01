package com.addressbook.addressbookapp.service;


import com.addressbook.addressbookapp.model.AddressBookModel;
import com.addressbook.addressbookapp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    // Using a List to store AddressBooks in memory
    private List<AddressBookModel> addressBooks = new ArrayList<>();
    private Long nextId = 1L;

    // Create AddressBook
    public AddressBookModel createAddressBook(AddressBookModel addressBook) {
        addressBook.setId(nextId++);
        addressBooks.add(addressBook);
        return addressBook;
    }

    // Get all AddressBooks
    public List<AddressBookModel> getAllAddressBooks() {
        return addressBooks;
    }

    // Get AddressBook by ID
    public Optional<AddressBookModel> getAddressBookById(Long id) {
        return addressBooks.stream().filter(addressBook -> addressBook.getId().equals(id)).findFirst();
    }

    // Update AddressBook by ID
    public Optional<AddressBookModel> updateAddressBook(Long id, AddressBookModel updatedAddressBook) {
        Optional<AddressBookModel> existingAddressBook = getAddressBookById(id);
        if (existingAddressBook.isPresent()) {
            AddressBookModel addressBook = existingAddressBook.get();
            addressBook.setName(updatedAddressBook.getName());
            addressBook.setPhoneNumber(updatedAddressBook.getPhoneNumber());
            addressBook.setEmail(updatedAddressBook.getEmail());
            return Optional.of(addressBook);
        }
        return Optional.empty();
    }

    // Delete AddressBook by ID
    public boolean deleteAddressBook(Long id) {
        return addressBooks.removeIf(addressBook -> addressBook.getId().equals(id));
    }
}

