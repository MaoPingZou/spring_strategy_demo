package com.example.spring_strategy_demo.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略工厂类：实现 ApplicationContextAware ，重写 setApplicationContext 方法，为策略 map 赋值
 *
 * @author MaoPing Zou
 */
@Component
public class StrategyFactory2 implements ApplicationContextAware {

    /**
     * key为策略实现类组件名称，value为对应策略实现类
     */
    private final Map<String, IStrategy> strategyMap = new ConcurrentHashMap<>();

    /**
     * 重写 setApplicationContext 方法
     *
     * @param applicationContext 容器上下文对象
     * @throws BeansException bean 获取异常
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 通过 applicationContext 获取所有 ManualDockStrategy 的实现类
        Map<String, IStrategy> beansMap = applicationContext.getBeansOfType(IStrategy.class);
        // 清除
        this.strategyMap.clear();
        // 往 strategyMap 填充
        this.strategyMap.putAll(beansMap);
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
