package com.hkk.boottest.statemachine;

import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kang
 * @since 2020/12/17
 */
@Getter
@AllArgsConstructor
public abstract class StateMachineTransaction<State, Event, Target> {
    private final State currentState;
    private final State nextState;
    private final Event event;
    private final Consumer<Target> action;
}
