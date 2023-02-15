package spring;

import org.springframework.beans.factory.annotation.Value;

public class VersionPrinter {
	@Value("5")
	private int majorVersion;
	@Value("0")
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
