package com.hkk.boottest.statemachine;

import java.util.Optional;

/**
 * @author kang
 * @since 2020/12/17o
 */
public interface StateMachine<State, Event> {

    /**
     * 根据当前状态判断返回下一个状态
     *
     * @param currentState 当前状态
     * @param event 事件类型
     * @return 下一个状态
     */
    Optional<State> nextState(State currentState, Event event);

}
