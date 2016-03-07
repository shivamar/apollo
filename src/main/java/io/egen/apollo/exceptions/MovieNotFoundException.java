package io.egen.apollo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Movie not fouhd")
public class MovieNotFoundException extends Throwable {
	private static final long serialVersionUID = -4733254241093928787L;

}
