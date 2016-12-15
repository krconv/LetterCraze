Team Scandium 
CS3733 : Software Engineering
Application Creators: Richard Cole, Kodey Converse, Jeffrey Martin, Connor Smith, Felix Sanchez
December 14, 2016

Group Project Final Implementation

**Important Note about Testing**
Run the tests on a new version of the project. 
(ie. before you have added or edited any levels with LevelBuilder or played any levels in LetterCraze).

To run LevelBuilder, navigate to the src folder and the scandium package. Run the file titled LevelBuilder as a Java Application.
To run LetterCraze, navigate to the src folder and the scandium package. Run the file titled LetterCraze as a Java Application.


**LetterCraze**

**Game Initialization**
All levels are self-contained in the file in a .xml file (as is the GameProgress) requiring no extra loading from the installer.
In the level file becomes corrupted or invalid, the levels will load from a default level file that cannot be overwritten without physically editing the file.
If this happens, the original 15 levels will be created rather than any edits that a Builder has made.

When you run LetterCraze, it will open to a screen known as the Main Menu.
LetterCraze will start with the first level unlocked (it is a Puzzle Level).
	This is known because the levelIcon is colored (Red is a Puzzle Level, Purple is a Lighting Level, and Green is a Theme Level).
	Locked Levels will appear as gray icons.
To Play a Level, click on the levelIcon for the level you want to play and the LevelPlayer will open (unless the level is not yet unlocked, see above).
Also on the Main Menu is a "Reset Progress" Button.
	Clicking this button will reset all your high scores to zero, remove all stars you have received on any levels, 
	and lock all levels except for the first level.

**Playing a Level**
Once the LevelPlayer is open, the Player will see (from top to bottom):
	The Level Name in the top left of the window.
	Three Buttons (Leave, Reset, Undo).
	Three Stars that will go from black to yellow when a star is achieved.
	A label that tells the Player's current Score.
	A label that tells the Player what they much achieve to reach the next Star.
	A label telling the Player the limiting factor for the Level being played (Puzzle-->Words Left, Lightning-->Time Left, Theme-->Words Left).
	A Found Words box in the bottom left of the window.
	A Board on the right of the window.

To select a word, click on a Board Tile, drag to an adjacent tile, continue dragging to adjacent tiles, release on the last Tile you want.
If the word is valid, the Tiles will be removed, the word added to Found Words, 
the Tiles below any open space will float up and new Tiles will be generated on the bottom row
Otherwise the Tiles will be de-selected and remain in the Board.
	
*Note: the hit-box for each tile in the drag is smaller than the entire tile so aim for the center of the tile when you are dragging through it.

When the Undo Button is selected, it will undo the last move (unless it is a Lighting Level where you cannot undo any moves).
When the Reset Button is selected, it will reset all parameters of the the current level and generate a new Board with the following exceptions:
	In a Lighting Level, the timer will continue to count down and will not be reset.
	In a Theme Level, the board will reset to its beginning state, not a random state.
When the Leave Button is pressed, the Player's progress will be saved as the high score and new star count if applicable and the Main Menu will
be displayed with the proper levels unlocked and the proper high scores and star counts displayed.

When the aforementioned limiting factor for the level being played has been reached (see above), the Board will turn gray and the 
Undo and Reset Buttons will be disabled, leaving the Player to only be able to leave the level.

**Cheat to Unlock all Levels**
In the Main Menu, type "scandium" (cannot have more than two second between key presses).
	This will unlock and give the Player three stars in every level.
	This state will not save unless the Player plays a level and scores higher than the threshold for the third star.


**LevelBuilder**

**Game Initialization**
All levels are self-contained in the file in a .xml file (as is the GameProgress) requiring no extra loading from the installer.
In the level file becomes corrupted or invalid, the levels will load from a default level file that cannot be overwritten without physically editing the file.
If this happens, the original 15 levels will be created rather than any edits that a Builder has made.

When you run LevelBuilder, it will open to a screen known as the Main Menu.
Shown on the Main Menu is:
	The Title of the Application.
	A display of levelIcons.
	Three Buttons (New Level, Edit Level, Delete Level).

LevelBuilder will will have all the levels open for editing.
	The type of level is known because the levelIcon is colored (Red is a Puzzle Level, Purple is a Lighting Level, and Green is a Theme Level).

To create a new Level, click on the New Level Button which will open the LevelEditor on a new Level (defaults to Puzzle Level).
To Edit a Level, click on the levelIcon for the Level you want to edit and then on the Edit Level Button which will open LevelEditor for the Level that was selected.

**THIS IS NOT UNDOABLE SO BE SURE YOU WANT TO DO THIS**
To Delete a Level, click on the levelIcon for the Level you want to delete and then on the Delete Level Button which will remove the Level from the playable of Levels.

**Editing a Level**
Once the LevelEditor is open, the Builder will see:
	The Title of the Application in use ("Level Editor") in the top left of the window.
	A Drop-down Menu for selecting the Level type.
	A Text Field for the name of the Level.
	A Text Field for the threshold for the first Star of the Level.
	A Text Field for the threshold for the second Star of the Level.
	A Text Field for the threshold for the third Star of the Level.
	A Text Field for the limiting factor of the Level (Puzzle-->Word Limit, Lightning-->Time Limit, Theme-->Word Limit).
	If the Level is a Theme Level, a Text Field for the Theme Words of the Level.
	Three Buttons (Save, Preview (or Generate if is a Theme Level), Main Menu).
	A Board on the left of the window.

To change the Level Type, select the wanted type from the drop-down selection.
	The window will redraw to display the proper variables and Text Fields for the new Level Type.
	This will not automatically Save the information in the view to the level.
To enable or disable a Board Square, click on a Board Square and its color will change from White to Black or vice versa (White is enabled, Black is disabled).
	This will not automatically Save the information in the view to the level.
To change an attribute of a Level, simply type the wanted information in the correct Text Field.
	This will not automatically Save the information in the view to the level.
To Save a Level with the current information, click the Save Button.
	This will only work if the Level is valid for the information in the window.
	(The Board must have at least 9 enabled Board Squares, there must be a Name for the Level, 
	the Star Thresholds must be positive numbers that are greater than the threshold for the last Star,
	and the limiting factor level must be filled in with a number and Theme Words if applicable)
To Preview what the level might look like (or generate a Theme Level's Board), click on the Preview/Generate Button.
	If this is a preview, this does not ensure that this is what the board will look like during play.
	If this is a generate, this does not ensure that the board will allow for the gaining of all three stars.
		(In circumstance where the number of letters that need to be placed are near the amount of enabled Board Squares, 
		a three star solution is not always guaranteed. It is up to the Builder to ensure that the Board Arrangement is playable.)
	This will not automatically Save the information in the view to the level.
To return to the Main Menu, click the Main Menu Button.
	This will NOT save the current information in the view to the Level.


**Other Information**
After editing a level or adding a new level in the LevelBuilder, all current progress in LetterCraze will be reset.
All third party files applications needed to run this application are included in the package.

