package com.ldh.portfolio.controller.contact;

import com.ldh.portfolio.controller.ApiBase;
import com.ldh.portfolio.dto.contact.ContactRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Contact API", description = "Contact related API")
public interface ContactApiDocs extends ApiBase {

    @Operation(summary = "Submits a message", description = "Submits a message.")
    ResponseEntity<Void> submitMessage(ContactRequestDTO dto);
}
