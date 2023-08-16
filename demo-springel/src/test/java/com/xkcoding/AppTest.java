package com.xkcoding;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) {


        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Inventor tesla = new Inventor();
        tesla.setInventions(new String[]{"0","1","2","3"});
        //invention = "3"
        String invention = parser.parseExpression("inventions[3]").getValue(context, tesla, String.class);
    }
}

