package com.example.twitterBacked.repository;

import com.example.twitterBacked.dao.UserDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<UserDetailsDao,String> {
}
