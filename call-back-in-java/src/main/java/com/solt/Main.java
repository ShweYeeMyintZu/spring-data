package com.solt;

import com.solt.ds.Pair;
import com.solt.evaluator.AddEvaluator;
import com.solt.evaluator.MultiplyEvaluator;
import com.solt.render.FormalREnder;
import com.solt.render.VerboseREnder;

public class Main {
    public static void main(String[] args) {
        EvaluatorService evaluatorService=new EvaluatorService();
       // evaluatorService.takeAction(new AddEvaluator(),new VerboseREnder(),new Pair(5,7));
       // evaluatorService.takeAction(new MultiplyEvaluator(),new FormalREnder(),new Pair(2,8));
    evaluatorService.takeAction(
            a->a.getA()* a.getB(),
            a-> System.out.println("Ans::"+a),
            new Pair(3,5)
    );

    }
}
