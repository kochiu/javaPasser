package com.kochiu.javaPasser.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by gaochao on 16/7/30.
 */
public class KafkaService {
    static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public void processMessage(Map<String, Map<Integer, String>> msgs) {
        System.out.print("Consumer Message received count :" + msgs.size());
        for (Map.Entry < String,Map<Integer, String>>entry:
                msgs.entrySet()){
            System.out.println("Consumer Message received: ");
            logger.debug("Suchit Topic:" + entry.getKey());
            for (String msg : entry.getValue().values()) {
                logger.info("Suchit Consumed Message: " + msg);
            }
        }
    }
}
