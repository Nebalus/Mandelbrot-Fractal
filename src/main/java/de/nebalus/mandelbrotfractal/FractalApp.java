package de.nebalus.mandelbrotfractal;

import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import de.nebalus.mandelbrotfractal.ui.Window;
import de.nebalus.mandelbrotfractal.ui.WindowCanvas;

public class FractalApp
{

	private final Window window;

	public FractalApp()
	{
		this.window = new Window();
	}

	public void go()
	{
		WindowCanvas canvas = window.getCanvas();
		MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getMandelbrotRenderer();

		// Creates a small fadein animation at startup
		while (renderer.getMaxIterations() < 50) {
			renderer.addMaxIterations();
			canvas.repaint();

			try {
				Thread.sleep(60l);
			} catch (InterruptedException e) {
			}
		}
	}
}
