package com.dicelogics.rsqlservice.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private Integer price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "order_date")
    private Timestamp orderTs;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
