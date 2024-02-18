package de.nebalus.mandelbrotfractal.ui.inputs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import de.nebalus.mandelbrotfractal.ui.Window;

public class MouseEventListener extends MouseAdapter {

	private final Window window;
	private final InputState inputState;

	public MouseEventListener(Window window, InputState inputState) {
		this.window = window;
		this.inputState = inputState;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!inputState.mouseKeyCache.containsKey(e.getButton())) {
			inputState.mouseKeyCache.put(e.getButton(), System.currentTimeMillis());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (inputState.mouseKeyCache.containsKey(e.getButton())) {
			inputState.mouseKeyCache.remove(e.getButton());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		inputState.isMouseOnCanvas = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		inputState.isMouseOnCanvas = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		inputState.mouseCords.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		inputState.mouseCords.setLocation(e.getX(), e.getY());
	}
}
