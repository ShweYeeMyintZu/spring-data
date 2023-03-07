package com.solt.render;

public class VerboseREnder implements RenderExpressionn{
    @Override
    public void display(int num) {
        System.out.println(String.format("num=[%s]",num));
    }
}
