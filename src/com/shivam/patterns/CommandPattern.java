package com.shivam.patterns;


/*
 * Command Pattern
 * 
 * Command pattern encapsulates a request/command as an object thereby letting you parameterize other objects with different requests, 
 * queue or log requests and support undo-able operations.
 * 
 *  
 */
public class CommandPattern {

	public static void main(String[] args) {
		
		//Create the actual devices to be controlled
		LightReceiver light = new LightReceiver();
		FanReceiver fan = new FanReceiver();
		
		//create concrete objects of the commands that link controlled objects and invoker
		LightOnCommand on = new LightOnCommand(light);
		LightOffCommand off = new LightOffCommand(light);
		LightBrightnessUpCommand up = new LightBrightnessUpCommand(light);
		LightBrightnessDownCommand down = new LightBrightnessDownCommand(light);
		
		//Now link the above commands to the buttons of the remote
		Invoker remote = new Invoker(on, off, up, down);
		
		remote.on.execute();
		remote.down.unexecute();

	}

}

// Invoker acts as a remote which actually calls the commands
class Invoker {
	ICommand on, off, up, down;

	public Invoker(ICommand on, ICommand off, ICommand up, ICommand down) {
		super();
		this.on = on;
		this.off = off;
		this.up = up;
		this.down = down;
	}
	
}

// The receiver which actually does something upon receiving the command
class LightReceiver {
	void turnOnLight() {
		System.out.println("Light Turned On");
	}
	
	void turnOffLight() {
		System.out.println("Light Turned Off");
	}
	
	void decreaseBrightness() {
		System.out.println("Light brightness decreased");
	}
	
	void increaseBrightness() {
		System.out.println("Light brightness increased");
	}
}

class FanReceiver {
	void turnOn() {
		System.out.println("Fan Turned On");
	}
	
	void turnOff() {
		System.out.println("Fan Turned Off");
	}
	
	void increaseFanSpeed() {
		System.out.println("Increased fan speed");
	}
	
	void decreaseFanSpeed() {
		System.out.println("Decreased fan speed");
	}
}

//Command pattern interface for encapsulating request/command
interface ICommand {
	void execute();
	void unexecute();
}

//Concrete implementation of the generic commands by Light and Fan
class LightOnCommand implements ICommand {
	LightReceiver light;
	
	public LightOnCommand(LightReceiver light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.turnOnLight();
	}

	@Override
	public void unexecute() {
		light.turnOffLight();
	}
	
}

class LightOffCommand implements ICommand {
	LightReceiver light;
	
	public LightOffCommand(LightReceiver light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.turnOffLight();
	}

	@Override
	public void unexecute() {
		light.turnOnLight();
	}
	
}

class LightBrightnessUpCommand implements ICommand {
	LightReceiver light;
	
	public LightBrightnessUpCommand(LightReceiver light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.increaseBrightness();
	}

	@Override
	public void unexecute() {
		light.decreaseBrightness();
	}
	
}

class LightBrightnessDownCommand implements ICommand {
	LightReceiver light;
	
	public LightBrightnessDownCommand(LightReceiver light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.decreaseBrightness();
	}

	@Override
	public void unexecute() {
		light.increaseBrightness();
	}
	
}