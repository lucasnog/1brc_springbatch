package com.lucasnogueira.onebrc.springbatch.writer;

import com.lucasnogueira.onebrc.springbatch.impl.CalculoMap;
import com.lucasnogueira.onebrc.springbatch.impl.Calculo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class ImprimeWriterConfig {

    @Bean
    public ItemWriter<Map.Entry<String, Calculo>> imprimeWriter() {
        return items -> {
            System.out.println(Thread.currentThread().getName());
                 };
    }

}


