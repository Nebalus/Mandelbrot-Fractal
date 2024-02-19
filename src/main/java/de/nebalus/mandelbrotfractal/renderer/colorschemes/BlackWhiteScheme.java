package de.nebalus.mandelbrotfractal.renderer.colorschemes;

import java.awt.Color;

public class BlackWhiteScheme implements ColorSchemeInterface
{

	@Override
	public int definePixelColor(int iteration, int maxIteration)
	{
		float modifier = (float) iteration / maxIteration;
		return new Color(modifier, modifier, modifier).getRGB();
	}

}
