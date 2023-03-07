package com.solt;

import com.solt.ds.Pair;
import com.solt.evaluator.Evaluator;
import com.solt.render.RenderExpressionn;

public class EvaluatorService {

    public void takeAction(Evaluator evaluator, RenderExpressionn render, Pair pair){
        render.display(evaluator.evaluate(pair));
    }
}
