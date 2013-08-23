package com.czy.myclass.test;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czy.myclass.dto.NewsFormDto;
import com.czy.myclass.service.NewsSevrice;

public class TestNews {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void addNews() {

		NewsSevrice newsSevrice = (NewsSevrice) ac.getBean("newsServiceImpl");
		for (int j = 0; j < 20; j++) {
			for (int i = 0; i < 1000; i++) {
				NewsFormDto news = new NewsFormDto();
				news.setAuthor("admin");
				news.setContent(getClipboard());
				news.setImg("137723843827801377210531.jpg");
				news.setSource(getClipboard());
				news.setTitle("title" + i);
				news.setNewsTypeId((long) 1);
				newsSevrice.saveNews(news);
			}
			for (int i = 0; i < 1000; i++) {
				NewsFormDto news = new NewsFormDto();
				news.setAuthor("admin");
				news.setContent(getClipboard());
				news.setImg("137723843827801377210531.jpg");
				news.setSource(getClipboard());
				news.setTitle("title" + i);
				news.setNewsTypeId((long) 2);
				newsSevrice.saveNews(news);
			}
			for (int i = 0; i < 1000; i++) {
				NewsFormDto news = new NewsFormDto();
				news.setAuthor("admin");
				news.setContent(getClipboard());
				news.setImg("137723843827801377210531.jpg");
				news.setSource(getClipboard());
				news.setTitle("title" + i);
				news.setNewsTypeId((long) 3);
				newsSevrice.saveNews(news);
			}
		}

	}

	@Test
	public void getclip() {
		System.out.println(getClipboard());
	}

	public static String getClipboard() {
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard()
				.getContents(null);

		try {
			if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				String text = (String) t
						.getTransferData(DataFlavor.stringFlavor);
				return text;
			}
		} catch (UnsupportedFlavorException e) {
		} catch (IOException e) {
		}
		return null;
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		NewsSevrice newsSevrice = (NewsSevrice) ac.getBean("newsServiceImpl");
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 1000; i++) {
				NewsFormDto news = new NewsFormDto();
				news.setAuthor("admin");
				news.setContent(getClipboard());
				news.setImg("137723843827801377210531.jpg");
				news.setSource("test news");
				news.setTitle("title" + i);
				news.setNewsTypeId((long) 1);
				newsSevrice.saveNews(news);
				System.out.print(i);
			}
			for (int i = 0; i < 1000; i++) {
				NewsFormDto news = new NewsFormDto();
				news.setAuthor("admin");
				news.setContent(getClipboard());
				news.setImg("137723843827801377210531.jpg");
				news.setSource("test news");
				news.setTitle("title" + i);
				news.setNewsTypeId((long) 2);
				newsSevrice.saveNews(news);
				System.out.print(i);
			}
			for (int i = 0; i < 1000; i++) {
				NewsFormDto news = new NewsFormDto();
				news.setAuthor("admin");
				news.setContent(getClipboard());
				news.setImg("137723843827801377210531.jpg");
				news.setSource("test news");
				news.setTitle("title" + i);
				news.setNewsTypeId((long) 3);
				newsSevrice.saveNews(news);
				System.out.print(i);
			}
		}
	}
}
