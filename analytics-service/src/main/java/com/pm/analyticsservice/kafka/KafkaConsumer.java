package com.pm.analyticsservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="patient", groupId = "analytics-service") // group id is consumer group id
    public void consumeEvent(byte[] event){
        try{
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
//            Perform any business logic here or call service layer
            log.info("Received patient event : [id = {}, name={}, email = {}]",
                    patientEvent.getPatientId(),
                    patientEvent.getPatientName(),
                    patientEvent.getPatientEmail());

        }catch (Exception e){
            log.error("Unable to parse Kafka event in analytic service {}", e.getMessage());
        }
    }
}
