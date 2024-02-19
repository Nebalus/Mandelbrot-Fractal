package de.nebalus.mandelbrotfractal.ui.userinputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import de.nebalus.mandelbrotfractal.renderer.filter.BlackWhiteFilter;
import de.nebalus.mandelbrotfractal.renderer.filter.RainbowFilter;
import de.nebalus.mandelbrotfractal.renderer.filter.TestFilter;
import de.nebalus.mandelbrotfractal.ui.Window;
import de.nebalus.mandelbrotfractal.ui.WindowCanvas;

public class KeyEventListener extends KeyAdapter
{

	private final Window window;

	public KeyEventListener(Window window)
	{
		this.window = window;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("KeyPressed: " + e.getKeyChar() + " Code:" + e.getKeyCode());

		WindowCanvas canvas = window.getCanvas();
		MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getFractalRenderer();

		boolean shouldRepaint = true;
		
		switch (e.getKeyCode()) {
			case 49:
				if(canvas.showDebug) {
					canvas.showDebug = false;
					break;
				}
				canvas.showDebug = true;
				break;
			case 50:
				renderer.setFilter(new TestFilter());
				break;
			case 51:
				renderer.setFilter(new RainbowFilter());
				break;
			case 52:
				renderer.setFilter(new BlackWhiteFilter());
				break;
			case 38:
			case 82:
				renderer.addMaxIterations(25);
				System.out.println("The max iterations are set to: " + renderer.getMaxIterations());
				break;
			case 40:
			case 70:
				renderer.removeMaxIterations(25);
				System.out.println("The max iterations are set to: " + renderer.getMaxIterations());
				break;
			case 69:
				renderer.zoomIn();
				System.out.println("Zooming IN");
				break;
			case 81:
				renderer.zoomOut();
				System.out.println("Zooming OUT");
				break;

			case 87:
				renderer.yOffset -= renderer.getZoom() * 0.1d;
				System.out.println(" Y - " + renderer.yOffset);
				break;
			case 65:
				renderer.xOffset -= renderer.getZoom() * 0.1d;
				System.out.println(" X - " + renderer.yOffset);
				break;
			case 83:
				renderer.yOffset += renderer.getZoom() * 0.1d;
				System.out.println(" Y + " + renderer.yOffset);
				break;
			case 68:
				renderer.xOffset += renderer.getZoom() * 0.1d;
				System.out.println(" X + " + renderer.yOffset);
				break;
			default:
				shouldRepaint = false;
				break;
		}

		if (shouldRepaint) {
			window.getCanvas().repaint();
		}
	}
}
