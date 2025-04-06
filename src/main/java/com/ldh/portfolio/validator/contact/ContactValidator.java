package com.ldh.portfolio.validator.contact;

import com.ldh.portfolio.dto.contact.ContactRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ContactValidator {

    public void validate(ContactRequestDTO dto) {
        if (dto.getMessage().length() > 2000) {
            throw new IllegalArgumentException("The message must be less than 2000 length.");
        }
    }
}
