package de.nebalus.mandelbrotfractal;

import de.nebalus.mandelbrotfractal.ui.Window;

public class FractalApp {
	
	private final Window window;
	
	public FractalApp() {
		this.window = new Window();
	}
	
	public void showWindow() {
		window.showWindow(true);
	}
}
