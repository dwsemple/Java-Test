import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.*;

class Entity{
	protected int width;
	protected int height;
	protected BufferedImage image;
	protected int x_pos;
	protected int y_pos;
	protected int x_dis;
	protected int y_dis;
	protected BoundingBox bounding_box;
	
	Entity()
	{
		width = 64;
		height = 64;
		x_pos = 512;
		y_pos = 512;
		
		try{
		File file = new File("sprites/square.png");
		image = ImageIO.read(file);
		}catch(Exception e){
			System.out.println("LOL NO FILE");
		}

		bounding_box = new BoundingBox(0,0,width,height);
	}
	
	Entity(int w, int h, int x, int y, int x_p, int y_p, String s)
	{
		width = w;
		height = h;
		x_pos = x;
		y_pos = y;
		x_dis = x_p;
		y_dis = y_p;
		try{
		File file = new File("sprites/"+s+".png");
		image = ImageIO.read(file);
		}catch(Exception e){
			System.out.println("LOL NO FILE");
		}
		for(int i=0;i < image.getWidth();i++)
		{
			for(int j=0;j < image.getHeight();j++)
			{
				
				if(image.getRGB(i,j) == new Color(255,0,255,255).getRGB())
				{
					image.setRGB(i,j,new Color(255,0,255,0).getRGB());
				}
			}
		}
		bounding_box = new BoundingBox(0,0,width,height);
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	public int getXPos()
	{
		return x_pos;
	}
	
	public int getYPos()
	{
		return y_pos;
	}
	
	public void setXPos(int i)
	{
		x_pos = x_pos + i;
	}
	
	public void setYPos(int i)
	{
		y_pos = y_pos + i;
	}
	
	public void paint(Graphics2D g)
	{
		g.drawImage(this.image,this.x_pos,this.y_pos,null);
	}
	
	public void update()
	{
		x_pos += x_dis;
		y_pos += y_dis;
	}
	
	public void setXDis(int x_d)
	{
		x_dis = x_d;
	}
	
	public void setYDis(int y_d)
	{
		y_dis = y_d;
	}

	public BoundingBox getBoundingBox()
	{
		return bounding_box;
	}

	public BoundingBox setBoundingBox(int min_x, int min_y, int max_x, int max_y)
	{
		bounding_box = new BoundingBox(min_x, min_y, max_x, max_y);
		return bounding_box;
	}

	public BoundingBox getWorldBoundingPoints()
	{
		BoundingBox world_bounding_points = new BoundingBox(x_pos - bounding_box.min_x(), y_pos - bounding_box.min_y(), x_pos + bounding_box.max_x(), y_pos + bounding_box.max_y());

		return world_bounding_points;
	}

	public void collide(Entity other)
	{

	}
}