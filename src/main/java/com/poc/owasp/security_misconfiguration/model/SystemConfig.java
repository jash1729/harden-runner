package com.poc.owasp.security_misconfiguration.model;

public class SystemConfig {

    private String activeProfile;
    private String databaseUrl;
    private String javaVersion;

    public SystemConfig(String activeProfile, String databaseUrl, String javaVersion) {
        this.activeProfile = activeProfile;
        this.databaseUrl = databaseUrl;
        this.javaVersion = javaVersion;
    }

    public String getActiveProfile() {
        return activeProfile;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getJavaVersion() {
        return javaVersion;
    }
}