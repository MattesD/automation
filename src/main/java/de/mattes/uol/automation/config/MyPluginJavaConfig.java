package de.mattes.uol.automation.config;

import com.atlassian.templaterenderer.TemplateRenderer;
import com.opencsv.CSVReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.atlassian.plugins.osgi.javaconfig.OsgiServices.importOsgiService;

@Configuration
public class MyPluginJavaConfig {

    // imports ApplicationProperties from OSGi

    @Bean
    public TemplateRenderer templateRenderer() {
        return importOsgiService(TemplateRenderer.class);
    }

    @Bean
    public CSVReader csvReader() {
        return importOsgiService(CSVReader.class);
    }

}