package com.dp3.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dp3.domain.Usuario;
import com.dp3.exceptions.UsuarioException;
import com.dp3.web.dto.UsuarioDTO;

public interface UsuarioService extends UserDetailsService {
	
	public Usuario modificarUsuario(Usuario usuario, UsuarioDTO dto) throws UsuarioException;


}
