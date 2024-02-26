package de.nebalus.mandelbrotfractal.renderer;

import java.awt.image.BufferedImage;

public class MandelbrotRenderTask implements Runnable
{

	private final BufferedImage img;
	private final MandelbrotRenderer renderer;
	private final int xFrom, xTo, yFrom, yTo;

	public MandelbrotRenderTask(BufferedImage img, MandelbrotRenderer renderer, int xFrom, int xTo, int yFrom, int yTo)
	{
		this.img = img;
		this.renderer = renderer;
		this.xFrom = xFrom;
		this.xTo = xTo;
		this.yFrom = yFrom;
		this.yTo = yTo;
	}

	@Override
	public void run()
	{
		final double middleR = -0.75;
		final double middleI = 0.0;
		final double rangeR = 4.5 * renderer.getZoom();
		final double rangeI = 3 * renderer.getZoom();

		final double aXOffset = renderer.getAbsoluteXOffset();
		final double aYOffset = renderer.getAbsoluteYOffset();

		for (int x = xFrom; x < xTo; x++) {
			for (int y = yFrom; y < yTo; y++) {
				double xPercentage = (double) (x) / renderer.getFrameWidth() + aXOffset;
				double yPercentage = (double) (y) / renderer.getFrameHeigth() + aYOffset;

				double cReal = xPercentage * rangeR + middleR - rangeR / 2;
				double cImaginary = yPercentage * rangeI + middleI - rangeI / 2;

				double zReal = 0.0d;
				double zImaginary = 0.0d;

				int iteration = 0;
				while (iteration < renderer.getMaxIterations() && zReal * zReal + zImaginary * zImaginary <= 3.5) {
					double temp = zReal * zReal - zImaginary * zImaginary + cReal;
					zImaginary = 2 * zReal * zImaginary + cImaginary;
					zReal = temp;
					iteration++;
				}

				img.setRGB(x, y, renderer.getColorScheme().definePixelColor(iteration, renderer.getMaxIterations()));
			}
			Thread.yield();
		}
	}
}
