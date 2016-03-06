package com.shengsiyuan.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		String path = req.getRealPath("/upload");
		System.out.println(path);
		
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(req);
			
			for(FileItem item : list) {
				String name = item.getFieldName();
				if(item.isFormField()) {
					String value = item.getString();
					
					System.out.println(name + " = " + value);
					req.setAttribute(name, value);
					
				} else {
					String value = item.getName();
					
					int start = value.lastIndexOf("/");
					String fileName = value.substring(start + 1);
					req.setAttribute(name, fileName);
					
					item.write(new File(path, fileName));
//					OutputStream os = new FileOutputStream(new File(path, fileName));
//					InputStream is = item.getInputStream();
//					
//					byte[] buffer = new byte[400];
//					int length = 0;
//					
//					while(-1 != (length = is.read(buffer, 0, 400))) {
//						os.write(buffer, 0, length);
//					}
//					
//					is.close();
//					os.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("fileUploadResult.jsp").forward(req, resp);
	}
	
	

}
