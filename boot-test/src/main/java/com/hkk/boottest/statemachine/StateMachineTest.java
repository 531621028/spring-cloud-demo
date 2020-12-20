package com.hkk.boottest.statemachine;

/**
 * @author kang
 * @since 2020/12/17
 */
public class StateMachineTest {

    private static final String TEMPLATE = "currentState is %s, event is %s, nextState is %s";

    public static void main(String[] args) {
        ArticleStatusMachine machine = new ArticleStatusMachine();
        System.out.println(String.format(TEMPLATE, ArticleState.DRAFT, ArticleEvent.SUBMIT,
            machine.nextState(ArticleState.DRAFT, ArticleEvent.SUBMIT).orElse(null))
        );
        System.out.println(String.format(TEMPLATE, ArticleState.AUDITING, ArticleEvent.REJECT,
            machine.nextState(ArticleState.AUDITING, ArticleEvent.REJECT).orElse(null))
        );
        System.out.println(String.format(TEMPLATE, ArticleState.AUDITING, ArticleEvent.PASS,
            machine.nextState(ArticleState.AUDITING, ArticleEvent.PASS).orElse(null))
        );
        System.out.println(String.format(TEMPLATE, ArticleState.DRAFT, ArticleEvent.PASS,
            machine.nextState(ArticleState.DRAFT, ArticleEvent.PASS).orElse(null))
        );
    }
}
