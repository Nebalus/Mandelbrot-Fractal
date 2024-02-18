package de.nebalus.mandelbrotfractal;

import de.nebalus.mandelbrotfractal.generation.FractalHelper;

public class FractalCore {

	private static final FractalApp fractalApp;
	
	static {
		fractalApp = new FractalApp();
	}
	
	public static void main(String[] args) 
	{
		fractalApp.showWindow();
	}
	
}
