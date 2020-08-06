package org.fbsql.servlet;

import java.lang.reflect.Method;

import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

public class MethodOrFunction {
	public Method     method;

	public Scriptable scope;
	public Function   function;
}
