/**
 * LevelRestrictor.java
 * 
 * @author Scandium
 */
package scandium.common.tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

import scandium.lettercraze.action.IAction;

/**
 * A tool for restricting the game play of a level. For example, time limit,
 * word limit, etc.
 */
public abstract class LevelRestrictor {
	private List<ActionListener> listeners;
	private Callable<Void> onValueChanged;
	private boolean isRestricting;

	/**
	 * Creates a new level restrictor.
	 */
	public LevelRestrictor() {
		listeners = new LinkedList<ActionListener>();
	}

	/**
	 * Adds an action listener to the {@code LevelRestrictor}.
	 * 
	 * @param listener
	 *            The listener to add.
	 */
	public void addActionListener(ActionListener listener) {
		if (listener != null)
			listeners.add(listener);
	}

	/**
	 * Passes actions to all of the subscribed action listeners to indicate that
	 * this restriction has ended the level.
	 * 
	 * @return Whether any listeners were activated.
	 */
	protected boolean restrict() {
		if (isRestricting) {
			ActionEvent event = new ActionEvent(this, 0, "restrict");
			for (ActionListener listener : listeners) {
				listener.actionPerformed(event);
			}
			stop();
			return !listeners.isEmpty();
		} else {
			return false;
		}
	}

	/**
	 * Starts the restriction in a fresh state (e.g. the timer starts, the word
	 * count starts, etc).
	 */
	public void start() {
		isRestricting = true;
	}

	/**
	 * Stops the restriction.
	 */
	public void stop() {
		isRestricting = false;
	}

	/**
	 * Gets whether this restriction has been started.
	 * @return whether the restriction has been started.
	 */
	public boolean isRestricting() {
		return isRestricting;
	}

	/**
	 * Records an action.
	 * 
	 * @param action
	 *            The action to record.
	 */
	public abstract void recordAction(IAction action);

	/**
	 * Removes an action.
	 * 
	 * @param action
	 *            The action to remove.
	 */
	public abstract void removeAction(IAction action);

	/**
	 * Returns the active label for this restriction (e.g. time left, words
	 * left, etc.).
	 * 
	 * @return The active label for this restriction.
	 */
	public abstract String getLabel();

	/**
	 * Returns the current value of this restriction.
	 * 
	 * @return The current value of this restriction.
	 */
	public abstract String getValue();

	/**
	 * Returns the unit for the current value of this restriction.
	 * 
	 * @return The unit for the current value of this restriction.
	 */
	public abstract String getValueUnit();

	/**
	 * Registers a callable to be called whenever the value has been changed.
	 * 
	 * @param callback
	 *            The callback to call when the value has changed.
	 */
	public void setOnValueChanged(Callable<Void> callback) {
		this.onValueChanged = callback;
	}

	/**
	 * Should be called whenever the value is changed.
	 */
	protected void valueChanged() {
		if (onValueChanged != null)
			try {
				onValueChanged.call();
			} catch (Exception e) {
				System.err.println("Could not notify that the value has changed!");
				e.printStackTrace();
			}
	}
}
