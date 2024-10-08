package com.future.spring.rocket.custom;

import com.future.spring.rocket.controller.ComponentScanUserController;
import com.future.spring.rocket.model.ComponentScanUserModel;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class OnlyOneFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        Class<?> currClass;
        try {
                currClass = Class.forName(metadataReader.getClassMetadata().getClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ComponentScanUserController.class.isAssignableFrom(currClass) || ComponentScanUserModel.class.isAssignableFrom(currClass);
    }
}
