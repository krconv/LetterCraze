/**
 * TimeLevelRestrictor.java
 * 
 * @author Kodey Converse (kodey@krconv.com)
 */
package scandium.common.tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import scandium.lettercraze.action.IAction;

/**
 * A level restrictor that is based on a time limit.
 */
public class TimeLevelRestrictor extends LevelRestrictor {
	protected Timer timer;
	private int timeLimit;
	private int timeLeft;
	
	/**
	 * Creates a new restrictor that is based on a time limit.
	 * @param timeLimit The time limit for the level in seconds.
	 */
	public TimeLevelRestrictor(int timeLimit) {
		this.timeLimit = timeLimit;
		this.timeLeft = 0;
		timer = new Timer(1000, null);
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// decrement the time left by one second
				timeLeft--;
				valueChanged();
				
				// see if the time has expired
				if (timeLeft <= 0)
					restrict();
			}
		});
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#recordAction(scandium.lettercraze.action.IAction)
	 */
	@Override
	public void recordAction(IAction action) { 
		// don't need to do anything special when a word is found
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#removeAction(scandium.lettercraze.action.IAction)
	 */
	@Override
	public void removeAction(IAction action) {
		// don't need to do anything special when a word us undone
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#start()
	 */
	@Override
	public void start() {
		super.start();
		timer.start();
		if (timeLeft == 0)
			timeLeft = timeLimit;
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#stop()
	 */
	@Override
	public void stop() {
		super.stop();
		timer.stop();
		timeLeft = 0;
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Time Left";
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#getValue()
	 */
	@Override
	public String getValue() {
		return "" + timeLeft;
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#getValueUnit()
	 */
	@Override
	public String getValueUnit() {
		return "second" + (timeLeft == 1 ? "" : "s");
	}

}
