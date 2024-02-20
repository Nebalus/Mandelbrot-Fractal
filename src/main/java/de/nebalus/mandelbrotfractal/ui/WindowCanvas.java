package de.nebalus.mandelbrotfractal.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;

public class WindowCanvas extends Canvas
{

	private static final long serialVersionUID = 8861427947706270401L;

	private final MandelbrotRenderer renderer;

	public boolean showDebug;

	public WindowCanvas(int windowWidth, int windowHeigth)
	{
		this.renderer = new MandelbrotRenderer(windowWidth, windowHeigth);

		this.showDebug = false;
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		MandelbrotRenderer mbRenderer = (MandelbrotRenderer) renderer;

		Long startProccesTimestamp = System.nanoTime();
		g.drawImage(mbRenderer.render(), 0, 0, null);
		Long proccesTimeNanos = System.nanoTime() - startProccesTimestamp;

		if (showDebug) {
			g.setFont(new Font("Ink Free", Font.BOLD, 20));
			g.setColor(Color.WHITE);

			g.drawString("iterations: " + mbRenderer.getMaxIterations(), 10, g.getFont().getSize() + 10);
			g.drawString("zoom: " + mbRenderer.getZoom(), 10, g.getFont().getSize() * 2 + 20);
			g.drawString("xOffset: " + mbRenderer.getXOffset(), 10, g.getFont().getSize() * 3 + 30);
			g.drawString("yOffset: " + mbRenderer.getYOffset(), 10, g.getFont().getSize() * 4 + 40);
			g.drawString("frameRendertimeNanos: " + proccesTimeNanos, 10, g.getFont().getSize() * 5 + 50);
			g.drawString("frameRendertimeMillis: " + (proccesTimeNanos / 1000000), 10, g.getFont().getSize() * 6 + 60);
		}
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void repaint()
	{
		super.repaint();
	}

	public MandelbrotRenderer getMandelbrotRenderer()
	{
		return renderer;
	}
}
