package br.edu.ifrs.simple;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AkkaConfiguration {
    @Bean public ActorSystem defaultActorSystem() {
        return ActorSystem.create("defaultActorSystem");
    }
}

