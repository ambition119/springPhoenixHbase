package cc.hdp.entity;

import org.apache.commons.lang.StringUtils;

public class SparkCmd {
	private String master;
	private String clazz;
	private String numExecutors;
	private String driverMemory;
	private String executorMemory;
	private String executorCores;
	private String jarParh;
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		if (StringUtils.isBlank(master)) {
			this.master = "";
		}else{
			this.master = "--master " + master;
		}
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		if (StringUtils.isBlank(clazz)) {
			this.clazz = "";
		}else{
			this.clazz = "--class " + clazz;
		}
	}
	public String getNumExecutors() {
		return numExecutors;
	}
	public void setNumExecutors(String numExecutors) {
		if (StringUtils.isBlank(numExecutors)) {
			this.numExecutors = "";
		}else{
			this.numExecutors = "--num-executors "+numExecutors;
		}
	}
	public String getDriverMemory() {
		return driverMemory;
	}
	public void setDriverMemory(String driverMemory) {
		if (StringUtils.isBlank(driverMemory)) {
			this.driverMemory = "";
		}else{
			this.driverMemory = "--driver-memory "+driverMemory;
		}
	}
	public String getExecutorMemory() {
		return executorMemory;
	}
	public void setExecutorMemory(String executorMemory) {
		if (StringUtils.isBlank(executorMemory)) {
			this.executorMemory = "";
		}else{
			this.executorMemory = "--executor-memory "+executorMemory;
		}
	}
	public String getExecutorCores() {
		return executorCores;
	}
	public void setExecutorCores(String executorCores) {
		if (StringUtils.isBlank(executorCores)) {
			this.executorCores = "";
		}else{
			this.executorCores = "--executor-cores "+executorCores;
		}
	}
	public String getJarParh() {
		return jarParh;
	}
	public void setJarParh(String jarParh) {
		if (StringUtils.isBlank(jarParh)) {
			this.jarParh = "";
		}
		this.jarParh = " "+jarParh;
	}
	@Override
	public String toString() {
		return master + " " 
				+ clazz +" " 
				+ numExecutors + " "
				+ driverMemory + " " 
				+ executorMemory+ " " 
				+ executorCores + " " 
				+ jarParh ;
	}
}
