package de.nebalus.mandelbrotfractal.renderer.colorschemes;

import java.awt.*;

public class WhiteGradientScheme implements ColorSchemeInterface
{

	@Override
	public int definePixelColor(int iteration, int maxIteration)
	{
		float modifier = (float) iteration / maxIteration;
		float imodifier = 1.0f - modifier;

		if (0.0f <= modifier && modifier < 0.1f)
		{
			return new Color(0.1f, 0.1f, 0.1f).getRGB();
		}
		else if (modifier < 0.2f)
		{
			return new Color(0.2f, 0.2f, 0.2f).getRGB();
		}
		else if (modifier < 0.3f)
		{
			return new Color(0.3f, 0.3f, 0.3f).getRGB();
		}
		else if (modifier < 0.4f)
		{
			return new Color(0.4f, 0.4f, 0.4f).getRGB();
		}
		else if (modifier < 0.5f)
		{
			return new Color(0.5f, 0.5f, 0.5f).getRGB();
		}
		else if (modifier < 0.6f)
		{
			return new Color(0.6f, 0.6f, 0.6f).getRGB();
		}
		else if (modifier < 0.7f)
		{
			return new Color(0.7f, 0.7f, 0.7f).getRGB();
		}
		else if (modifier < 0.8f)
		{
			return new Color(0.8f, 0.8f, 0.8f).getRGB();
		}
		else if (modifier < 0.9f)
		{
			return new Color(0.9f, 0.9f, 0.9f).getRGB();
		}
		else if (modifier < 1.0f)
		{
			return new Color(1.0f, 1.0f, 1.0f).getRGB();
		}
		else
		{
			return new Color(0, 0, 0).getRGB();
		}
	}

}
