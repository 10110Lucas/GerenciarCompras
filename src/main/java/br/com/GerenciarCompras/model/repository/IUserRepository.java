package br.com.GerenciarCompras.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.GerenciarCompras.model.bean.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

	
}