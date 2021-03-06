package org.ansj.splitWord.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.ansj.domain.Term;
import org.ansj.util.IOUtil;

public class ToAnalysisTest {
	public static void main(String[] args) throws IOException {
		Reader reader = new InputStreamReader(new FileInputStream("/Users/ansj/Documents/快盘/冒死记录中国神秘事件（真全本）.txt"), "GBK");
		ToAnalysis toAnalysis = new ToAnalysis(reader,true);
		Term next = null;
		long start = System.currentTimeMillis();
		StringBuilder sb =  new StringBuilder() ;
		while ((next = toAnalysis.next()) != null) {
			System.out.println(next.getName() + ":" + next.maxNature);
			sb.append(next.getName()+":"+next.maxNature) ;
			sb.append("\n") ;
		}
		System.out.println(System.currentTimeMillis() - start);
		IOUtil.Writer("/Users/ansj/Documents/快盘/冒死.txt", "UTF-8", sb.toString()) ;
		
	}
}
