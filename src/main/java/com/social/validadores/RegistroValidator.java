/**
 * 
 */
package com.social.validadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.social.entidades.Usuario;
import com.social.servicios.UsuarioService;

/**
 * <h1>Registro Validator</h1>
 * 
 * @author Antonio Paya Gonzalez
 * @author Pablo Diaz Rancaño
 *
 */
@Component
public class RegistroValidator implements Validator{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public boolean supports(Class<?> arg0) {
		return Usuario.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Error.usernameVacio");
		
		if(usuario.getUsername().length() < 4 || usuario.getUsername().length() > 24 )
			errors.rejectValue("username", "Error.usernameLength");
		if (usuarioService.getUserByUsername(usuario.getUsername()) != null) 
			errors.rejectValue("username", "Error.usernameExists");
		if (usuarioService.getUserByEmail(usuario.getEmail()) != null) 
			errors.rejectValue("username", "Error.emailExists");
		if (usuario.getPassword().length() < 5 || usuario.getPassword().length() > 24) {
			errors.rejectValue("password", "Error.passLength");
		}
		if (!usuario.getPasswordConfirm().equals(usuario.getPassword())) {
			errors.rejectValue("passwordConfirm", "Error.passNoCoincide");
		}
		
	}

	

}
