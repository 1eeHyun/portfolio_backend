package com.ldh.portfolio.service.contact;

import com.ldh.portfolio.domain.contact.ContactMessage;
import com.ldh.portfolio.dto.contact.ContactRequestDTO;
import com.ldh.portfolio.repository.contact.ContactMessageRepository;
import com.ldh.portfolio.validator.contact.ContactValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactMessageRepository contactRepository;
    private final ContactValidator contactValidator;

    @Override
    public void submit(ContactRequestDTO dto) {

        contactValidator.validate(dto);
        ContactMessage message = ContactMessage.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .message(dto.getMessage())
                .build();
        contactRepository.save(message);
    }
}
