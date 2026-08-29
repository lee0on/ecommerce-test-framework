package com.ecomauto.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;

public final class Config {

    private static final Path CONFIG_DIR = Path.of("config");
    private static final Config INSTANCE = new Config();

    private final Properties properties;

    private Config() {
        properties = load();
    }

    public static Config get() {
        return INSTANCE;
    }

    public String baseUrl() {
        return value("base.url");
    }

    public String browser() {
        return value("browser");
    }

    public boolean headless() {
        return Boolean.parseBoolean(value("headless"));
    }

    public Duration implicitWait() {
        return Duration.ofSeconds(Long.parseLong(value("implicit.wait.seconds")));
    }

    public Duration explicitWait() {
        return Duration.ofSeconds(Long.parseLong(value("explicit.wait.seconds")));
    }

    public Duration pageLoadTimeout() {
        return Duration.ofSeconds(Long.parseLong(value("page.load.timeout.seconds")));
    }

    private String value(String key) {
        String override = System.getProperty(key);
        return override != null ? override : properties.getProperty(key);
    }

    private Properties load() {
        Properties defaults = readProperties(CONFIG_DIR.resolve("config.properties"));

        String env = System.getProperty("env");
        if (env != null && !env.isBlank()) {
            Path envFile = CONFIG_DIR.resolve("config-" + env + ".properties");
            defaults.putAll(readProperties(envFile));
        }

        return defaults;
    }

    private Properties readProperties(Path path) {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(path)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load config file: " + path, e);
        }
        return props;
    }
}
