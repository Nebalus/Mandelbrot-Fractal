package de.nebalus.mandelbrotfractal.worker;

import java.awt.image.BufferedImage;

import de.nebalus.mandelbrotfractal.FractalConfig;

public class FractalHelper {

	public BufferedImage zeichneFractal(int x1, int x2, int y1, int y2) {
		BufferedImage img = new BufferedImage(FractalConfig.WINDOW_WIDTH, FractalConfig.WINDOW_HEIGTH, BufferedImage.TYPE_INT_RGB);
		
		double x_s = (x2-x1)/FractalConfig.WINDOW_WIDTH;
		double y_s = (y2-y1)/FractalConfig.WINDOW_HEIGTH;
		
		for (int x = 0; x <= FractalConfig.WINDOW_WIDTH; x++) {
			for (int y = 0; y <= FractalConfig.WINDOW_HEIGTH; y++) {
				
			}
		}
		return img;
	}
	
}
