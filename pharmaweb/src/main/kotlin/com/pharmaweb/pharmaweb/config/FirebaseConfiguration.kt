package com.pharmaweb.pharmaweb.config

import com.google.firebase.FirebaseApp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseOptions

@Configuration
@ComponentScan
class FirebaseConfiguration {

    @Autowired
    lateinit private var resourceLoader: ResourceLoader

    @Bean
    fun firebaseBuilderApp(): FirebaseApp {

        val resource: Resource = resourceLoader.getResource("classpath:pharmaweb-firebase.json");

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(resource.inputStream))
                .setDatabaseUrl("https://pharmaweb-35ccb.firebaseio.com")
                .build()

        return FirebaseApp.initializeApp(options)

    }

}