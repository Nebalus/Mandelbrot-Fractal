package de.nebalus.mandelbrotfractal.renderer;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import de.nebalus.mandelbrotfractal.renderer.filter.RainbowFilter;
import de.nebalus.mandelbrotfractal.renderer.filter.FilterInterface;

public class MandelbrotRenderer
{

	public static final int DEFAULT_FRAME_WIDTH;
	public static final int DEFAULT_FRAME_HEIGTH;
	public static final int DEFAULT_MAX_ITERATIONS;
	public static final double DEFAULT_ZOOM;
	public static final double DEFAULT_ZOOM_IN_FACTOR;
	public static final double DEFAULT_ZOOM_OUT_FACTOR;
	public static final double DEFAULT_X_OFFSET;
	public static final double DEFAULT_Y_OFFSET;
	public static final FilterInterface DEFAULT_FILTER;

	static {
		DEFAULT_FRAME_WIDTH = 90;
		DEFAULT_FRAME_HEIGTH = 60;
		DEFAULT_MAX_ITERATIONS = 0;
		DEFAULT_ZOOM = 1.0d;
		DEFAULT_ZOOM_IN_FACTOR = 0.9d;
		DEFAULT_ZOOM_OUT_FACTOR = 1.1d;
		DEFAULT_X_OFFSET = 0.0d;
		DEFAULT_Y_OFFSET = 0.0d;
		DEFAULT_FILTER = new RainbowFilter();
	}
	
	private int frameWidth;
	private int frameHeigth;
	private int maxIterations;
	private double zoom;
	private FilterInterface currentFilter;
	private double xOffset;
	private double yOffset;

	public MandelbrotRenderer(int frameWidth, int frameHeigth)
	{
		setFrameWidth(frameWidth);
		setFrameHeigth(frameHeigth);
		setMaxIterations(DEFAULT_MAX_ITERATIONS);
		setZoom(DEFAULT_ZOOM);
		setFilter(DEFAULT_FILTER);
		setXOffset(DEFAULT_X_OFFSET);
		setYOffset(DEFAULT_Y_OFFSET);
	}

	public void setFilter(FilterInterface newFilter)
	{
		currentFilter = newFilter;
	}

	public FilterInterface getFilter()
	{
		return currentFilter;
	}

	public synchronized BufferedImage render()
	{
		BufferedImage img = getBaseImage();

		List<Thread> workerThreads = new LinkedList<>();

		final int maxThreads = Runtime.getRuntime().availableProcessors();

		for (int i = 1; i <= maxThreads; i++) {
			MandelbrotRenderTask task = new MandelbrotRenderTask(img, this, (frameWidth / maxThreads) * (i - 1), (frameWidth / maxThreads) * i, 0, frameHeigth);
			Thread workerThread = new Thread(task);
			workerThread.start();
			workerThreads.add(workerThread);
		}

		workerThreads.forEach((thread) -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		return img;
	}

	public BufferedImage getBaseImage()
	{
		return new BufferedImage(frameWidth, frameHeigth, BufferedImage.TYPE_INT_RGB);
	}

	public synchronized void setFrameWidth(int newFrameWidth)
	{
		if (newFrameWidth < 0) {
			this.frameWidth = DEFAULT_FRAME_WIDTH;
			return;
		}

		this.frameWidth = newFrameWidth;
	}

	public int getFrameWidth()
	{
		return frameWidth;
	}

	public synchronized void setFrameHeigth(int newFrameHeigth)
	{
		if (newFrameHeigth < 0) {
			this.frameHeigth = DEFAULT_FRAME_HEIGTH;
			return;
		}

		this.frameHeigth = newFrameHeigth;
	}

	public int getFrameHeigth()
	{
		return frameHeigth;
	}

	public void setXOffset(double newXOffset)
	{
		this.xOffset = newXOffset;
	}

	public double getXOffset()
	{
		return xOffset;
	}

	public double getAbsoluteXOffset()
	{
		double aOffset = xOffset * xOffset / zoom;

		return xOffset < 0 ? aOffset * -1.0f : aOffset;
	}

	public void setYOffset(double yOffset)
	{
		this.yOffset = yOffset;
	}

	public double getYOffset()
	{
		return yOffset;
	}

	public double getAbsoluteYOffset()
	{
		double aOffset = yOffset * yOffset / zoom;

		return yOffset < 0 ? aOffset * -1.0f : aOffset;
	}

	public synchronized void setZoom(double zoom)
	{
		this.zoom = zoom;
	}

	public void zoomIn()
	{
		setZoom(zoom * DEFAULT_ZOOM_IN_FACTOR);
	}

	public void zoomOut()
	{
		setZoom(zoom * DEFAULT_ZOOM_OUT_FACTOR);
	}

	public double getZoom()
	{
		return zoom;
	}

	public synchronized void setMaxIterations(int newMaxIterations)
	{
		if (newMaxIterations < 0)
			return;

		maxIterations = newMaxIterations;
	}

	public void addMaxIterations()
	{
		addMaxIterations(1);
	}

	public void addMaxIterations(int amount)
	{
		setMaxIterations(maxIterations + amount);
	}

	public void removeMaxIterations()
	{
		removeMaxIterations(1);
	}

	public void removeMaxIterations(int amount)
	{
		setMaxIterations(maxIterations - amount);
	}

	public int getMaxIterations()
	{
		return maxIterations;
	}
}
