package br.edu.ifrs.simple.actors;

import akka.actor.UntypedActor;
import br.edu.ifrs.simple.messages.HaltMessage;
import br.edu.ifrs.simple.messages.HelloWorldMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldActor extends UntypedActor {
    private final Logger LOGGER = LoggerFactory.getLogger(HelloWorldActor.class);

    @Override
    public void onReceive(Object rawMessage) throws Exception {
        if (!(rawMessage instanceof HelloWorldMessage)) {
            throw new IllegalArgumentException("someone sent me an invalid message!");
        }

        LOGGER.info("hello world!");

        this.getSender().tell(new HaltMessage(), this.getSender());
    }

}
