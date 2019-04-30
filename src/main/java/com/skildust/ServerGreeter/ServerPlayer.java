package com.skildust.ServerGreeter;

import java.util.UUID;

class ServerPlayer {
    private UUID uuid;
    private String name;
    private long lastPlayed;

    ServerPlayer(UUID uuid, String name, long lastPlayed) {
        this.uuid = uuid;
        this.name = name;
        this.lastPlayed = lastPlayed;
    }

    UUID getUuid() {
        return uuid;
    }

    String getName() {
        return name;
    }

    long getLastPlayed() {
        return lastPlayed;
    }

    void setLastPlayed(long lastPlayed) {
        this.lastPlayed = lastPlayed;
    }
}
