package de.nebalus.mandelbrotfractal.generation;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import de.nebalus.mandelbrotfractal.FractalConfig;

public class FractalHelper {

	public static BufferedImage zeichneFractal(final int imageWidth, final int imageHeigth) 
	{	
		BufferedImage img = new BufferedImage(imageWidth, imageHeigth, BufferedImage.TYPE_INT_RGB);
		
		final int maxIteration = 30;
		final double middleR = -0.75;
		final double middleI = 0;
		final double rangeR = 3.0;
		final double rangeI = 2;
		
		for (int x = 0; x < imageWidth; x++) 
		{
			for (int y = 0; y < imageHeigth; y++)
			{
				double xPercentage = (double) x / imageWidth;
				double yPercentage = (double) y / imageHeigth;
				
				double cReal = xPercentage * rangeR + middleR - rangeR / 2;
				double cImaginary = yPercentage * rangeI + middleI - rangeI / 2;
				
				double zReal = 0.0d;
				double zImaginary = 0.0d;
				
				int iteration = 0;
				while (iteration < maxIteration && zReal * zReal + zImaginary * zImaginary <= 3) {
					double temp = zReal * zReal - zImaginary * zImaginary + cReal;
					zImaginary = 2 * zReal * zImaginary + cImaginary;
					zReal = temp;
					iteration++;
				}
				
				float colorVal = (float) iteration / maxIteration;
				
				img.setRGB(x, y, new Color(colorVal, 0, 0).getRGB());
				
//				if (iteration != maxIteration)  {
//					Random ran = new Random();
//					img.setRGB(x, y, new Color(ran.nextFloat(0.0f, 1.0f), ran.nextFloat(0.0f, 1.0f), ran.nextFloat(0.0f, 1.0f)).getRGB());
//				
//				}
				
				//Random ran = new Random();
				//img.setRGB(x, y, new Color(ran.nextFloat(0.0f, 1.0f), ran.nextFloat(0.0f, 1.0f), ran.nextFloat(0.0f, 1.0f)).getRGB());
			}
		}
		return img;
	}
	
}
