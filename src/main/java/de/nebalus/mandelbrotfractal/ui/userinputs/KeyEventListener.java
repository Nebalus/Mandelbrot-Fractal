package de.nebalus.mandelbrotfractal.ui.userinputs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventListener extends KeyAdapter {

	private final InputState inputState;

	public KeyEventListener(InputState inputState) {
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
