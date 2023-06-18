package com.hiratab.simpleapachecamelcsvmove.components;

import com.hiratab.simpleapachecamelcsvmove.entities.NameAddress;
import com.hiratab.simpleapachecamelcsvmove.entities.NameFullAddress;
import com.hiratab.simpleapachecamelcsvmove.processor.CsvFileAddAddressProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CsvFileAddAddressRoute extends RouteBuilder {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final BindyCsvDataFormat inBindyCsvDataFormat = new BindyCsvDataFormat(NameAddress.class);

    private final BindyCsvDataFormat outBindyCsvDataFormat = new BindyCsvDataFormat(NameFullAddress.class);

    @Override
    public void configure() throws Exception {
        from("file:data/input?fileName=inputFileConcatenateAddress.csv")
            .routeId("csvFileAddAddressRouteId")
            .split(body().tokenize("\n", 1, true))
            .unmarshal(inBindyCsvDataFormat)
            .process(new CsvFileAddAddressProcessor())
            .marshal(outBindyCsvDataFormat)
            .log(LoggingLevel.INFO, "Transformed Body: ${body}")
            .to("file:data/output?fileName=outputFileConcatenateAddress.csv&fileExist=append");
    }

}
