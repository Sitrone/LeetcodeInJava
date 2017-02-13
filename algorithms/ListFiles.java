package com.snippet.util;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.io.FileUtils;

public class ListFiles
{
	public static void listFiles(String file)
	{
		File path = new File(file);
		Collection<File> files = FileUtils.listFiles(path, null, true);
		System.out.println(files.size());
		for (File file2 : files)
		{
			System.out.println(file2.getAbsolutePath());
		}
	}
	
	public static void listFilesRecursive(String file)
	{
		File path = new File(file);
		for(File f : path.listFiles())
		{
			if(f.isDirectory())
			{
				listFilesRecursive(f.getAbsolutePath());
			}
			else if(f.isFile())
			{
				System.out.println(f.getAbsolutePath());
			}
		}
	}

	public static void printFilesDFS(String dir)
	{
		Stack<File> stack = new Stack<File>();
		stack.push(new File(dir));
		while (!stack.isEmpty())
		{
			File child = stack.pop();
			if (child.isDirectory())
			{
				for (File f : child.listFiles())
				{
					stack.push(f);
				}
			}
			else if (child.isFile())
			{
				System.out.println(child.getPath());
			}
		}
	}
	
	public static void listFilesBFS(String dir)
	{
		Queue<File> queue = new ArrayDeque<>();
		queue.offer(new File(dir));
		while(!queue.isEmpty())
		{
			File child = queue.remove();
			if(child.isDirectory())
			{
				for(File f: child.listFiles())
				{
					queue.add(f);
				}
			}
			else if(child.isFile())
			{
				System.out.println(child.getAbsolutePath());
			}
		}
	}
	
	
	public static void main(String[] args)
	{
//		listFiles("H:\\影 视");
//		printFilesDFS("H:\\影 视");
//		listFilesBFS("H:\\影 视");
		listFilesRecursive("H:\\影 视");
	}
}
