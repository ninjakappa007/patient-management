package com.pm.billingservice.grpc;

import billing.BillingResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
                                     StreamObserver<billing.BillingResponse> responseObserver){

        log.info("creteBillingAccount request received {}", billingRequest.toString());

        // Business logic - e.g. save to db, perform some calculation or something
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("9876")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response); // send response to client
//        we can send multiple response to client in a single connection and then close it
//        responseObserver.onNext(response); // send response to client
//        responseObserver.onNext(response); // send response to client
//        responseObserver.onNext(response); // send response to client
//        responseObserver.onNext(response); // send response to client

        responseObserver.onCompleted(); // close the connection

    }
}
