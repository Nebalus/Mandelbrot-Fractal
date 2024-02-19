package de.nebalus.mandelbrotfractal.renderer.filter;

public interface Filter {

	public abstract int filterPixel(int iteration, int maxIteration);
	
}
