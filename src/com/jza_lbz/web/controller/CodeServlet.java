package com.jza_lbz.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeServlet extends HttpServlet {


	public CodeServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);
		
		int width = 85;
		int height = 25;
		String code = ""; 
		int[] line = new int[4];
		for(int i=0;i<4;i++){  
            int j = (int)(Math.random()*10);  
            line[i] = j;  
            code += "" + j;
        }
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		
		//创建图像
		BufferedImage img= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//创建画笔
		Graphics g = img.getGraphics();
		//图片添加背景色
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, width, height);
		//边框色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);
		//设置文本样式
		g.setColor(Color.GRAY);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		//添加文本
		Random rand = new Random();
		int position = 15;
		for (int i = 0; i < 4; i++) {
			g.drawString(line[i]+"", position, 18);
			position +=15;
		}
		//添加干扰线
		for (int i = 0; i < 4; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		//将图片以流的方式输出到客户端
		ImageIO.write(img, "jpg", response.getOutputStream());
		
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
