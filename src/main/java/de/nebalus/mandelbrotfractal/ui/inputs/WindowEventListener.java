package de.nebalus.mandelbrotfractal.ui.inputs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import de.nebalus.mandelbrotfractal.ui.Window;

public class WindowEventListener extends WindowAdapter {

	private final Window window;
	private final InputState inputState;

	public WindowEventListener(Window window, InputState inputState) {
		this.window = window;
		this.inputState = inputState;
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		inputState.isWindowFocused = false;
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		inputState.isWindowFocused = true;
	}

	@Override
	public void windowIconified(WindowEvent e) {
		inputState.isWindowIconified = true;
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		inputState.isWindowIconified = false;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		inputState.isWindowOpened = true;
		inputState.isWindowClosed = false;
		inputState.isWindowClosing = false;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		inputState.isWindowOpened = false;
		inputState.isWindowClosed = false;
		inputState.isWindowClosing = true;
	}

	@Override
	public void windowClosed(WindowEvent e) {
		inputState.isWindowOpened = false;
		inputState.isWindowClosed = true;
		inputState.isWindowClosing = false;
	}
}
