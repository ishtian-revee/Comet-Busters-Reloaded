# Comet Busters Reloaded

Comet Busters Reloaded is a PC game developed in Java programming language. The
game concept is actually familiar with the real **'Comet Busters'** game which
is more likely a space shooter game. This is why the name of this game is same
as **'Comet Busters'** with just a extend part of 'reloaded'. But this game has
limited features and levels than **'Comet Busters'**. But users will find the
gameplay quite similar.

## Development and Resources

This game is developed in raw Java programming language. No game engines or any
types of game development frameworks have been used in this. The main components
of Java that has been used in this game developments are:

* JFrame
* Java AWT Libraries
* Java Swing Libraries

---

Tools used: `Eclipse IDE` and `Adobe Fireworks`

Game Assets: `Kenney`

Background Music: `Geoplex`

All the game components textures has been cropped from a single sprite sheet
which is in `res/textures/sheet.png`. There are also some other textures and
icons in the directory which has been downloaded from google.

`res/audio/` contains all the game sounds and background music. All these files
are in .mp3 extension.

---

For some game implementation additional Libraries has been used in this project.
All these additional libraries are in `lib/` directory.

## Gameplay and concept

After a smooth splash screen main menu state appears. User will find total of
4 options in the main menu which are **start game**, **high scores**,
**options** and **exit game**.

After starting the game users will have full on control over the player to move
from one place to other and shoot lasers.

### Controls

Up: `W` or `up arrow`

Down: `S` or `down arrow`

Left: `A` or `left arrow`

Right: `D` or `right arrow`

Shoot laser: `space`

Pause: `ESC`

### Start Game

When the level starts there will be some comets coming from upwards in random
direction. These comets will roam between the game screen. What user has to do
is shoot at these comets to destroy them and again avoid these from collision
or else player will loose a life.

Some times after destroying a comet player will have some powerups to collect.
These powerups could be +life, +xp and so on.

Initially the player will have total of 3 lives, single laser beam and no ship
mode and also score of 0. By destroying comets player will some points which
will added to the scores. And also by getting powerups player will have xp,
additional life, more laser power and ship modes.

This game has total of **20 Levels**. In each level different size, types and
numbers of comets will appear. In the initial levels the number of comets are
less. But when the player move forward to the next levels the difficulty level
gets higher. The number of comets increases.

If the player loose all of its life the game over. After game over user has to
input their name in 3 letters (roll up and down like slots to input the username)
and enter. The score along with the name will store in the high score table.

### High Scores

This screen shows all the scores and names of the user in a single table. This
table is sorted in ascending order with the player score. High scores will show
at the top of the table along with the username.

### Options

This game has only one setting option which is to turning on or off the
background music while playing.

**[Note: After turning off the music when the player again turn it on then the
music will start from the beginning.]**

### Exit Game

This will close the game.

## Powerups

There are total of 7 powerups in the game which are:

* +life: increases lives

* +power: increases laser power to dual beams and triple beams

* +mode: increases ship modes to change the player ship (there are total of 3
  ship modes)

* +10: increases to 10 xp

* +50: increases to 50 xp

* +100: increases to 100 xp

* slow mo: slowing down all the live components for 7 seconds

## Compilation

Run `Launcher.java` from any IDE (which supports java).

The path for this java file is `src/dev/rev/cometbusters/Launcher.java`

## Gameplay

The gameplay of this game has been uploaded in YouTube. The gameplay video link
is given: `https://www.youtube.com/watch?v=30-ef0iPMZE&t=1s`

## Game

The game is completely FREE! Link for the jar file of the game is given:
`https://goo.gl/udx3gz`

**Download Zip -> Extract -> Double click on the jar file -> Play**

## Drawbacks

There are some major issues in the game. Users need to keep in mind these issues
to play and while playing the game. These are:

* As I was a beginner in game development I didn't think about the game window
at the first place. That is why I set the window size to **640*960** as I have a
wide screen monitor. That is why user needs to have a minimum display resolution
of **1920*1080** or higher. Lower resolution will mess up everything. User can
change the width and height of the window from `Launcher.java` but it won't
help anything. Everything will be still messed up.

* After turning off the music when the player again turn it on then the music
will start from the beginning.

* When the player collides with the comets it won't show anything. Perhaps it
just decrease the player life.

* While the slow mo is occurring if the screen has new comets then these new
comets won't be slow down for that slow mo time.

* After game over when users need to input their names in roll over mechanic
they will find that the roll over are way too fast.
