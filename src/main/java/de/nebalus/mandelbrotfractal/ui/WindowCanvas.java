package de.nebalus.mandelbrotfractal.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

import de.nebalus.mandelbrotfractal.FractalConfig;
import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import de.nebalus.mandelbrotfractal.renderer.Renderer;

public class WindowCanvas extends JPanel {

	private static final long serialVersionUID = 8861427947706270401L;
	
	private final Renderer renderer;
	
	public WindowCanvas(Window window) {
		this.renderer = new MandelbrotRenderer(FractalConfig.CANVAS_WIDTH, FractalConfig.CANVAS_HEIGTH);
		
		super.setDoubleBuffered(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		MandelbrotRenderer mbRenderer = (MandelbrotRenderer) renderer;
		
		g.drawImage(mbRenderer.render(), 0, 0, null);
		
		g.setFont(new Font("Ink Free", Font.BOLD, 20));
		g.setColor(Color.DARK_GRAY);

		g.drawString("iterations: " + mbRenderer.getMaxIterations(), 10, g.getFont().getSize() + 10);
		g.drawString("zoom: " + mbRenderer.getZoom(), 10, g.getFont().getSize() * 2 + 20);
		g.drawString("xOffset: " + mbRenderer.getXOffset(), 10, g.getFont().getSize() * 3 + 30);
		g.drawString("yOffset: " + mbRenderer.getYOffset(), 10, g.getFont().getSize() * 4 + 40);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public Renderer getFractalRenderer() {
		return renderer;
	}
}
