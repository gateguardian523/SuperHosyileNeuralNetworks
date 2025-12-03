package cn.qiuye.shnn.api;

import lombok.Getter;

@Getter
public enum Version {

    V5("v5", 32),
    V6("v6", 64),
    V7("v7", 128),
    VMAX("vmax", 256);

    final String id;
    final int multiplier;

    Version(String id, int multiplier) {
        this.id = id;
        this.multiplier = multiplier;
    }

    public static Version getVersion(String version) {
        return switch (version.toLowerCase()) {
            case "c6" -> V6;
            case "v7" -> V7;
            case "vmax" -> VMAX;
            default -> V5;
        };
    }
}
