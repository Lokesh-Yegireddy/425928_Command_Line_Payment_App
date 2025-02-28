package com.entity;

 enum SourceType {
	 
       BANK_ACCOUNT("BankAccount",1),
	   WALLET_ACCOUNT("WalletAccount",2),
	   THIRD_PARTY("ThirdParty",3);
	   
	   
	   private final String sourceTypeName;
	   private final int sourceCode;

	  SourceType(String sourceTypeName, int sourceCode) {
		this.sourceTypeName = sourceTypeName;
		this.sourceCode = sourceCode;
	}

	public String getSourceTypeName() {
		return sourceTypeName;
	}

	public int getSourceCode() {
		return sourceCode;
	}
	   
	 public static SourceType getSourceTypeByCode(int code) {
	        for (SourceType source : SourceType.values()) {
	            if (source.getSourceCode() == code) {
	                return source;
	            }
	        }
	        throw new IllegalArgumentException("Invalid source type code : "+code);
	 }
	 
	 public static SourceType findBySourceTypeName(String name) {
	        for (SourceType source : SourceType.values()) {
	            if (source.getSourceTypeName().equalsIgnoreCase(name)) {
	                return source;
	            }
	        }
	        throw new IllegalArgumentException("Invalid source type name: " + name);
	    }
}

 
public class Sources{
	private int sourceId;
	private SourceType sourceType;
	
	
	
	public Sources() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Sources(int sourceId, SourceType sourceType) {
		//super();
		this.sourceId = sourceId;
		this.sourceType = sourceType;
	}



	public int getSourceId() {
		return sourceId;
	}



	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}



	public SourceType getSourceType() {
		return sourceType;
	}



	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}
	
	
}