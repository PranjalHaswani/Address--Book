package com.addressbook.addressbookapp.controller;

import com.addressbook.addressbookapp.DTO.AddressBookDTO;
import com.addressbook.addressbookapp.model.AddressBookModel;
import com.addressbook.addressbookapp.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//Section-02(UC-1)
@RestController
public class AddressBookController {

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    // Endpoint to get AddressBook by id
    @GetMapping("/addressbook/{id}")
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
}
