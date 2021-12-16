package aval3.observer;

import aval3.observer.CheckpointData;
import aval3.observer.CheckpointListener;

import java.util.Map;

public class ReportCheckpoint implements CheckpointListener{

	@Override
	public void notifyRestoreEvent(CheckpointData data) {
		System.out.println("RESTAURA��O DE CHECKPOINT REALIZADO COM SUCESSO");
		this.printReport(data.getPctConclusaoDisciplinas());
	}

	@Override
	public void notifyCheckpointEvent(CheckpointData data) {
		System.out.println("CHECKPOINT REALIZADO COM SUCESSO");
		this.printReport(data.getPctConclusaoDisciplinas());
	}
	
	private void printReport(Map<String, Double> discs) {
		for(String disc : discs.keySet())
			System.out.println("[" + disc+ "] " + discs.get(disc) + " horas");
	}

}
