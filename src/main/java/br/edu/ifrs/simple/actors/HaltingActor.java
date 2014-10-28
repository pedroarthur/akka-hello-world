package br.edu.ifrs.simple.actors;

import akka.actor.UntypedActor;
import br.edu.ifrs.simple.messages.HaltMessage;

public class HaltingActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if (!(o instanceof HaltMessage)) {
            throw new IllegalArgumentException("got a message I'm not aware of");
        }

        this.context().system().shutdown();
    }
}
