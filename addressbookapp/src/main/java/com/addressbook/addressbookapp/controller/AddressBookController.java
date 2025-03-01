package com.addressbook.addressbookapp.controller;

import com.addressbook.addressbookapp.DTO.AddressBookDTO;
import com.addressbook.addressbookapp.model.AddressBookModel;
import com.addressbook.addressbookapp.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Section-02(UC-1)
@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    // GET all AddressBooks
    @GetMapping
    public List<AddressBookModel> getAllAddressBooks() {
        return addressBookService.getAllAddressBooks();
    }
    // Endpoint to get AddressBook by id
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressBookById(@PathVariable Long id) {
        Optional<AddressBookModel> addressBook = addressBookService.findById(id);
        if (addressBook.isPresent()) {
            AddressBookDTO addressBookDTO = new AddressBookDTO(
                    addressBook.get().getId(),
                    addressBook.get().getName(),
                    addressBook.get().getPhoneNumber(),
                    addressBook.get().getEmail()
            );
            return new ResponseEntity<>(addressBookDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // POST - Create AddressBook
    @PostMapping
    public ResponseEntity<AddressBookModel> createAddressBook(@RequestBody AddressBookModel addressBook) {
        AddressBookModel createdAddressBook = addressBookService.createAddressBook(addressBook);
        return new ResponseEntity<>(createdAddressBook, HttpStatus.CREATED);
    }

    // PUT - Update AddressBook by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddressBook(@PathVariable Long id, @RequestBody AddressBookModel addressBook) {
        Optional<AddressBookModel> updatedAddressBook = addressBookService.updateAddressBook(id, addressBook);
        return updatedAddressBook.map(value -> new ResponseEntity<>(new AddressBookDTO(value.getId(), value.getName(), value.getPhoneNumber(), value.getEmail()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE - Delete AddressBook by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressBook(@PathVariable Long id) {
        boolean deleted = addressBookService.deleteAddressBook(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
