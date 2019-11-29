package meri.padhai.designpatterns;

public class Computer {

	//required parameters
	private String ram;
	private String hdd;
	
	//optional parameters
	private boolean isGraphicCardRequired;
	private boolean isBluetoothEnabled;
	
	private Computer(ComputerBuilder builder)
	{
		this.ram = builder.ram;
		this.hdd = builder.hdd;
		this.isGraphicCardRequired = builder.isGraphicCardRequired;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	public boolean isGraphicCardRequired() {
		return isGraphicCardRequired;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	public String getRam() {
		return ram;
	}

	public String getHdd() {
		return hdd;
	}

	static class ComputerBuilder
	{
		
		//required parameters
		private String ram;
		private String hdd;
		
		//optional parameters
		private boolean isGraphicCardRequired;
		private boolean isBluetoothEnabled;
		
		public ComputerBuilder(String ram, String hdd) 
		{
			super();
			this.ram = ram;
			this.hdd = hdd;
		}


		public void setGraphicCardRequired(boolean isGraphicCardRequired) {
			this.isGraphicCardRequired = isGraphicCardRequired;
		}


		public void setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
		}
		
		public Computer buildComputer()
		{
			return new Computer(this);
		}
		
		
	}
	
	
	
}
