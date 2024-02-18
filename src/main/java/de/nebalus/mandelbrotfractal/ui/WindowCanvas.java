package de.nebalus.mandelbrotfractal.ui;

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
		
		g.drawImage(renderer.render(), 0, 0, null);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public Renderer getFractalRenderer() {
		return renderer;
	}
}
