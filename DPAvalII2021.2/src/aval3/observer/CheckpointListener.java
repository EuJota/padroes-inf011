package aval3.observer;

import aval3.observer.CheckpointData;

public interface CheckpointListener {
	
	public void notifyRestoreEvent(CheckpointData data);
	public void notifyCheckpointEvent(CheckpointData data);
	
}
