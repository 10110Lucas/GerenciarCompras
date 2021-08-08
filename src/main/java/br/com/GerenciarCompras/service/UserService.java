package br.com.GerenciarCompras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.GerenciarCompras.model.bean.User;
import br.com.GerenciarCompras.model.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;
	
	public void criarUsuario(User user) {
		userRepository.save(user);
	}
}