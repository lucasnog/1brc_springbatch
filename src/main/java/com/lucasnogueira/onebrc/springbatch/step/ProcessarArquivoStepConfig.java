package com.lucasnogueira.onebrc.springbatch.step;

import com.lucasnogueira.onebrc.springbatch.impl.Calculo;
import com.lucasnogueira.onebrc.springbatch.impl.ConteudoLinha;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import java.util.Map;


@Configuration
public class ProcessarArquivoStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step processarArquivoStep(FlatFileItemReader<ConteudoLinha> leituraArquivoTxt,
                                     ItemProcessor<ConteudoLinha, Map.Entry<String, Calculo>> processCalculoMedia,
                                     ItemWriter<Map.Entry<String, Calculo>> imprimeWriter) {
        return stepBuilderFactory
                .get("processarArquivoStep")
                .<ConteudoLinha, Map.Entry<String, Calculo>>chunk(10000)
                .reader(leituraArquivoTxt)
                .processor(processCalculoMedia)
                .writer(imprimeWriter)
                .taskExecutor(taskExecutor())
                .build();

    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("Chunk nº: ");
    }

}

