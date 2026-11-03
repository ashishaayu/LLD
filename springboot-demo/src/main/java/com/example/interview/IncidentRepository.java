package com.example.interview;


import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class IncidentRepository {

    private final Map<String, Incident> incidents = new ConcurrentHashMap<>();

    private final Map<String, String> dedupeIndex = new ConcurrentHashMap<>();

    public synchronized  Incident saveIfAbsent(Incident incident) {

        String key = incident.serviceId() + ":" + incident.dedupeKey();
        String existingId = dedupeIndex.get(key);

        if(existingId != null) {
            return incidents.get(existingId);
        }

        incidents.put(incident.incidentId(), incident);
        dedupeIndex.put(key, incident.incidentId());

        return   incident;
    }

    public synchronized List<Incident> findAll(IncidentStatus status) {
        return incidents.values().stream()
                .filter(i->status == null || i.status() == status)
                .sorted(Comparator.comparing(Incident::createdAt).reversed())
                .toList();
    }

}
