package nanocounter;

import java.util.function.Consumer;

public class NanoCounter {
	
	public static void run(String name, Consumer<String> callback) {
		
		long l1 = System.nanoTime();
		
		callback.accept(name);
		
		long l2 = System.nanoTime() - l1;
		
		System.out.format("%s took: %s nanoseconds, %s milliseconds%n", name, l2, l2 / 1_000_000);
	}
	
}
