package com.example.borrow_books.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class MainAspect {
    private long requestsToServer = 0;
    @Pointcut("within(com.example.borrow_books.controller.*)")
    public void countRequestsToServer() {
    }

    @Before("countRequestsToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.requestsToServer++;
        System.out.println("The request of requests to server: " + this.requestsToServer);
    }
}
