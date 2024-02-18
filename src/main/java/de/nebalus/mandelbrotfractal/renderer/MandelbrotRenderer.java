package de.nebalus.mandelbrotfractal.renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class MandelbrotRenderer implements Renderer{
	
	public static final int DEFAULT_MAX_ITERATIONS = 0;
	public static final double DEFAULT_ZOOM = 1.0d; 
	public static final double DEFAULT_ZOOM_IN_FACTOR = 0.90d; 
	public static final double DEFAULT_ZOOM_OUT_FACTOR = 1.10d; 
	public static final double DEFAULT_X_OFFSET = 0.0d; 
	public static final double DEFAULT_Y_OFFSET = 0.0d; 
	
	private final int frameWidth;
	private final int frameHeigth;
	
	private int maxIterations;
	private double zoom;
	public double xOffset;
	public double yOffset;
	
	public MandelbrotRenderer(int frameWidth, int frameHeigth) {
		this.frameWidth = frameWidth;
		this.frameHeigth = frameHeigth;
		
		this.maxIterations = DEFAULT_MAX_ITERATIONS;
		this.zoom = DEFAULT_ZOOM;
		this.xOffset = DEFAULT_X_OFFSET;
		this.yOffset = DEFAULT_Y_OFFSET;
	}

	public double getXOffset() {
		return xOffset;
	}
	
	public double getYOffset() {
		return yOffset;
	}
	
	public double getZoom() {
		return zoom;
	}
	
	public void zoomIn() {
		zoom *= DEFAULT_ZOOM_IN_FACTOR;
	}
	
	public void zoomOut() {
		zoom *= DEFAULT_ZOOM_OUT_FACTOR;
	}
	
	@Override
	public BufferedImage render() 
	{
		BufferedImage img = getBaseImage();
		
		final double middleR = -0.75;
		final double middleI = 0;
		final double rangeR = 4.5 * zoom;
		final double rangeI = 3 * zoom;
		
		for (int x = 0; x < frameWidth; x++) 
		{
			for (int y = 0; y < frameHeigth; y++)
			{
				double xPercentage = ((double) x / frameWidth) + xOffset;
				double yPercentage = ((double) y / frameHeigth) + yOffset;
				
				double cReal = xPercentage * rangeR + middleR - rangeR / 2;
				double cImaginary = yPercentage * rangeI + middleI - rangeI / 2;
				
				double zReal = 0.0d;
				double zImaginary = 0.0d;
				
				int iteration = 0;
				while (iteration < maxIterations && zReal * zReal + zImaginary * zImaginary <= 3.5) {
					double temp = zReal * zReal - zImaginary * zImaginary + cReal;
					zImaginary = 2 * zReal * zImaginary + cImaginary;
					zReal = temp;
					iteration++;
				}
				
				float a = 1.0f - ((float) iteration / maxIterations);
				
				if(0.0f <= a && a < 0.3f) {
					img.setRGB(x, y, new Color(0, 0, a).getRGB());
				} else if (0.3f <= a && a < 0.6f) {
					img.setRGB(x, y, new Color(0, a, 0).getRGB());
				} else if (0.6f <= a && a < 0.91f) {
					img.setRGB(x, y, new Color(a, 0, 0).getRGB());
				} else {
					img.setRGB(x, y, new Color(a, a, a).getRGB());
				}
	
				img.setRGB(x, y, new Color(a, a, a).getRGB());
			}
		}
		return img;
	}
	
	public BufferedImage getBaseImage() {
		return new BufferedImage(frameWidth, frameHeigth, BufferedImage.TYPE_INT_RGB); 
	}
	
	
	public int getMaxIterations() {
		return maxIterations;
	}
	
	public synchronized void setMaxIterations(int newMaxIterations) {
		if(newMaxIterations < 0) return;
		
		maxIterations = newMaxIterations;
	}
	
	public void addMaxIterations() {
		addMaxIterations(1);
	}
	
	public void addMaxIterations(int amount) {
		setMaxIterations(maxIterations + amount);
	}
	
	public void removeMaxIterations() {
		removeMaxIterations(1);
	}
	
	public void removeMaxIterations(int amount) {
		setMaxIterations(maxIterations - amount);
	}
	
}
/*
public BufferedImage render() 
	{
		BufferedImage img = getBaseImage();
		
		final double middleR = -0.75;
		final double middleI = 0;
		final double rangeR = 3.0 / 20.0;
		final double rangeI = 2 / 20.0;
		
		for (int x = 0; x < frameWidth; x++) 
		{
			for (int y = 0; y < frameHeigth; y++)
			{
				double xPercentage = ((double) x / frameWidth) + 0.20;
				double yPercentage = ((double) y / frameHeigth) + 1.30;
				
				double cReal = xPercentage * rangeR + middleR - rangeR / 2;
				double cImaginary = yPercentage * rangeI + middleI - rangeI / 2;
				
				double zReal = 0.0d;
				double zImaginary = 0.0d;
				
				int iteration = 0;
				while (iteration < maxIterations && zReal * zReal + zImaginary * zImaginary <= 3) {
					double temp = zReal * zReal - zImaginary * zImaginary + cReal;
					zImaginary = 2 * zReal * zImaginary + cImaginary;
					zReal = temp;
					iteration++;
				}
				
				float colorVal = (float) iteration / maxIterations;
				
				img.setRGB(x, y, new Color(0, 0, colorVal).getRGB());
			}
		}
		return img;
	}
*/