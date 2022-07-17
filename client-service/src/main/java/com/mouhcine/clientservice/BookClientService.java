package com.mouhcine.clientservice;

import com.google.protobuf.Descriptors;
import com.mouhcine.Book;
import com.mouhcine.BookRequest;
import com.mouhcine.BookServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookClientService {

    @GrpcClient("grpc-book-service")
    BookServiceGrpc.BookServiceBlockingStub syncClient;

    public Map<Descriptors.FieldDescriptor, Object> getBook(Long id){
        BookRequest request = BookRequest.newBuilder()
                .setId(id)
                .build();
        Map<Descriptors.FieldDescriptor, Object> fields = syncClient.getBook(request).getAllFields();
        return fields;
    }
}
