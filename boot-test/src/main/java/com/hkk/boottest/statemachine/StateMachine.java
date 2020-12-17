package com.hkk.boottest.statemachine;

import java.util.Optional;

/**
 * @author kang
 * @since 2020/12/17o
 */
public interface StateMachine<State, Event, Source> {

    Optional<StateTransaction<State, Event, Source>> transfer(State state, Event event);
}
