package co.edu.eam.sistemasdistribuidos.sgc.request.controllers;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import co.edu.eam.sistemasdistribuidos.sgc.request.services.BorrowRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrow/request")
public class BorrowRequestController {

    @Autowired
    private BorrowRequestService borrowRequestService;

    @PostMapping
    public long create(@RequestBody BorrowRequest borrowRequest) throws Exception{
        borrowRequestService.studyBorrow(borrowRequest);
        return borrowRequest.getId();
    }
}
