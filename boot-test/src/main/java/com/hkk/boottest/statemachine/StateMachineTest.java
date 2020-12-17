package com.hkk.boottest.statemachine;

import java.util.Optional;

/**
 * @author kang
 * @since 2020/12/17
 */
public class StateMachineTest {

    public static void main(String[] args) {
        ApkStatusMachine machine = new ApkStatusMachine();
        Optional<StateTransaction<ApkState, ApkEvent, Apk>> optional = machine
            .transfer(ApkState.AUDITING, ApkEvent.PASS, new Apk());
        optional.ifPresent(System.out::println);
    }

}
