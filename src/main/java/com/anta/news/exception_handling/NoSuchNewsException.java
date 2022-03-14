package com.anta.news.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "News Not_Found")
public class NoSuchNewsException extends RuntimeException{
}
