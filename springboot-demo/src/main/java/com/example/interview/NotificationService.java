package com.example.interview;


import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {


    private  final  ExotelClient exotelClient;

    public  final Map<String, String > onCallNumbers =
            Map.of("svc-payments","+919900112233",
                    "svc-checkout","+919900445566",
                    "svc-search","+919900778899"
            );

    public NotificationService(ExotelClient exotelClient) {
        this.exotelClient = exotelClient;
    }


    public Notification notify(Incident incident) {

        if(incident.severity() != Severity.CRITICAL) {

            return new Notification(
                    "PHONE",
                    NotificationStatus.SKIPPED,
                    null,
                    null);
        }

        String phoneNumber = onCallNumbers.get(incident.serviceId());

        if(phoneNumber == null) {
            return new Notification("PHONE",
                    NotificationStatus.FAILED,
                    null,
                    "No on-call number found");
        }

        try {
            var response = exotelClient.makeCall(phoneNumber,
                    "CRITICAL: "
                    +incident.title() +
                    incident.serviceId());


            if(response == null
                || response.callSid() == null
                || response.callSid().isBlank()) {

                return new Notification(
                        "PHONE",
                        NotificationStatus.FAILED,
                        null,
                        "Invalid Exotel response"
                );

            }

            return new Notification(
                    "PHONE",
                    NotificationStatus.SENT,
                    response.callSid(),
                    null
            );
        } catch (Exception e) {
            return new Notification(
                    "PHONE",
                    NotificationStatus.FAILED,
                    null,
                    e.getMessage()
            );
        }
    }
}
