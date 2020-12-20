package com.hkk.boottest.statemachine;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kang
 * @since 2020/12/17
 */
@Getter
@AllArgsConstructor
public class StateTransaction<State, Event> {

    /**
     * 当前的状态
     */
    private final State currentState;
    /**
     * 当前发生事件
     */
    private final Event event;
    /**
     * 下一个状态
     */
    private final State nextState;

}
