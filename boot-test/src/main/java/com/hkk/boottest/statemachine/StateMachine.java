package com.hkk.boottest.statemachine;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author kang
 * @since 2020/12/17
 */
public interface StateMachine<State, Event, Target> {

    Optional<State> transfer(State state, Event event, Target target);
}
