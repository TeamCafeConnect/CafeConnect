package com.yash.cafeconnect.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private Long transactionId;


    @Column(name = "user_id",nullable = false, length = 50)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "time_stamp", nullable = false)
    private LocalDateTime timeStamp;

    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", length = 20, nullable = false)
    private TransactionStatus transactionStatus;

    public enum TransactionStatus {
        SUCCESS, PENDING, REFUNDED, FAILED
    }




}
