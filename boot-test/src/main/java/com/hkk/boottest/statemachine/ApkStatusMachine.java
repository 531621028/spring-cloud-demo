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

    private static final Set<ApkStateMachineTransaction> transactions;

    static {
        transactions = Sets.newHashSet(
            new ApkStateMachineTransaction(DRAFT, AUDITING, SUBMIT, System.out::println),
            new ApkStateMachineTransaction(AUDITING, SUCCESS, PASS, System.out::println),
            new ApkStateMachineTransaction(AUDITING, FAILED, REJECT, System.out::println)
        );
    }

    @Override
    public Optional<ApkState> transfer(ApkState apkState, ApkEvent apkEvent, Apk apk) {
        Optional<ApkStateMachineTransaction> transactionOptional = transactions.stream().filter(t ->
            t.getCurrentState().equals(apkState) && t.getEvent().equals(apkEvent)).findAny();
        if (transactionOptional.isPresent()) {
            transactionOptional.get().getAction().accept(apk);
            return Optional.of(transactionOptional.get().getNextState());
        }
        return Optional.empty();
    }
}
