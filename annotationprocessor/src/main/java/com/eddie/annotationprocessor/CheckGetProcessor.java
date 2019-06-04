package com.eddie.annotationprocessor;

import com.google.auto.service.AutoService;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;


@AutoService(Processor.class)

public class CheckGetProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement annotaredClass : ElementFilter.typesIn(roundEnvironment.getElementsAnnotatedWith(CheckGetAnnotation.class))) {
            //试一下打印的用法
//            processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,"annotation："+annotaredClass.getSimpleName());
//            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,"annotation："+annotaredClass.getSimpleName());
            for (VariableElement field : ElementFilter.fieldsIn(annotaredClass.getEnclosedElements())) {
                if (!containsGetter(annotaredClass, field.getSimpleName().toString())) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, String.format("getter not found for '%s.%s'", annotaredClass.getSimpleName(), field.getSimpleName()));
                }
            }
        }
        return false;
    }

    private boolean containsGetter(TypeElement typeElement, String name) {
        boolean result = false;
        String getter = "get" + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            if (!executableElement.getModifiers().contains(Modifier.STATIC)
                    && executableElement.getSimpleName().toString().equals(getter)
                    && executableElement.getParameters().isEmpty()) {
                result = true;
            }
        }

        return result;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        HashSet<String> supportTypes = new LinkedHashSet<>();
        supportTypes.add(CheckGetAnnotation.class.getCanonicalName());
        return supportTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }
}
