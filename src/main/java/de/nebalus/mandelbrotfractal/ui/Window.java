package de.nebalus.mandelbrotfractal.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import de.nebalus.mandelbrotfractal.FractalConfig;
import de.nebalus.mandelbrotfractal.ui.inputs.InputState;
import de.nebalus.mandelbrotfractal.ui.inputs.KeyEventListener;
import de.nebalus.mandelbrotfractal.ui.inputs.MouseEventListener;
import de.nebalus.mandelbrotfractal.ui.inputs.WindowEventListener;

public class Window {

	// Basic
	private final GraphicsEnvironment graphicsEnviroment;
	private final GraphicsDevice graphicsDevice;
	
	// Listener
	private final KeyEventListener keyListener;
	private final MouseEventListener mouseListener;
	private final WindowEventListener windowListener;
	
	// Cache
	private final InputState inputState;
	
	// Window
	private final JFrame jFrame;
	private final WindowCanvas canvas;
	
	public Window()
	{
		graphicsEnviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = graphicsEnviroment.getDefaultScreenDevice();
		
		inputState = new InputState();
		
		// Init JFrame Event Listeners
		keyListener = new KeyEventListener(this, inputState);
		mouseListener = new MouseEventListener(this, inputState);
		windowListener = new WindowEventListener(this, inputState);
		
		// Init Window Component Objects
		jFrame = new JFrame();
		JPanel contentPane = new JPanel(new GridBagLayout());
		jFrame.setContentPane(contentPane);
		canvas = new WindowCanvas(this);
		jFrame.add(canvas);
		
		// JFrame Listeners
		jFrame.addWindowFocusListener(windowListener);
		jFrame.addWindowListener(windowListener);
		jFrame.addWindowStateListener(windowListener);

		canvas.addMouseMotionListener(mouseListener);
		canvas.addMouseListener(mouseListener);
		canvas.addKeyListener(keyListener);
		
		// JFrame deklaration
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setTitle("Mandelbrot Fractal");
		jFrame.setName("Mandelbrot Fractal");
		jFrame.setUndecorated(false);
		jFrame.setAlwaysOnTop(false);
		jFrame.setResizable(false);
		jFrame.setPreferredSize(new Dimension(FractalConfig.WINDOW_WIDTH, FractalConfig.WINDOW_HEIGTH));
		jFrame.pack();
		
		// ContentPane deklaration
		contentPane.setBackground(Color.BLACK);

		// Canvas dekaration
		canvas.setBackground(Color.BLACK);
		canvas.setLayout(new GridBagLayout());
		canvas.setPreferredSize(new Dimension(FractalConfig.WINDOW_WIDTH, FractalConfig.WINDOW_HEIGTH));
		canvas.setFocusable(true);

		// Centers the window in the middle of the screen
		jFrame.setLocationRelativeTo(null);
		
		jFrame.setVisible(true);
	}

	public WindowCanvas getCanvas() {
		return canvas;
	}
}
