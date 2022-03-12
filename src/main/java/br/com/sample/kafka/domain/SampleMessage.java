package br.com.sample.kafka.domain;

import lombok.Data;

@Data
public class SampleMessage {

    private Integer id;
    private String message;
    private String date;
}
