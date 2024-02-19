package de.nebalus.mandelbrotfractal.ui.userinputs;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import de.nebalus.mandelbrotfractal.ui.Window;
import de.nebalus.mandelbrotfractal.ui.WindowCanvas;

public class MouseEventListener extends MouseAdapter
{

	private final Window window;

	private final Point mouseCords;

	public MouseEventListener(Window window)
	{
		this.window = window;

		this.mouseCords = new Point(0, 0);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		WindowCanvas canvas = window.getCanvas();
		MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getFractalRenderer();

		if (e.getPreciseWheelRotation() < 0.0d) {
			renderer.zoomIn();
		} else {
			renderer.zoomOut();
		}
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseCords.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		final int oldX = (int) mouseCords.getLocation().getX();
		final int oldY = (int) mouseCords.getLocation().getY();

		WindowCanvas canvas = window.getCanvas();
		MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getFractalRenderer();

		final int xTrace = e.getX() - oldX;
		final int yTrace = e.getY() - oldY;

		final double xTracePercent = ((double) xTrace / (double) renderer.getFrameWidth());
		final double yTracePercent = ((double) yTrace / (double) renderer.getFrameHeigth());

		renderer.setXOffset(renderer.getXOffset() - (renderer.getZoom() * xTracePercent));
		renderer.setYOffset(renderer.getYOffset() - (renderer.getZoom() * yTracePercent));

		mouseCords.setLocation(e.getX(), e.getY());
		canvas.repaint();
	}
}
