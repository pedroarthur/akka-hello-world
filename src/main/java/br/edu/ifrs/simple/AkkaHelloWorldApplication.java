package br.edu.ifrs.simple;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import br.edu.ifrs.simple.actors.HaltingActor;
import br.edu.ifrs.simple.actors.HelloWorldActor;
import br.edu.ifrs.simple.messages.HelloWorldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AkkaHelloWorldApplication implements CommandLineRunner {

  @Autowired private ActorSystem actorSystem;

  @Override
  public void run(String ... args) {
    ActorRef helloWorldActor = actorSystem.actorOf(Props.create(HelloWorldActor.class));

    helloWorldActor.tell(new HelloWorldMessage(),
        actorSystem.actorOf(Props.create(HaltingActor.class)));
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(AkkaHelloWorldApplication.class, args);
  }
}
