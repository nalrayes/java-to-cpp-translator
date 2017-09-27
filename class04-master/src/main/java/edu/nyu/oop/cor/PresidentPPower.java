package edu.nyu.oop.cor;

class PresidentPPower extends PurchasePower {
  private final double ALLOWABLE = 40 * BASE;

  public void processRequest(PurchaseRequest request) {
    if (request.getAmount() < ALLOWABLE) {
      System.out.println("President will approve $" + request.getAmount());
    } else {
      System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
    }
  }
}