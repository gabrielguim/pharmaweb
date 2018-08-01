package com.pharmaweb.pharmaweb.config

import com.google.firebase.FirebaseApp
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseOptions
import org.slf4j.LoggerFactory
import org.springframework.core.io.ClassPathResource

@Configuration
@ComponentScan
class FirebaseConfiguration {

    @Bean
    fun firebaseBuilderApp(): FirebaseApp {

        val logger = LoggerFactory.getLogger(FirebaseConfiguration::class.java)

        val resource: Resource = ClassPathResource("/pharmaweb-firebase-key.json");

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(resource.inputStream))
                .setDatabaseUrl("https://pharmaweb-35ccb.firebaseio.com")
                .build()

        logger.info("INIT FIREBASE WITH URL = " + options.databaseUrl)

        return FirebaseApp.initializeApp(options)

    }

}
