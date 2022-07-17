package com.mouhcine.bookservice.domain;

import com.mouhcine.Book;
import com.mouhcine.BookRequest;
import com.mouhcine.BookServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {

    private final  BookRepository bookRepository;
    @Override
    public void getBook(BookRequest request, StreamObserver<Book> responseObserver) {
        BookEntity bookEntity =  bookRepository.findById(request.getId())
                .orElse(null);

        if(bookEntity == null) {
            responseObserver.onError(new RuntimeException("Book Not Found"));
            return;
        }

        responseObserver.onNext(
                Book.newBuilder()
                        .setId(bookEntity.getId())
                        .setName(bookEntity.getName())
                        .setPage(bookEntity.getPage())
                        .build()
        );
        responseObserver.onCompleted();
    }
}
