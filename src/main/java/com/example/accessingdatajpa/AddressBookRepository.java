package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    AddressBook findById(long id);
}