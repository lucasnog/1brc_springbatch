package com.lucasnogueira.onebrc.springbatch.reader;

import com.lucasnogueira.onebrc.springbatch.impl.ConteudoLinha;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class LeituraArquivoConfig {
    @StepScope
    @Bean
    public FlatFileItemReader<ConteudoLinha> leituraArquivoTxt() {
        return new FlatFileItemReaderBuilder<ConteudoLinha>()
                .name("leituraArquivoTxtReader")
                .resource(new ClassPathResource("measurements.txt"))
                .delimited()
                .delimiter(";")
                .names( new String[] {"nomeCidade", "temperatura"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>(){{
                    setTargetType(ConteudoLinha.class);
                }})
                .build();
    }


}
