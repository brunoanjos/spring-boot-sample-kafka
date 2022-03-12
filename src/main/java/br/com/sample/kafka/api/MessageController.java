package br.com.sample.kafka.api;

import br.com.sample.kafka.producer.Producer;
import br.com.sample.kafka.domain.SampleMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sample_kafka/v1")
@ControllerAdvice
public class MessageController {

    @Autowired
    private Producer producer;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity incluirTipoAcessoCanalAtendimento(@RequestBody SampleMessage message) throws JsonProcessingException {
        producer.send(message);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
