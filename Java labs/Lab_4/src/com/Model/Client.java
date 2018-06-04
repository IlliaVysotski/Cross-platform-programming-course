package com.Model;

public class Client {
    private String expression;

    /**
     * Constructor of Client
     * @param expression
     */
    public Client(String expression)
    {
        this.expression = expression;
    }

    /**
     * Getter
     * @return expression
     */
    public String getExpression()
    {
        return expression;
    }
}
