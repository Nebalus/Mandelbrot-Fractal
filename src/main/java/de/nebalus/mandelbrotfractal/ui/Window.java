package de.nebalus.mandelbrotfractal.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import de.nebalus.mandelbrotfractal.ui.userinputs.KeyEventListener;
import de.nebalus.mandelbrotfractal.ui.userinputs.MouseEventListener;

public class Window
{

	// Window
	private final JFrame jFrame;
	private final WindowCanvas canvas;

	public Window(GraphicsDevice graphicsDevice)
	{
		// Display modus
		DisplayMode displayMode = graphicsDevice.getDisplayMode();
		
		// Init JFrame Event Listeners
		KeyEventListener keyListener = new KeyEventListener(this);
		MouseEventListener mouseListener = new MouseEventListener(this);

		// Init Window
		jFrame = new JFrame();

		// JFrame deklaration
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setTitle("Mandelbrot Fractal");
		jFrame.setName("Window");
		jFrame.setUndecorated(true);
		jFrame.setAlwaysOnTop(true);
		jFrame.setResizable(true);
		jFrame.setPreferredSize(new Dimension(displayMode.getWidth(), displayMode.getHeight()));
		jFrame.setBackground(Color.BLACK);
		jFrame.pack();
		jFrame.setLocationRelativeTo(null);
		
		// Init and Adding Canvas
		canvas = new WindowCanvas(displayMode.getWidth(), displayMode.getHeight());
		jFrame.add(canvas);
		
		// JFrame Listeners
		canvas.addMouseWheelListener(mouseListener);
		canvas.addMouseMotionListener(mouseListener);
		canvas.addMouseListener(mouseListener);
		canvas.addKeyListener(keyListener);
		
		// Canvas dekaration
		canvas.setBackground(Color.BLACK);
		canvas.setName("Canvas");
		canvas.setPreferredSize(new Dimension(displayMode.getWidth(), displayMode.getHeight()));
		canvas.setFocusable(true);

		if (graphicsDevice.isFullScreenSupported()) {
			graphicsDevice.setFullScreenWindow(jFrame);
		} else {
			// Try to fake fullscreen
			jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
		}
		
		jFrame.setVisible(true);
	}

	public WindowCanvas getCanvas()
	{
		return canvas;
	}
}
