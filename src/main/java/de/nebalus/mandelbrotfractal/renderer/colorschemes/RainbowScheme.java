package de.nebalus.mandelbrotfractal.renderer.colorschemes;

import java.awt.Color;

public class RainbowScheme implements ColorSchemeInterface
{

	@Override
	public int definePixelColor(int iteration, int maxIteration)
	{
		float modifier = (float) iteration / maxIteration;
		float imodifier = 1.0f - modifier;

		if (0.0f <= modifier && modifier < 0.3f) {
			return new Color(0, 0, modifier * 3).getRGB();
		} else if (0.3f <= modifier && modifier < 0.6f) {
			return new Color(imodifier, modifier, 0).getRGB();
		} else if (0.6f <= modifier && modifier < 1.0f) {
			return new Color(modifier, 0, imodifier).getRGB();
		} else {
			return new Color(0, 0, 0).getRGB();
		}
	}

}
