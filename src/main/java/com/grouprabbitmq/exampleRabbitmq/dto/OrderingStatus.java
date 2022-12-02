package com.grouprabbitmq.exampleRabbitmq.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderingStatus {

    private Ordering ordering;
    private String status;
    private String message;

}
