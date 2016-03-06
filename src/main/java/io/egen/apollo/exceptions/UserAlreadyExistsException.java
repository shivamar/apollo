package io.egen.apollo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="User already exists")
public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 3932906165189258949L;
}
