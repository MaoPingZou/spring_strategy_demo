package com.example.spring_strategy_demo.strategy_demo_1;

import org.springframework.stereotype.Component;

/**
 * 策略实现类A
 *
 * @author MaoPing Zou
 */
@Component("策略A1")
public class StrategyA implements IStrategy {
    @Override
    public void strategyMethod() {

        System.out.println("使用了策略实现A");

    }
}
