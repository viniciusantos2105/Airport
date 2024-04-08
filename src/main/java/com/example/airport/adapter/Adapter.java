package com.example.airport.adapter;

import com.example.airport.config.MapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Adapter {

    public static final ModelMapper mapper = new MapperConfig().modelMapper();

    public static  <Source, Target> Target mapSourceToTarget(Source source, Class<Target> targetClass) {
        return mapper.map(source, targetClass);
    }

    public static  <Type> Type updateTargetWithSource(Type source, Type target) {
        mapper.map(source, target);
        return target;
    }
}
