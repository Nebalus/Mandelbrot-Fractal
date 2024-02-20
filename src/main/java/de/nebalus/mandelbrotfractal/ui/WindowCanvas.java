package de.nebalus.mandelbrotfractal.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;

public class WindowCanvas extends JPanel
{

	private static final long serialVersionUID = 8861427947706270401L;

	private final MandelbrotRenderer renderer;

	public boolean showDebug;

	public WindowCanvas(int windowWidth, int windowHeigth)
	{
		this.renderer = new MandelbrotRenderer(windowWidth, windowHeigth);

		this.showDebug = false;

		super.setDoubleBuffered(true);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Long startProccesTimestamp = System.nanoTime();
		g.drawImage(renderer.render(), 0, 0, null);
		Long proccesTimeNanos = System.nanoTime() - startProccesTimestamp;

		if (showDebug) {
			g.setFont(new Font("Ink Free", Font.BOLD, 20));
			g.setColor(Color.WHITE);

			g.drawString("iterations: " + renderer.getMaxIterations(), 10, g.getFont().getSize() + 10);
			g.drawString("zoom: " + renderer.getZoom(), 10, g.getFont().getSize() * 2 + 20);
			g.drawString("xOffset: " + renderer.getXOffset(), 10, g.getFont().getSize() * 3 + 30);
			g.drawString("yOffset: " + renderer.getYOffset(), 10, g.getFont().getSize() * 4 + 40);
			g.drawString("frameRendertimeNanos: " + proccesTimeNanos, 10, g.getFont().getSize() * 5 + 50);
			g.drawString("frameRendertimeMillis: " + (proccesTimeNanos / 1000000), 10, g.getFont().getSize() * 6 + 60);
		}
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public MandelbrotRenderer getMandelbrotRenderer()
	{
		return renderer;
	}
}
