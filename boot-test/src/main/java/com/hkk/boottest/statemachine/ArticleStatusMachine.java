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
public class ArticleStatusMachine implements StateMachine<ArticleState, ArticleEvent> {

    @SuppressWarnings("unchecked")
    private static final Set<StateTransaction<ArticleState, ArticleEvent>> transactions = Sets
        .newHashSet(
            new StateTransaction<>(DRAFT, AUDITING, SUBMIT),
            new StateTransaction<>(AUDITING, SUCCESS, PASS),
            new StateTransaction<>(AUDITING, FAILED, REJECT)
        );

    @Override
    public Optional<ArticleState> nextState(
        ArticleState articleState,
        ArticleEvent articleEvent) {
        Optional<StateTransaction<ArticleState, ArticleEvent>> transaction = transactions.stream().filter(t ->
            t.getCurrentState().equals(articleState) && t.getEvent().equals(articleEvent))
            .findAny();
        return transaction.map(StateTransaction::getNextState);
    }
}
