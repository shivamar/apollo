package io.egen.apollo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Movie already exists")
public class MovieAlreadyExistsException extends Throwable{

}
