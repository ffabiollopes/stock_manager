package io.altar.jseproject.state;

import io.altar.jseproject.utils.ScannerUtils;

public interface State {
	
	public static final ScannerUtils input = new ScannerUtils();
	
	public int execute();

}
