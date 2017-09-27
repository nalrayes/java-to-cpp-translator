package edu.nyu.oop.cor;

abstract class PurchasePower {
  protected static final double BASE = 10;
  protected PurchasePower successor;

  public void setSuccessor(PurchasePower successor) {
    this.successor = successor;
  }

  abstract public void processRequest(PurchaseRequest request);
}