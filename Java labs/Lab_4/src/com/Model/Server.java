package com.Model;

public class Server {
    private double leftOp;
    private double rightOp;
    private double res;
    private char sign;

    /**
     * Constructors of Server
     * @param expression
     */
    Server(String expression)
    {
        expression.trim();
        searchForSign(expression);
        searchForOperand(expression);

        Calculate();
        System.out.println(Double.toString(leftOp) + sign + Double.toString(rightOp) + " = " + Double.toString(res));
    }
    Server() {}

    /**
     * Sets sign of operation
     * @param str
     */
    private void searchForSign(String str)
    {
        if (str.contains("-") == true) {
            sign = '-';
        }
        else if (str.contains("+") == true) {
            sign = '+';
        }
        else if (str.contains("*") == true) {
            sign = '*';
        }
        else if (str.contains("/") == true || str.contains(":") == true) {
            sign = '/';
        }
        else sign = '\0';
    }

    /**
     * Filling right and left operand
     * @param str
     */
    private boolean searchForOperand(String str)
    {
        int sign = str.indexOf(this.sign);
        //if (sign != '/' || sign != '+' || sign != '-' || sign != '*')
          //  return  false;

        String number = str.substring(0, sign);
        if (isNumber(number) == true)
        {
            System.out.println(number);
            leftOp = Double.parseDouble(number);
        }
        //else return false;

        number = str.substring(sign+1,sign+10);
        if (isNumber(number) == true)
        {
            rightOp = Double.parseDouble(number);
        }
        //else return false;
        else rightOp = Double.parseDouble(number);
        return true;
    }

    /**
     * Method that calculates sended operation
     */
    private void Calculate()
    {
        switch(sign)
        {
            case '+':
            {
                res = rightOp + leftOp;
                break;
            }
            case '-':
            {
                res = leftOp - rightOp;
                break;
            }
            case '*':
            {
                res = rightOp * leftOp;
                break;
            }
            case '/':
            {
                res = leftOp / rightOp;
                break;
            }
        }
    }

    /**
     * Determines if str is a digit or not
     * @param str
     * @return
     */
    private static boolean isNumber(String str)
    {
        for (char c: str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public String getResultString()
    {
        return Double.toString(leftOp) + sign + Double.toString(rightOp) + " = " + Double.toString(res);
    }
}

