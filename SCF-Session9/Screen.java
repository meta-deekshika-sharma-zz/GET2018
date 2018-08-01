package graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will have a virtual screen and have method to display shapes on screen
 * @author Deekshika Sharma
 */
public class Screen {

	private int xMax;
	private int yMax;
	
	public Screen(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
//	Create a map to store time stamp of shape creation
	Map<Shape, Date> screenObject = new HashMap<Shape, Date>();
	
	/**
	 * This method will add a shape object on the screen
	 * @param shapeObject
	 */
	public boolean addShape(Shape shapeObject)
	{
		if (shapeObject != null && shapeObject.getOrigin().getX() <= xMax && shapeObject.getOrigin().getX() >= 0 && shapeObject.getOrigin().getY() <= yMax && shapeObject.getOrigin().getY() >= 0)
		{
			screenObject.put(shapeObject, new Date());
			return true;
		}
		else
			throw new AssertionError("The given shape object is not added into screen!");
	}
	
	/**
	 * This method will delete a specified shape object
	 * @param shapeObject
	 */
	public boolean deleteShape(Shape shapeObject)
	{
		if(screenObject.containsKey(shapeObject))
		{
            screenObject.remove(shapeObject);
            return true;
		}
        else
            throw new AssertionError("The given shape object is not present on screen!");
	}
	
	/**
	 * This method will delete the objects of specified shape
	 * @param shapeType
	 */
	public boolean deleteShapeType(ShapeTypes shapeType)
	{
		for(Shape shape : screenObject.keySet())
		{
			if (shape.getShapeType() == shapeType)
			{
				screenObject.remove(shape);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method will find list of shapes which are enclosed to a specified point
	 * @param point
	 * @return list of shapes enclosed to a specified point
	 */
	public List<Shape> shapeEnclosedPoints(Point point)
	{
		List<Shape> listOfShape = new ArrayList<Shape>();
		
		for (Shape shape : screenObject.keySet())
		{
			if (shape.isPointEnclosed(point))
				listOfShape.add(shape);
		}
		
		return listOfShape;
	}
	
	/**
	 * This method will sort the shapes on screen according to area, parameter, origin distance or by time stamp
	 * @param sortedType
	 * @return list of shapes in sorted way
	 */
	public List<Shape> sortedShapeObject(ShapeSorted sortedType)
	{
		List<Shape> listOfSortedShape = new ArrayList<Shape>(screenObject.keySet());
		
		
		switch(sortedType)
		{
		case AREA:Collections.sort(listOfSortedShape, (o1, o2) -> (int)(o1.getArea() - o2.getArea()));
			break;
		case ORIGINDISTANCE:Collections.sort(listOfSortedShape, (o1, o2) -> (int)(o1.getOriginDistance() - o2.getOriginDistance()));
			break;
		case PERIMETER:Collections.sort(listOfSortedShape, (o1, o2) -> (int)(o1.getPerimeter() - o2.getPerimeter()));
			break;
		case TIMESTAMPS:Collections.sort(listOfSortedShape, (o1, o2) -> (o1.getCurrentDate().compareTo(o2.getCurrentDate())));
			break;
		
		}
		
		showList(listOfSortedShape);
		return listOfSortedShape;
	}
	
	/**
	 * This method will show the list of shapes
	 * @param listOfShape
	 */
	public void showList(List<Shape> listOfShape)
	{
		for (Shape shape : listOfShape)
		{
			System.out.println(shape.getArea() + " " + shape.getPerimeter() + " " + shape.getOriginDistance() + " " + shape.getOrigin() + " " + shape.getShapeType() + " " + shape.getCurrentDate());
		}
	}
}
