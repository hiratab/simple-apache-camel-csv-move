package com.hiratab.simpleapachecamelcsvmove.components;

import com.hiratab.simpleapachecamelcsvmove.entities.NameAddress;
import com.hiratab.simpleapachecamelcsvmove.processor.CsvFileProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CsvFileRoute extends RouteBuilder {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final BindyCsvDataFormat bindyDataFormat = new BindyCsvDataFormat(NameAddress.class);

    @Override
    public void configure() throws Exception {
        from("file:data/input?fileName=inputFile.csv")
            .routeId("csvFileRouteId")
            .split(body().tokenize("\n", 1, false))
            .unmarshal(bindyDataFormat)
            .process(new CsvFileProcessor())
            .marshal(bindyDataFormat)
            .to("file:data/output?fileName=output.csv&fileExist=append");
    }

}
