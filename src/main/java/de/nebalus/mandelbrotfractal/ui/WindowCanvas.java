package de.nebalus.mandelbrotfractal.ui;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class WindowCanvas extends JPanel {

	private static final long serialVersionUID = 8861427947706270401L;

	public WindowCanvas(Window window) {
		super.setDoubleBuffered(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
}
