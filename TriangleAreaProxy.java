package com.area;

public class TriangleAreaProxy implements com.area.TriangleArea {
  private String _endpoint = null;
  private com.area.TriangleArea triangleArea = null;
  
  public TriangleAreaProxy() {
    _initTriangleAreaProxy();
  }
  
  public TriangleAreaProxy(String endpoint) {
    _endpoint = endpoint;
    _initTriangleAreaProxy();
  }
  
  private void _initTriangleAreaProxy() {
    try {
      triangleArea = (new com.area.TriangleAreaServiceLocator()).getTriangleArea();
      if (triangleArea != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)triangleArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)triangleArea)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (triangleArea != null)
      ((javax.xml.rpc.Stub)triangleArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.area.TriangleArea getTriangleArea() {
    if (triangleArea == null)
      _initTriangleAreaProxy();
    return triangleArea;
  }
  
  public double triangleArea(int side1, int side2, int side3) throws java.rmi.RemoteException{
    if (triangleArea == null)
      _initTriangleAreaProxy();
    return triangleArea.triangleArea(side1, side2, side3);
  }
  
  
}