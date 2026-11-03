package com.example.interview;

public record Notification(
        String channel,
        NotificationStatus status,
        String providerCallId,
        String lastError) {
}