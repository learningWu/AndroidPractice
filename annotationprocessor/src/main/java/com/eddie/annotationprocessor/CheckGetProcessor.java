package com.eddie.annotationprocessor;

import com.google.auto.service.AutoService;

import java.lang.reflect.Method;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;


@AutoService(CheckGetAnnoation.class)
@SupportedAnnotationTypes("CheckGetAnnoation")
public class CheckGetProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement annotaredClass : ElementFilter.typesIn(roundEnvironment.getElementsAnnotatedWith(CheckGetAnnoation.class))) {
            for (VariableElement field:ElementFilter.fieldsIn(annotaredClass.getEnclosedElements())){
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,"注解："+field.getSimpleName());
                if (!containsGetter(annotaredClass,field.getSimpleName().toString())){
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,String.format("getter not found for '%s.%s'",annotaredClass.getSimpleName(),field.getSimpleName()));
                }
            }
        }
        return false;
    }

    private boolean containsGetter(TypeElement annotaredClass, String field) {

        return false;
    }


}
