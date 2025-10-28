package dev.nebalus.mandelbrotfractal;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import dev.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import dev.nebalus.mandelbrotfractal.ui.Window;
import dev.nebalus.mandelbrotfractal.ui.WindowCanvas;

public class FractalApp
{

	private final Window window;

	public FractalApp()
	{
		GraphicsEnvironment graphicsEnviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice graphicsDevice = graphicsEnviroment.getDefaultScreenDevice();
		this.window = new Window(graphicsDevice);
	}

	public void go()
	{
		WindowCanvas canvas = window.getCanvas();
		MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getMandelbrotRenderer();

		// Creates a small fadein animation at startup
		while (renderer.getMaxIterations() < 50) {
			renderer.addMaxIterations();
			
			Long test = System.nanoTime();
			canvas.repaint();
			System.out.println(System.nanoTime() - test);

			try {
				Thread.sleep(75l);
			} catch (InterruptedException e) {
			}
		}
	}
}
