package com.Model;
import com.View.Gui;

public class MyThread extends Thread {
    private String resultString;
    private Server server;
    private String expression;
    private int number;


    public MyThread() {}

    /**
     * Setting info about operation and number of client
     * @param client
     * @param number
     */
    public void setInfo(Client client, int number)
    {
        setExpression(client.getExpression());
        this.number = number;
    }

    /**
     * Getter
     * @return expression
     */
    public String getInfo()
    {
        return expression;
    }

    private void setExpression(String expr)
    {
        expression = expr;
    }

    /**
     * Method that returns result of operation
     * @return result
     */
    public String getResultString()
    {
        return resultString + "   №" + Integer.toString(number);
    }

    /**
     *  Sending expression to server and getting the result
     */
    @Override
    public void run()
    {
        server = new Server(expression);
        resultString = server.getResultString();
    }

    public static class Main {

        public static void main(String[] args) {
            Gui gui = new Gui();
            Server server = new Server();
        }

    }
}

