package spring;

public class VersionPrinter {
	
	private int majorVersion;
	private int minorVersion;
	
	
	public void print() {
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n",
				majorVersion, minorVersion);
	}
	//세터 빌더처럼..
	public VersionPrinter setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
		return this;
	}
	public VersionPrinter setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
		return this;
	}
	
	
}
