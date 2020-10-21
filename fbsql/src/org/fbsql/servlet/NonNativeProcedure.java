package org.fbsql.servlet;

public class NonNativeProcedure {
	public ProcedureType procedureType;
	public String        optionsJson;

	@Override
	public String toString() {
		return "NonNativeProcedure [procedureType=" + procedureType + ", optionsJson=" + optionsJson + "]";
	}

}
