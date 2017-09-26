package com.dp3.web.dto;

import com.dp3.domain.Usuario;

public class UsuarioTranslator {
	public static UsuarioDTO getUsuarioDTO(Usuario user) {
		return new UsuarioDTO(Integer.valueOf(user.getUsername()), user.getNombre(), user.getPassword());
	}
}
