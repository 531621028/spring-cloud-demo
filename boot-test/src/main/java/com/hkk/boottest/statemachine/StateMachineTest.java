package com.hkk.boottest.statemachine;

/**
 * @author kang
 * @since 2020/12/17
 */
public class StateMachineTest {

    public static void main(String[] args) {
        ArticleStatusMachine machine = new ArticleStatusMachine();
        machine.transfer(ArticleState.AUDITING, ArticleEvent.PASS);
    }

}
