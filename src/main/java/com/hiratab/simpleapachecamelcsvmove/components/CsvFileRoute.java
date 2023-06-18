package com.hiratab.simpleapachecamelcsvmove.components;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CsvFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/input?fileName=inputFile.csv")
    }

}
