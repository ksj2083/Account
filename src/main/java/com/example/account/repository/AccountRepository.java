package com.example.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findFirstByOrderByIdDesc(); //자동으로 쿼리를 생성해준다.. 값이 없을수도 있기 때문에 Optional

	Integer countByAccountUser(AccountUser accountUser);

	Optional<Account> findByAccountNumber(String AccountNumber);

	List<Account> findByAccountUser(AccountUser accountUser);
}
