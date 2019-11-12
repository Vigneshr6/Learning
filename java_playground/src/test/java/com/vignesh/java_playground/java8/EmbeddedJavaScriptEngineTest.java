package com.vignesh.java_playground.java8;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class EmbeddedJavaScriptEngineTest {

	@Test
	void testNashornJSEngine() throws ScriptException, FileNotFoundException {
		ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("nashorn");
		jsEngine.eval(new FileReader("resources/sample.js"));
	}
}
