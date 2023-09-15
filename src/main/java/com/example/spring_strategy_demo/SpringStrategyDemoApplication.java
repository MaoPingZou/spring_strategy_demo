package com.example.spring_strategy_demo;

import com.example.spring_strategy_demo.demo.IStrategy;
import com.example.spring_strategy_demo.demo.StrategyFactory1;
import com.example.spring_strategy_demo.demo.StrategyFactory2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author MaoPing Zou
 */
@SpringBootApplication
public class SpringStrategyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStrategyDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo1(StrategyFactory1 strategyFactory1) {
        return args -> {
            IStrategy a = strategyFactory1.getStrategy("策略A");
            a.strategyMethod();
            IStrategy b = strategyFactory1.getStrategy("策略B");
            b.strategyMethod();
        };
    }

    @Bean
    public CommandLineRunner demo2(StrategyFactory2 strategyFactory2) {
        return args -> {
            IStrategy a = strategyFactory2.getStrategy("策略A");
            a.strategyMethod();
            IStrategy b = strategyFactory2.getStrategy("策略B");
            b.strategyMethod();
        };
    }


}
