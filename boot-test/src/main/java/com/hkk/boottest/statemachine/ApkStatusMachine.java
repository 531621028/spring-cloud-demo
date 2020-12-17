package com.hkk.boottest.statemachine;

import static com.hkk.boottest.statemachine.ApkEvent.PASS;
import static com.hkk.boottest.statemachine.ApkEvent.REJECT;
import static com.hkk.boottest.statemachine.ApkEvent.SUBMIT;
import static com.hkk.boottest.statemachine.ApkState.AUDITING;
import static com.hkk.boottest.statemachine.ApkState.DRAFT;
import static com.hkk.boottest.statemachine.ApkState.FAILED;
import static com.hkk.boottest.statemachine.ApkState.SUCCESS;

import com.google.common.collect.Sets;
import java.util.Optional;
import java.util.Set;

/**
 * @author kang
 * @since 2020/12/17
 */
public class ApkStatusMachine implements StateMachine<ApkState, ApkEvent, Apk> {

    private static final Set<StateTransaction<ApkState, ApkEvent, Apk>> transactions = Sets.newHashSet(
        new StateTransaction<>(DRAFT, AUDITING, SUBMIT, System.out::println),
        new StateTransaction<>(AUDITING, SUCCESS, PASS, System.out::println),
        new StateTransaction<>(AUDITING, FAILED, REJECT, System.out::println)
    );

    @Override
    public Optional<StateTransaction<ApkState, ApkEvent, Apk>> transfer(ApkState apkState,
        ApkEvent apkEvent, Apk apk) {
        return transactions.stream().filter(t ->
            t.getCurrentState().equals(apkState) && t.getEvent().equals(apkEvent)).findAny();
    }
}
