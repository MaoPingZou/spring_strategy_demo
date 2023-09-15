package com.example.spring_strategy_demo.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略工厂类：使用 @Autowired 注入所有实现了策略接口的策略实现类
 *
 * @author MaoPing Zou
 */
@Component
public class StrategyFactory1 {
    /**
     * key为策略实现类组件名称，value为对应策略实现类
     */
    private final Map<String, IStrategy> strategyMap = new ConcurrentHashMap<>();

    /**
     * 使用 @Autowired 注入所有实现了IStrategy接口的Bean
     *
     * @param strategyMap 所有实现了 IStrategy 的策略实现类组成的Map
     */
    @Autowired
    public void setStrategyContextMap(Map<String, IStrategy> strategyMap) {
        // 清除Map
        this.strategyMap.clear();
        // 往策略Map中set容器中
        this.strategyMap.putAll(strategyMap);
    }

    /**
     * 根据组件名称获取对应策略实现类
     *
     * @param componentName 组件名称
     * @return 策略实现类
     */
    public IStrategy getStrategy(String componentName) {
        IStrategy iStrategy = strategyMap.get(componentName);
        if (iStrategy == null) {
            throw new RuntimeException("No strategy defined!");
        }
        return iStrategy;
    }
}
