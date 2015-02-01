public interface Content {

  public void notifySubscribers();

  public Boolean subscribe(Subscription aSubscription);

  public Boolean unsubscribe(Subscription toRemove);

}