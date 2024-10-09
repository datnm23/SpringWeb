package org.example.springweb04.rest;

import lombok.AllArgsConstructor;
import org.example.springweb04.model.request.ReaderCreationRequest;
import org.example.springweb04.model.request.ReaderUpdateRequest;
import org.example.springweb04.model.response.ReaderResponse;
import org.example.springweb04.service.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/readers")
public class ReaderResource {

    ReaderService readerService;
    @GetMapping
    public List<ReaderResponse> getReaders() {
        return readerService.getAll();
    }

    @GetMapping("/{id}")
    public ReaderResponse getReader(@PathVariable Integer id) {
        return readerService.getDetail(id);
    }

    @PostMapping
    public ReaderResponse createReader(@RequestBody ReaderCreationRequest readerCreationRequest) {
        return readerService.createReader(readerCreationRequest);
    }

    @PutMapping("/{id}")
    public ReaderResponse updateReader(@PathVariable Integer id, @RequestBody ReaderUpdateRequest readerUpdateRequest) {
        return readerService.updateReader(id,readerUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable Integer id) {
        readerService.deleteReader(id);
    }

}
