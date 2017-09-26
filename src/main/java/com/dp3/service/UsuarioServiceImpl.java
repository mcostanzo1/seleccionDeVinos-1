package com.dp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp3.dao.UsuarioDAO;
import com.dp3.domain.Usuario;
import com.dp3.exceptions.UsuarioException;
import com.dp3.web.dto.UsuarioDTO;

@Service("userDetailsService")
public class UsuarioServiceImpl implements UsuarioService {
	
	private com.dp3.dao.UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioDAO dao) {
		usuarioDAO = dao;
	}

	@Transactional(readOnly=true)
	@Override
	public Usuario loadUserByUsername(final String username) throws UsernameNotFoundException {
		Usuario user = usuarioDAO.retrieve(username);
		return user;
	}
	
	@Transactional
	@Override
	public Usuario modificarUsuario(Usuario usuario, UsuarioDTO dto) throws UsuarioException {
		Usuario usuarioContexto = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!usuarioContexto.getUsername().equals(String.valueOf(dto.getUf()))) {
			throw new UsuarioException("Usuario de contexto modificado.");
		}
		
//		if (!usuario.getEmail().equals(dto.getEmail())) {
//			usuario.setEmail(dto.getEmail());
//		}
//		if (!usuario.getNombre().equals(dto.getEmail2())) {
//			usuario.setEmail2(dto.getEmail2());
//		}
//		if (dto.getPassword() != "" && dto.getPassword() != null && !usuario.getPassword().equals(dto.getPassword())) {
//			usuario.setPassword(dto.getPassword());
//		}
		return usuarioDAO.update(usuario);
	}
}
