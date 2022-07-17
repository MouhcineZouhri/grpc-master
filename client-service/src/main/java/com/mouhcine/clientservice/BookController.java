package com.mouhcine.clientservice;

import com.google.protobuf.Descriptors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookClientService bookClientService;

    @GetMapping("/{id}")
    public Map<Descriptors.FieldDescriptor, Object> book(@PathVariable Long id){
        return bookClientService.getBook(id);
    }

}
