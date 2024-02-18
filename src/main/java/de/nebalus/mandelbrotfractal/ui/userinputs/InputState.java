package de.nebalus.mandelbrotfractal.ui.userinputs;

import java.awt.Point;
import java.util.concurrent.ConcurrentHashMap;

public class InputState {
	protected final ConcurrentHashMap<Integer, Long> mouseKeyCache;
	protected final ConcurrentHashMap<Integer, Long> keyCache;

	protected final Point mouseCords;

	protected boolean isMouseOnCanvas;

	public InputState() {
		mouseKeyCache = new ConcurrentHashMap<>();
		keyCache = new ConcurrentHashMap<>();

		mouseCords = new Point(0, 0);

		isMouseOnCanvas = false;
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
}
