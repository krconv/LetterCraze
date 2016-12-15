/**
 * ProgressLoader.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.tool;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import scandium.common.model.Level;
import scandium.lettercraze.model.LevelProgress;

/**
 * A tool which can be used to save and load files related to the game.
 */
public class ProgressLoader {
	private String savePath;

	/**
	 * Creates a new progress loader which will load and save to the default save file.
	 */
	public ProgressLoader() {
		savePath = Paths.get("LetterCrazeProgress.xml").toString();
	}
	
	/**
	 * Creates a new progress loader which will load and save to the given file.
	 * 
	 * @param savePath
	 *            The path to save and load progress data from.
	 */
	public ProgressLoader(String savePath) {
		savePath = Paths.get(savePath).toString();
	}


	/**
	 * Loads all of the progress from the save file and returns it as a list.
	 * Precondition: The given levels list is not null. 
	 * Postcondition: Gather's a list of progress if it exist in the save file.
	 * 
	 * @param levels
	 *              The levels that the progresses are for.
	 * 
	 * @return The progress loaded from file or an empty list if the file couldn't be loaded.
	 */
	public List<LevelProgress> LoadLevelProgress(List<Level> levels) {
		return LoadLevelProgress(levels, new ArrayList<LevelProgress>());
	}

	/**
	 * Loads all of the progress from the save file and returns it as a list.
	 * Precondition: The given levels list and the list to fill are not null. 
	 * Postcondition: Gather's a list of loaded progress based on the given list of levels.
	 *
	 * @param levels
	 *              The levels that the progresses are for.
	 * @param list
	 *            The list object to add all the loaded levels to.
	 * 
	 * @return The progress loaded from file or an empty list if the file couldn't be loaded.
	 */
	public List<LevelProgress> LoadLevelProgress(List<Level> levels, List<LevelProgress> list) {
		try {
			JAXBContext context = JAXBContext.newInstance(ProgressContainer.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// load the file
			File file = new File(savePath);
			if (file.exists() && !file.isDirectory()) {
				ProgressContainer unmarshalled = (ProgressContainer) unmarshaller.unmarshal(file);
	
				// add the results to the passed in list
				boolean dirty = false;
				for (int i = 0; i < levels.size(); i++) {
					Level level = levels.get(i);
					LevelProgress progress;
					// get the progress for this level
					if (unmarshalled.getProgress().size() > i) { // there are enough progresses
						progress = unmarshalled.getProgress().get(i);
						// invalidate the progress if the tokens don't match
						if (level.getToken() != progress.getToken())
							dirty = true;
						
						progress.setLevel(level);
					} else {
						dirty = true;
						progress = new LevelProgress(level);
					}
					
					// reset the progress if it doesn't match the level
					if (dirty) {
						progress.reset();
					}
					
					// unlock the level if it should be unlocked
					progress.setUnlocked(i == 0 
							|| i >= unmarshalled.getProgress().size() 
							|| unmarshalled.getProgress().get(i - 1).getStarCount() > 0);
					
					// add the progress
					list.add(progress);
				}
			} else {
				// the progress file doesn't exist
				boolean first = true;
				// add brand new progresses with the first one set to unlocked
				for (Level level : levels) {
					LevelProgress progress = new LevelProgress(level);
					if (first) {
						progress.setUnlocked(true);
						first = false;
					}
					list.add(progress);
				}
			}
		} catch (JAXBException e) {
			System.err.println("Could not load progress from \"" + savePath + "\"!");
			e.printStackTrace();
		}

		// return the list
		return list;

	}

	/**
	 * Saves all of the progress to the save file.
	 * Precondition: The given list is not null.
	 * Postcondition: The level progress is saved in a serialized form to the save file.
	 * 
	 * @param progress
	 *            The progress to save.
	 * 
	 * @return Whether any progress was saved.
	 */
	public boolean SaveLevelProgress(List<LevelProgress> progress) {
		try {
			JAXBContext context = JAXBContext.newInstance(ProgressContainer.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File file = new File(savePath);

			// save the levels
			marshaller.marshal(new ProgressContainer(progress), file);

		} catch (JAXBException e) {
			System.err.println("Could not save progress to \"" + savePath + "\"!");
			e.printStackTrace();
			return false;
		}
		// return whether any levels were saved
		return !progress.isEmpty();
	}

	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * A helper class which holds all of the levels and is a container for serialization.
	 */
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class ProgressContainer {
		@XmlElementWrapper(name = "progresses")
		@XmlElement(name = "progress")
		private List<LevelProgress> progress;

		/**
		 * Creates a new Level container with default information.
		 */
		@SuppressWarnings("unused")
		private ProgressContainer() {
			progress = new ArrayList<LevelProgress>();
		}


		/**
		 * Creates a new Progress container with the given progress.
		 * 
		 * @param progress
		 *            The progress to be contained.
		 */
		public ProgressContainer(List<LevelProgress> progress) {
			this.progress = progress;
		}

		/**
		 * @return the levels
		 */
		public List<LevelProgress> getProgress() {
			return progress;
		}
	}
}
