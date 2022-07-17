package com.mouhcine.bookservice.domain;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class BookServiceAdvice {

    @GrpcExceptionHandler
    public Status handle(Exception e){
        return Status.INTERNAL.withDescription(e.getMessage());
    }
}
