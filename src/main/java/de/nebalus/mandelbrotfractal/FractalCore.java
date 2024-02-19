package de.nebalus.mandelbrotfractal;

import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import de.nebalus.mandelbrotfractal.ui.Window;
import de.nebalus.mandelbrotfractal.ui.WindowCanvas;

public class FractalCore {

	private static final FractalApp fractalApp;
	
	static {
		fractalApp = new FractalApp();
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Window window = fractalApp.getWindow();
		window.showWindow(true);
		
		WindowCanvas canvas = window.getCanvas();
		MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getMandelbrotRenderer();
		
		while (renderer.getMaxIterations() < 50) {
			renderer.addMaxIterations();
			canvas.repaint();
			
			Thread.sleep(75l);
		}
	}
}
