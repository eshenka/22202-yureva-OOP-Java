package ModelFactory.Details;

public class Car extends Detail {
    Detail motor;
    Detail body;
    Detail accessory;
    public Car(Motor motor, Body body, Accessory accessory) {
        super();
        this.motor = motor;
        this.body = body;
        this.accessory = accessory;
    }

    public Detail getMotor() {
        return motor;
    }

    public Detail getBody() {
        return body;
    }

    public Detail getAccessory() {
        return accessory;
    }
}
