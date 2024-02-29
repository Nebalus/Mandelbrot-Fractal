package de.nebalus.mandelbrotfractal;

import java.awt.GraphicsEnvironment;

public class FractalCore
{

	public static void main(String[] args)
	{
		if(GraphicsEnvironment.isHeadless()) {
			System.out.println("Headless instance detected... please plugin a display device!");
			System.out.println("ABORTING!!!");
			return;
		}
		
		new FractalApp().go();
	}
}
