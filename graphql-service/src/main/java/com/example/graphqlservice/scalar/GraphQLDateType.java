package com.example.graphqlservice.scalar;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by scottmcallister on 2018-02-16.
 */
public class GraphQLDateType extends GraphQLScalarType {

    public GraphQLDateType() {

        super("Date", "Date", new Coercing<OffsetDateTime, String>() {

            DateTimeFormatter fmt = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

            @Override
            public String serialize(Object input) {
                if (input instanceof OffsetDateTime) {
                    return fmt.format((OffsetDateTime) input);
                } else {
                    return null;
                }
            }

            @Override
            public OffsetDateTime parseValue(Object input) {
                if (input instanceof String) {
                    return OffsetDateTime.from(fmt.parse((String) input));
                }
                return null;
            }

            @Override
            public OffsetDateTime parseLiteral(Object input) {
                if (input instanceof StringValue) {
                    return OffsetDateTime.from(fmt.parse(((StringValue) input).getValue()));
                }
                return null;
            }
        });
    }
}