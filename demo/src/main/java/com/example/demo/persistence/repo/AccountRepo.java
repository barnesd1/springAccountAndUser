package com.example.demo.persistence.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
@Query(value="select * from account where name =?1", nativeQuery = true)
List<Account> findByName(String name);
}
