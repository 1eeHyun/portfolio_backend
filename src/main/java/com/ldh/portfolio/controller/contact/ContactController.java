package com.ldh.portfolio.controller.contact;

import com.ldh.portfolio.dto.contact.ContactRequestDTO;
import com.ldh.portfolio.service.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/contacts")
public class ContactController implements ContactApiDocs {

    private final ContactService contactService;

    @Override
    public ResponseEntity<Void> submitMessage(ContactRequestDTO dto) {
        contactService.submit(dto);
        return ResponseEntity.ok().build();
    }
}
