package co.edu.eam.sistemasdistribuidos.sgc.request.controllers;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import co.edu.eam.sistemasdistribuidos.sgc.request.services.BorrowRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/borrows/request")
public class BorrowRequestController {

    @Autowired
    private BorrowRequestService borrowRequestService;

    @PostMapping
    public long create(@RequestBody BorrowRequest borrowRequest) throws Exception{
        borrowRequestService.studyBorrow(borrowRequest);
        return borrowRequest.getId();
    }
    @GetMapping("/{id}")
    public BorrowRequest find(@PathVariable("id") Long id){
        return borrowRequestService.find(id);
    }
}
