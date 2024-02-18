package de.nebalus.mandelbrotfractal.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import de.nebalus.mandelbrotfractal.FractalConfig;
import de.nebalus.mandelbrotfractal.ui.userinputs.InputState;
import de.nebalus.mandelbrotfractal.ui.userinputs.KeyEventListener;
import de.nebalus.mandelbrotfractal.ui.userinputs.MouseEventListener;
import de.nebalus.mandelbrotfractal.ui.userinputs.WindowEventListener;

public class Window {

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
		inputState = new InputState();
		
		// Init JFrame Event Listeners
		keyListener = new KeyEventListener(inputState);
		mouseListener = new MouseEventListener(inputState);
		windowListener = new WindowEventListener(inputState);
		
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
		contentPane.setBackground(Color.CYAN);

		// Canvas dekaration
		canvas.setBackground(Color.BLACK);
		canvas.setLayout(new GridBagLayout());
		canvas.setPreferredSize(new Dimension(FractalConfig.WINDOW_WIDTH, FractalConfig.WINDOW_HEIGTH));
		canvas.setFocusable(true);

		// Centers the window in the middle of the screen
		jFrame.setLocationRelativeTo(null);
	}

	public void showWindow(boolean visibility) {
		jFrame.setVisible(visibility);
	}
	
	public WindowCanvas getCanvas() {
		return canvas;
	}
}
