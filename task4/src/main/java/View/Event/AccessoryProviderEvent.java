package View.Event;

public class AccessoryProviderEvent extends Event {
    public AccessoryProviderEvent(int changedValue) {
        super(changedValue);
        System.out.println(changedValue + "ffff");
    }
}
