package com.example.interview;

import java.time.Instant;

public record Incident(

        String incidentId,
        String serviceId,
        Severity severity,
        String title,
        String description,
        String dedupeKey,
        IncidentStatus status,
        Instant createdAt,
        Notification notification

) {
}