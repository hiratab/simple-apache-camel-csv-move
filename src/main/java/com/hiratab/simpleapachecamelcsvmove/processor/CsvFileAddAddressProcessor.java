package com.hiratab.simpleapachecamelcsvmove.processor;

import com.hiratab.simpleapachecamelcsvmove.entities.NameAddress;
import com.hiratab.simpleapachecamelcsvmove.entities.NameFullAddress;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CsvFileAddAddressProcessor implements Processor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void process(Exchange exchange) throws Exception {
        List<NameAddress> nameAddresses = exchange.getIn().getBody(List.class);
        logger.info("File Data: {}", nameAddresses);

        List<NameFullAddress> nameFullAddresses = new ArrayList<>();
        nameAddresses.forEach(nameAddress -> {
            nameFullAddresses.add(new NameFullAddress(
                nameAddress.getName(),
                nameAddress.getHouseNumber(),
                nameAddress.getCity(),
                nameAddress.getProvince(),
                nameAddress.getPostalCode(),
                returnOutboundAddress(nameAddress)
            ));
        });
        logger.info("Setting body to: {}", nameFullAddresses);
        exchange.getIn().setBody(nameFullAddresses);
    }

    private String returnOutboundAddress(NameAddress nameAddress) {

        return nameAddress.getHouseNumber() +
            " " +
            nameAddress.getCity() +
            " " +
            nameAddress.getProvince() +
            " " +
            nameAddress.getPostalCode();
    }

}
