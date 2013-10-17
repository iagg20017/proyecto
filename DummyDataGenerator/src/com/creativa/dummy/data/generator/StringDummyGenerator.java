package com.creativa.dummy.data.generator;

import com.softabar.lipsum.LoremIpsum4J;

public class StringDummyGenerator {
	public static String getWords(int size) {
		String s = null;
		LoremIpsum4J loremIpsum = new LoremIpsum4J();
		String[] paragraphs = null;
		loremIpsum.setStartWithLoremIpsum(false);
		paragraphs = loremIpsum.getWords(size);
		s = "";
		for (String string : paragraphs) {
			s += string;
		}
		return s.trim();
	}
}
