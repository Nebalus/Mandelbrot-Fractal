package de.nebalus.mandelbrotfractal.ui.userinputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import de.nebalus.mandelbrotfractal.renderer.colorschemes.BlackWhiteScheme;
import de.nebalus.mandelbrotfractal.renderer.colorschemes.RainbowScheme;
import de.nebalus.mandelbrotfractal.renderer.colorschemes.TestScheme;
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
		MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getMandelbrotRenderer();

		boolean shouldRepaint = true;

		switch (e.getKeyCode()) {
			case 49:
				if (canvas.showDebug) {
					canvas.showDebug = false;
					break;
				}
				canvas.showDebug = true;
				break;
			case 50:
				renderer.setFilter(new TestScheme());
				break;
			case 51:
				renderer.setFilter(new RainbowScheme());
				break;
			case 52:
				renderer.setFilter(new BlackWhiteScheme());
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
				renderer.setYOffset(renderer.getYOffset() - (renderer.getZoom() * 0.1d));
				System.out.println(" Y - " + renderer.getYOffset());
				break;
			case 65:
				renderer.setXOffset(renderer.getXOffset() - (renderer.getZoom() * 0.1d));
				System.out.println(" X - " + renderer.getXOffset());
				break;
			case 83:
				renderer.setYOffset(renderer.getYOffset() + (renderer.getZoom() * 0.1d));
				System.out.println(" Y + " + renderer.getYOffset());
				break;
			case 68:
				renderer.setXOffset(renderer.getXOffset() + (renderer.getZoom() * 0.1d));
				System.out.println(" X + " + renderer.getXOffset());
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
