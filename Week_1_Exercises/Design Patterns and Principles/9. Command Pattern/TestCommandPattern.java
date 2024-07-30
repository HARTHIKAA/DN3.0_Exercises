public class TestCommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        
        RemoteControl remoteControl = new RemoteControl();
        
        // Turn the light on
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();
        
        // Turn the light off
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
    }
}
