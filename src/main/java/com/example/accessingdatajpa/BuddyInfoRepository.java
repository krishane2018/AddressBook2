package com.example.accessingdatajpa;


import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    BuddyInfo findById(long id);
}