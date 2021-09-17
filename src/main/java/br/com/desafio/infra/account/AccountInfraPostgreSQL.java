package br.com.desafio.infra.account;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.domain.account.entity.Account;

public interface AccountInfraPostgreSQL extends JpaRepository<Account, Long> {
	
}
