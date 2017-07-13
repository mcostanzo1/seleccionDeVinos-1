package com.depetris.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.depetris.domain.Usuario;
import com.depetris.exceptions.UsuarioException;
import com.depetris.web.dto.UsuarioDTO;

public interface UsuarioService extends UserDetailsService {
	
	public Usuario modificarUsuario(Usuario usuario, UsuarioDTO dto) throws UsuarioException;


}
