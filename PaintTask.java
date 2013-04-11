import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.*;

class PaintTask extends TimerTask{

	BasePanel paint;

	PaintTask(BasePanel to_paint)
	{
		paint = to_paint;
	}
	
	public void run()
	{
		paint.paintComponent((Graphics2D)paint.getGraphics());
	}
}