package com.venitmarket.api.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Method Payment")
@Table(name = "TB_METHODSPAYMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MethodPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PaymentsTypes typesPayments;
}