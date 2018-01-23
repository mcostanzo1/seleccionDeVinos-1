package com.dp3.service;

import com.dp3.dao.UserRepository;
import com.dp3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	@Override
	public User loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		return user;
	}
	
//	@Transactional
//	@Override
//	public User modificarUsuario(User usuario, UsuarioDTO dto) throws UsuarioException {
//		User usuarioContexto = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (!usuarioContexto.getUsername().equals(String.valueOf(dto.getUf()))) {
//			throw new UsuarioException("User de contexto modificado.");
//		}
//		
////		if (!usuario.getEmail().equals(dto.getEmail())) {
////			usuario.setEmail(dto.getEmail());
////		}
////		if (!usuario.getFirstname().equals(dto.getEmail2())) {
////			usuario.setEmail2(dto.getEmail2());
////		}
////		if (dto.getPassword() != "" && dto.getPassword() != null && !usuario.getPassword().equals(dto.getPassword())) {
////			usuario.setPassword(dto.getPassword());
////		}
//		return usuarioDAO.update(usuario);
//	}
}
