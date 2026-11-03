package com.example.interview;


import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@
@Service
public class AlertService {

    private final IncidentRepository repository;
    private final NotificationService notificationService;


    public AlertService(IncidentRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public Incident createAlert(AlterRequest request) {

        Incident incident = new Incident(
                "inc-"+ UUID.randomUUID(),
                request.serviceId(),
                request.severity(),
                request.title(),
                request.description(),
                request.dedupekey(),
                Instant.now(),
                IncidentStatus.TRIGGERED,
                null
        );

        Incident saved = repository.saveIfAbsent(incident);

        // duplicae alert then return the existing
        if(!saved.incidentId().equals(incident.incidentId())) {
            return  saved;
        }

        Notification notification = notificationService.notify(saved);

        Incident status = notification.status() ==
                NotificationStatus.SENT ? IncidentStatus.NOTIFIED
                :IncidentStatus.TRIGGERED;
    }
}
