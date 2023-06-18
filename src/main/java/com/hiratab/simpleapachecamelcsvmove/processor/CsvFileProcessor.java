package com.hiratab.simpleapachecamelcsvmove.processor;

import com.hiratab.simpleapachecamelcsvmove.entities.NameAddress;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvFileProcessor implements Processor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void process(Exchange exchange) throws Exception {
        NameAddress nameAddress = exchange.getIn().getBody(NameAddress.class);
        logger.info("File Data: {}", nameAddress);
    }

}
