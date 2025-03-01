package com.addressbook.addressbookapp.repository;


import com.addressbook.addressbookapp.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Section-02(UC-1)
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
}
