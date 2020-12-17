package com.hkk.boottest.statemachine;

import java.util.Optional;

/**
 * @author kang
 * @since 2020/12/17
 */
public class StateMachineTest {

    public static void main(String[] args) {
        ArticleStatusMachine machine = new ArticleStatusMachine();
        Optional<StateTransaction<ArticleState, ArticleEvent, Article>> optional = machine
            .transfer(ArticleState.AUDITING, ArticleEvent.PASS, new Article());
        optional.ifPresent(System.out::println);
    }

}
