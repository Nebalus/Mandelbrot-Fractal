package de.nebalus.mandelbrotfractal.ui;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

import de.nebalus.mandelbrotfractal.FractalConfig;
import de.nebalus.mandelbrotfractal.generation.FractalHelper;

public class WindowCanvas extends JPanel {

	private static final long serialVersionUID = 8861427947706270401L;

	public WindowCanvas(Window window) {
		super.setDoubleBuffered(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(FractalHelper.zeichneFractal(FractalConfig.WINDOW_WIDTH, FractalConfig.WINDOW_HEIGTH), 0, 0, null);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
}
