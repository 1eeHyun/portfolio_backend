package com.ldh.portfolio.controller.contact;

import com.ldh.portfolio.dto.contact.ContactRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Contact API", description = "Contact related API")
@RequestMapping("/api/contact")
public interface ContactApiDocs {

    @PostMapping
    @Operation(summary = "Submits a message", description = "Submits a message.")
    ResponseEntity<Void> submitMessage(ContactRequestDTO dto);
}
