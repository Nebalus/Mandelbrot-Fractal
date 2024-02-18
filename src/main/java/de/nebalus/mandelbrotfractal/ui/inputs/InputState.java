package de.nebalus.mandelbrotfractal.ui.inputs;

import java.awt.Point;
import java.util.concurrent.ConcurrentHashMap;

public class InputState {
	protected final ConcurrentHashMap<Integer, Long> mouseKeyCache;
	protected final ConcurrentHashMap<Integer, Long> keyCache;

	protected final Point mouseCords;

	protected boolean isMouseOnCanvas;
	protected boolean isWindowFocused;
	protected boolean isWindowIconified;
	protected boolean isWindowOpened;
	protected boolean isWindowClosed;
	protected boolean isWindowClosing;

	public InputState() {
		mouseKeyCache = new ConcurrentHashMap<>();
		keyCache = new ConcurrentHashMap<>();

		mouseCords = new Point(0, 0);

		isMouseOnCanvas = false;
		isWindowFocused = false;
		isWindowIconified = false;
		isWindowOpened = false;
		isWindowClosed = false;
		isWindowClosing = false;
	}

	/**
	 * @return the mouseKeyCache
	 */
	public ConcurrentHashMap<Integer, Long> getMouseKeyCache() {
		return mouseKeyCache;
	}

	/**
	 * @return the keyCache
	 */
	public ConcurrentHashMap<Integer, Long> getKeyCache() {
		return keyCache;
	}

	/**
	 * @return the mouseCords
	 */
	public Point getMouseCords() {
		return mouseCords;
	}

	/**
	 * @return the isMouseOnCanvas
	 */
	public boolean isMouseOnCanvas() {
		return isMouseOnCanvas;
	}

	/**
	 * @return the isWindowFocused
	 */
	public boolean isWindowFocused() {
		return isWindowFocused;
	}

	/**
	 * @return the isWindowIconified
	 */
	public boolean isWindowIconified() {
		return isWindowIconified;
	}

	/**
	 * @return the isWindowOpened
	 */
	public boolean isWindowOpened() {
		return isWindowOpened;
	}

	/**
	 * @return the isWindowClosed
	 */
	public boolean isWindowClosed() {
		return isWindowClosed;
	}

	/**
	 * @return the isWindowClosing
	 */
	public boolean isWindowClosing() {
		return isWindowClosing;
	}
}
