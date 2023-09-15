package com.example.spring_strategy_demo.strategy_demo_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略工厂类
 *
 * @author MaoPing Zou
 */
@Component
public class StrategyFactory {
    /**
     * key为策略实现类组件名称，value为对应策略实现类
     */
//    private final Map<String, IStrategy> strategyMap = new ConcurrentHashMap<>();
//
//    /**
//     * 注入所有实现了IStrategy接口的Bean
//     *
//     * @param strategyMap
//     */
//    @Autowired
//    public void setStrategyContextMap(Map<String, IStrategy> strategyMap) {
//        // 清除Map中的所有映射
//        this.strategyMap.clear();
//        // 往策略Map中set容器中
//        this.strategyMap.putAll(strategyMap);
//    }

    @Autowired
    private Map<String, IStrategy> map;

    /**
     * 根据组件名称获取对应策略实现类
     *
     * @param componentName 组件名称
     * @return 策略实现类
     */
    public IStrategy getStrategy(String componentName) {
        IStrategy iStrategy = map.get(componentName);
        if (iStrategy == null) {
            throw new RuntimeException("no strategy defined!");
        }
        return iStrategy;
    }

}
