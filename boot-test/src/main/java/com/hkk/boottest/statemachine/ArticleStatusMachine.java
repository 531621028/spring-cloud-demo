package com.hkk.boottest.statemachine;

import static com.hkk.boottest.statemachine.ArticleEvent.PASS;
import static com.hkk.boottest.statemachine.ArticleEvent.REJECT;
import static com.hkk.boottest.statemachine.ArticleEvent.SUBMIT;
import static com.hkk.boottest.statemachine.ArticleState.AUDITING;
import static com.hkk.boottest.statemachine.ArticleState.DRAFT;
import static com.hkk.boottest.statemachine.ArticleState.FAILED;
import static com.hkk.boottest.statemachine.ArticleState.SUCCESS;

import com.google.common.collect.Sets;
import java.util.Optional;
import java.util.Set;

/**
 * @author kang
 * @since 2020/12/17
 */
public class ArticleStatusMachine implements StateMachine<ArticleState, ArticleEvent, Article> {

    private static final Set<StateTransaction<ArticleState, ArticleEvent, Article>> transactions = Sets.newHashSet(
        new StateTransaction<>(DRAFT, AUDITING, SUBMIT, System.out::println),
        new StateTransaction<>(AUDITING, SUCCESS, PASS, System.out::println),
        new StateTransaction<>(AUDITING, FAILED, REJECT, System.out::println)
    );

    @Override
    public Optional<StateTransaction<ArticleState, ArticleEvent, Article>> transfer(
        ArticleState articleState,
        ArticleEvent articleEvent, Article article) {
        return transactions.stream().filter(t ->
            t.getCurrentState().equals(articleState) && t.getEvent().equals(articleEvent)).findAny();
    }
}
