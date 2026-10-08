package com.capaDatos;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JPAUtil {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {

            String host = System.getenv().getOrDefault("DB_HOST", "localhost");
            String port = System.getenv().getOrDefault("DB_PORT", "3306");
            String database = System.getenv().getOrDefault("DB_NAME", "capa_datos_jpa");
            String user = System.getenv().getOrDefault("DB_USER", "root");
            String password = System.getenv().getOrDefault("DB_PASSWORD", "");

            Map<String, Object> properties = new HashMap<>();

            properties.put(
                "jakarta.persistence.jdbc.url",
                "jdbc:mysql://" + host + ":" + port + "/" + database
                + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
            );

            properties.put("jakarta.persistence.jdbc.user", user);
            properties.put("jakarta.persistence.jdbc.password", password);

            emf = Persistence.createEntityManagerFactory(
                "CapaDatosPU",
                properties
            );
        }

        return emf;
    }
}
