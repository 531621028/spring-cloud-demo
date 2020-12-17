package com.hkk.boottest.statemachine;

import java.util.function.Consumer;
import lombok.AllArgsConstructor;

/**
 * @author kang
 * @since 2020/12/17
 */
public class ApkStateMachineTransaction extends StateMachineTransaction<ApkState, ApkEvent, Apk> {

    public ApkStateMachineTransaction(ApkState currentState,
        ApkState nextState, ApkEvent apkEvent,
        Consumer<Apk> action) {
        super(currentState, nextState, apkEvent, action);
    }
}
