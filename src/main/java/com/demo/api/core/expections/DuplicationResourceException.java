package com.demo.api.core.expections;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class DuplicationResourceException extends RuntimeException {

    public DuplicationResourceException(String errorMessage) {
        super(errorMessage);
    }

    public DuplicationResourceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

}
