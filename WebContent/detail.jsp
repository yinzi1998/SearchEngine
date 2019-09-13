<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% String title = new String(request.getParameter("title").getBytes("ISO-8859-1")); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title><%=title %></title>
</head>
<%
   
	
   out.clear();
   out = pageContext.pushBody();
   response.setContentType("application/pdf");

   try {
    	String strPdfPath = "D:/Eclipse/EclipseWorkspace/Search_Engine/files/WSDM/fset_pdf/"+title+".pdf";
    	//判断该路径下的文件是否存在
    	File file = new File(strPdfPath);
    	if (file.exists()) {
     		DataOutputStream temps = new DataOutputStream(response.getOutputStream());
     		DataInputStream in = new DataInputStream(new FileInputStream(strPdfPath));

     		byte[] b = new byte[2048];
     		while ((in.read(b)) != -1) {
      		temps.write(b);
      		temps.flush();
     	}

     	in.close();
     	temps.close();
    	} 
    	else {
             out.print("文件不存在!");
        }

   } 
   catch (Exception e) {
    	out.println(e.getMessage());
   }
%>
<body>
   <br>
</body>
</html>