package de.nebalus.mandelbrotfractal.ui.userinputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import de.nebalus.mandelbrotfractal.renderer.MandelbrotRenderer;
import de.nebalus.mandelbrotfractal.ui.Window;
import de.nebalus.mandelbrotfractal.ui.WindowCanvas;

public class KeyEventListener extends KeyAdapter {

	private final Window window;
	private final InputState inputState;

	public KeyEventListener(Window window, InputState inputState) {
		this.window = window;
		this.inputState = inputState;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!inputState.keyCache.containsKey(e.getKeyCode())) {
			inputState.keyCache.put(e.getKeyCode(), System.currentTimeMillis());
			
			System.out.println("KeyPressed: " + e.getKeyChar() + " Code:" + e.getKeyCode());
			
			WindowCanvas canvas = window.getCanvas();
			MandelbrotRenderer renderer = (MandelbrotRenderer) canvas.getFractalRenderer();
			
			switch (e.getKeyCode()) {
				case 38:
					renderer.addMaxIterations();
					System.out.println("The max iterations are set to: " + renderer.getMaxIterations());
					break;
				case 40:
					renderer.removeMaxIterations();
					System.out.println("The max iterations are set to: " + renderer.getMaxIterations());
					break;
				case 69:
					renderer.zoomIn();
					System.out.println("Zooming IN");
					break;
				case 81:
					renderer.zoomOut();
					System.out.println("Zooming OUT");
					break;
					
				case 87:
					renderer.yOffset -= 0.1d;
					System.out.println(" Y - ");
					break;
				case 65:
					renderer.xOffset -= 0.1d;
					System.out.println(" X - ");
					break;
				case 83:
					renderer.yOffset += 0.1d;
					System.out.println(" Y +");
					break;
				case 68:
					renderer.xOffset += 0.1d;
					System.out.println(" X +");
					break;
				default:
					break;
			}
			
			window.getCanvas().repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (inputState.keyCache.containsKey(e.getKeyCode())) {
			inputState.keyCache.remove(e.getKeyCode());
		}
	}
}
