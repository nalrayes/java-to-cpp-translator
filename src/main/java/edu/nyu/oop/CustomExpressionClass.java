package edu.nyu.oop;

import xtc.tree.Node;

public class CustomExpressionClass {

    int position;

    public Node leftArgument;
    public String operator;
    public Node rightArgument;

    public void setLeftArgument(Node leftArgument) {
        this.leftArgument = leftArgument;
    }

    public Node getLeftArgument() {
        return leftArgument;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setRightArgument(Node rightArgument) {
        this.rightArgument = rightArgument;
    }

    public Node getRightArgument() {
        return rightArgument;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
