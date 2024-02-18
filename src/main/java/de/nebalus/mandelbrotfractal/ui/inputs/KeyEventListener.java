package de.nebalus.mandelbrotfractal.ui.inputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import de.nebalus.mandelbrotfractal.ui.Window;

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
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (inputState.keyCache.containsKey(e.getKeyCode())) {
			inputState.keyCache.remove(e.getKeyCode());
		}
	}
}
