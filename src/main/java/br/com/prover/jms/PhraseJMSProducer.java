package br.com.prover.jms;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@ApplicationScoped
public class PhraseJMSProducer {

    @Resource(lookup = "java:/JmsXA")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/queue/FraseQueue")
    private Queue queue;

    private JMSContext context;

    @PostConstruct
    public void init() {
        context = connectionFactory.createContext();
    }

    public void send(String message) {
        context.createProducer().send(queue, message);
    }
}
