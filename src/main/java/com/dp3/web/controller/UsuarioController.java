package com.dp3.web.controller;

import com.dp3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
//	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);

    @Autowired
    UserService userDetailsService;
	
//	@RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
//	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable("idUser") Integer id) {
//		LOGGER.debug("Recuperamos el usuario por ID: " + id);
//		User user = (User) usuarioService.loadUserByUsername(String.valueOf(id));
//		return new ResponseEntity<UsuarioDTO>(UsuarioTranslator.getUsuarioDTO(user), HttpStatus.OK);
//	}
	
//	@RequestMapping(path="/modificar", method=RequestMethod.POST, consumes="application/json")
//	@ResponseBody
//	public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO dto) throws UsuarioException {
//		User esteUsuario = (User) usuarioService.loadUserByUsername(String.valueOf(dto.getUf()));
//		User usuario = usuarioService.modificarUsuario(esteUsuario, dto);
//		return new ResponseEntity<UsuarioDTO>(UsuarioTranslator.getUsuarioDTO(usuario), HttpStatus.ACCEPTED);
//	}
}
