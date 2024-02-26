package de.nebalus.mandelbrotfractal.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import de.nebalus.mandelbrotfractal.ui.userinputs.KeyEventListener;
import de.nebalus.mandelbrotfractal.ui.userinputs.MouseEventListener;

public class Window
{

	// Window
	private final JFrame jFrame;
	private final WindowCanvas canvas;

	public Window()
	{
		// Graphics Enviroment
		GraphicsEnvironment graphicsEnviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice graphicsDevice = graphicsEnviroment.getDefaultScreenDevice();
		DisplayMode displayMode = graphicsDevice.getDisplayMode();

		// Init JFrame Event Listeners
		KeyEventListener keyListener = new KeyEventListener(this);
		MouseEventListener mouseListener = new MouseEventListener(this);

		// Init Window Component Objects
		jFrame = new JFrame();
		JPanel contentPane = new JPanel(new GridBagLayout());
		jFrame.setContentPane(contentPane);
		canvas = new WindowCanvas(displayMode.getWidth(), displayMode.getHeight());
		jFrame.add(canvas);

		// JFrame Listeners
		canvas.addMouseWheelListener(mouseListener);
		canvas.addMouseMotionListener(mouseListener);
		canvas.addMouseListener(mouseListener);
		canvas.addKeyListener(keyListener);

		// JFrame deklaration
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setTitle("Mandelbrot Fractal");
		jFrame.setName("MainWindow");
		jFrame.setUndecorated(false);
		jFrame.setAlwaysOnTop(true);
		jFrame.setResizable(true);
		jFrame.setPreferredSize(new Dimension(displayMode.getWidth(), displayMode.getHeight()));
		jFrame.pack();

		// ContentPane deklaration
		contentPane.setName("ContentPane");
		contentPane.setBackground(Color.BLACK);

		// Canvas dekaration
		canvas.setBackground(Color.BLACK);
		canvas.setName("MainCanvas");
		canvas.setLayout(new GridBagLayout());
		canvas.setPreferredSize(new Dimension(jFrame.getWidth(), jFrame.getHeight()));
		canvas.setFocusable(true);

		if (graphicsDevice.isFullScreenSupported()) {
			graphicsDevice.setFullScreenWindow(jFrame);
		} else {
			// Try to fake fullscreen
			jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
		}

		// Centers the window in the middle of the screen
		jFrame.setLocationRelativeTo(null);
		
		jFrame.setVisible(true);
	}

	public WindowCanvas getCanvas()
	{
		return canvas;
	}
}
