package de.nebalus.mandelbrotfractal.renderer.filter;

import java.awt.Color;

public class BlackWhiteFilter implements Filter{

	@Override
	public int filterPixel(int iteration, int maxIteration) {
		float modifier = (float) iteration / maxIteration;
		return new Color(modifier, modifier, modifier).getRGB();
	}

}
