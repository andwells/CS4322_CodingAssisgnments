import java.util.ArrayList;
public interface Content
{

  public void notifySubscribers(Object arg);
  public void notifySubscribers();

  public Boolean subscribe(Subscription aSubscription);

  public Boolean unsubscribe(Subscription toRemove);
  
  public ArrayList<PressRelease>deliverAllContent();
  
  public void start();
}