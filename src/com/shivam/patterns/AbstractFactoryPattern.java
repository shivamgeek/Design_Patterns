package com.shivam.patterns;

/*
 * ABSTRACT FACTORY PATTERN
 * 
 * Abstract factory pattern provides an interface for providing/creating families of related or dependent objects
 * without specifying their concrete classes.
 *   
 * Here we have IButton with concrete implementations as DarkButton, LightButton and ColouredButton.
 * Similarly, IText with DarkText, LightText, ColouredText.
 * 
 * Now we always need LightButton with LightText, DarkButton with DarkText. To enforce this constraint we can use
 * factory pattern, such that a instance of a light type factory always returns lightButon and lightText, for vice versa for Dark.
 * This way we're creating a family of related objects ie whether they're are of dark theme or light theme.
 */

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		
		ButtonAndTextFactory factory = new DarkButtonAndTextFactory();
		Button button = factory.getButton();
		Text text = factory.getText();
		
		button.buttonClick();
		text.showText();

	}

}

interface Button {
	int id = 0;
	String color = "";
	void buttonClick();
	String buttonColor();
}

class DarkButton implements Button {
	String color = "BLACK";
	
	public void buttonClick() {
		System.out.println("Dark Button clicked");
	}
	
	public String buttonColor() {
		return color;
	}
}

class LightButton implements Button {
	String color = "LIGHT";
	
	public void buttonClick() {
		System.out.println("Light Button clicked");
	}
	
	public String buttonColor() {
		return color;
	}
}

class ColouredButton implements Button {
	String color = "COLOURED";
	
	public void buttonClick() {
		System.out.println("Coloured Button clicked");
	}
	
	public String buttonColor() {
		return color;
	}
}


interface Text {
	int id = 0;
	String color = "";
	void showText();
	String getTextColor();
}

class DarkText implements Text {
	String color = "BLACK";
	
	public void showText() {
		System.out.println("This is Dark Text");
	}
	
	public String getTextColor() {
		return color;
	}
}

class LightText implements Text {
	String color = "LIGHT";
	
	public void showText() {
		System.out.println("This is Light Text");
	}
	
	public String getTextColor() {
		return color;
	}
}

class ColouredText implements Text {
	String color = "COLOURED";
	
	public void showText() {
		System.out.println("This is Coloured Text");
	}
	
	public String getTextColor() {
		return color;
	}
}


interface ButtonAndTextFactory {
	Button getButton();
	Text getText();
}

class LightButtonAndTextFactory implements ButtonAndTextFactory {

	@Override
	public Button getButton() {
		return new LightButton();
	}

	@Override
	public Text getText() {
		return new LightText();
	}
	
}

class DarkButtonAndTextFactory implements ButtonAndTextFactory {

	@Override
	public Button getButton() {
		return new DarkButton();
	}

	@Override
	public Text getText() {
		return new DarkText();
	}
	
}

class ColouredButtonAndTextFactory implements ButtonAndTextFactory {

	@Override
	public Button getButton() {
		return new ColouredButton();
	}

	@Override
	public Text getText() {
		return new ColouredText();
	}
	
}


