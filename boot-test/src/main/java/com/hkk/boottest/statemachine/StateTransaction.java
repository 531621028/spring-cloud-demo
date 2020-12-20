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
    private final State currentState;
    private final State nextState;
    private final Event event;
}
