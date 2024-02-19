package de.nebalus.mandelbrotfractal.renderer.filter;

public interface FilterInterface
{

	public abstract int filterPixel(int iteration, int maxIteration);

}
